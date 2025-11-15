package com.reservation;

import java.io.Serializable;

/**
 * User class demonstrating Encapsulation
 * Keeps user information private with controlled access
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String userId;
    private String name;
    private String email;
    private String phone;
    
    // Constructor
    public User(String userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    // Getters and Setters - Encapsulation
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "User [ID: " + userId + ", Name: " + name + ", Email: " + email + ", Phone: " + phone + "]";
    }
}
