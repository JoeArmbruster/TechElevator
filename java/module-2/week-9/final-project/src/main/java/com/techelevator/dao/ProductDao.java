package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    Product getProductById(int id);

    List<Product> getProductsByOptionalSkuAndOrName(String sku, String name, boolean useWildCard);

    List<Product> getProductsByUserId(int userId);

}
