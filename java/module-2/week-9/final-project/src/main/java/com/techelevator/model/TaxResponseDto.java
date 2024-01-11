package com.techelevator.model;

import java.math.BigDecimal;

public class TaxResponseDto {

    private BigDecimal salesTax;
    private String lastUpdated;

    public TaxResponseDto(BigDecimal salesTax, String lastUpdated){
        this.salesTax = salesTax;
        this.lastUpdated = lastUpdated;
    }
    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
