package com.multi.cekl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.multi.cekl.utils.AbstractBaseEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT", indexes = @Index(name = "PRODUCT_INDEX", columnList = "ID"))
public class Product extends AbstractBaseEntity {

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "SHORT_DESC", length = 40)
    private String shortDesc;

    @Column(name = "LONG_DESC")
    private String longDesc;

    @Column(name = "QTY")
    private int qty;

    @Column(name = "PRICE")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PACKING_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Packing packing;

    public Product() {
    }

    public Product(String name, String shortDesc, String longDesc, int qty, Double price, Category category, Packing packing) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.qty = qty;
        this.price = price;
        this.category = category;
        this.packing = packing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Packing getPacking() {
        return packing;
    }

    public void setPacking(Packing packing) {
        this.packing = packing;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", category=" + category +
                ", packing=" + packing +
                '}';
    }
}
