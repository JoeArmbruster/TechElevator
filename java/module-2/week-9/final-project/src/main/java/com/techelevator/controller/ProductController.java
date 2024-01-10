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
    public List<Product> getList(@RequestParam(required = false) String sku,
                                 @RequestParam(required = false) String name)

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
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "false") boolean useWildCard) {
        return productDao.getProductsByOptionalSkuAndOrName(sku, name, useWildCard);
    }

    @GetMapping("/user/{userId}")
    public List<Product> getProductsByUserId(@PathVariable int userId){
        return productDao.getProductsByUserId(userId);
    }

}
