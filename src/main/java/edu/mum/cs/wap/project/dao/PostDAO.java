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
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

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
            post.setStatus(true);

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
            postList = session.createQuery("from edu.mum.cs.wap.project.model.Post P WHERE P.status = 1 order by postId desc").list();
            session.close();
        } catch (HibernateException e) {
            System.out.println("Error  is displaying the posts");
        }
        return postList;
    }
    //for getting all the posts by userId and followerId
    public List<Post> getAllPostByUserAndFollower(User user) {
        try {
            //get session object
            Session session = HibernateUtil.getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            List<Post> posts = new ArrayList<Post>();
            int userId = user.getUserId();

            String ql = "FROM edu.mum.cs.wap.project.model.Post P where P.status = 1 order by postId desc" ;


            posts = (List<Post>) session.createQuery(ql).list();


            transaction.commit();
            System.out.println("Posts Loaded");
            //closing the session
            session.close();
            //getting user's and friends post
            List<User> followerList = user.getFriends();
            if(!followerList.contains(user)){
                followerList.add(user);
            }
            List<Post> filteredPost = new ArrayList<Post>();
            for(User u: followerList){
                for(Post p : posts){
                    if(u.getUserId()==p.getUser().getUserId()){
                        filteredPost.add(p);
                    }
                }
            }
            return filteredPost;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Post> getAllPostByUserId(int userId) {
        List<Post> postList = new ArrayList<Post>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            postList = (List<Post>) session.createQuery("from  edu.mum.cs.wap.project.model.Post WHERE status ="+1+" AND userId = "+userId+"  order by postId desc").list();
            System.out.println(" Displaying the post is running!");
            session.close();

        } catch (HibernateException e) {
            System.out.println("Error  is displaying the posts");
        }
        return postList;

    }


    public List<Post> loadPost() {
        List<Post> posts = new ArrayList<Post>();
        try {
            //get session object
            Session session = HibernateUtil.getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            posts = (List<Post>) session.createQuery("FROM edu.mum.cs.wap.project.model.Post").list();
            transaction.commit();
            System.out.println("All posts already loaded!!!");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return posts;
    }

    // tungnd
    public void updatePostStatus(Integer postId) {
        try {
            //get session object
            Session session = HibernateUtil.getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            Post post = session.get(Post.class, postId);
            post.setStatus(!post.isStatus());
            session.update(post);
            transaction.commit();
            System.out.println("The status of post already updated in the Database!!!");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
    }



                /*
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