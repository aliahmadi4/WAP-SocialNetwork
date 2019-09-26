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
import java.util.*;
import java.util.stream.Collectors;

public class ProfileDAO {
    private static SessionFactory sessionFactory;



    public List<User> getAllUsers() {
        try {
            //get session object
            Session session =  HibernateUtil.getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            List<User> users = new ArrayList<User>();
            users = (List<User>) session.createQuery("FROM edu.mum.cs.wap.project.model.User order by userId desc").list();
            transaction.commit();
            System.out.println("User List Fetched");
            session.close();
            return users;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Set<User> getOtherUser(User user) {
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

            List<User> followerList = new ArrayList<>();
            followerList = user.getFriends();
            if(!followerList.contains(user)){
                followerList.add(user);
            }

            List<User> otherUsers = new ArrayList<>();
            HashMap<Integer, User> hashMap = new HashMap<>();

            Set<User> set1 = new HashSet<User>();
            set1.addAll(users);

            Set<User> set2 = new HashSet<User>();
            set2.addAll(followerList);

            set1.removeAll(set2);


//            for(User u : users){
//                for(User f: followerList){
//                    if(!u.equals(f) && e){
//                        if(!hashMap.containsValue(u)){
//                            hashMap.put(u.getUserId(),u);
//                            otherUsers.add(u);
//                    }
//                    }
//                }
//            }
            return set1;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public List<User> getAllUsersNotAdmin() {
        try {
            //get session object
            Session session =  HibernateUtil.getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            List<User> users = new ArrayList<User>();
            users = (List<User>) session.createQuery("FROM edu.mum.cs.wap.project.model.User as U where U.role != 'ROLE_ADMIN'").list();
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

    // tungnd
    public void updateUserStatus(Integer userId) {
        try {
            //get session object
            Session session = HibernateUtil.getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            User user = (User) session.get(User.class, userId);
            user.setStatus(!user.isStatus());
            session.update(user);
            //session.save(ads);
            transaction.commit();
            System.out.println("User status update to DB");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
    }




}
