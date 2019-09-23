package edu.mum.cs.wap.project.dao;

import edu.mum.cs.wap.project.model.Post;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PostDAO {
private static SessionFactory sessionFactory;
public void savePost(String title, String description){
        try{
                //get session object
                Session session =getSessionFactory().openSession();
                //Start the transaction
                Transaction transaction = session.beginTransaction();
                Post post = new Post(title, description);
                session.save(post);
                transaction.commit();

                   System.out.println("New Post added to Db");

        }
        catch (HibernateException e){
        System.out.println(e.getMessage());
        System.out.println("error");
        }
        }


public static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(edu.mum.cs.wap.project.model.Post.class);
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactory;
        }
        }