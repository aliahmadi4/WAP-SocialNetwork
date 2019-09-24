package edu.mum.cs.wap.project.controller;

import edu.mum.cs.wap.project.dao.AdsDAO;
import edu.mum.cs.wap.project.model.Ads;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdsServlet", urlPatterns = "/createAds")
public class AdsController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdsDAO adsDAO = new AdsDAO();
        Ads ads = adsDAO.loadAds();
        if (ads != null) {
            request.setAttribute("adsTitle", ads.getAdsTitle());
            request.setAttribute("image", ads.getImageURL());
            RequestDispatcher rd = request.getRequestDispatcher("/view/admin/createAds.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("/view/admin/createAds.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adsTitle = request.getParameter("adsTitle");
        String imageURL = request.getParameter("imageURL");
        try {
            AdsDAO adsDAO = new AdsDAO();
            adsDAO.saveAds(adsTitle, imageURL);
            request.setAttribute("adsTitle", adsTitle);
            request.setAttribute("image", imageURL);
            RequestDispatcher rd = request.getRequestDispatcher("/view/admin/createAds.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
