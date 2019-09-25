package edu.mum.cs.wap.project.util;

import edu.mum.cs.wap.project.model.User;

import javax.servlet.http.HttpSession;

public class AppUtils {
    // Store user info in Session.
    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }
    // Get the user information stored in the session.
    public static User getLoginedUser(HttpSession session) {
        User loginedUser = (User) session.getAttribute("loginedUser");
        return loginedUser;
    }
}
