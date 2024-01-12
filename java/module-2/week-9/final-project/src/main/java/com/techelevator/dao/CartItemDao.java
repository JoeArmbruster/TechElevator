package com.techelevator.dao;

import com.techelevator.model.Cart;
import com.techelevator.model.CartItem;

import java.util.List;

public interface CartItemDao {
    List<CartItem> getCartItemsByUserId(int userId);

    void addCartItem(CartItem cartItem);

    void updateCartItemQuantity(int itemId, int quantity);

    void removeCartitem(int itemId);

    void clearCart(int userId);

    CartItem getCartItemByProductId(int userId, int productId);
}
