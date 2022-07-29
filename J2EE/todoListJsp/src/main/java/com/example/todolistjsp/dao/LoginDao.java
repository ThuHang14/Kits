package com.example.todolistjsp.dao;

import com.example.todolistjsp.model.LoginBean;
import com.example.todolistjsp.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public boolean checkLogin(LoginBean user){
        boolean status = false;

        String INSERT_USERS_SQL = "SELECT u.id, u.firt_name FROM users u WHERE u.username = ? AND password = ?";

        try (Connection conn = JDBCUtils.connection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);

          preparedStatement.setString(1,user.getUserName());
          preparedStatement.setString(2,user.getPassword());
            ResultSet rs = preparedStatement.executeQuery();

            status = rs.next();

        } catch (SQLException e) {
            System.out.println("UserDao.registerUser that bai");
            throw new RuntimeException(e);
        }
        return status;
    }
}
