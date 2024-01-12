package com.techelevator.service;

import com.techelevator.dao.CartItemDao;
import com.techelevator.dao.ProductDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Cart;
import com.techelevator.model.CartItem;
import com.techelevator.model.Product;
import com.techelevator.model.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Component
public class CartService {

    private CartItemDao cartItemDao;

    private ProductDao productDao;

    private UserDao userDao;

    private TaxService taxService;

    public CartService(CartItemDao cartItemDao, ProductDao productDao, UserDao userDao, TaxService taxService) {
        this.cartItemDao = cartItemDao;
        this.productDao = productDao;
        this.userDao = userDao;
        this.taxService = taxService;
    }

    public Cart getUserCart(Principal principal) {

        // get the userId from the Principal object (HINT: this is where the UserDao is helpful)
        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        // use this to get a list of CartItem objects from the CartItemDao
        List<CartItem> items = cartItemDao.getCartItemsByUserId(userId);

        // place this within a new Cart object
        Cart cart = new Cart(items);

        // get a list of all products belonging to this user (HINT: use the ProductDao)
        List<Product> userProducts = productDao.getProductsByUserId(userId);

        for (CartItem cartItem : items) {
            int productId = cartItem.getProductId();
            Product correspondingProduct = getCorrespondingProduct(productId, userProducts);
            cartItem.setProduct(correspondingProduct);
        }

        // calculate subtotal
        BigDecimal subtotal = calculateSubtotal(cart.getItems());
        cart.setSubtotal(subtotal);

        BigDecimal taxRate = taxService.getTaxRate(user.getStateCode());

        BigDecimal taxAmount = subtotal.multiply(taxRate);
        cart.setTax(taxAmount);

        BigDecimal total = subtotal.add(taxAmount);
        cart.setTotal(total);

        return cart;

    }

    private BigDecimal calculateSubtotal(List<CartItem> items) {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (CartItem cartItem : items) {
            if (cartItem.getProduct() != null && cartItem.getProduct().getPrice() != null) {
                BigDecimal itemTotal = cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
                subtotal = subtotal.add(itemTotal);
            }
        }
        return subtotal;
    }

    private Product getCorrespondingProduct(int productId, List<Product> productsToSearch) {

        for (Product product : productsToSearch) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void addCartItem(CartItem cartItem, Principal principal) {
        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        List<CartItem> existingItems = cartItemDao.getCartItemsByUserId(userId);
        for (CartItem existingItem : existingItems) {
            if (existingItem.getProductId() == cartItem.getProductId()) {
                int updatedQuantity = existingItem.getQuantity() + cartItem.getQuantity();
                cartItemDao.updateCartItemQuantity(existingItem.getCartItemId(), updatedQuantity);
                return;
            }
        }

        cartItem.setUserId(userId);
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(int itemId, Principal principal) {
        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        cartItemDao.removeCartitem(itemId);

        Cart cart = getUserCart(principal);
        cart.setItems(cartItemDao.getCartItemsByUserId(userId));

    }

    public void clearCart(Principal principal) {
        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        cartItemDao.clearCart(userId);
    }

}
