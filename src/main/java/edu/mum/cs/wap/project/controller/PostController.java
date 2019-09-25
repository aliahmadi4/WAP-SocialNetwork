package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.PostDAO;
import edu.mum.cs.wap.project.dao.ProfileDAO;
import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.util.AppUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="PostController", urlPatterns = {"/createpost"})
public class PostController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String absoluteDiskPath = getServletContext().getRealPath("/images/post");
        System.out.println(absoluteDiskPath);

        String photoName="";
        String description="";
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for(FileItem item : multiparts){
                    if(item.isFormField()){
                        description = item.getString();

                    }else{
                        photoName = new File(item.getName()).getName();
                        if(photoName.length() >3){
                            item.write( new File(absoluteDiskPath + File.separator + photoName));
                        }

                    }
                }

                //File uploaded successfully
                System.out.println("File Uploaded Successfully");
                PostDAO postDAO = new PostDAO();
                postDAO.savePost(description, AppUtils.getLoginedUser(request.getSession()), photoName);
                response.sendRedirect("home");
            } catch (Exception ex) {
                System.out.println("File Upload Failed due to " + ex);
            }

        }else{
            System.out.println("Sorry this Servlet only handles file upload request");
        }



    }
}
