package dao;

import model.Inventory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class JdbcInventoryDao implements InventoryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Inventory getInventoryById(int inventoryId);



}
