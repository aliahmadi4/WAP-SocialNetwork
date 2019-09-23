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
        PrintWriter out = response.getWriter();

        try{
            ProfileDAO profileDAO = new ProfileDAO();
            List<User> users = profileDAO.getAllUsers();
            out.println(users.toString());

        }catch (Exception e){
            e.printStackTrace();
            out.println("Error ocured");
        }

        //request.getRequestDispatcher("view/user/test.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");


        try{
            ProfileDAO profileDAO = new ProfileDAO();
            profileDAO.savePost(firstName, lastName);
            response.sendRedirect("success.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
