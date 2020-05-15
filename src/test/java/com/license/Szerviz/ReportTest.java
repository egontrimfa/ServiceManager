package com.license.Szerviz;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Service.Models.CommandModel;
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


public class ReportTest {
	public static void main(String[] args) {
	    final String url = "jdbc:postgresql://localhost:5432/szervizdb";
	    final String user = "szervizuser";
	    final String password = "szervizpw98";
	    
	    Connection conn = null;
	    
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            
            JasperReport CommandInvoice = JasperCompileManager.compileReport("D:\\Sapientia\\licencework\\Eclipse\\Szerviz\\src\\main\\java\\com\\license\\Print\\CommandInvoice.jrxml");
            //JasperReport ClientInfo = JasperCompileManager.compileReport("D:\\Sapientia\\licencework\\Eclipse\\Szerviz\\src\\main\\java\\com\\license\\Print\\ClientInfo.jrxml");
            //JasperReport CompanyInfo = JasperCompileManager.compileReport("D:\\Sapientia\\licencework\\Eclipse\\Szerviz\\src\\main\\java\\com\\license\\Print\\CompanyInfo.jrxml");

            Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("REG_ID", 220);
			/*parameters.put("CLIENT_ID", 3);
			parameters.put("CLIENT_SUB_REPORT", ClientInfo);
			parameters.put("OFFICE_ID", 1);
			parameters.put("OFFICE_SUB_REPORT", CompanyInfo);*/

			JasperPrint jasperPrint = JasperFillManager.fillReport(CommandInvoice, parameters, conn);
		
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(new File("C:\\Users\\egont\\OneDrive\\Documents\\JasperReports\\HalfTest1.pdf")));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
	}
}
