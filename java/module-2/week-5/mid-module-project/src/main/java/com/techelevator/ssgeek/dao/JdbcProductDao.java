package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;

import javax.sql.DataSource;
import java.util.List;

public class JdbcProductDao implements ProductDao {
    private DataSource dataSource;

    public JdbcProductDao(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<Product> getProductsWithNoSales() {
        return null;
    }

    @Override
    public Product createProduct(Product newProduct) {
        return null;
    }

    @Override
    public Product updateProduct(Product updatedProduct) {
        return null;
    }

    @Override
    public int deleteProductById(int productId) {
        return 0;
    }
}
