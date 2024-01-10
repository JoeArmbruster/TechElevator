package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    List<Product> getProductsByOptionalSkuAndOrName(String sku, String name, boolean useWildCard);

    Product getProductById(int id);

    List<Product> getProductsByUserId(int userId); //bonus #1

}
