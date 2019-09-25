package edu.mum.cs.wap.project.controller;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.regex.*;

import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.model.User;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/fileUpload")
public class ProfilePicUpload extends HttpServlet{
//    private final String UPLOAD_DIRECTORY = "C:/Users/HP/Desktop/project/WAP-SocialNetwork/src/main/webapp/images";


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String absoluteDiskPath = getServletContext().getRealPath("/images/profile");
        System.out.println(absoluteDiskPath);
//        String newPath = absoluteDiskPath.replace("\\", "/");
//        System.out.println(newPath);

        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(absoluteDiskPath + File.separator + name));

                        User user = (User)request.getSession().getAttribute("loginedUser");
                        int id = user.getUserId();

                        ProfileDAO profileDAO = new ProfileDAO();
                        profileDAO.setProfilePic(name, id);

                        //update the session

                        User newUser = new ProfileDAO().getUserById(id);
                        request.getSession().setAttribute("loginedUser", newUser);

                    }
                }

                System.out.println("File Uploaded Successfully");

            } catch (Exception ex) {
                System.out.println("File Upload Failed due to " + ex);
            }

        }else{
            System.out.println("Sorry this Servlet only handles file upload request");
        }

        response.sendRedirect("profile");

    }
}