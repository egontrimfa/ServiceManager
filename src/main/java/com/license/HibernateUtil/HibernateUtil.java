package com.license.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.license.Szerviz.Entities.Auto_pieces;
import com.license.Szerviz.Entities.Car;
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;
import com.license.Szerviz.Entities.Inventory;
import com.license.Szerviz.Entities.Invoice;
import com.license.Szerviz.Entities.Invoice_item;
import com.license.Szerviz.Entities.Invoice_itemPK;
import com.license.Szerviz.Entities.Job;
import com.license.Szerviz.Entities.Job_registration;
import com.license.Szerviz.Entities.Job_registrationPK;
import com.license.Szerviz.Entities.Reception;
import com.license.Szerviz.Entities.Receptions_auto_pieces;
import com.license.Szerviz.Entities.Registration;
import com.license.Szerviz.Entities.Registrations_inventory;
import com.license.Szerviz.Entities.Registrations_inventoryPK;
import com.license.Szerviz.Entities.Replaced;
import com.license.Szerviz.Entities.Role;
import com.license.Szerviz.Entities.User;
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
            configuration.addAnnotatedClass(Car.class);
            configuration.addAnnotatedClass(Job.class);
            configuration.addAnnotatedClass(Inventory.class);
            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Registration.class);
            configuration.addAnnotatedClass(Registrations_inventory.class);
            configuration.addAnnotatedClass(Job_registration.class);
            configuration.addAnnotatedClass(Job_registrationPK.class);
            configuration.addAnnotatedClass(Invoice.class);
            configuration.addAnnotatedClass(Invoice_item.class);
            configuration.addAnnotatedClass(Invoice_itemPK.class);
            configuration.addAnnotatedClass(Reception.class);
            configuration.addAnnotatedClass(Receptions_auto_pieces.class);
            configuration.addAnnotatedClass(Registrations_inventoryPK.class);

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