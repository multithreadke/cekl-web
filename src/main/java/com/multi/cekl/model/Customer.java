package com.multi.cekl.model;

import com.multi.cekl.utils.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER", indexes = @Index(name = "CUSTOMER_INDEX", columnList = "ID, EMAIL_ADDRESS, PHONE_NO"))
public class Customer extends AbstractBaseEntity {

    @Column(name = "FIRST_NAME", length = 15)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 15)
    private String middleName;

    @Column(name = "LAST_NAME", length = 15)
    private String lastName;

    @Column(name = "GENDER", length = 1)
    private String gender;

    @Column(name = "EMAIL_ADDRESS", unique = true, length = 60)
    private String emailAddress;

    @Column(name = "COUNTRY", length = 20)
    private String country;

    @Column(name = "PHONE_NO", unique = true, length = 12)
    private String phoneNo;

    public Customer() {
    }

    public Customer(String firstName, String middleName, String gender, String emailAddress, String lastName, String country, String phoneNo) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.lastName = lastName;
        this.country = country;
        this.phoneNo = phoneNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id='" + getId() + '\'' +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender='" + gender + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
