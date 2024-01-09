package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;

    public ProductController(ProductDao productDao){
        this.productDao = productDao;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productDao.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productDao.getProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String sku,
            @RequestParam(required = false) String name) {
        return productDao.getProductsByOptionalSkuAndOrName(sku, name);
    }

    @GetMapping("/user/{userId}")
    public List<Product> getProductsByUserId(@PathVariable int userId){
        return productDao.getProductsByUserId(userId);
    }

}
