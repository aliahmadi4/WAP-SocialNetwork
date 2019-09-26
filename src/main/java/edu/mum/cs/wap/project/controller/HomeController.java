package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.PostDAO;
import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.dao.UserDAO;
import edu.mum.cs.wap.project.model.Post;
import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.util.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            if(AppUtils.getLoginedUser(request.getSession())==null){
                response.sendRedirect("login");
                return;
            }
            PostDAO postDAO = new PostDAO();
            ProfileDAO profileDAO = new ProfileDAO();
         //   List<Post> posts = postDAO.getAllPosts();
            List<Post> posts = postDAO. getAllPostByUserAndFollower(AppUtils.getLoginedUser(request.getSession()));
            request.setAttribute("posts",posts);
             User currentUser = AppUtils.getLoginedUser(request.getSession());
            Set<User> userList = profileDAO.getOtherUser(currentUser);
            //using Lambda exp to remove user
//            userList.removeIf( u-> u.getUserId()==currentUser.getUserId());
            request.setAttribute("userList", userList);
            //update the session
            int userId= ((User)request.getSession().getAttribute("loginedUser")).getUserId();
            User newUser = new ProfileDAO().getUserById(userId);
            request.getSession().setAttribute("loginedUser", newUser);


            request.getRequestDispatcher("/view/home/index.jsp").forward(request,response);
        }catch (Exception e){
            System.out.println("Could not fetch Posts! "+e.getStackTrace());
        }
    }
}