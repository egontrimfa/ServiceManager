package com.license.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.license.Szerviz.Entities.Auto_pieces;
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;
import com.license.Szerviz.Entities.Replaced;
import com.license.Szerviz.Entities.replacePK;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {

        try {

            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Company.class);
            configuration.addAnnotatedClass(Auto_pieces.class);
            configuration.addAnnotatedClass(Replaced.class);
            configuration.addAnnotatedClass(replacePK.class);

            configuration.configure("hibernate.cfg.xml");

            System.out.println("Hibernate Annotation Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            System.out.println("Hibernate Annotation serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;

        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);

            ex.printStackTrace();

            throw new ExceptionInInitializerError(ex);

        }

    }



    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null)

            sessionFactory = buildSessionFactory();

        return sessionFactory;

    }

	public static void shutDown() {
		sessionFactory.close();		
	}

}