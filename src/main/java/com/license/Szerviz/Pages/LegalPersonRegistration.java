package com.license.Szerviz.Pages;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;

import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Label;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LegalPersonRegistration extends JFrame {

	private JPanel contentPane;
	
	int xx,xy;
	private JTextField txtNumeleClientului;
	private JTextField txtNumarulDeTelefon;
	private JTextField txtNumeleCompaniei;
	private JTextField txtNumComp;
	private JTextField txtAddress;
	private JTextField txtCIF;
	private JTextField txtRegNR;
	private JTextField txtBank;
	private JTextField txtIBAN;
	private JTextField txtOffice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LegalPersonRegistration frame = new LegalPersonRegistration();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	

	/**
	 * Create the frame.
	 */
	
	public LegalPersonRegistration() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1325, 645);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            LegalPersonRegistration.this.setLocation(x - xx, y - xy);  
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel exit = new JLabel("");
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		exit.setToolTipText("EXIT");
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setIcon(new ImageIcon(LegalPersonRegistration.class.getResource("/images/exit0.png")));
		exit.setBounds(1236, 13, 59, 32);
		contentPane.add(exit);
		
		JLabel back = new JLabel("");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setToolTipText("BACK");
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setIcon(new ImageIcon(LegalPersonRegistration.class.getResource("/images/back-arrow.png")));
		back.setBounds(12, 13, 52, 32);
		contentPane.add(back);
		
		JLabel legalClient = new JLabel("");
		legalClient.setIcon(new ImageIcon(LegalPersonRegistration.class.getResource("/images/manager-4.png")));
		legalClient.setBounds(50, 42, 457, 531);
		contentPane.add(legalClient);
		
		txtNumeleClientului = new JTextField();
		txtNumeleClientului.setBounds(896, 138, 365, 22);
		contentPane.add(txtNumeleClientului);
		txtNumeleClientului.setColumns(10);
		
		JLabel lblNumeleClientului = new JLabel("Numele contactului");
		lblNumeleClientului.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeleClientului.setBounds(896, 106, 151, 16);
		contentPane.add(lblNumeleClientului);
		
		JLabel lblNumarulDeTelefon = new JLabel("Numarul de telefon al contactului");
		lblNumarulDeTelefon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumarulDeTelefon.setBounds(896, 181, 261, 16);
		contentPane.add(lblNumarulDeTelefon);
		
		txtNumarulDeTelefon = new JTextField();
		txtNumarulDeTelefon.setColumns(10);
		txtNumarulDeTelefon.setBounds(896, 218, 365, 22);
		contentPane.add(txtNumarulDeTelefon);
		
		JButton btnNewButton = new JButton("Salveaza");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Getting the textbox values
				String companyAdress = txtAddress.getText();
				String companyBank = txtBank.getText();
				String companyCIF = txtCIF.getText();
				String companyIBAN = txtIBAN.getText();
				String clientPhone = txtNumarulDeTelefon.getText();
				String companyPhone = txtNumComp.getText();
				String clientName = txtNumeleClientului.getText();
				String companyName = txtNumeleCompaniei.getText();
				String companyOffice = txtOffice.getText();
				String companyRegNR = txtRegNR.getText();
				
				//Creating session
				Session session = HibernateUtil.getSessionFactory().openSession();
				//Begin transaction
				session.beginTransaction();
			    
			    //Create new Client object
			    Client newClient = new Client(clientName, clientPhone, true);
			    
			    //Save Client
			    session.save(newClient);
			    
				//Create new Company object
				Company newCompany = new Company(newClient.getId(), companyPhone, companyName, companyAdress, companyCIF,companyRegNR, companyBank, companyIBAN, companyOffice);
			    
			    //Save Company
			    newCompany.setClients(newClient);
			    session.save(newCompany);
			      
			    //Committing the transaction
			    session.getTransaction().commit();
			    
			    //Closing the session
			    HibernateUtil.shutDown();
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(LegalPersonRegistration.class.getResource("/images/save-button.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(792, 493, 197, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNumeleCompaniei = new JLabel("Numele companiei");
		lblNumeleCompaniei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeleCompaniei.setBounds(519, 103, 151, 22);
		contentPane.add(lblNumeleCompaniei);
		
		txtNumeleCompaniei = new JTextField();
		txtNumeleCompaniei.setColumns(10);
		txtNumeleCompaniei.setBounds(519, 138, 365, 22);
		contentPane.add(txtNumeleCompaniei);
		
		JLabel lblNumarulDeTelefon_1 = new JLabel("Numarul de telefon al companiei");
		lblNumarulDeTelefon_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumarulDeTelefon_1.setBounds(519, 173, 261, 32);
		contentPane.add(lblNumarulDeTelefon_1);
		
		txtNumComp = new JTextField();
		txtNumComp.setColumns(10);
		txtNumComp.setBounds(519, 218, 365, 22);
		contentPane.add(txtNumComp);
		
		JLabel lblAddresulCompaniei = new JLabel("Addresa companiei");
		lblAddresulCompaniei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddresulCompaniei.setBounds(519, 253, 161, 32);
		contentPane.add(lblAddresulCompaniei);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(519, 298, 365, 22);
		contentPane.add(txtAddress);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCif.setBounds(519, 333, 161, 32);
		contentPane.add(lblCif);
		
		txtCIF = new JTextField();
		txtCIF.setColumns(10);
		txtCIF.setBounds(519, 378, 365, 22);
		contentPane.add(txtCIF);
		
		JLabel lblNumarulDeInregistrare = new JLabel("Numarul de inregistrare");
		lblNumarulDeInregistrare.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumarulDeInregistrare.setBounds(519, 413, 197, 32);
		contentPane.add(lblNumarulDeInregistrare);
		
		txtRegNR = new JTextField();
		txtRegNR.setColumns(10);
		txtRegNR.setBounds(519, 458, 365, 22);
		contentPane.add(txtRegNR);
		
		JLabel lblBank = new JLabel("Bank");
		lblBank.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBank.setBounds(896, 253, 161, 32);
		contentPane.add(lblBank);
		
		txtBank = new JTextField();
		txtBank.setColumns(10);
		txtBank.setBounds(896, 298, 365, 22);
		contentPane.add(txtBank);
		
		JLabel lblIban = new JLabel("IBAN");
		lblIban.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIban.setBounds(896, 333, 161, 32);
		contentPane.add(lblIban);
		
		txtIBAN = new JTextField();
		txtIBAN.setColumns(10);
		txtIBAN.setBounds(896, 378, 365, 22);
		contentPane.add(txtIBAN);
		
		JLabel lblOffice = new JLabel("Office");
		lblOffice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOffice.setBounds(896, 413, 161, 32);
		contentPane.add(lblOffice);
		
		txtOffice = new JTextField();
		txtOffice.setColumns(10);
		txtOffice.setBounds(896, 458, 365, 22);
		contentPane.add(txtOffice);
	}
}
