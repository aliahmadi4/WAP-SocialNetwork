package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.util.AppUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // tungnd - Added get session for logging out Admin page
        HttpSession session = request.getSession();
        System.out.println("session " + session);
        User user = AppUtils.getLoginedUser(session);
        System.out.println("User login " + user.toString());
        request.getSession().invalidate();
        response.sendRedirect("login");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.doGet(request, response);
    }
}
