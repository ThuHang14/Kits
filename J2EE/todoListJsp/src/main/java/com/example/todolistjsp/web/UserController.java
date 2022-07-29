package com.example.todolistjsp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRegister(request, response);
    }

    private void processRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("txtName");
        String pass = request.getParameter("pass");
        String pass2 = request.getParameter("pass");
    }
}
