package edu.mum.cs.wap.project.dao;

import edu.mum.cs.wap.project.model.Ads;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AdsDAO {

    private static SessionFactory sessionFactory;

    public void saveAds(String title, String imageURL) {
        try {
            //get session object
            Session session = getSessionFactory().openSession();
            //starting Transcation
            Transaction transaction = session.beginTransaction();
            Ads ads = (Ads) session.get(Ads.class, 1);
            if (ads != null) {
                ads.setAdsTitle(title);
                ads.setImageURL(imageURL);
                session.update(ads);
            } else {
                ads = new Ads(title, imageURL);
                session.save(ads);
            }
            //session.save(ads);
            transaction.commit();
            System.out.println("New Ads added to DB");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
    }

    public Ads loadAds() {
        try {
            //get session object
            Session session = getSessionFactory().openSession();
            Ads ads = (Ads) session.get(Ads.class, 1);
            return ads;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return null;
    }


    public static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(edu.mum.cs.wap.project.model.Ads.class);
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);

        return sessionFactory;
    }
}
