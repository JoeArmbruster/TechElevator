package com.techelevator.model;

import java.math.BigDecimal;

public class CartItem {

    private int cartItemId;

    private int userId;

    private int productId;

    private Product product;

    private BigDecimal price;

    private int quantity;

    public CartItem(){
    }

    public CartItem(int cartItemId, int userId, int productId, BigDecimal price, int quantity) {
        this.cartItemId = cartItemId;
        this.userId = userId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
