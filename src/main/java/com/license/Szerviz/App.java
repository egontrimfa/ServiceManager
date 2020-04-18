package com.license.Szerviz;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Service.Models.CommandModel;
import com.license.Service.Models.ReceptionReport;
import com.license.Service.Models.RegistrationReport;
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
			JasperReport jasperReport = JasperCompileManager.compileReport("D:\\Sapientia\\licencework\\Eclipse\\Szerviz\\src\\main\\java\\com\\license\\Print\\CommandInvoice.jrxml");
			//mJasperReport jasperSubReport = JasperCompileManager.compileReport("D:\\Sapientia\\licencework\\Eclipse\\Szerviz\\src\\main\\java\\com\\license\\Print\\CommandInvoice.jrxml");
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("REG_ID", 56);
			parameters.put("CLIENT_ID", 1);
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			//Begin transaction
			session.beginTransaction();
			
			List<Registrations_inventory> registrations_inventory= (List<Registrations_inventory>)session
					.createQuery("from Registrations_inventory where registrationsid=:registrationsid")
					.setParameter("registrationsid", 56)
					.list();
			List<CommandModel> cmd = new ArrayList<CommandModel>();
			
			for(int i=0; i<registrations_inventory.size(); i++) {
				Registrations_inventory ri = registrations_inventory.get(i);
				
				cmd.add(new CommandModel
						(ri.getInventory().getAuto_pieces().getAutopiecename(), 
						ri.getInventory().getAuto_pieces().getAutopieceunitename(), 
						ri.getQuantity(), 
						ri.getNewuniteprice(),
						(ri.getQuantity()*ri.getNewuniteprice()), 
						(float)(ri.getQuantity()*ri.getNewuniteprice()*0.09), 
						(float)(ri.getQuantity()*ri.getNewuniteprice()*1.09))
				);
			}
			
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(cmd);
			
		    //Committing the transaction
		    session.getTransaction().commit();

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(new File("C:\\Users\\egont\\OneDrive\\Documents\\JasperReports\\invoicetest4.pdf")));
		    
		    //Close the session
		    session.close();
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
			ex.printStackTrace(System.out);
		}
	}
}
