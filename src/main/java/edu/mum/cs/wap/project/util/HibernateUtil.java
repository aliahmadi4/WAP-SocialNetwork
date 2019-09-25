package edu.mum.cs.wap.project.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static  SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(edu.mum.cs.wap.project.model.User.class)
                .addAnnotatedClass(edu.mum.cs.wap.project.model.Post.class)
                .addAnnotatedClass(edu.mum.cs.wap.project.model.Follower.class);
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);

        return sessionFactory;
    }
}
