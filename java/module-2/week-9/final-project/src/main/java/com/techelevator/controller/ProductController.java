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

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Product> getProducts(){
        return productDao.getProducts();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int id){
        return productDao.getProductById(id);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public List<Product> searchProducts(
            @RequestParam(required = false) String sku,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "false") boolean useWildCard) {
        return productDao.getProductsByOptionalSkuAndOrName(sku, name, useWildCard);
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public List<Product> getProductsByUserId(@PathVariable int userId){
        return productDao.getProductsByUserId(userId);
    }

}
