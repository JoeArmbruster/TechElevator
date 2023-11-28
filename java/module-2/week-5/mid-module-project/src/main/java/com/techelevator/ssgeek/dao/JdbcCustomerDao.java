package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.crypto.Cipher;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcCustomerDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE customer_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
            if (results.next()) {
                customer = mapRowToCustomer(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database");
        }
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Customer customer = mapRowToCustomer(results);
                customers.add(customer);
            }
            return customers;
        } catch (DataAccessException e) {
            throw new DaoException("Error retrieving customers", e);
        }
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        int newId;
        String sql = "INSERT INTO customer(\n" +
                "\tname, street_address1, street_address2, city, state, zip_code)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?) RETURNING customer_id;";

        try {
            newId = jdbcTemplate.queryForObject(sql, int.class, newCustomer.getName(), newCustomer.getStreetAddress1(), newCustomer.getStreetAddress2(),
                    newCustomer.getCity(), newCustomer.getState(), newCustomer.getZipCode());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return getCustomerById(newId);
    }

    @Override
    public Customer updateCustomer(Customer updatedCustomer) {

        String sql = "UPDATE customer\n" +
                "\tSET name=?, street_address1=?, street_address2=?, city=?, state=?, zip_code=?\n" +
                "\tWHERE customer_id=?;";
        try {
            int rowsAffected = jdbcTemplate.update(sql, updatedCustomer.getName(), updatedCustomer.getStreetAddress1(),
                    updatedCustomer.getStreetAddress2(), updatedCustomer.getCity(), updatedCustomer.getState(),
                    updatedCustomer.getZipCode(), updatedCustomer.getCustomerId());
            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expect at last one");
            } else {
                updatedCustomer = getCustomerById(updatedCustomer.getCustomerId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedCustomer;
    }

    private Customer mapRowToCustomer(SqlRowSet results) {
        Customer customer = new Customer();
        customer.setCustomerId(results.getInt("customer_id"));
        customer.setName(results.getString("name"));
        customer.setStreetAddress1(results.getString("street_address1"));
        customer.setStreetAddress2(results.getString("street_address2"));
        customer.setCity(results.getString("city"));
        customer.setState(results.getString("state"));
        customer.setZipCode(results.getString("zip_code"));
        return customer;
    }
}
