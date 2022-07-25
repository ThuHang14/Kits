package org.example.daoimpl;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {
    public Employee getEmployeeById(int id) {
        return null;
    }

    public Employee getEmployeeByName(String name) {
        return null;
    }

    public void getEmployeeByEmail(String email) {

    }

    public String getNameById(int id) {
        return null;
    }

    public List<Employee> getAllEmployees() {
//        b1 : ket noi mySql
        String dbUrl = "jdbc:mysql://localhost:8080/users";
        List<Employee> employeeList = new ArrayList<Employee>();
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(dbUrl,"root","123");
//            b2: dinh nghia truy van va thuc hien truy van
            String sql = "SELECT * from employee";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
//          b3 :  xu li ket qua tra ve
            while (rs.next()){
                Employee e =new Employee();
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
            return employeeList;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ket noi that bai");
        }
        return null;
    }

    public void saveEmployee(Employee emp) {

    }

    public void updateEmployee(Employee emp) {

    }

    public void deleteEmployee(Employee emp) {

    }
}
