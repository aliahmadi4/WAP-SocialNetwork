package edu.mum.cs.wap.project.controller;

import com.google.gson.Gson;
import edu.mum.cs.wap.project.dao.PostDAO;
import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.dao.UserDAO;
import edu.mum.cs.wap.project.model.Post;
import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.util.AppUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/follow")
public class FollowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int follower_id = Integer.parseInt( request.getParameter("follower_id"));
        PrintWriter out = response.getWriter();
        UserDAO userDAO = new UserDAO();
        ProfileDAO profileDAO = new ProfileDAO();
        PostDAO postDAO = new PostDAO();
        List<User> otherUsers = new ArrayList<>();
        Set<Post> postList = new HashSet<>();
        if(userDAO.follow(AppUtils.getLoginedUser(request.getSession()), follower_id)){
            //otherUsers = profileDAO.getOtherUser(AppUtils.getLoginedUser(request.getSession()));
            //postList = postDAO.getAllPostByUserAndFollower(AppUtils.getLoginedUser(request.getSession()));
//            response.sendRedirect("home");

            response.sendRedirect("home");
        }
//        String userJSON;
//        userJSON = new Gson().toJson(otherUsers);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        out.write(userJSON);


    }
}
