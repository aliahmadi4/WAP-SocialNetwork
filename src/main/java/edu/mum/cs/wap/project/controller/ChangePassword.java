package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        String repeatPassword = request.getParameter("repeat-password");

        response.setContentType("text/html");
        System.out.println(oldPassword +" "+ newPassword +" "+ repeatPassword);

        User user = (User) request.getSession().getAttribute("loginedUser");
        if(user.getPassword().equals(oldPassword)){
            if(newPassword.equals(repeatPassword) && !newPassword.equals("")){
                try{
                    //change password in database
                    int id = user.getUserId();
                    ProfileDAO profileDAO = new ProfileDAO();
                    profileDAO.setPassword(newPassword, id);

                    //update the session
                    User newUser = new ProfileDAO().getUserById(id);
                    request.getSession().setAttribute("loginedUser", newUser);
                    response.getWriter().write("Password Successfuly Changed!");
                }catch (Exception e){
                    System.out.println("could not change the password" + e.getStackTrace());
                    response.getWriter().write("Could not change the password!");
                }

            }else{
                response.getWriter().write("New password and repeat password does not match or its empty!");
            }
        }else{
            response.getWriter().write("Wrong Old Password!");
        }


    }
}
