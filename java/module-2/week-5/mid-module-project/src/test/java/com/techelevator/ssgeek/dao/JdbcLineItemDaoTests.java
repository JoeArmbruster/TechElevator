package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.util.List;

public class JdbcLineItemDaoTests extends BaseDaoTests {

    private static final LineItem TEST_LINE_ITEM_1 = new LineItem(1, 1, 1, 1, "Product 1", new BigDecimal("9.99"));
    private static final LineItem TEST_LINE_ITEM_2 = new LineItem(2, 1, 2, 1, "Product 2", new BigDecimal("19.00"));
    private static final LineItem TEST_LINE_ITEM_3 = new LineItem(3, 1, 4, 1, "Product 4", new BigDecimal("0.99"));
    private static final LineItem TEST_LINE_ITEM_4 = new LineItem(4, 2, 3, 10, "Product 4", new BigDecimal("0.99"));
    private static final LineItem TEST_LINE_ITEM_5 = new LineItem(5, 2, 1, 10, "Product 1", new BigDecimal("9.99"));
    private static final LineItem TEST_LINE_ITEM_6 = new LineItem(6, 3, 1, 100, "Product 1", new BigDecimal("9.99"));

    private JdbcLineItemDao jdbcLineItemDao;

    @Before
    public void setup() {
        jdbcLineItemDao = new JdbcLineItemDao(dataSource);
    }

    @Test
    public void getLineItemsBySaleId_returns_correct_line_items() {
        List<LineItem> lineItems = jdbcLineItemDao.getLineItemsBySaleId(1);

        Assert.assertEquals(3, lineItems.size());
        assertLineItemsMatch("Returned wrong or partial data", TEST_LINE_ITEM_1, lineItems.get(0));
        assertLineItemsMatch("Returned wrong or partial data", TEST_LINE_ITEM_2, lineItems.get(1));
        assertLineItemsMatch("Returned wrong or partial data", TEST_LINE_ITEM_3, lineItems.get(2));

    }

    private void assertLineItemsMatch(String message, LineItem expected, LineItem actual){
        Assert.assertEquals(message, expected.getLineItemId(), actual.getLineItemId());
        Assert.assertEquals(message, expected.getSaleId(), actual.getSaleId());
        Assert.assertEquals(message, expected.getProductId(), actual.getProductId());
        Assert.assertEquals(message, expected.getQuantity(), actual.getQuantity());
        Assert.assertEquals(message, expected.getProductName(), actual.getProductName());
        Assert.assertEquals(message, 0, expected.getPrice().compareTo(actual.getPrice()));

    }

}
