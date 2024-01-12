package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.CartItem;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCartItemDao implements CartItemDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCartItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CartItem> getCartItemsByUserId(int userId) {
        List<CartItem> cartItems = new ArrayList<>();
        String sql = "SELECT * FROM cart_item WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                CartItem cartItem = mapRowToCartItem(results);
                cartItems.add(cartItem);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }

        return cartItems;
    }

    @Override
    public CartItem getCartItemByProductId(int userId, int productId) {
        CartItem cartItem = null;
        String sql = "SELECT * FROM cart_item WHERE user_id = ? AND product_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, productId);
            if(results.next()){
                cartItem = mapRowToCartItem(results);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database");
        }

        return cartItem;
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        String sql = "INSERT INTO cart_item (user_id, product_id, price, quantity) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, cartItem.getUserId(), cartItem.getProductId(), cartItem.getPrice(), cartItem.getQuantity());


    }

    @Override
    public void updateCartItemQuantity(int itemId, int quantity) {
        String sql = "UPDATE cart_item SET quantity = ? WHERE cart_item_id = ?";
        jdbcTemplate.update(sql, quantity, itemId);

    }

    @Override
    public void removeCartitem(int itemId) {
        String sql = "DELETE FROM cart_item WHERE cart_item_id = ?";
        jdbcTemplate.update(sql, itemId);

    }

    @Override
    public void clearCart(int userId) {
        String sql = "DELETE FROM cart_item WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }



    private CartItem mapRowToCartItem(SqlRowSet results) {
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(results.getInt("cart_item_id"));
        cartItem.setUserId(results.getInt("user_id"));
        cartItem.setProductId(results.getInt("product_id"));
//        cartItem.setPrice(results.getBigDecimal("price"));
        cartItem.setQuantity(results.getInt("quantity"));
        return cartItem;
    }
}
