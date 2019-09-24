package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.PostDAO;
import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name ="ProfileController", urlPatterns = {"/profilecontroller"})
public class ProfileController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        PrintWriter out = response.getWriter();

        try{
            ProfileDAO profileDAO = new ProfileDAO();
            User user = profileDAO.getUserById(Integer.parseInt(userId));
            request.setAttribute("user", user);
        }catch (Exception e){
            e.printStackTrace();
            out.println("Error ocured");
        }
        request.getRequestDispatcher("view/user/my.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
