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

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {
    private static SessionFactory sessionFactory;

//    public void savePost(String firstName, String lastName) {
//        try {
//            //get session object
//            Session session = getSessionFactory().openSession();
//            //starting Transcation
//            Transaction transaction = session.beginTransaction();
//            User user = new User(firstName, lastName);
//            session.save(user);
//            transaction.commit();
//            System.out.println("New User added to Db");
//
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//            System.out.println("error");
//        }
//    }

    public List<User> getAllUsers() {
        try {
            //get session object
            Session session = getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            List<User> users = new ArrayList<User>();
            users = (List<User>) session.createQuery("FROM edu.mum.cs.wap.project.model.User").list();
            transaction.commit();
            System.out.println("User List Fetched");
            session.close();
            return users;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User getUserById(int id) {
        try {
            //get session object
            Session session = getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();


            User user = (User) session.get(User.class, id);
//             User user = findRecordById(id);
            transaction.commit();
            System.out.println("User List Fetched");
            session.close();
            return user;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User getUserByName(String name) {
        try {
            //get session object
            Session session = getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            String ql = "FROM edu.mum.cs.wap.project.model.User WHERE firstName = :name" ;
            List<User> users = (List<User>) session.createQuery(ql);
            transaction.commit();
            System.out.println("User List Fetched");
            session.close();
            return null;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(User.class);
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);

        return sessionFactory;
    }
}
