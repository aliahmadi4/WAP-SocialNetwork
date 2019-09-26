package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");

        try{
            UserDAO registerDAO = new UserDAO();
            registerDAO.registerUser(firstName, lastName, email, username, password, state, city, country, gender);
            response.sendRedirect("login");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
