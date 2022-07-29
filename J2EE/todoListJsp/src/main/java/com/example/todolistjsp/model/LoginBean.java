package com.example.todolistjsp.model;

public class LoginBean {
    private String userName;
    private String password;

    public LoginBean(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                " " + userName +
                " " + password +
                '}';
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
}
