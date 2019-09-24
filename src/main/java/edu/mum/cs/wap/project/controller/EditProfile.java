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

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

//        try{
//            ProfileDAO profileDAO = new ProfileDAO();
//            profileDAO.get(title, description);
//            response.sendRedirect("success.jsp");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response) throws ServletException, IOException {
//        String title = request.getParameter("title");
//        String description = request.getParameter("description");
//
//        try{
//            PostDAO postDAO = new PostDAO();
//            postDAO.savePost(title, description);
//            response.sendRedirect("success.jsp");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
