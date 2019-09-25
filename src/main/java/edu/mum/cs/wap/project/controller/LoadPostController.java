package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.PostDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// tungnd
@WebServlet("/loadPost")
public class LoadPostController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDAO postDAO = new PostDAO();
        if (postDAO.loadPost() != null) {
            request.setAttribute("postLists", postDAO.loadPost());
            request.getRequestDispatcher("/view/admin/managePost.jsp").forward(request, response);
        } else {
            response.sendRedirect("managePost");
        }
    }
}
