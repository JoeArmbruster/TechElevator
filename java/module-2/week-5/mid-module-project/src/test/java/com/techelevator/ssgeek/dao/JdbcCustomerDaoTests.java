package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class JdbcCustomerDaoTests extends BaseDaoTests {

    private static final Customer TEST_CUSTOMER_1 = mapValuesToCustomer(1, "Customer 1", "Addr 1-1", "Addr 1-2",
            "City 1", "S1", "11111");

    private static final Customer TEST_CUSTOMER_2 = mapValuesToCustomer(2, "Customer 2", "Addr 2-1", "Addr 2-2",
            "City 2", "S2", "22222");

    private static final Customer TEST_CUSTOMER_3 = mapValuesToCustomer(3, "Customer 3", "Addr 3-1", null,
            "City 3", "S3", "33333");

    private static final Customer TEST_CUSTOMER_4 = mapValuesToCustomer(4, "Customer 4", "Addr 4-1", null,
            "City 4", "S4", "44444");

    private JdbcCustomerDao jdbcCustomerDao;

    @Before
    public void setup() {
        jdbcCustomerDao = new JdbcCustomerDao(dataSource);
    }

    @Test
    public void getCustomerById_returns_correct_customer_for_id() {

        Customer customer = jdbcCustomerDao.getCustomerById(1);
        assertNotNull("getCustomerById(1) returned null", customer);
        assertCustomersMatch("getCustomerById(1) returned wrong or partial data", TEST_CUSTOMER_1, customer);

        customer = jdbcCustomerDao.getCustomerById(2);
        assertNotNull("getCustomerById(2) returned null", customer);
        assertCustomersMatch("getCustomerById(2) returned wrong or partial data", TEST_CUSTOMER_2, customer);

        customer = jdbcCustomerDao.getCustomerById(3);
        assertNotNull("getCustomerById(3) returned null", customer);
        assertCustomersMatch("getCustomerById(3) returned wrong or partial data", TEST_CUSTOMER_3, customer);

        customer = jdbcCustomerDao.getCustomerById(4);
        assertNotNull("getCustomerById(4) returned null", customer);
        assertCustomersMatch("getCustomerById(4) returned wrong or partial data", TEST_CUSTOMER_4, customer);

        customer = jdbcCustomerDao.getCustomerById(5);
        assertNull("getCustomerById(5) does not exist and should be null", customer);
    }

    @Test
    public void getCustomers_returns_all_customers() {
        List<Customer> customers = jdbcCustomerDao.getCustomers();
        Assert.assertEquals("getCustomers() returned wrong number of customers", 4, customers.size());
    }

    @Test
    public void createCustomer_creates_customer() {
        Customer newCustomer = new Customer(5, "Homer Simpson", "742 Evergreen Terrace",
                null, "Springfield", "OR", "80085");
        Customer createdCustomer = jdbcCustomerDao.createCustomer(newCustomer);

        assertNotNull("createCustomer did not return a created customer", createdCustomer);
        assertCustomersMatch("createCustomer did not create the correct customer", newCustomer, createdCustomer);
    }

    @Test
    public void updateCustomer_updates_customer() {
        Customer existingCustomer = TEST_CUSTOMER_1;
        existingCustomer.setZipCode("16511");

        Customer updatedCustomer = jdbcCustomerDao.updateCustomer(existingCustomer);

        assertNotNull("updateCustomer did not return an updated customer", updatedCustomer);
        assertCustomersMatch("updateCustomer did not update the correct customer", existingCustomer, updatedCustomer);
    }

    private static Customer mapValuesToCustomer(int customerId, String name, String streetAddress1, String streetAddress2,
                                                String city, String state, String zipCode) {

        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setName(name);
        customer.setStreetAddress1(streetAddress1);
        customer.setStreetAddress2(streetAddress2);
        customer.setCity(city);
        customer.setState(state);
        customer.setZipCode(zipCode);
        return customer;
    }

    private void assertCustomersMatch(String message, Customer expected, Customer actual) {

        Assert.assertEquals(message, expected.getCustomerId(), actual.getCustomerId());
        Assert.assertEquals(message, expected.getName(), actual.getName());
        Assert.assertEquals(message, expected.getStreetAddress1(), actual.getStreetAddress1());
        Assert.assertEquals(message, expected.getStreetAddress2(), actual.getStreetAddress2());
        Assert.assertEquals(message, expected.getCity(), actual.getCity());
        Assert.assertEquals(message, expected.getState(), actual.getState());
        Assert.assertEquals(message, expected.getZipCode(), actual.getZipCode());
    }

}
