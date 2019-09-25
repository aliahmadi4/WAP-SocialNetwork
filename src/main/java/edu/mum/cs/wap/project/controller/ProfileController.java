package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.PostDAO;
import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.dao.UserDAO;
import edu.mum.cs.wap.project.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name ="ProfileController", urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        System.out.println(userId);

        if(userId==null){
            User user = (User)request.getSession().getAttribute("loginedUser");
            userId = String.valueOf(user.getUserId());


        }

        try{
            ProfileDAO profileDAO = new ProfileDAO();
            User user = profileDAO.getUserById(Integer.parseInt(userId));
            request.setAttribute("user", user);
        }catch (Exception e){
            e.printStackTrace();
        }



        request.getRequestDispatcher("view/user/profile.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
