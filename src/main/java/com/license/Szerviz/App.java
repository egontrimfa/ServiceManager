package com.license.Szerviz;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import com.license.HibernateUtil.HibernateUtil;
import com.license.Service.Models.CommandModel;
import com.license.Szerviz.Entities.Car;
import com.license.Szerviz.Entities.Registrations_inventory;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class App {
	public static void main(String[] args) {
		
		/*try {
			System.out.println(Float.valueOf(null));
		}catch(NumberFormatException nfe) {
			System.out.println("Number format exception: " + nfe.toString());
		}catch(NullPointerException npe) {
			System.out.println("Null pointer exception: " + npe.toString());
		}*/
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//session.beginTransaction();
		
		Car car = session.get(Car.class, 40);
		
		System.out.println(car.getBrands().getBrandname());
		
		Car car2 = session.get(Car.class, 43);
		
		System.out.println(car2.getBrands().getBrandname());
		
		//session.getTransaction().commit();
		
		session.close();
		
		try {

		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
