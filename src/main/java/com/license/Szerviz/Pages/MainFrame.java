package com.license.Szerviz.Pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Cursor;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	static private JPanel panelDB;
	static private JPanel panelCR;
	static private JPanel panelLPR;
	static private JPanel panelNPR;
	static private JPanel panelCL;
	
	private static JTable table;
	private JTextField clientName;
	private JTextField clientPhone;
	private JTextField isCompany;
	private JTextField txtNumeleClientuluiL;
	private JTextField txtNumarulDeTelefonL;
	private JTextField txtNumeleCompaniei;
	private JTextField txtNumComp;
	private JTextField txtAddress;
	private JTextField txtCIF;
	private JTextField txtRegNR;
	private JTextField txtBank;
	private JTextField txtIBAN;
	private JTextField txtOffice;
	private JTextField txtNumeleClientuluiN;
	private JTextField txtNumarulDeTelefonN;
	
	int xx,xy;
	static MainFrame mainFrame = new MainFrame();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame.setUndecorated(true);
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1325, 645);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            MainFrame.this.setLocation(x - xx, y - xy);  
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		/////////////////////////////////////////
		//--------//Dasboard Section//--------//
		///////////////////////////////////////
		
		panelDB = new JPanel();
		contentPane.add(panelDB, "name_1108443134470599");
		panelDB.setLayout(null);
		
		JLabel exitDB = new JLabel("");
		exitDB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitDB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		exitDB.setToolTipText("EXIT");
		exitDB.setHorizontalAlignment(SwingConstants.CENTER);
		exitDB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitDB.setBounds(1236, 13, 59, 32);
		panelDB.add(exitDB);
		
		JLabel newClient = new JLabel("");
		newClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelCR.setVisible(true);
				panelDB.setVisible(false);
			}
		});
		newClient.setToolTipText("Adaugă client nou");
		newClient.setIcon(new ImageIcon(MainFrame.class.getResource("/images/new_client1.png")));
		newClient.setBounds(12, 109, 154, 154);
		panelDB.add(newClient);
		
		JLabel listClients = new JLabel("");
		listClients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelCL.setVisible(true);
				panelDB.setVisible(false);
				
				LoadClients();
			}
		});
		listClients.setToolTipText("Clienţii");
		listClients.setIcon(new ImageIcon(MainFrame.class.getResource("/images/list_clients1.png")));
		listClients.setBounds(178, 109, 154, 154);
		panelDB.add(listClients);
		
		////////////////////////////////////////////////////
		//--------//Client Registration Section//--------//
		///////////////////////////////////////////////////
		
		panelCR = new JPanel();
		contentPane.add(panelCR, "name_1108447015053600");
		panelCR.setLayout(null);
		
		JLabel natural = new JLabel("");
		natural.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		natural.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCR.setVisible(false);
				panelNPR.setVisible(true);
			}
		});
		natural.setAlignmentX(Component.CENTER_ALIGNMENT);
		natural.setIcon(new ImageIcon(MainFrame.class.getResource("/images/persfizik0.png")));
		natural.setVerticalAlignment(SwingConstants.TOP);
		natural.setBounds(55, 163, 581, 378);
		panelCR.add(natural);
		
		JLabel legal = new JLabel("");
		legal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		legal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCR.setVisible(false);
				panelLPR.setVisible(true);
			}
		});
		legal.setIcon(new ImageIcon(MainFrame.class.getResource("/images/PERSJUR0.png")));
		legal.setVerticalAlignment(SwingConstants.TOP);
		legal.setAlignmentX(0.5f);
		legal.setBounds(675, 163, 581, 378);
		panelCR.add(legal);
		
		JLabel exitCR = new JLabel("");
		exitCR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitCR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		exitCR.setToolTipText("EXIT");
		exitCR.setHorizontalAlignment(SwingConstants.CENTER);
		exitCR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitCR.setBounds(1236, 13, 59, 32);
		panelCR.add(exitCR);
		
		JLabel backCR = new JLabel("");
		backCR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCR.setVisible(false);
				panelDB.setVisible(true);
			}
		});
		backCR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backCR.setToolTipText("BACK");
		backCR.setHorizontalAlignment(SwingConstants.CENTER);
		backCR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backCR.setBounds(12, 13, 52, 32);
		panelCR.add(backCR);

		/////////////////////////////////////////////////////////
		//--------//Legal Person Registration Section//--------//
		////////////////////////////////////////////////////////
		
		panelLPR = new JPanel();
		contentPane.add(panelLPR, "name_1108449335953499");
		panelLPR.setLayout(null);
		
		JLabel legalClient = new JLabel("");
		legalClient.setIcon(new ImageIcon(MainFrame.class.getResource("/images/manager-4.png")));
		legalClient.setBounds(50, 42, 457, 531);
		panelLPR.add(legalClient);
		
		txtNumeleClientuluiL = new JTextField();
		txtNumeleClientuluiL.setBounds(896, 138, 365, 22);
		panelLPR.add(txtNumeleClientuluiL);
		txtNumeleClientuluiL.setColumns(10);
		
		JLabel lblNumeleClientului = new JLabel("Numele contactului");
		lblNumeleClientului.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeleClientului.setBounds(896, 106, 151, 16);
		panelLPR.add(lblNumeleClientului);
		
		JLabel lblNumarulDeTelefon = new JLabel("Numarul de telefon al contactului");
		lblNumarulDeTelefon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumarulDeTelefon.setBounds(896, 181, 261, 16);
		panelLPR.add(lblNumarulDeTelefon);
		
		txtNumarulDeTelefonL = new JTextField();
		txtNumarulDeTelefonL.setColumns(10);
		txtNumarulDeTelefonL.setBounds(896, 218, 365, 22);
		panelLPR.add(txtNumarulDeTelefonL);
		
		JButton btnSaveLegale = new JButton("Salveaza");
		btnSaveLegale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SaveLegalPerson();
				
				panelCR.setVisible(true);
				panelLPR.setVisible(false);
			}
		});
		btnSaveLegale.setIcon(new ImageIcon(LegalPersonRegistration.class.getResource("/images/save-button.png")));
		btnSaveLegale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSaveLegale.setBounds(792, 493, 197, 41);
		panelLPR.add(btnSaveLegale);
		
		JLabel lblNumeleCompaniei = new JLabel("Numele companiei");
		lblNumeleCompaniei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeleCompaniei.setBounds(519, 103, 151, 22);
		panelLPR.add(lblNumeleCompaniei);
		
		txtNumeleCompaniei = new JTextField();
		txtNumeleCompaniei.setColumns(10);
		txtNumeleCompaniei.setBounds(519, 138, 365, 22);
		panelLPR.add(txtNumeleCompaniei);
		
		JLabel lblNumarulDeTelefon_1 = new JLabel("Numarul de telefon al companiei");
		lblNumarulDeTelefon_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumarulDeTelefon_1.setBounds(519, 173, 261, 32);
		panelLPR.add(lblNumarulDeTelefon_1);
		
		txtNumComp = new JTextField();
		txtNumComp.setColumns(10);
		txtNumComp.setBounds(519, 218, 365, 22);
		panelLPR.add(txtNumComp);
		
		JLabel lblAddresulCompaniei = new JLabel("Addresa companiei");
		lblAddresulCompaniei.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddresulCompaniei.setBounds(519, 253, 161, 32);
		panelLPR.add(lblAddresulCompaniei);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(519, 298, 365, 22);
		panelLPR.add(txtAddress);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCif.setBounds(519, 333, 161, 32);
		panelLPR.add(lblCif);
		
		txtCIF = new JTextField();
		txtCIF.setColumns(10);
		txtCIF.setBounds(519, 378, 365, 22);
		panelLPR.add(txtCIF);
		
		JLabel lblNumarulDeInregistrare = new JLabel("Numarul de inregistrare");
		lblNumarulDeInregistrare.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumarulDeInregistrare.setBounds(519, 413, 197, 32);
		panelLPR.add(lblNumarulDeInregistrare);
		
		txtRegNR = new JTextField();
		txtRegNR.setColumns(10);
		txtRegNR.setBounds(519, 458, 365, 22);
		panelLPR.add(txtRegNR);
		
		JLabel lblBank = new JLabel("Bank");
		lblBank.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBank.setBounds(896, 253, 161, 32);
		panelLPR.add(lblBank);
		
		txtBank = new JTextField();
		txtBank.setColumns(10);
		txtBank.setBounds(896, 298, 365, 22);
		panelLPR.add(txtBank);
		
		JLabel lblIban = new JLabel("IBAN");
		lblIban.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIban.setBounds(896, 333, 161, 32);
		panelLPR.add(lblIban);
		
		txtIBAN = new JTextField();
		txtIBAN.setColumns(10);
		txtIBAN.setBounds(896, 378, 365, 22);
		panelLPR.add(txtIBAN);
		
		JLabel lblOffice = new JLabel("Office");
		lblOffice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOffice.setBounds(896, 413, 161, 32);
		panelLPR.add(lblOffice);
		
		txtOffice = new JTextField();
		txtOffice.setColumns(10);
		txtOffice.setBounds(896, 458, 365, 22);
		panelLPR.add(txtOffice);
		
		JLabel exitLPR = new JLabel("");
		exitLPR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitLPR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		exitLPR.setToolTipText("EXIT");
		exitLPR.setHorizontalAlignment(SwingConstants.CENTER);
		exitLPR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitLPR.setBounds(1236, 13, 59, 32);
		panelLPR.add(exitLPR);
		
		JLabel backLPR = new JLabel("");
		backLPR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCR.setVisible(true);
				panelLPR.setVisible(false);
			}
		});
		backLPR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backLPR.setToolTipText("BACK");
		backLPR.setHorizontalAlignment(SwingConstants.CENTER);
		backLPR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backLPR.setBounds(12, 13, 52, 32);
		panelLPR.add(backLPR);
		
		///////////////////////////////////////////////////////////	
		//--------//Natural Person Registration Section//--------//
		///////////////////////////////////////////////////////////
		
		panelNPR = new JPanel();
		contentPane.add(panelNPR, "name_1108451248100400");
		panelNPR.setLayout(null);
		
		JLabel naturalClient = new JLabel("");
		naturalClient.setIcon(new ImageIcon(MainFrame.class.getResource("/images/person-4.png")));
		naturalClient.setBounds(50, 42, 457, 531);
		panelNPR.add(naturalClient);
		
		txtNumeleClientuluiN = new JTextField();
		txtNumeleClientuluiN.setBounds(732, 144, 365, 22);
		panelNPR.add(txtNumeleClientuluiN);
		txtNumeleClientuluiN.setColumns(10);
		
		JLabel lblNumeleClientuluiN = new JLabel("Numele clientului");
		lblNumeleClientuluiN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeleClientuluiN.setBounds(732, 115, 139, 16);
		panelNPR.add(lblNumeleClientuluiN);
		
		JLabel lblNumarulDeTelefonN = new JLabel("Numarul de telefon");
		lblNumarulDeTelefonN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumarulDeTelefonN.setBounds(732, 189, 151, 16);
		panelNPR.add(lblNumarulDeTelefonN);
		
		txtNumarulDeTelefonN = new JTextField();
		txtNumarulDeTelefonN.setColumns(10);
		txtNumarulDeTelefonN.setBounds(732, 218, 365, 22);
		panelNPR.add(txtNumarulDeTelefonN);
		
		JButton btnSaveNatural = new JButton("Salveaza");
		btnSaveNatural.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SaveNaturalClient();
				
				panelCR.setVisible(true);
				panelNPR.setVisible(false);
			}
		});
		btnSaveNatural.setIcon(new ImageIcon(NaturalPersonRegistrtation.class.getResource("/images/save-button.png")));
		btnSaveNatural.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSaveNatural.setBounds(810, 253, 197, 41);
		panelNPR.add(btnSaveNatural);
		
		JLabel exitNPR = new JLabel("");
		exitNPR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitNPR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		exitNPR.setToolTipText("EXIT");
		exitNPR.setHorizontalAlignment(SwingConstants.CENTER);
		exitNPR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitNPR.setBounds(1236, 13, 59, 32);
		panelNPR.add(exitNPR);
		
		JLabel backNPR = new JLabel("");
		backNPR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCR.setVisible(true);
				panelNPR.setVisible(false);
			}
		});
		backNPR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backNPR.setToolTipText("BACK");
		backNPR.setHorizontalAlignment(SwingConstants.CENTER);
		backNPR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backNPR.setBounds(12, 13, 52, 32);
		panelNPR.add(backNPR);
		
		///////////////////////////////////////////
		//--------//Client List Section//--------//
		///////////////////////////////////////////
		
		panelCL = new JPanel();
		contentPane.add(panelCL, "name_1108453295279800");
		panelCL.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(350, 97, 945, 488);
		panelCL.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				clientName.setText(model.getValueAt(index, 0).toString());
				clientPhone.setText(model.getValueAt(index, 1).toString());
				isCompany.setText(model.getValueAt(index, 2).toString());
			}
		});
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 21));
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(12, 97, 326, 488);
		panelCL.add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel lblNumele = new JLabel("Numele:");
		lblNumele.setBounds(12, 56, 48, 16);
		infoPanel.add(lblNumele);
		
		JLabel lblDetaliiClientului = new JLabel("Detalii clientului");
		lblDetaliiClientului.setBounds(100, 13, 134, 20);
		lblDetaliiClientului.setFont(new Font("Tahoma", Font.BOLD, 16));
		infoPanel.add(lblDetaliiClientului);
		
		clientName = new JTextField();
		clientName.setBounds(131, 53, 183, 22);
		infoPanel.add(clientName);
		clientName.setColumns(10);
		
		JLabel lblNumarulDeTelefonInfo = new JLabel("Numarul de telefon:");
		lblNumarulDeTelefonInfo.setBounds(12, 85, 116, 16);
		infoPanel.add(lblNumarulDeTelefonInfo);
		
		clientPhone = new JTextField();
		clientPhone.setBounds(131, 82, 183, 22);
		infoPanel.add(clientPhone);
		clientPhone.setColumns(10);
		
		JLabel lblStatutulClientului = new JLabel("Statutul clientului:");
		lblStatutulClientului.setBounds(12, 114, 103, 16);
		infoPanel.add(lblStatutulClientului);
		
		isCompany = new JTextField();
		isCompany.setBounds(131, 111, 183, 22);
		infoPanel.add(isCompany);
		isCompany.setColumns(10);
		
		JLabel exitCL = new JLabel("");
		exitCL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitCL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		exitCL.setToolTipText("EXIT");
		exitCL.setHorizontalAlignment(SwingConstants.CENTER);
		exitCL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitCL.setBounds(1236, 13, 59, 32);
		panelCL.add(exitCL);
		
		JLabel backCL = new JLabel("");
		backCL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCL.setVisible(false);
				panelDB.setVisible(true);
			}
		});
		backCL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backCL.setToolTipText("BACK");
		backCL.setHorizontalAlignment(SwingConstants.CENTER);
		backCL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backCL.setBounds(12, 13, 52, 32);
		panelCL.add(backCL);
		
		JLabel reloadTable = new JLabel("");
		reloadTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadClients();
			}
		});
		reloadTable.setToolTipText("Reload table");
		reloadTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload0.png")));
		reloadTable.setBounds(1179, 13, 45, 32);
		panelCL.add(reloadTable);
		
		//On Creation
		panelDB.setVisible(true);
		panelCR.setVisible(false);
		panelLPR.setVisible(false);
		panelNPR.setVisible(false);
		panelCL.setVisible(false);
		
	}
	
	/////////////////////////////////////////////
	//--------//CRUD Methods Section//--------//
	///////////////////////////////////////////

	private void LoadClients() {
		//Creating session
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Begin transaction
		session.beginTransaction();
	    
		List<Client> clients= (List<Client>)session.createQuery("from Client").list();
		String[] cols= {"Numele clientului","Firm?","Numarul de telefon"};
		
		DefaultTableModel dtm = new DefaultTableModel(cols, 0);
		
		for(Client c:clients) 
		{
		    String[] row= {c.getContactname(), String.valueOf(c.getIscompany()), c.getContactphone()};
		    dtm.addRow( row );
		}

		table.setModel(dtm);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Closing the session
	    session.close();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	private void SaveLegalPerson() {
		//Getting the textbox values
		String companyAdress = txtAddress.getText();
		String companyBank = txtBank.getText();
		String companyCIF = txtCIF.getText();
		String companyIBAN = txtIBAN.getText();
		String clientPhone = txtNumarulDeTelefonL.getText();
		String companyPhone = txtNumComp.getText();
		String clientName = txtNumeleClientuluiL.getText();
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
	    session.close();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}

	private void SaveNaturalClient() {
		//Getting the textbox values
		String clientName = txtNumeleClientuluiN.getText();
		String clientPhone = txtNumarulDeTelefonN.getText();
		
		//Creating session
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Begin transaction
		session.beginTransaction();
	    
	    //Create new Client object
	    Client newClient = new Client(clientName, clientPhone, false);
	    
	    //Save Client
	    session.save(newClient);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Closing the session
	    session.close();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
}
