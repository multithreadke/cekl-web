package com.multi.cekl.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderDTO {

    @NotEmpty(message = "productId field cannot be empty!")
    private String product;

    @NotEmpty(message = "CustomerId field cannot be empty!")
    private String customer;

    @NotNull(message = "Quantity field cannot be null!")
    private int qty;

    @NotEmpty(message = "SessionId field cannot be empty!")
    private String session;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "product='" + product + '\'' +
                ", customer='" + customer + '\'' +
                ", qty=" + qty +
                ", session='" + session + '\'' +
                '}';
    }
}
