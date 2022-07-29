package com.example.webproject.web;

import com.example.webproject.dao.UserDao;
import com.example.webproject.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "userServlet", value = "/user")
public class userServlet extends HttpServlet {

    private UserDao userDAO;

    public void init() {
        userDAO = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":

                case "/edit":
                    showNewForm(request, response);
                    break;

                case "/delete":
                    break;

                case "/update":
                    updateUser(request, response);
                    break;

                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list-jsp.jsp");
        dispatcher.forward(request, response);
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(id);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form-edit-jsp.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String country = request.getParameter("country");

        User user = userDAO.getUserById(id);
        user.setCountry(country);
        user.setEmail(mail);
        user.setName(name);

        userDAO.updateUser(user);

        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form-edit-jsp.jsp");
        dispatcher.forward(request, response);

        response.sendRedirect("/");
    }

}
