package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.dao.UserDAO;
import edu.mum.cs.wap.project.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/manageUser")
public class UserController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = request.getParameter("userId");
            ProfileDAO profileDAO = new ProfileDAO();
            profileDAO.updateUserStatus(Integer.parseInt(userId));
//            request.getRequestDispatcher("/view/admin/manageAccount.jsp").forward(request, response);
            response.sendRedirect("manageAccount");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
