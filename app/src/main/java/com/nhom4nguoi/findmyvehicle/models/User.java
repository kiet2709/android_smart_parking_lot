package com.nhom4nguoi.findmyvehicle.models;

public class User {
    private String username;
    private String password;

    public User(String studentCode, String password) {
        this.username = studentCode;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setStudentCode(String studentCode) {
        this.username = studentCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }
}
