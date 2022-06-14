package org.acme.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("password")
    String password;

    @JsonProperty("mobileNo")
    String mobileNo;

    @JsonProperty("email")
    String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
