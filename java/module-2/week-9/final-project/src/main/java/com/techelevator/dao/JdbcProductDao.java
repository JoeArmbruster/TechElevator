package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Product;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT *  FROM product";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }
        return products;
    }


    @Override
    public List<Product> getProductsByOptionalSkuAndOrName(String sku, String name, boolean useWildCard) {
        List<Product> products = new ArrayList<>();

        if (useWildCard) {
            name = "%" + (name == null ? "" : name) + "%";
        }

        boolean checkSku = sku != null && !sku.isEmpty();

        String sql = "SELECT * FROM product WHERE name ILIKE ? " +
                (checkSku ? "AND product_sku = ? " : "") +
                "ORDER BY product_id";

        try {
            SqlRowSet results;

            if (checkSku) {
                results = jdbcTemplate.queryForRowSet(sql, name, sku);
            } else {
                results = jdbcTemplate.queryForRowSet(sql, name);
            }

            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database");
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE product_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                product = mapRowToProduct(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }
        return product;
    }


    @Override
    public List<Product> getProductsByUserId(int userId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_id IN (SELECT product_id FROM cart_item WHERE user_id = ?);";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }

        return products;
    }

    private Product mapRowToProduct(SqlRowSet results) {
        Product product = new Product();
        product.setId(results.getInt("product_id"));
        product.setSku(results.getString("product_sku"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getBigDecimal("price"));
        product.setImageName(results.getString("image_name"));
        return product;
    }

}
