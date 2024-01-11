package com.techelevator.dao;

import com.techelevator.model.CartItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcCartItemDao implements CartItemDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCartItemDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CartItem> getCartItemsByUserId(int userId) {
        return null;
    }
}
