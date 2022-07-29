package com.example.todolistjsp.dao;

import com.example.todolistjsp.model.Todo;
import com.example.todolistjsp.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    @Override
    public boolean insertTodo(Todo todo) {

        boolean status = false;
        String INSERT_USERS_SQL = "INSERT INTO todos" +
                " (title,desciption,is_done,target_date,user_id)" +
                " VALUES (?,?,?,?,?);";

        try (Connection conn = JDBCUtils.connection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);

            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setBoolean(3, todo.isIs_done());
            preparedStatement.setDate(4, (Date) todo.getTarget_date());
            preparedStatement.setInt(5, todo.getUser_id());

            if (preparedStatement.executeUpdate() > 0) {
                status = true;
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("UserDao.registerUser that bai");
            throw new RuntimeException(e);
        }

        return status;
    }

    @Override
    public Todo selectTodo(int id) {
        Todo todo = null;
        String SELECT_ALL_TODO = "SELECT * FROM todos WHERE id = ?";

        try (Connection conn = JDBCUtils.connection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_TODO);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ids = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("desciption");
                boolean isDone = rs.getBoolean("is_done");
                Date date = rs.getDate("target_date");
                int userId = rs.getInt("user_id");

                todo = new Todo(title, description, date, userId, isDone);
            }


        } catch (SQLException e) {
            System.out.println("UserDao.registerUser that bai");
            throw new RuntimeException(e);
        }

        return todo;
    }

    @Override
    public List<Todo> selectAllTodos() {
        List<Todo> todoList = new ArrayList<>();

        String SELECT_ALL_TODO = "SELECT * FROM todos";

        try (Connection conn = JDBCUtils.connection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_TODO);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ids = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("desciption");
                boolean isDone = rs.getBoolean("is_done");
                Date date = rs.getDate("target_date");
                int userId = rs.getInt("user_id");

                todoList.add(new Todo(title, description, date, userId, isDone));
            }


        } catch (SQLException e) {
            System.out.println("UserDao.registerUser that bai");
            throw new RuntimeException(e);
        }


        return todoList;
    }

    @Override
    public boolean deleteTodo(int id) {
        boolean status = false;
        String INSERT_USERS_SQL = "DELETE from todos WHERE id = ?";

        try (Connection conn = JDBCUtils.connection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);

            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("UserDao.registerUser that bai");
            throw new RuntimeException(e);
        }

        return status;
    }

    @Override
    public boolean updateTodo(Todo todo) {
        boolean status = false;
        String INSERT_USERS_SQL = "UPDATE todos SET title = ?,desciption = ?" +
                ",is_done = ? ,target_date = ? ,user_id = ? " +
                "WHERE id = ?";

        try (Connection conn = JDBCUtils.connection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);

            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setBoolean(3, todo.isIs_done());
            preparedStatement.setDate(4, (Date) todo.getTarget_date());
            preparedStatement.setInt(5, todo.getUser_id());
            status = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("UserDao.registerUser that bai");
            throw new RuntimeException(e);
        }

        return status;
    }
}
