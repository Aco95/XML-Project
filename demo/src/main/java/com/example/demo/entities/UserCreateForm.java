package com.example.demo.entities;


import javax.validation.constraints.NotNull;

public class UserCreateForm {

   
    private String email = "";

  
    private String password = "";

    
    private String passwordRepeated = "";

    
    private Uloga role = Uloga.USER;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public Uloga getRole() {
        return role;
    }

    public void setRole(Uloga role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
                "email='" + email + '\'' +
                ", password=***" + '\'' +
                ", passwordRepeated=***" + '\'' +
                ", role=" + role +
                '}';
    }

}
