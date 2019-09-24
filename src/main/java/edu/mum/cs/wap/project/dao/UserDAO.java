package edu.mum.cs.wap.project.dao;

import edu.mum.cs.wap.project.model.Post;
import edu.mum.cs.wap.project.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class UserDAO {
    private static SessionFactory sessionFactory;

    public void registerUser(String firstName, String lastName, String email, String username, String password,
                             String state, String city, String country, String gender) {
        try {
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            User user = new User(firstName, lastName, email, username, password, state, city, country, gender);
            user.setRole("ROLE_USER");
            user.setStatus(true);        // tungnd - Set default status of account
            session.save(user);
            transaction.commit();
            System.out.println("User registered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User findUserByUsernamePassword(String userName, String password) {
        return new User();
    }

    // tungnd - Load all users in the Manage Account page
    public User loadUser() {
        try {
            Session session = getSessionFactory().openSession();
            User user = session.get(User.class, 2);
            return user;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(edu.mum.cs.wap.project.model.User.class);
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);

        return sessionFactory;
    }
}
