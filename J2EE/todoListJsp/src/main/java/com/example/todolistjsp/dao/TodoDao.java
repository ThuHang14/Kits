package com.example.todolistjsp.dao;

import com.example.todolistjsp.model.Todo;

import java.util.List;

public interface TodoDao {
    public boolean insertTodo(Todo todo);

    public Todo selectTodo(int id);

    public List<Todo> selectAllTodos();

    public boolean deleteTodo(int id);

    public boolean updateTodo(Todo todo);
}
