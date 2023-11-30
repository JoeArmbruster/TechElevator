package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Sale;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaleDao implements SaleDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcSaleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Sale getSaleById(int saleId) {
        Sale sale = null;
        String sql = "SELECT sale.*, customer.name AS customer_name " +
                "FROM sale " +
                "JOIN customer ON sale.customer_id = customer.customer_id " +
                "WHERE sale_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);
            if (results.next()) {
                sale = mapRowToSale(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }

        return sale;
    }

    @Override
    public List<Sale> getUnshippedSales() {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT sale.*, customer.name AS customer_name " +
                "FROM sale " +
                "JOIN customer ON sale.customer_id = customer.customer_id " +
                "WHERE sale.ship_date IS NULL " +
                "ORDER BY sale.sale_id;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Sale sale = mapRowToSale(results);
                sales.add(sale);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }
        return sales;
    }


    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT sale.*, customer.name as customer_name " +
                "FROM sale " +
                "JOIN customer ON sale.customer_id = customer.customer_id " +
                "WHERE sale.customer_id = ? " +
                "ORDER BY sale.sale_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
            while (results.next()) {
                Sale sale = mapRowToSale(results);
                sales.add(sale);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }

        return sales;
    }

    @Override
    public List<Sale> getSalesByProductId(int productId) {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT sale.*, customer.name AS customer_name " +
                "FROM sale " +
                "JOIN customer ON sale.customer_id = customer.customer_id " +
                "JOIN line_item ON sale.sale_id = line_item.sale_id " +
                "WHERE line_item.product_id = ? " +
                "ORDER BY sale.sale_id;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
            while (results.next()) {
                Sale sale = mapRowToSale(results);
                sales.add(sale);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }

        return sales;
    }

    @Override
    public Sale createSale(Sale newSale) {

        String sql = "INSERT INTO sale(customer_id, sale_date, ship_date) VALUES (?, ?, ?) RETURNING sale_id;";
        try {
            int newId = jdbcTemplate.queryForObject(sql, Integer.class, newSale.getCustomerId(), newSale.getSaleDate(),
                    newSale.getShipDate());
            newSale.setSaleId(newId);
            return newSale;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Error creating sale", e);
        }
    }

    @Override
    public Sale updateSale(Sale updatedSale) {
        String sql = "UPDATE sale SET customer_id=?, sale_date=?, ship_date=? WHERE sale_id=?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, updatedSale.getCustomerId(), updatedSale.getSaleDate(),
                    updatedSale.getShipDate(), updatedSale.getSaleId());

            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expect at least one");
            } else {
                updatedSale = getSaleById(updatedSale.getSaleId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedSale;
    }

    @Override
    public int deleteSaleById(int saleId) {
        String sql1 = "DELETE FROM line_item WHERE sale_id = ?;";
        String sql2 = "DELETE FROM sale WHERE sale_id = ?;";

        try {
            jdbcTemplate.update(sql1, saleId);
            return jdbcTemplate.update(sql2, saleId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private Sale mapRowToSale(SqlRowSet results) {
        Sale sale = new Sale();
        sale.setSaleId(results.getInt("sale_id"));
        sale.setCustomerId(results.getInt("customer_id"));
        sale.setSaleDate(results.getDate("sale_date").toLocalDate());
        if (results.getDate("ship_date") != null) {
            sale.setShipDate(results.getDate("ship_date").toLocalDate());
        }
        sale.setCustomerName(results.getString("customer_name"));
        return sale;
    }
}
