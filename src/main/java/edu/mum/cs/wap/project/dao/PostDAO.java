package edu.mum.cs.wap.project.dao;

import edu.mum.cs.wap.project.model.Post;
import edu.mum.cs.wap.project.util.HibernateUtil;
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
            //get session object from utility file
            Session session = HibernateUtil.getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            Post post = new Post(title,description);
            session.save(post);
            transaction.commit();
            System.out.println("New Post added to Db");

        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
            System.out.println("error");
        }
    }



}
