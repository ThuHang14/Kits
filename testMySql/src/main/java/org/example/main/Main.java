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

        employeeList.forEach(System.out::println);

        String findByName = empDapImp.getNameById(2);
        System.out.println(findByName);

        empDapImp.getEmployeeByEmail("A@gmail.com");

      empDapImp.getEmployeeByName("nguyen van A");

        Employee e = empDapImp.getEmployeeById(3);

        System.out.println(e);

        empDapImp.saveEmployee(e);

        empDapImp.deleteEmployee(e);

        empDapImp.updateEmployee(e);
    }
}
