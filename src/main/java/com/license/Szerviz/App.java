package com.license.Szerviz;

import org.hibernate.Session;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;

/**
 * Hello world
 *
 */
public class App {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		//System.out.println(session);
		session.beginTransaction();
	    
	    //Create new Client object
	    Client newClient = new Client("ForKeyTest5", "+410", true);
	    
	    //Save Client
	    session.save(newClient);
	    
		//Create new Company object
		Company newCompany = new Company(newClient.getId(), "F", "F", "F", "F","F", "F", "F", "F");
	    
	    //Save Company
	    newCompany.setClients(newClient);
	    session.save(newCompany);
	       
	    session.getTransaction().commit();    
	    HibernateUtil.shutDown();
	}
}
