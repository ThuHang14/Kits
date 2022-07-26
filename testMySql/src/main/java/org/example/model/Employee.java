package org.example.model;

public class Employee {
    private int id;
    private String fullName;
    private String lastName;
    private String email;
    private int hourWorkPerDay;
    private int logWork;
    private double fixedSalary;
    private int outSideServiceNumber;
    private double totalSalary;

    public Employee(String name, String mail) {
    }

    @Override
    public String toString() {
        return "Employee{" +
                " " + id +
                " " + fullName +
                " " + lastName +
                " " + email +
                " " + hourWorkPerDay +
                " " + logWork +
                " " + fixedSalary +
                " " + outSideServiceNumber +
                " " + totalSalary +
                '}';
    }

    public Employee() {
    }

    public Employee(String fullName, String lastName, String email, int hourWorkPerDay, int logWork, double fixedSalary, int outSideServiceNumber, double totalSalary) {
        this.fullName = fullName;
        this.lastName = lastName;
        this.email = email;
        this.hourWorkPerDay = hourWorkPerDay;
        this.logWork = logWork;
        this.fixedSalary = fixedSalary;
        this.outSideServiceNumber = outSideServiceNumber;
        this.totalSalary = totalSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHourWorkPerDay() {
        return hourWorkPerDay;
    }

    public void setHourWorkPerDay(int hourWorkPerDay) {
        this.hourWorkPerDay = hourWorkPerDay;
    }

    public int getLogWork() {
        return logWork;
    }

    public void setLogWork(int logWork) {
        this.logWork = logWork;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public int getOutSideServiceNumber() {
        return outSideServiceNumber;
    }

    public void setOutSideServiceNumber(int outSideServiceNumber) {
        this.outSideServiceNumber = outSideServiceNumber;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
