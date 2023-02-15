package com.abedsa.loginsqlite;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String userName;
    private String password;
    private String address;
    private String phoneNumber;
    private String email;


    public User(int id, String userName, String password, String address, String phoneNumber, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(String userName, String password, String address, String phoneNumber, String email) {
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
