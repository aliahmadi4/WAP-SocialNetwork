//package edu.mum.cs.wap.project.filter;
//
//import edu.mum.cs.wap.project.model.User;
//import edu.mum.cs.wap.project.util.AppUtils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
////@WebFilter("/*")
//public class SecurityFilter implements Filter {
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response= (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();
//        String servletPath = request.getServletPath();
//        //get loggedin user information
//        User user = AppUtils.getLoginedUser(session);
//        if(servletPath.equals("/login")){
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
