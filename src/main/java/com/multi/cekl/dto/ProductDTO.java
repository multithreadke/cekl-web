package com.multi.cekl.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDTO {

    @NotEmpty(message = "Name field cannot be empty!")
    private String name;

    @NotEmpty(message = "ShortDesc field cannot be empty!")
    private String shortDesc;

    @NotEmpty(message = "LongDesc field cannot be empty!")
    private String longDesc;

    @NotNull(message = "qty field cannot be null!")
    private int qty;

    @NotNull(message = "Price field cannot be null!")
    private Double price;

    @NotEmpty(message = "Category field cannot be empty!")
    private String category;

    @NotEmpty(message = "Unit field cannot be empty!")
    private String unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", packing='" + unit + '\'' +
                '}';
    }
}
