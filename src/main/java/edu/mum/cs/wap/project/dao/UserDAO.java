package edu.mum.cs.wap.project.dao;

import edu.mum.cs.wap.project.model.Post;
import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.service.UserService;
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

import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    private static SessionFactory sessionFactory;

    public void registerUser(String firstName, String lastName, String email, String username, String password,
                             String state, String city, String country, String gender){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            User user = new User(firstName, lastName, email, username, password, state, city, country, gender);
            user.setRole("ROLE_USER");
            session.save(user);
            transaction.commit();
            System.out.println("User registered");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //for following another user
    public boolean follow(User user, int id){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            user.getFriends().add(new UserService().getUserById(id));
            session.saveOrUpdate(user);

            session.getTransaction().commit();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }




}
