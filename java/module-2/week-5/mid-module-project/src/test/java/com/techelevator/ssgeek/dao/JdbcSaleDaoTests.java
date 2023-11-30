package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNull;

public class JdbcSaleDaoTests extends BaseDaoTests {

    private static final Sale TEST_SALE_1 = new Sale(1, 1, LocalDate.parse("2022-01-01"),
            null, "Customer 1");
    private static final Sale TEST_SALE_2 = new Sale(2, 1, LocalDate.parse("2022-02-01"),
            LocalDate.parse("2022-02-02"), "Customer 1");
    private static final Sale TEST_SALE_3 = new Sale(3, 2, LocalDate.parse("2022-03-01"),
            null, "Customer 2");
    private static final Sale TEST_SALE_4 = new Sale(4, 2, LocalDate.parse("2022-01-01"),
            LocalDate.parse("2022-01-02"), "Customer 2");

    private JdbcSaleDao jdbcSaleDao;

    @Before
    public void setup() {
        jdbcSaleDao = new JdbcSaleDao(dataSource);
    }

    @Test
    public void getSaleById_returns_correct_sale() {
        Sale result = jdbcSaleDao.getSaleById(1);
        assertSalesMatch("TEST_SALE_1 does not match result", TEST_SALE_1, result);
    }

    @Test
    public void getUnshippedSales_returns_correct_sales() {
        List<Sale> results = jdbcSaleDao.getUnshippedSales();
        Assert.assertEquals(2, results.size());
        assertSalesMatch("TEST_SALE_1 does not match results", TEST_SALE_1, results.get(0));
        assertSalesMatch("TEST_SALE_3 does not match results", TEST_SALE_3, results.get(1));
    }

    @Test
    public void getSalesByCustomerId_returns_correct_sales() {
        List<Sale> results = jdbcSaleDao.getSalesByCustomerId(1);
        Assert.assertEquals(2, results.size());
        assertSalesMatch("TEST_SALE_1 does not match results", TEST_SALE_1, results.get(0));
        assertSalesMatch("TEST_SALE_2 does not match results", TEST_SALE_2, results.get(1));
    }

    @Test
    public void getSalesByProductId_returns_correct_sales() {
        List<Sale> results = jdbcSaleDao.getSalesByProductId(1);
        Assert.assertEquals(3, results.size());
        assertSalesMatch("TEST_SALE_1 does not match results", TEST_SALE_1, results.get(0));
        assertSalesMatch("TEST_SALE_3 does not match results", TEST_SALE_2, results.get(1));
    }

    @Test
    public void createSale_adds_new_sale_and_returns_it() {
        Sale newSale = new Sale(0, 3, LocalDate.parse("2022-04-01"), null, "Customer 3");
        Sale result = jdbcSaleDao.createSale(newSale);
        assertSalesMatch("New sale does not match result", newSale, result);
    }

    @Test
    public void updateSale_updates_sale_and_returns_it() {
        Sale updatedSale = new Sale(2, 1, LocalDate.parse("2022-02-01"),
                LocalDate.parse("2022-02-03"), "Customer 1");
        Sale result = jdbcSaleDao.updateSale(updatedSale);
        assertSalesMatch("Updated sale does not match result", updatedSale, result);
    }

    @Test
    public void deleteSaleById_deletes_sale() {
        int rowsAffected = jdbcSaleDao.deleteSaleById(1);
        Assert.assertEquals(1, rowsAffected);
        Sale result = jdbcSaleDao.getSaleById(1);
        assertNull("Sale with ID 1 still exists after deletion", result);
    }

    private void assertSalesMatch(String message, Sale expected, Sale actual) {
        Assert.assertEquals(message, expected.getSaleId(), actual.getSaleId());
        Assert.assertEquals(message, expected.getCustomerId(), actual.getCustomerId());
        Assert.assertEquals(message, expected.getSaleDate(), actual.getSaleDate());
        Assert.assertEquals(message, expected.getShipDate(), actual.getShipDate());
        Assert.assertEquals(message, expected.getCustomerName(), actual.getCustomerName());
    }
}
