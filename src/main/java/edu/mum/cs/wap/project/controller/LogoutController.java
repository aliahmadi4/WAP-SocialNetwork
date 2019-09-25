package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.UserDAO;
import edu.mum.cs.wap.project.util.AppUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.getSession().invalidate();

        // Redrect to Login Page.
        response.sendRedirect( request.getContextPath()+"/login");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.doGet(request, response);
    }
}
