package edu.mum.cs.wap.project.dao;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;
import edu.mum.cs.wap.project.model.Post;
import edu.mum.cs.wap.project.model.User;
import javafx.geometry.Pos;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.HibernateQuery;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
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

//Display all posts from the database:
        public   List<Post> displayPosts(){
        List <Post> postList= new ArrayList<>();
        try{
                Session session= getSessionFactory().openSession();
                session.beginTransaction();
                postList= session.createQuery( "from  edu.mum.cs.wap.project.model.Post").list();
                System.out.println(" Displaying the post is running!");
                session.close();
        }
        catch (HibernateException e) {
                System.out.println("Error  is displaying the posts");
        }
        return  postList;
        }


        public   List<Post> displayPostByUserId(int userId){
                List <Post> postList= new ArrayList<>();

                try{
                        Session session= getSessionFactory().openSession();
                        session.beginTransaction();
                        postList= session.createQuery( "from  edu.mum.cs.wap.project.model.Post  Where userId=:userId").list();

                        System.out.println(" Displaying the post is running!");
                        session.close();
                }
                catch (HibernateException e) {
                        System.out.println("Error  is displaying the posts");
                }
                return  postList;
        }




        //Display posts using userId :
        public   List<Post> displayPostsByID(int userId){
                List <Post> postList= new ArrayList<>();
                try{
                        Session session= getSessionFactory().openSession();
                        session.beginTransaction();
                        postList= (List<Post>) session.load(Post.class, userId);
                        System.out.println(" Displaying the post using userId is running successfully!");
                        session.close();                }
                catch (HibernateException e) {
                        System.out.println("Error  is displaying the posts");
                }
                return  postList;
        }


        public   void deletePost(){
                try{
                        //getting session Object from

                        Session session= getSessionFactory().openSession();
                        session.beginTransaction();
                        Query queryObj=session.createQuery("delete from edu.mum.cs.wap.project.model.Post");
                        queryObj.executeUpdate();
                        //Commiting the transaction
                        session.getTransaction().commit();
                        System.out.println(" The posts are deleted successfully!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        session.close();
                }
                catch ( HibernateException e)
                {
                        System.out.println(" Some error occured");
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