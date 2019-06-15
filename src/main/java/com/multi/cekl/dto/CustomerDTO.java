package com.multi.cekl.dto;


import javax.validation.constraints.NotEmpty;

public class CustomerDTO {

    @NotEmpty(message = "FirstName field cannot be empty!")
    private String firstName;

    private String middleName;

    @NotEmpty(message = "LastName field cannot be empty!")
    private String lastName;

    @NotEmpty(message = "Gender field cannot be empty!")
    private String gender;

    @NotEmpty(message = "EmailAddress field cannot be empty!")
    private String emailAddress;

    @NotEmpty(message = "Country field cannot be empty!")
    private String country;

    @NotEmpty(message = "PhoneNo field cannot be empty!")
    private String phoneNo;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "CustomerDTO{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", country='" + country + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
