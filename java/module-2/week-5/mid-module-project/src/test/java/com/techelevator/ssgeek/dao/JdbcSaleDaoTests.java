package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;
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



    private static Sale mapValuesToSale(int saleId, int customerId, LocalDate saleDate, LocalDate shipDate, String customerName) {

        Sale sale = new Sale();
        sale.setSaleId(saleId);
        sale.setCustomerId(customerId);
        sale.setSaleDate(saleDate);
        sale.setShipDate(shipDate);
        sale.setCustomerName(customerName);
        return sale;
    }

    private void assertSalesMatch(String message, Sale expected, Sale actual){
        Assert.assertEquals(message, expected.getSaleId(), actual.getSaleId());
        Assert.assertEquals(message, expected.getCustomerId(), actual.getCustomerId());
        Assert.assertEquals(message, expected.getSaleDate(), actual.getSaleDate());
        Assert.assertEquals(message, expected.getShipDate(), actual.getShipDate());
        Assert.assertEquals(message, expected.getCustomerName(), actual.getCustomerName());
    }
}
