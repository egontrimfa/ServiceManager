package com.license.Szerviz;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Service.Models.ReceptionReport;
import com.license.Szerviz.Entities.Auto_pieces;
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;
import com.license.Szerviz.Entities.Registration_job;
import com.license.Szerviz.Entities.Registrations_inventory;
import com.license.Szerviz.Entities.Receptions_auto_pieces;
import com.license.Szerviz.Entities.Registration;
import com.license.Szerviz.Entities.Replaced;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class App {
	public static void main(String[] args) {
		
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport("D:\\Sapientia\\licencework\\Eclipse\\Szerviz\\src\\main\\java\\com\\license\\Print\\Blank_A4.jrxml");

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("REC_ID", 2);
			Session session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction
			session.beginTransaction();
			
			List<ReceptionReport> rec = (List<ReceptionReport>) session.createQuery("from ReceptionReport").list();
			
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(rec);
			
		    //Committing the transaction
		    session.getTransaction().commit();

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(new File("C:\\Users\\egont\\OneDrive\\Documents\\JasperReports\\test3.pdf")));
		    
		    //Close the session
		    session.close();
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
			ex.printStackTrace(System.out);
		}
	}
}
