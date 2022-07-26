package org.example.daoimpl;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;
import org.example.ultils.DBCconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDaoImp implements EmployeeDao {

    String dbUrl = "jdbc:mysql://localhost:8080/Employee";

    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, "root", "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public Employee getEmployeeById(int id) {
        String query = "SELECT * FROM `employee` e  WHERE e.id = " + id;
        try {
            Statement stm = connection().createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setEmail(rs.getString("email"));
                e.setFullName(rs.getString("fullName"));
                e.setFixedSalary(rs.getDouble("fixed_salary"));
                e.setHourWorkPerDay(rs.getInt("hour_work_per_day"));
                e.setLogWork(rs.getInt("long_work"));
                e.setOutSideServiceNumber(rs.getInt("outside_service_number"));
                e.setTotalSalary(rs.getDouble("total_salary"));

                rs.close();
                return e;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Employee> getEmployeeByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        String query = "SELECT * FROM `employee` e WHERE e.fullName = \'" + name + "\'";
        try {
            Statement stm = connection().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setEmail(rs.getString("email"));
                e.setFullName(rs.getString("fullName"));
                e.setFixedSalary(rs.getDouble("fixed_salary"));
                e.setHourWorkPerDay(rs.getInt("hour_work_per_day"));
                e.setLogWork(rs.getInt("long_work"));
                e.setOutSideServiceNumber(rs.getInt("outside_service_number"));
                e.setTotalSalary(rs.getDouble("total_salary"));

                employeeList.add(e);
            }
            rs.close();
            employeeList.forEach(System.out::println);
            return employeeList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getEmployeeByEmail(String email) {
        List<Employee> employeeList = new ArrayList<>();
        String query = "SELECT * FROM `employee` e WHERE e.email = \'" + email + "\'";
        try {
            Statement stm = connection().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setEmail(rs.getString("email"));
                e.setFullName(rs.getString("fullName"));
                e.setFixedSalary(rs.getDouble("fixed_salary"));
                e.setHourWorkPerDay(rs.getInt("hour_work_per_day"));
                e.setLogWork(rs.getInt("long_work"));
                e.setOutSideServiceNumber(rs.getInt("outside_service_number"));
                e.setTotalSalary(rs.getDouble("total_salary"));

                employeeList.add(e);
            }
            rs.close();
            employeeList.forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    public String getNameById(int id) {
        String query = "SELECT e.fullName FROM `employee` e  WHERE e.id = " + id;
        try {
            Statement stm = connection().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String str = rs.getString("fullName");
                rs.close();
                return str;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(dbUrl, "root", "123");
//            String sql = "SELECT e.fullName FROM `employee` e  WHERE e.id = " + id;
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String str = rs.getString("fullName");
//                return str;
//            }
//        } catch (SQLException e) {
//            System.out.println("ket noi that bai");
//            throw new RuntimeException(e);
//        }
        return null;
    }

    public List<Employee> getAllEmployees() {
//        b1 : ket noi mySql
        List<Employee> employeeList = new ArrayList<Employee>();
//        Connection conn = null;
        try {
//            conn = DriverManager.getConnection(dbUrl, "root", "123");

            DBCconnection dbc = new DBCconnection();
            dbc.connectDB();
//            b2: dinh nghia truy van va thuc hien truy van
            String sql = "SELECT * from employee";
//            PreparedStatement ps = conn.prepareStatement(sql);
            PreparedStatement ps = dbc.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
//          b3 :  xu li ket qua tra ve
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setEmail(rs.getString("email"));
                e.setFullName(rs.getString("fullName"));
                e.setFixedSalary(rs.getDouble("fixed_salary"));
                e.setHourWorkPerDay(rs.getInt("hour_work_per_day"));
                e.setLogWork(rs.getInt("long_work"));
                e.setOutSideServiceNumber(rs.getInt("outside_service_number"));
                e.setTotalSalary(rs.getDouble("total_salary"));

                employeeList.add(e);

            }
//            b4 dong ket noi
//            rs.close();
            dbc.disConnectDb();
            return employeeList;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ket noi that bai");
        }
        return null;
    }

    public void saveEmployee(Employee emp) {

        String query = "INSERT INTO `employee` ( `fullName`, `email`, `hour_work_per_day`, `long_work`, `fixed_salary`, `outside_service_number`, `total_salary`) " +
                "VALUES("
                + "\'" + emp.getFullName() + "\',"
                + "\'" + emp.getEmail() + "\',"
                + "\'" + emp.getHourWorkPerDay() + "\',"
                + "\'" + emp.getLogWork() + "\',"
                + "\'" + emp.getFixedSalary() + "\',"
                + "\'" + emp.getOutSideServiceNumber() + "\',"
                + "\'" + emp.getTotalSalary() + "\'"
                + ");";



        try {
            Statement stm = connection().createStatement();
            stm.executeUpdate(query);
            System.out.println("save success");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateEmployee(Employee emp) {
        String query = "UPDATE employee e \n" +
                "SET e.fullName='" + emp.getFullName() + "\' " +
                ",e.email = ' " + emp.getEmail() + "\' \n" +
                "WHERE id=" + emp.getId();

        try {
            Statement stm = connection().createStatement();
            stm.executeUpdate(query);
            System.out.println("update success");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmployee(Employee emp) {
        String query = "delete from employee WHERE id=" + emp.getId();
        try {
            Statement stm = connection().createStatement();
             stm.executeUpdate(query);
            System.out.println("delete success");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
