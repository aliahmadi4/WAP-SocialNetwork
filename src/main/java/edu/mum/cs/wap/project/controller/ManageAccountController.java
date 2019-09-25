package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.ProfileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// tungnd
@WebServlet("/manageAccount")
public class ManageAccountController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfileDAO userDAO = new ProfileDAO();
        if (userDAO.getAllUsers() != null) {
            request.setAttribute("userLists", userDAO.getAllUsers());
            request.getRequestDispatcher("/view/admin/manageAccount.jsp").forward(request, response);
        } else {
            response.sendRedirect("/view/admin/manageAccount.jsp");
        }
    }
}
