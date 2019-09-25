package edu.mum.cs.wap.project.filter;

import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.util.AppUtils;
import edu.mum.cs.wap.project.util.SecurityUtils;
import edu.mum.cs.wap.project.util.UserRoleRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class SecurityFilter implements Filter {



    public void init(FilterConfig filterConfig) throws ServletException {

    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession(false);
//        String loginUri = request.getContextPath() + "/login";

        //get loggedin user information
//        User loginedUser = (User)session.getAttribute("loginedUser");
//        boolean logined = session!= null && session.getAttribute("loginedUser") != null;
//        boolean loginRequest = request.getRequestURI().equals(loginUri);
//        if(logined || loginRequest){
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//            // If the user is not logged in,
//            // Redirect to the login page.
//            else  {
//                response.sendRedirect(loginUri);
//            }
        String servletPath = request.getServletPath();

        // User information stored in the Session.
        // (After successful login).
        User loginedUser = AppUtils.getLoginedUser(request.getSession());
        if (servletPath.equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        HttpServletRequest wrapRequest = request;

        if (loginedUser != null) {
            // User Name
            String userName = loginedUser.getUsername();

            // Roles
            String role = loginedUser.getRole();

            // Wrap old request by a new Request with userName and Roles information.
            wrapRequest = new UserRoleRequestWrapper(userName, role, request);
        }
        // Pages must be signed in.
        if (SecurityUtils.isSecurityPage(request)) {

            // If the user is not logged in,
            // Redirect to the login page.
            if (loginedUser == null) {

                String requestUri = request.getRequestURI();

                // Store the current page to redirect to after successful login.
                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

                response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }

            // Check if the user has a valid role?
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {

                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher("/view/user/login.jsp");

                dispatcher.forward(request, response);
                return;
            }
        }

        filterChain.doFilter(wrapRequest, response);

    }


    public void destroy() {

    }
}
