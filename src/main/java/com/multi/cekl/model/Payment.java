package com.multi.cekl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.multi.cekl.utils.AbstractBaseEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PAYMENT", indexes = @Index(name = "PAYMENT_INDEX", columnList = "ID, SESSION_ID"))
public class Payment extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    @Column(name = "TOTAL_QTY")
    private int totalQty;

    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    @Column(name = "SESSION_ID", length = 100)
    private String sessionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PAYMENT_MODE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PaymentMode paymentMode;

    @Column(name = "CREATED_ON")
    private Date dateCreated;

    public Payment() {
    }

    public Payment(Customer customer, int totalQty, double totalPrice, String sessionId, PaymentMode paymentMode, Date dateCreated) {
        this.customer = customer;
        this.totalQty = totalQty;
        this.totalPrice = totalPrice;
        this.sessionId = sessionId;
        this.paymentMode = paymentMode;
        this.dateCreated = dateCreated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getSessionId() {
        return sessionId;
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

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + getId() +
                "customer=" + customer +
                ", totalQty=" + totalQty +
                ", totalPrice=" + totalPrice +
                ", sessionId='" + sessionId + '\'' +
                ", paymentMode=" + paymentMode +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
