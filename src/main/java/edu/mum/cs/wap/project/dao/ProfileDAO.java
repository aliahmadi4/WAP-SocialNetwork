package edu.mum.cs.wap.project.dao;

import edu.mum.cs.wap.project.model.Post;
import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.util.AppUtils;
import edu.mum.cs.wap.project.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {
    private static SessionFactory sessionFactory;



    public List<User> getAllUsers() {
        try {
            //get session object
            Session session =  HibernateUtil.getSessionFactory().openSession();
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
            Session session = HibernateUtil.getSessionFactory().openSession();
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
            Session session = HibernateUtil.getSessionFactory().openSession();
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

    public int setProfilePic(String name, int id) {
        try {

            //get session object
            Session session = HibernateUtil.getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            String ql = "Update edu.mum.cs.wap.project.model.User SET profilePic = :name WHERE userId = :id" ;
            Query query =  session.createQuery(ql);
            query.setParameter("name", name);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            transaction.commit();
            System.out.println("Pic Updated");
            session.close();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int setPassword(String password, int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            String ql = "Update edu.mum.cs.wap.project.model.User SET password = :password WHERE userId = :id" ;
            Query query =  session.createQuery(ql);
            query.setParameter("password", password);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            transaction.commit();
            System.out.println("Password changed");
            session.close();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }




}
