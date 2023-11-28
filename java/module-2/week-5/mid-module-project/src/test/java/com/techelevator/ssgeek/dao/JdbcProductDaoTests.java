package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class JdbcProductDaoTests extends BaseDaoTests {

    private static final Product TEST_PRODUCT_1 = mapValuesToProduct(1, "Product 1", "Description 1",
            new BigDecimal("9.99"), "product-1.png");
    private static final Product TEST_PRODUCT_2 = mapValuesToProduct(2, "Product 2", "Description 2",
            new BigDecimal("19.00"), "product-2.png");
    private static final Product TEST_PRODUCT_3 = mapValuesToProduct(3, "Product 3", "Description 3",
            new BigDecimal("123.45"), "product-3.png");
    private static final Product TEST_PRODUCT_4 = mapValuesToProduct(4, "Product 4", "Description 4",
            new BigDecimal("0.99"), "product-4.png");

    private JdbcProductDao jdbcProductDao;


    @Before
    public void setup() {
        jdbcProductDao = new JdbcProductDao(dataSource);
    }

    @Test
    public void getProductById_returns_correct_product_for_id() {
        Product product = jdbcProductDao.getProductById(1);
        assertNotNull("getProductById(1) returned null", product);
        assertProductsMatch("getProductById(1) returned wrong or partial data", TEST_PRODUCT_1, product);

        product = jdbcProductDao.getProductById(2);
        assertNotNull("getProductById(2) returned null", product);
        assertProductsMatch("getProductById(2) returned wrong or partial data", TEST_PRODUCT_2, product);

        product = jdbcProductDao.getProductById(3);
        assertNotNull("getProductById(3) returned null", product);
        assertProductsMatch("getProductById(3) returned wrong or partial data", TEST_PRODUCT_3, product);

        product = jdbcProductDao.getProductById(4);
        assertNotNull("getProductById(4) returned null", product);
        assertProductsMatch("getProductById(4) returned wrong or partial data", TEST_PRODUCT_4, product);

        product = jdbcProductDao.getProductById(5);
        assertNull("getProductById(5) does not exist and should be null", product);
    }

    @Test
    public void getProducts_returns_all_products() {
        List<Product> products = jdbcProductDao.getProducts();
        assertEquals("getProducts() returned wrong number of products", 4, products.size());
    }

    @Test
    public void getProductsWithNoSales_returns_products_with_no_sales() {
        List<Product> productsWithNoSales = jdbcProductDao.getProductsWithNoSales();

        assertNotNull("getProductWithNoSales() returned null", productsWithNoSales);
        assertEquals("Unexpected number of products with no sales", 1, productsWithNoSales.size());

    }

    @Test
    public void createProduct_creates_product() {
        Product newProduct = new Product(6, "Product 6", "Description 6", new BigDecimal("21.21"), "product-6.png");
        Product createdProduct = jdbcProductDao.createProduct(newProduct);

        assertNotNull("createProduct did not return a created product", createdProduct);
        assertProductsMatch("createProduct did not create the correct product", newProduct, createdProduct);
    }

    @Test
    public void updateProduct_update_product() {
        Product existingProduct = TEST_PRODUCT_1;
        existingProduct.setDescription("New Description");

        Product updatedProduct = jdbcProductDao.updateProduct(existingProduct);

        assertNotNull("updateProduct did not return an updated product", updatedProduct);
        assertProductsMatch("updateProduct did not update the correct product", existingProduct, updatedProduct);
    }

    @Test
    public void deleteProductById_deletes_product(){
        Product newProduct = new Product(6, "Test Product", "Test Description",
                new BigDecimal("10.10"), "test_product.png");
        Product createdProduct = jdbcProductDao.createProduct(newProduct);

        Product retrievedProduct = jdbcProductDao.getProductById(createdProduct.getProductId());
        assertNotNull("Initial product retrieval failed", retrievedProduct);

        int rowsDeleted =  jdbcProductDao.deleteProductById(createdProduct.getProductId());
        assertEquals("Unexpected number of rows deleted", 1, rowsDeleted);

        retrievedProduct = jdbcProductDao.getProductById(createdProduct.getProductId());
        assertNull("Product was not deleted", retrievedProduct);

    }


    private static Product mapValuesToProduct(int productId, String name, String description, BigDecimal price, String imageName) {
        Product product = new Product();
        product.setProductId(productId);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageName(imageName);
        return product;
    }

    private void assertProductsMatch(String message, Product expected, Product actual) {

        assertEquals(message, expected.getProductId(), actual.getProductId());
        assertEquals(message, expected.getName(), actual.getName());
        assertEquals(message, expected.getDescription(), actual.getDescription());
        assertEquals(message, expected.getPrice(), actual.getPrice());
        assertEquals(message, expected.getImageName(), actual.getImageName());
    }
}
