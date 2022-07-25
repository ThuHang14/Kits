package org.example.main;

import org.example.daoimpl.EmployeeDaoImp;
import org.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDaoImp empDapImp = new EmployeeDaoImp();
        List<Employee> employeeList = new ArrayList<Employee>();

//        goi phuong thuc tra ve danh sach nhan vien
        employeeList = empDapImp.getAllEmployees();

//        employeeList.forEach(System.out::println);
    }
}
