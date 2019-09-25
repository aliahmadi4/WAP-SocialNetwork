package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.PostDAO;
import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.model.Post;
import edu.mum.cs.wap.project.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            PostDAO postDAO = new PostDAO();
            List<Post> posts = postDAO.getAllPosts();
            request.setAttribute("posts",posts);
            request.getRequestDispatcher("/view/home/index.jsp").forward(request,response);
        }catch (Exception e){
            System.out.println("Could not fetch Posts! "+e.getStackTrace());
        }
    }
}