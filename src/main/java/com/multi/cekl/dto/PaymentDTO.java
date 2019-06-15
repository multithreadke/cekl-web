package com.multi.cekl.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PaymentDTO {

    @NotEmpty(message = "Customer field cannot be empty!")
    private String customer;

    @NotNull(message = "TotalQty field cannot be null!")
    private int totalQty;

    @NotNull(message = "TotalPrice field cannot be null!")
    private double totalPrice;

    @NotEmpty(message = "SessionId field cannot be empty!")
    private String session;

    @NotEmpty(message = "PaymentMode field cannot be empty!")
    private String paymentMode;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "customer='" + customer + '\'' +
                ", totalQty=" + totalQty +
                ", totalPrice=" + totalPrice +
                ", session='" + session + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                '}';
    }
}
