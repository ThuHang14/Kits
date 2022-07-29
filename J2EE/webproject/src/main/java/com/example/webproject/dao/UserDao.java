package com.example.webproject.dao;

import com.example.webproject.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private String jdbcURL = "jdbc:mysql://localhost:7000/Users";
    private String jdbcUserName = "root";
    private String jdbcPass = "123";

    //    private static final String
    private static String SELECT_ALL_USERS = "SELECT * FROM users";
    private static String SELECT_USERS_BY_NAME = "SELECT * FROM `users` WHERE name LIKE '%";
    private static String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ? ";
    private static String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ? ";

    //    DELETE FROM users WHERE id = 10 and 9
    private static final String INSERT_USERS_SQL = "insert into users (name, email, country) values (?, ?, ?);";

    private static String UPDATE_USERS_BY_ID = "UPDATE users SET name= ? , email = ? , country= ? WHERE id = ? ";


    protected Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPass);
        } catch (SQLException e) {
            System.out.println("ket noi that bai");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public List<User> selectAllUsers() { // jdbc lay database -> resulset -> list
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect().prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getNString("email");
                String country = rs.getNString("country");

                userList.add(new User(id, name, email, country));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    public List<User> findUserByName(String search) {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect().prepareStatement(SELECT_USERS_BY_NAME + search + "%'");
//            preparedStatement.setString(1,search);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getNString("email");
                String country = rs.getNString("country");

                userList.add(new User(id, name, email, country));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public boolean deleteUserById(int id) {
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connect().prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public void updateUser(User user) {

        try {
            PreparedStatement preparedStatement = connect().prepareStatement(UPDATE_USERS_BY_ID);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCountry());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertNewUser(User user) {
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connect().prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public User getUserById(int id) {
        User u = new User();

        try {
            PreparedStatement preparedStatement = connect().prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getNString("email");
                String country = rs.getNString("country");

                u.setName(name);
                u.setEmail(email);
                u.setCountry(country);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return u;
    }
}
