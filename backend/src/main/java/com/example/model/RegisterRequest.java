package com.example.model;

public class RegisterRequest {
    private String lastName;
    private String firstname;
    private String password;
    private String email;

    // Getters et Setters
    public String getlastName() {
        return lastName;
    }

    public void setlastName (String lastName) {
        this.lastName = lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname (String firstname) {
        this.firstname = firstname;
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
