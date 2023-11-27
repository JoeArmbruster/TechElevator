package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;

import javax.sql.DataSource;
import java.util.List;

public class JdbcLineItemDao implements LineItemDao{

    private DataSource dataSource;

    public JdbcLineItemDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<LineItem> getLineItemsBySaleId(int saleId) {
        return null;
    }
}
