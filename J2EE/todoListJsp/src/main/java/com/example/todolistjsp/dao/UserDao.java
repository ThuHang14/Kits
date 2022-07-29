package com.example.todolistjsp.dao;

import com.example.todolistjsp.model.User;
import com.example.todolistjsp.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public int registerUser(User user) {
        int rersult = 0;

        String INSERT_USERS_SQL = "INSERT INTO users" +
                " (firt_name,last_name,username,password)" +
                " VALUES (?,?,?,?);";

        try (Connection conn = JDBCUtils.connection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);

            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            rersult = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("UserDao.registerUser that bai");
            throw new RuntimeException(e);
        }
        return rersult;
    }
}
