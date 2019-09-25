package edu.mum.cs.wap.project.dao;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;
import edu.mum.cs.wap.project.model.Post;
import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.util.AppUtils;
import edu.mum.cs.wap.project.util.HibernateUtil;
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

    public void savePost(String description, User user, String photoName) {
        try {
            System.out.println(description);
            //get session object
            Session session = HibernateUtil.getSessionFactory().openSession();
            //Start the transaction
            Transaction transaction = session.beginTransaction();
            Post post = new Post(description);
            post.setUser(user);
            post.setPostPic(photoName);


            session.save(post);
            transaction.commit();
            System.out.println("New Post added to Db");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
    }


    public List<Post> getAllPosts() {
        List<Post> postList = new ArrayList<Post>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            postList = session.createQuery("from edu.mum.cs.wap.project.model.Post order by postId desc").list();
            session.close();
        } catch (HibernateException e) {
            System.out.println("Error  is displaying the posts");
        }
        return postList;
    }






        /*
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
        }*/


}