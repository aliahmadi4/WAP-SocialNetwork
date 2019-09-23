package edu.mum.cs.wap.project.dao;



import edu.mum.cs.wap.project.model.Post;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.HibernateQuery;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

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

        //This mehtod get posts by usrId: getPostByUserID

        public List<Post> getPostByUserID(int userId) {
       // post= null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Transaction tx=null;
        Post post  =null;
        try{
                tx=session.getTransaction();
                tx.begin();
                Query query = (Query) session.createQuery("from edu.mum.cs.wap.project.model.Post where userId='"+userId+"'").list();
                post= (Post)query.uniqueResult();
                tx.commit();
        }
        catch (Exception e)
                {
                        if(tx!=null){
                                tx.rollback();
                        }                }
        finally {
                session.close();
        }
        return  post;
}

//getpost by postId:
        public Post getPostByPostId( int postId){
        Session session = getSessionFactory().openSession();
        Transaction tx=null;
        Post post= null;
        try{
                tx=session.getTransaction();
                tx.begin();
                Query query = (Query) session.createQuery ("from edu.mum.cs.wap.project.model.Post where postId='"+postId+"'");
                post= (Post)query.uniqueResult();
                tx.commit();
        }
        catch ( Exception e)
        {
        System.out.println("Can't get the post, please search again");
        }
        finally {
        }
return  post;
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