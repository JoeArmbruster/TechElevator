package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JdbcCustomerDaoTests extends BaseDaoTests {

private static final Customer CUSTOMER_1 = mapValuesToCustomer(1, "Sherlock Holmes", "221B Baker Street", "Apartment B",
        "London", "OH", "43140");

private static final Customer CUSTOMER_2 = mapValuesToCustomer(2, "Mona List", "99 rue de Rivoli", null,
        "Paris", "OH", "45347");

private static final Customer CUSTOMER_3 = mapValuesToCustomer(3, "Lady Liberty", "Liberty Island", null,
        "New York", "NY", "10004");

private static final Customer CUSTOMER_4 = mapValuesToCustomer(4, "The President", "1600 Pennsylvania Avenue NW", null,
        "Washington", "DC", "20500");

private static final Customer CUSTOMER_5 = mapValuesToCustomer(5, "Anne Frank", "263 Prinsengracth", null,
        "Amsterdam", "OH", "43903");

private static final Customer CUSTOMER_6 = mapValuesToCustomer(6, "Elwood Blues", "1060 West Addison Street", null,
        "Chicago", "IL", "60613");

    private JdbcCustomerDao jdbcCustomerDao;

    @Before
    public void setup() {
        jdbcCustomerDao = new JdbcCustomerDao(dataSource);
    }

@Test
public void getCustomerById_returns_correct_customer_for_id(){

        Customer customer = jdbcCustomerDao.getCustomerById(1);
        Assert.assertNotNull("getCustomerById(1) returned null", customer);
        assertCustomersMatch("getCustomerById(1) returned wrong or partial data", CUSTOMER_1, customer);

    customer = jdbcCustomerDao.getCustomerById(2);
    Assert.assertNotNull("getCustomerById(2) returned null", customer);
    assertCustomersMatch("getCustomerById(2) returned wrong or partial data", CUSTOMER_2, customer);

    customer = jdbcCustomerDao.getCustomerById(3);
    Assert.assertNotNull("getCustomerById(3) returned null", customer);
    assertCustomersMatch("getCustomerById(3) returned wrong or partial data", CUSTOMER_3, customer);

    customer = jdbcCustomerDao.getCustomerById(4);
    Assert.assertNotNull("getCustomerById(4) returned null", customer);
    assertCustomersMatch("getCustomerById(4) returned wrong or partial data", CUSTOMER_4, customer);

    customer = jdbcCustomerDao.getCustomerById(5);
    Assert.assertNotNull("getCustomerById(5) returned null", customer);
    assertCustomersMatch("getCustomerById(5) returned wrong or partial data", CUSTOMER_5, customer);

    customer = jdbcCustomerDao.getCustomerById(6);
    Assert.assertNotNull("getCustomerById(6) returned null", customer);
    assertCustomersMatch("getCustomerById(6) returned wrong or partial data", CUSTOMER_6, customer);

    customer = jdbcCustomerDao.getCustomerById(7);
    Assert.assertNotNull("getCustomerById(7) does not exist and should be null", customer);
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
