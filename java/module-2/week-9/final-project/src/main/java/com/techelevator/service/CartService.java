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

        for (CartItem cartItem : items){
            int productId = cartItem.getProductId();
            Product correspondingProduct = getCorrespondingProduct(productId, userProducts);
            cartItem.setProduct(correspondingProduct);
        }

        // BONUS:
        // Add tax, subtotal, and total.

        BigDecimal taxAmount = taxService.getTaxRate(user.getStateCode());
        cart.setTax(taxAmount);
        cart.setSubtotal(new BigDecimal("100"));
        cart.setTotal(new BigDecimal("200"));

        return cart;

    }

    private Product getCorrespondingProduct(int productId, List<Product> productsToSearch) {

        for (Product product : productsToSearch){
            if (product.getId() == productId){
                return product;
            }
        }
        return null;
    }
}
