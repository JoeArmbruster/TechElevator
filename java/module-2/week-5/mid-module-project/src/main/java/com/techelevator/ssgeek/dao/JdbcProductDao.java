package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Product getProductById(int productId) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE product_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
            if (results.next()) {
                product = mapRowToProduct(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }
        return product;
    }


    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        } catch (DataAccessException e) {
            throw new DaoException("Error retrieving products", e);
        }
        return products;
    }

    @Override
    public List<Product> getProductsWithNoSales() {
        List<Product> productsWithNoSales = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_id NOT IN (SELECT DISTINCT product_id FROM line_item);";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Product product = mapRowToProduct(results);
                productsWithNoSales.add(product);
            }
        } catch (DataAccessException e) {
            throw new DaoException("Error retrieving products with no sales", e);
        }

        return productsWithNoSales;
    }

    @Override
    public Product createProduct(Product newProduct) {
        int newId;
        String sql = "INSERT INTO product (name, description, price, image_name) VALUES (?, ?, ?, ?) RETURNING product_id;";

        try {
            newId = jdbcTemplate.queryForObject(sql, int.class, newProduct.getName(), newProduct.getDescription(),
                    newProduct.getPrice(), newProduct.getImageName());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return getProductById(newId);
    }

    @Override
    public Product updateProduct(Product updatedProduct) {
        String sql = "UPDATE product SET name=?, description=?, price=?, image_name=? WHERE product_id=?;";

        try {
            int rowsAffected = jdbcTemplate.update(sql, updatedProduct.getName(), updatedProduct.getDescription(),
                    updatedProduct.getPrice(), updatedProduct.getImageName(), updatedProduct.getProductId());

            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expect at least one");
            } else {
                updatedProduct = getProductById(updatedProduct.getProductId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedProduct;
    }

    @Override
    public int deleteProductById(int productId) {
        String sql = "DELETE FROM product WHERE product_Id = ?;";

        try {
            return jdbcTemplate.update(sql, productId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private Product mapRowToProduct(SqlRowSet results) {
        Product product = new Product();
        product.setProductId(results.getInt("product_id"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getBigDecimal("price"));
        product.setImageName(results.getString("image_name"));
        return product;
    }
}
