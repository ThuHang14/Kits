package org.example.model;

import java.sql.Date;

public class User {

    private int id;
    private String email;
    private String passwords;
    private String firtName;
    private String lastName;
    private String address;
    private Date dod; //Util.sql
    private Boolean sex;
    private String phone;
    private Boolean isAdmin;
    private Boolean isActive;

    @Override
    public String toString() {
        return "User{" +
                " " + id +
                " " + email +
                " " + passwords +
                " " + firtName +
                " " + lastName +
                " " + address +
                " " + dod +
                " " + sex +
                " " + phone +
                " " + isAdmin +
                " " + isActive +
                '}';
    }

    public User() {
    }

    public User(String email, String passwords, String firtName, String lastName, String address, Date dod, Boolean sex, String phone, Boolean isAdmin, Boolean isActive) {
        this.email = email;
        this.passwords = passwords;
        this.firtName = firtName;
        this.lastName = lastName;
        this.address = address;
        this.dod = dod;
        this.sex = sex;
        this.phone = phone;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
