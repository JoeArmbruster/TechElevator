package model;

public class Inventory {

    private int inventoryId;
    private String stockNumber;
    private int year;
    private String make;
    private String model;
    private String series;
    private int sellingPrice;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Inventory(){}

    public Inventory(int inventoryId, String stockNumber, int year, String make, String model, String series, int sellingPrice){
        this.inventoryId = inventoryId;
        this.stockNumber = stockNumber;
        this.year = year;
        this.make = make;
        this.model = model;
        this.series = series;
        this.sellingPrice = sellingPrice;
    }
}