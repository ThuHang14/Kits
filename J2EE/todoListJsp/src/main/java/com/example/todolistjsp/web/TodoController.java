package com.example.todolistjsp.web;

import com.example.todolistjsp.dao.TodoDao;
import com.example.todolistjsp.model.Todo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "todo", value = "/todo")
public class TodoController extends HttpServlet {

    private TodoDao todoDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.sendRedirect("todo/todo.jsp");
            String action = request.getServletPath();
            try {
                switch (action){
                    case "/listTodo" :
                        listTodo(request,response);
                        break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    private void listTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Todo>todoList = todoDao.selectAllTodos();
        request.setAttribute("listTodo",todoList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
