package edu.mum.cs.wap.project.util;

import java.util.*;

public class SecurityConfig {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {

        // Configure For "Admin" Role.
        List<String> urlPatterns1 = new ArrayList<String>();

        urlPatterns1.add("/*");


        mapConfig.put(ROLE_ADMIN, urlPatterns1);

        // Configure For "User" Role.
        List<String> urlPatterns2 = new ArrayList<String>();

        urlPatterns2.add("/*");


        mapConfig.put(ROLE_USER, urlPatterns2);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}
