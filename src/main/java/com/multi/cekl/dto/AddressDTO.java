package com.multi.cekl.dto;

import javax.validation.constraints.NotEmpty;

public class AddressDTO {

    @NotEmpty(message = "StreetAddress field cannot be empty!")
    private String streetAddress;

    @NotEmpty(message = "City field cannot be empty!")
    private String city;

    @NotEmpty(message = "State field cannot be empty!")
    private String state;

    @NotEmpty(message = "ZipCode field cannot be empty!")
    private String zipCode;

    @NotEmpty(message = "Customer field cannot be empty!")
    private String customer;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
