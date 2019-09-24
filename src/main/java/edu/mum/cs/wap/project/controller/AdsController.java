package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.AdsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Blob;

@WebServlet(name = "AdsServlet", urlPatterns = "/createAds")
public class AdsController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adsTitle = request.getParameter("adsTitle");
        String imageURL = request.getParameter("imageURL");
        try {
            AdsDAO adsDAO = new AdsDAO();
            adsDAO.saveAds(adsTitle, imageURL);
            request.setAttribute("ads", imageURL);
            RequestDispatcher rd = request.getRequestDispatcher("/createAds.jsp");
            rd.forward(request, response);
            //response.sendRedirect("/createAds.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
