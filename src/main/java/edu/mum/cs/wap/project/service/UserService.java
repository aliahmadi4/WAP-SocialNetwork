package edu.mum.cs.wap.project.service;

import edu.mum.cs.wap.project.model.User;
import edu.mum.cs.wap.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserService {

    public User getUserById(int userId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        User user = null;
        try{
            transaction = session.beginTransaction();

            Query query = session.createQuery("from edu.mum.cs.wap.project.model.User where userId = :userId ");

//
            query.setParameter("userId", userId);
            user = (User)query.uniqueResult();
            transaction.commit();


        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            session.close();
        }
        return user;
    }
}
