package com.techelevator.dao;

import com.techelevator.model.CartItem;

import java.util.List;

public interface CartItemDao {
    List<CartItem> getCartItemsByUserId(int userId);
}
