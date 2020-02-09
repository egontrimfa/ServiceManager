package com.license.Szerviz;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Szerviz.Entities.Auto_pieces;
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;
import com.license.Szerviz.Entities.Replaced;

/**
 * Hello world
 *
 */
public class App {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		//System.out.println(session);
		session.beginTransaction();
	    
		Query<Auto_pieces> querry;
		querry = session.createQuery("from Auto_pieces where id=:id");
		querry.setParameter("id", "A");
		
		Auto_pieces selectedPiece = (Auto_pieces) querry.uniqueResult();
		Auto_pieces replacablePiece;
		
		for (Replaced rep : selectedPiece.getReplaceables()) 
		{
			querry = session.createQuery("from Auto_pieces where id=:id");
			querry.setParameter("id", rep.getAutopiecesidto());
			
			replacablePiece = (Auto_pieces) querry.uniqueResult();
			
			System.out.println(replacablePiece.getId() + ", " + replacablePiece.getAutopiecename() + ", " + replacablePiece.getAutopieceunitename() + ".");
		}
	       
	    session.getTransaction().commit();    
	    HibernateUtil.shutDown();
	}
}
