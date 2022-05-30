package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(name = "MobileNo", columnNames = "MobileNo"),
        @UniqueConstraint(name = "Password", columnNames = "Password"),
        @UniqueConstraint(name = "Email", columnNames = "Email")
})
public class Users {

    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "MobileNo")
    @NotNull
    private String mobileNo;

    @Column(name = "Password")
    @NotNull
    private String password;

    @Column(name = "Email")
    @NotNull
    private String email;

    public Integer getUserId() {
        return userId;
    }

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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
