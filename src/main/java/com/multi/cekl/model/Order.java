package com.multi.cekl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.multi.cekl.utils.AbstractBaseEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS", indexes = @Index(name = "ORDERS_INDEX", columnList = "ID, SESSION_ID"))
public class Order extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    @Column(name = "QTY")
    private int quantity;

    @Column(name = "SESSION_ID", length = 100)
    private String sessionId;

    @Column(name = "CREATED_ON")
    private Date dateCreated;

    public Order() {
    }

    public Order(Product product, Customer customer, int quantity, String sessionId, Date dateCreated) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
        this.sessionId = sessionId;
        this.dateCreated = dateCreated;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                "product=" + product +
                ", customer=" + customer +
                ", quantity=" + quantity +
                ", sessionId='" + sessionId + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
