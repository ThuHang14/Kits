package org.example.views;

import org.example.daoimpl.EmployeeDaoImp;
import org.example.daoimpl.UserDaoImp;
import org.example.model.Employee;
import org.example.model.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class loginEmployee {
    Scanner sc = new Scanner(System.in);

    public void loginHome() {
        boolean isLogin = false;
        do {
            System.out.println("---------------- LOGIN --------------");
            System.out.println("email : ");
            String email = sc.nextLine();
            System.out.println("pass : ");
            String pass = sc.nextLine();

            User user = new User();
            UserDaoImp userDaoImp = new UserDaoImp();

            user = userDaoImp.getUserByEmailAndPassword(email, pass);

            if (user != null) {
                System.out.println("chao mung  " + user.getFirtName());
//            login thanh cong
                isLogin = true;
                choose();

            } else {
                System.out.println("dang nhap that bai");
            }
        } while (!isLogin);
    }

    public void choose() {
        Scanner sc = new Scanner(System.in);

        EmployeeDaoImp empDapImp = new EmployeeDaoImp();

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList = empDapImp.getAllEmployees();


        List<Employee> emp = new ArrayList<>();
        emp = empDapImp.getEmployeeByEmail("dbascomb0@ehow.com");

        System.out.println("-------------------------------------------");
        System.out.println("1.danh sach employee");
        System.out.println("2.lay ten employee theo id ");
        System.out.println("3. lay employee theo email ");
        System.out.println("4 . tim theo ten  employee");
        System.out.println("5. lay theo ten employee");
        System.out.println("6. them moi employee");
        System.out.println("7.xoa employee ");
        System.out.println("8. cap nhap employee ");
        System.out.println("orther. Thoat ");

        boolean checkWhile = true;
        while (checkWhile) {
            System.out.println("-------------------------------------------");
            System.out.println("nhap lua chon : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    employeeList.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("nhap id : ");
                    int id = sc.nextInt();
                    String findByName = empDapImp.getNameById(id);
                    if (findByName != null) {
                        System.out.println(findByName);
                    } else {
                        System.out.println("khong tim thay ket qua phu hop ");
                    }
                    break;
                case 3:
                    System.out.println("nhap email : ");
                    String emails = sc.nextLine();
                    empDapImp.getEmployeeByEmail(emails);
                    break;
                case 4:
                    System.out.println("nhap ten  : ");
                    String names = sc.nextLine();
                    empDapImp.getEmployeeByName(names);
                    break;
                case 5:
                    System.out.println("nhap id : ");
                    int ids = sc.nextInt();
                    Employee e = empDapImp.getEmployeeById(ids);
                    if (e != null) {
                        System.out.println(e);
                    } else {
                        System.out.println("khong hop le ");
                    }
                    break;
                case 6:
                    System.out.println("name");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("email");
                    String mail = new Scanner(System.in).nextLine();

                    Employee employee = new Employee(name,mail);
                    empDapImp.saveEmployee(employee);
                    break;
                case 7:
                    System.out.println("nhap stt employee");
                    int num = sc.nextInt();

//                    System.out.println("ban co muon xoa " + employeeList.get(num).getFullName());
//                    sc.nextLine();
//                    String yn = sc.nextLine();
//
//                    if(yn.toLowerCase().equals("y") ){
//                    empDapImp.deleteEmployee(employeeList.get(num));}
//                    else {
//                        System.out.println("huy xoa");
//                    }

                    int confirm = JOptionPane.showConfirmDialog(null,"ban muon xoa " + employeeList.get(num).getFullName(),"xoa thong tin nhan vien ",JOptionPane.YES_NO_OPTION);
                    if(confirm == 0){ //delete confirm
                        empDapImp.deleteEmployee(employeeList.get(num));}
                    break;
                case 8:
                    System.out.println("nhap stt employee");
                    int number = sc.nextInt();
                    empDapImp.updateEmployee(employeeList.get(number));

                    System.out.println(employeeList.get(number));
                    break;
                default:
                    System.out.println("Tam biet ");
                    checkWhile = false;
                    break;
            }
        }
    }

}
