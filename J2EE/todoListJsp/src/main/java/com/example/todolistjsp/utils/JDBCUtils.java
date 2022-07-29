package com.example.todolistjsp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    private static final String jdbcURL = "jdbc:mysql://localhost:7000/TodoList";
    private static final String user = "root";
    private static final String pass = "123";

    public static Connection connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL,user,pass);
        } catch (SQLException e) {
            System.out.println("key noi sql that bai");
            throw new RuntimeException(e);
        }

        return connection;
    }
}
