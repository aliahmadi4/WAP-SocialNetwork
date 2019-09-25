package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.PostDAO;
import edu.mum.cs.wap.project.dao.ProfileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// tungnd - Update the status of post
@WebServlet("/managePost")
public class ManagePostController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String postId = request.getParameter("postId");
            PostDAO postDAO = new PostDAO();
            postDAO.updatePostStatus(Integer.parseInt(postId));
            response.sendRedirect("loadPost");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
