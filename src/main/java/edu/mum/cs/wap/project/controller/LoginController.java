package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.service.LoginService;
import edu.mum.cs.wap.project.service.UserService;
import edu.mum.cs.wap.project.util.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        if(loginService.authenticateUser(userName, password)){
            User user = loginService.getUserByUserName(userName);
            AppUtils.storeLoginedUser(session, user);
            if (user.getRole().equals("ROLE_ADMIN")) {
                response.sendRedirect("admin");
            } else {
                response.sendRedirect("home");
            }

        }
        else{
            String errorMessage = "Invalid UserName/Password or Account is locked!!!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("view/user/login.jsp").forward(request, response);
        }


    }
}
