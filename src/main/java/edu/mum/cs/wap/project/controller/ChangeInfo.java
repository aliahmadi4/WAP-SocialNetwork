package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeInfo")
public class ChangeInfo extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        response.setContentType("text/html");

        int userId = ((User)request.getSession().getAttribute("loginedUser")).getUserId();
        try{
            new ProfileDAO().updateInfo(firstName,lastName,email,userId);
            response.getWriter().write("successful");

        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().write("Could not change the Info");
        }






    }
}
