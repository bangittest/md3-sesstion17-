package bai1;

import java.io.Serializable;

public class Product implements Serializable {
    private String productCode;
    private String productName;
    private String manufacturingDate;
    private double price;
    private String description;

    public Product(String productCode, String productName, String manufacturingDate, double price, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturingDate = manufacturingDate;
        this.price = price;
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
