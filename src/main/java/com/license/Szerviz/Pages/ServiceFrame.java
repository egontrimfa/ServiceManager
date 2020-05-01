package com.license.Szerviz.Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Szerviz.Entities.Auto_pieces;
import com.license.Szerviz.Entities.Car;
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;
import com.license.Szerviz.Entities.Inventory;
import com.license.Szerviz.Entities.Job;
import com.license.Szerviz.Entities.Reception;
import com.license.Szerviz.Entities.Receptions_auto_pieces;
import com.license.Szerviz.Entities.Registration;
import com.license.Szerviz.Entities.Registration_job;
import com.license.Szerviz.Entities.Registrations_inventory;
import com.license.Szerviz.Entities.Replaced;
import com.license.Szerviz.Entities.Role;
import com.license.Szerviz.Entities.User;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Component;
import java.awt.Container;

import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.FlowLayout;
import java.awt.Toolkit;

import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.RowFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ServiceFrame {
	//BASE
	private JFrame frmServiceManagerSoftware;
	
	//DEFINED
	//Hibernate
	private static Session session;
	
	//Panels		
	static Stack<JPanel> panels = new Stack<>();
	static JPanel currentPanel = null;
	
	//Navigation
	static private JLabel back;
	static private JLabel home;
	
	//Entity	
	private Client selectedClient;
	private Company selectedCompany;
	private Auto_pieces selectedAutoPiece;
	private Role selectedRole;
	private Reception selectedReception;
	private Receptions_auto_pieces selectedRAPL;
	private Car selectedCar;
	private Inventory selectedInventoryItem;
	private Registration selectedRegistration;
	private Registrations_inventory selectedRegistrationInventory;
	private Registration_job selectedRegistrationJob;
	private Job selectedJob;
	private User selectedUser;
	
	//Other
	static private String selectPiece;
	
	//GENERATED
	//All Major Panels
	static private JPanel panelDB;
	static private JPanel panelCR;
	static private JPanel panelAAP;
	static private JPanel panelANJ;
	static private JPanel panelANU;
	static private JPanel panelANS;
	static private JPanel panelCL;
	static private JPanel panelAPL;
	static private JPanel panelSL;
	static private JPanel panelRAPL;
	static private JPanel panelIM;
	static private JPanel panelJL;
	static private JPanel panelUL;	
	static private JPanel panelAR;
	static private JPanel panelSC;
	static private JPanel panelSII;
	static private JPanel panelSJ;
	static private JPanel panelANR;
	
	//Client Registration Panel<components>
	private JTextField JTF_clientName_CR;
	private JTextField JTF_clientPhone_CR;
	private JTextField JTF_companyName_CR;
	private JTextField JTF_companyPhone_CR;
	private JTextField JTF_companyRegNR_CR;
	private JTextField JTF_companyCIF_CR;
	private JTextField JTF_companyBank_CR;
	private JTextField JTF_companyIBAN_CR;
	private JTextField JTF_companyAddress_CR;
	private JTextField JTF_companyBranchOffice_CR;
	
	//Add Auto Piece Panel<components>
	private JTextField JTF_autoPieceID_AAP;
	private JTextField JTF_autoPieceName_AAP;
	private JTextField JTF_autoPieceUniteName_AAP;
	
	//Add New Job Panel<components>
	private JTextField JTF_jobName_ANJ;
	private JTextField JTF_jobPrice_ANJ;
	
	//Add New User Panel<components>
	private JTextField JTF_userName_ANU;
	private JPasswordField JPF_userPassword_ANU;
	private JPasswordField JPF_userPasswordRE_ANU;
	private JComboBox<Role> JCB_userRole_ANU;
	
	//Add New Supplie Panel<components>
	private JTextField JTF_clientName_ANS;
	private JTextField JTF_selectedClientName_ANS;
	private JTextField JTF_invoiceNR_ANS;
	private JTextField JTL_pieceID_ANS;
	private JTextField JTF_pieceQuantity_ANS;
	private JTextField JTF_piecePriceIN_ANS;
	private JTextField JTF_piecePriceOUT_ANS;
	private JTextField JTF_pieceVAT_ANS;
	private JTable JT_pieces_ANS;
	
	//Client List Panel<components>
	private JTable JT_clients_CL;
	private JTextField JTF_clientNameInfo_CL;
	private JTextField JTF_clientPhoneInfo_CL;
	private JTextField JTF_clientCompanyInfo_CL;
	private JTextField JTF_companyNameInfo_CL;
	private JTextField JTF_companyAddressInfo_CL;
	private JTextField JTF_companyPhoneInfo_CL;
	private JTextField JTF_companyCIFInfo_CL;
	private JTextField JTF_companyRegNRInfo_CL;
	private JTextField JTF_companyBankInfo_CL;
	private JTextField JTF_companyIBANInfo_CL;
	private JTextField JTF_companyBranchOfficeInfo_CL;
	private JTextField JTF_clientQuickSearchByName_CL;
	private JTextField JTF_clientQuickSearchByPhone_CL;
	private JTextField JTF_clientQuickSearchByStatus_CL;
	
	//Auto Piece List Panel<components>
	private JTextField JTF_pieceIDInfo_APL;
	private JTextField JTF_pieceNameInfo_APL;
	private JTextField JTF_pieceUnitNameInfo_APL;
	private JTable JT_pieces_APL;
	private JTextField JTF_pieceQuickSearch_APL;
	
	//Supplie List Panel<components>
	private JTable JT_supplies_SL;
	private JTextField JTF_clientNameInfo_SL;
	private JTextField JTF_invoiceNRInfo_SL;
	private JTextField JTF_clientNameQuickSearch_SL;
	private JTextField JTF_invoiceNRQuickSearch_SL;
	
	//Reception Auto Piece List Panel<components>
	private JTable JT_rapl_RAPL;
	private JTextField JTF_recInvoiceNRInfo_RAPL;
	private JTextField JTF_autoPieceIDInfo_RAPL;
	private JTextField JTF_quantityInfo_RAPL;
	private JTextField JTF_priceINInfo_RAPL;
	private JTextField JTF_priceOUTInfo_RAPL;
	private JTextField JTF_vatInfo_RAPL;
	private JTextField JTF_rapQuickSearch_RAPL;
	
	//Inventory Management Panel<components>
	private JTable JT_inventory_IM;
	private JTextField JTF_pieceIDInfo_IM;
	private JTextField JTF_clientNameInfo_IM;
	private JTextField JTF_quantityInfo_IM;
	private JTextField JTF_unitePriceINInfo_IM;
	private JTextField JTF_unitePriceOUTInfo_IM;
	private JTextField JTF_autoPieceQuickSearch_IM;
	private JTextField JTF_clientQuickSearch_IM;
	private JTextField temp1;
	private JTextField temp2;
	private JTextField temp3;
	private JTextField JTF_dateINQuickSearch_IM;
	
	//Job List Panel<components>
	private JTable JT_jobs_JL;
	private JTextField JTF_jobNameInfo_JL;
	private JTextField JTF_jobPriceInfo_JL;
	private JTextField JTF_jobQuickSearch_JL;
	
	//User List Panel<components>
	private JTable JT_users_UL;
	private JTextField JTF_userNameInfo_UL;
	private JTextField JTF_userQuickSearch_UL;
	
	//Add Replaceable Panel<components>
	private JTable JT_pieces_AR;
	private JTextField JTF_pieceNameFrom_AR;
	private JTextField JTF_pieceNameTo_AR;
	private JTextField JTF_toPieceIDInfo_AR;
	private JTextField JTF_toPieceNameInfo_AR;
	private JTextField JTF_toPieceUnitNameInfo_AR;
	private JTextField JTF_fromPieceIDInfo_AR;
	private JTextField JTF_fromPieceNameInfo_AR;
	private JTextField JTF_fromPieceUnitNameInfo_AR;
	private JTextField JTF_autoPieceQuickSearch_AR;

	//Add Auto Panel<components>
	private JTable JT_prevCars_AA;
	private JTextField JTF_carLicenseNumber_AA;
	private JTextField JTF_carBrand_AA;
	private JTextField JTF_carModel_AA;
	private JTextField JTF_carChassisNR_AA;
	private JTextField JTF_carEngineNR_AA;
	private JTextField JTF_carMilometer_AA;
	
	//Select Inventory Item Panel<components>
	private JTable JT_inventory_SII;
	private JTextField JTF_inventoryItemSearch_SII;
	private JTextField JTF_inventoryItemName_SII;
	private JTextField JTF_inventoryItemPrice_SII;
	private JTextField JTF_invenotyItemQuantity_SII;
	
	//Select Job Panel<components>
	private JTable JT_jobs_SJ;
	private JTextField JTF_jobSearch_SJ;
	private JTextField JTF_jobName_SJ;
	private JTextField JTF_jobPrice_SJ;
	
	//Add New Registration Panel<components>
	private JTextField JTF_registrationNumber_ANR;
	private JTable JT_info_ANR;
	private JLabel JL_selectClient_ANR;
	private JLabel JL_selectCar_ANR;
	private JLabel JL_selectPiece_ANR;
	private JLabel JL_selectJob_ANR;
	private JLabel SC_addClient_ANR;
	private JLabel SC_editClient_ANR;
	private JLabel SC_infoClient_ANR;
	private JLabel SC_addCar_ANR;
	private JLabel SC_editCar_ANR;
	private JLabel SC_infoCar_ANR;
	private JLabel SC_addPiece_ANR;
	private JLabel SC_editPiece_ANR;
	private JLabel SC_infoPiece_ANR;
	private JLabel SC_addJob_ANR;
	private JLabel SC_editJob_ANR;
	private JLabel SC_infoJob_ANR;
	private JDateChooser JDC_registrationNumber_ANR;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceFrame window = new ServiceFrame();
					window.frmServiceManagerSoftware.setVisible(true);
					
					//Panel option initializations
					panels.push(panelDB);
					currentPanel = panelDB;
					
					//Global UI settings
					UIManager.put("OptionPane.minimumSize", new Dimension(350,75));
					
					//Open new hibernate session
					session = HibernateUtil.getSessionFactory().openSession();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ServiceFrame() {
		initialize();
	}

	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frmServiceManagerSoftware = new JFrame();
		frmServiceManagerSoftware.setTitle("Service Manager Software (Development)");
		frmServiceManagerSoftware.getContentPane().setBackground(Color.WHITE);
		frmServiceManagerSoftware.setBounds(100, 100, (int)(screenSize.width*1.15), (int)(screenSize.height*0.9));
		frmServiceManagerSoftware.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServiceManagerSoftware.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel centralPanel = new JPanel();
		centralPanel.setBackground(Color.WHITE);
		frmServiceManagerSoftware.getContentPane().add(centralPanel, BorderLayout.CENTER);
		centralPanel.setLayout(new CardLayout(0, 0));
		
		panelDB = new JPanel();
		panelDB.setBackground(Color.WHITE);
		centralPanel.add(panelDB, "name_67988197394200");
		panelDB.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][][][][]"));
		
		JLabel MC_listClient_DB = new JLabel("");
		MC_listClient_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_listClient_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelSelectionHelper(panelDB, panelCL);
				
				SetDefaultTable(JT_clients_CL, new String[]{"Client", "Numele clientului", "Numarul de telefon", "Firm?"});				
				LoadClients();
			}
		});
		
		JLabel MC_addClient_DB = new JLabel("");
		MC_addClient_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelSelectionHelper(panelDB, panelCR);
			}
		});
		MC_addClient_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_addClient_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/new_client1.png")));
		panelDB.add(MC_addClient_DB, "cell 0 0");
		
		JLabel MC_addAutoPiece_DB = new JLabel("");
		MC_addAutoPiece_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelDB, panelAAP);
			}
		});
		MC_addAutoPiece_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_addAutoPiece_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/addPiece0.png")));
		panelDB.add(MC_addAutoPiece_DB, "cell 1 0");
		
		JLabel MC_addReception_DB = new JLabel("");
		MC_addReception_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelDB, panelANS);
				
				SetDefaultTable(JT_pieces_ANS, new String[]{"COD", "Nume", "Unitate/Masura", "Quantity", "IN", "OUT", "TVA"});
			}
		});
		MC_addReception_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_addReception_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/supplier2.png")));
		panelDB.add(MC_addReception_DB, "cell 2 0");
		
		JLabel MC_addJob_DB = new JLabel("");
		MC_addJob_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelDB, panelANJ);
			}
		});
		MC_addJob_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_addJob_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/addjob0.png")));
		panelDB.add(MC_addJob_DB, "cell 3 0");
		
		JLabel MC_addUser_DB = new JLabel("");
		MC_addUser_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelDB, panelANU);
				
				if(JCB_userRole_ANU.getItemCount()==0) {
					LoadRoles(JCB_userRole_ANU);
				}
			}
		});
		MC_addUser_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_addUser_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/worker0.png")));
		panelDB.add(MC_addUser_DB, "cell 4 0");
		
		JLabel MC_addRegistration_DB = new JLabel("");
		MC_addRegistration_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelDB, panelANR);
				
				generateRegistrationNumber();
				JDC_registrationNumber_ANR.setDate(new Date());
				saveRegistration(JTF_registrationNumber_ANR.getText(), JDC_registrationNumber_ANR.getDate());
			}
		});
		MC_addRegistration_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_addRegistration_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_registration_154.png")));
		panelDB.add(MC_addRegistration_DB, "cell 5 0");
		MC_listClient_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/list_clients1.png")));
		panelDB.add(MC_listClient_DB, "cell 0 1");
		
		JLabel MC_listAutoPiece_DB = new JLabel("");
		MC_listAutoPiece_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelSelectionHelper(panelDB, panelAPL);
				
				SetDefaultTable(JT_pieces_APL, new String[]{"Auto_piece", "COD", "Nume", "Unitate/Masura"});
				LoadPieces();
			}
		});
		MC_listAutoPiece_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_listAutoPiece_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/list_parts0.png")));
		panelDB.add(MC_listAutoPiece_DB, "cell 1 1");
		
		JLabel MC_listReception_DB = new JLabel("");
		MC_listReception_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelDB, panelSL);
				
				SetDefaultTable(JT_supplies_SL, new String[]{"Reception", "Furnizor", "Număr de factură", "Date IN", "Due Date"});				
				loadReception();
			}
		});
		MC_listReception_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_listReception_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/supplier_list_154.png")));
		panelDB.add(MC_listReception_DB, "cell 2 1");
		
		JLabel MC_listJob_DB = new JLabel("");
		MC_listJob_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelDB, panelJL);
				
				SetDefaultTable(JT_jobs_JL, new String[]{"Job", "Numele jobului", "Tarifa jobului"});				
				LoadJobs();
			}
		});
		MC_listJob_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_listJob_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/jobsList0.png")));
		panelDB.add(MC_listJob_DB, "cell 3 1");
		
		JLabel MC_listUser_DB = new JLabel("");
		MC_listUser_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelDB, panelANU);
				
				if(JCB_userRole_ANU.getItemCount()==0) {
					LoadRoles(JCB_userRole_ANU);
				}
			}
		});
		MC_listUser_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_listUser_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/worker2.png")));
		panelDB.add(MC_listUser_DB, "cell 4 1");
		
		JLabel MC_replaceAutoPiece_DB = new JLabel("");
		MC_replaceAutoPiece_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelSelectionHelper(panelDB, panelAR);
				
				SetDefaultTable(JT_pieces_AR, new String[]{"COD", "Nume", "Unitate/Masura"});
			}
		});
		MC_replaceAutoPiece_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_replaceAutoPiece_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/auto_piece_replace_154.png")));
		panelDB.add(MC_replaceAutoPiece_DB, "cell 1 2");
		
		JLabel MC_showInventory_DB = new JLabel("");
		MC_showInventory_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelDB, panelIM);
				
				SetDefaultTable(JT_inventory_IM, new String[]{"Inventory", "Piese de auto", "Furnizor", "Quantity", "Price IN", "Price OUT", "Date"});				
				loadInventory();
			}
		});
		MC_showInventory_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MC_showInventory_DB.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/inventory_154.png")));
		panelDB.add(MC_showInventory_DB, "cell 2 2");
		
		panelCR = new JPanel();
		centralPanel.add(panelCR, "name_86357985624400");
		panelCR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_CR = new JPanel();
		JP_west_CR.setBackground(Color.WHITE);
		panelCR.add(JP_west_CR, BorderLayout.WEST);
		JP_west_CR.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel HC_client_CR = new JLabel("");
		HC_client_CR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/client_512.png")));
		JP_west_CR.add(HC_client_CR);
		
		JPanel JP_center_CR = new JPanel();
		JP_center_CR.setBackground(Color.WHITE);
		panelCR.add(JP_center_CR, BorderLayout.CENTER);
		JP_center_CR.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][][][][][][]"));
		
		JToggleButton JTB_isCompany_CR = new JToggleButton("Client legal");
		JTB_isCompany_CR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JTB_isCompany_CR.isSelected()) {
					panelStateChangeHelper(panelCR, "secondary", null);
				}else {
					panelStateChangeHelper(panelCR, "primary", null);
				}
			}
		});
		JTB_isCompany_CR.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_center_CR.add(JTB_isCompany_CR, "cell 0 0,growx");
		
		JLabel JL_naturalClient_CR = new JLabel("Client natural");
		JL_naturalClient_CR.setName("permanent");
		JL_naturalClient_CR.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		JL_naturalClient_CR.setHorizontalAlignment(SwingConstants.CENTER);
		JP_center_CR.add(JL_naturalClient_CR, "cell 0 1 4 1,growx");
		
		JLabel JL_clientName_CR = new JLabel("Numele contactului:");
		JL_clientName_CR.setName("permanent");
		JL_clientName_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_clientName_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_clientName_CR, "cell 0 2,alignx left,aligny center");
		
		JTF_clientName_CR = new JTextField();
		JTF_clientName_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				textfieldBorderResetter(JTF_clientName_CR);
			}
		});
		JTF_clientName_CR.setName("permanent");
		JTF_clientName_CR.setColumns(10);
		JP_center_CR.add(JTF_clientName_CR, "cell 1 2,growx");
		
		JLabel JL_clientPhone_CR = new JLabel("Numarul de telefon al contactului:");
		JL_clientPhone_CR.setName("permanent");
		JL_clientPhone_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_clientPhone_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_clientPhone_CR, "cell 2 2,alignx left,aligny center");
		
		JTF_clientPhone_CR = new JTextField();
		JTF_clientPhone_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_clientPhone_CR);
			}
		});
		JTF_clientPhone_CR.setName("permanent");
		JTF_clientPhone_CR.setColumns(10);
		JP_center_CR.add(JTF_clientPhone_CR, "cell 3 2,growx");
		
		JLabel JL_legalClient_CR = new JLabel("Client juridic");
		JL_legalClient_CR.setVisible(false);
		JL_legalClient_CR.setName("secondary");
		JL_legalClient_CR.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		JL_legalClient_CR.setHorizontalAlignment(SwingConstants.CENTER);
		JP_center_CR.add(JL_legalClient_CR, "cell 0 3 4 1,growx");
		
		JLabel JL_companyName_CR = new JLabel("Numele companiei:");
		JL_companyName_CR.setVisible(false);
		JL_companyName_CR.setName("secondary");
		JL_companyName_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_companyName_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_companyName_CR, "cell 0 4,alignx left,aligny center");
		
		JTF_companyName_CR = new JTextField();
		JTF_companyName_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_companyName_CR);
			}
		});
		JTF_companyName_CR.setVisible(false);
		JTF_companyName_CR.setName("secondary");
		JTF_companyName_CR.setColumns(10);
		JP_center_CR.add(JTF_companyName_CR, "cell 1 4,growx");
		
		JLabel JL_companyPhone_CR = new JLabel("Numarul de telefon al companiei");
		JL_companyPhone_CR.setVisible(false);
		JL_companyPhone_CR.setName("secondary");
		JL_companyPhone_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_companyPhone_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_companyPhone_CR, "cell 2 4,alignx left,aligny center");
		
		JTF_companyPhone_CR = new JTextField();
		JTF_companyPhone_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_companyPhone_CR);
			}
		});
		JTF_companyPhone_CR.setVisible(false);
		JTF_companyPhone_CR.setName("secondary");
		JTF_companyPhone_CR.setColumns(10);
		JP_center_CR.add(JTF_companyPhone_CR, "cell 3 4,growx");
		
		JLabel JL_companyRegNR_CR = new JLabel("Numarul de inregistrare:");
		JL_companyRegNR_CR.setVisible(false);
		JL_companyRegNR_CR.setName("secondary");
		JL_companyRegNR_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_companyRegNR_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_companyRegNR_CR, "cell 0 5,alignx left,aligny center");
		
		JTF_companyRegNR_CR = new JTextField();
		JTF_companyRegNR_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_companyRegNR_CR);
			}
		});
		JTF_companyRegNR_CR.setVisible(false);
		JTF_companyRegNR_CR.setName("secondary");
		JTF_companyRegNR_CR.setColumns(10);
		JP_center_CR.add(JTF_companyRegNR_CR, "cell 1 5,growx");
		
		JLabel JL_companyCIF_CR = new JLabel("CIF:");
		JL_companyCIF_CR.setVisible(false);
		JL_companyCIF_CR.setName("secondary");
		JL_companyCIF_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_companyCIF_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_companyCIF_CR, "cell 2 5,alignx left,aligny center");
		
		JTF_companyCIF_CR = new JTextField();
		JTF_companyCIF_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_companyCIF_CR);
			}
		});
		JTF_companyCIF_CR.setVisible(false);
		JTF_companyCIF_CR.setName("secondary");
		JTF_companyCIF_CR.setColumns(10);
		JP_center_CR.add(JTF_companyCIF_CR, "cell 3 5,growx");
		
		JLabel JL_companyBank_CR = new JLabel("Bank:");
		JL_companyBank_CR.setVisible(false);
		JL_companyBank_CR.setName("secondary");
		JL_companyBank_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_companyBank_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_companyBank_CR, "cell 0 6,alignx left,aligny center");
		
		JTF_companyBank_CR = new JTextField();
		JTF_companyBank_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_companyBank_CR);
			}
		});
		JTF_companyBank_CR.setVisible(false);
		JTF_companyBank_CR.setName("secondary");
		JTF_companyBank_CR.setColumns(10);
		JP_center_CR.add(JTF_companyBank_CR, "cell 1 6,growx");
		
		JLabel JL_companyIBAN_CR = new JLabel("IBAN:");
		JL_companyIBAN_CR.setVisible(false);
		JL_companyIBAN_CR.setName("secondary");
		JL_companyIBAN_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_companyIBAN_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_companyIBAN_CR, "cell 2 6,alignx left,aligny center");
		
		JTF_companyIBAN_CR = new JTextField();
		JTF_companyIBAN_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_companyIBAN_CR);
			}
		});
		JTF_companyIBAN_CR.setVisible(false);
		JTF_companyIBAN_CR.setName("secondary");
		JTF_companyIBAN_CR.setColumns(10);
		JP_center_CR.add(JTF_companyIBAN_CR, "cell 3 6,growx");
		
		JLabel JL_companyAddress_CR = new JLabel("Addresa companiei:");
		JL_companyAddress_CR.setVisible(false);
		JL_companyAddress_CR.setName("secondary");
		JL_companyAddress_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_companyAddress_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_companyAddress_CR, "cell 0 7,alignx left,aligny center");
		
		JTF_companyAddress_CR = new JTextField();
		JTF_companyAddress_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_companyAddress_CR);
			}
		});
		JTF_companyAddress_CR.setVisible(false);
		JTF_companyAddress_CR.setName("secondary");
		JTF_companyAddress_CR.setColumns(10);
		JP_center_CR.add(JTF_companyAddress_CR, "cell 1 7,growx");
		
		JLabel JL_companyBranchOffice_CR = new JLabel("Office:");
		JL_companyBranchOffice_CR.setVisible(false);
		JL_companyBranchOffice_CR.setName("secondary");
		JL_companyBranchOffice_CR.setHorizontalAlignment(SwingConstants.LEFT);
		JL_companyBranchOffice_CR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JP_center_CR.add(JL_companyBranchOffice_CR, "cell 2 7,alignx left,aligny center");
		
		JTF_companyBranchOffice_CR = new JTextField();
		JTF_companyBranchOffice_CR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_companyBranchOffice_CR);
			}
		});
		JTF_companyBranchOffice_CR.setVisible(false);
		JTF_companyBranchOffice_CR.setName("secondary");
		JTF_companyBranchOffice_CR.setColumns(10);
		JP_center_CR.add(JTF_companyBranchOffice_CR, "cell 3 7,growx");
		
		JPanel JP_south_CR = new JPanel();
		JP_south_CR.setBackground(Color.WHITE);
		panelCR.add(JP_south_CR, BorderLayout.SOUTH);
		JP_south_CR.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton JB_saveClient_CR = new JButton("Salveaza");
		JB_saveClient_CR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_clientName_CR);
				jtf_list.add(JTF_clientPhone_CR);
				
				if(JTB_isCompany_CR.isSelected()) {
					jtf_list.add(JTF_companyName_CR);
					jtf_list.add(JTF_companyPhone_CR);
					jtf_list.add(JTF_companyAddress_CR);
					jtf_list.add(JTF_companyCIF_CR);
					jtf_list.add(JTF_companyRegNR_CR);
					jtf_list.add(JTF_companyBank_CR);
					jtf_list.add(JTF_companyIBAN_CR);
					jtf_list.add(JTF_companyBranchOffice_CR);
				}
				
				if(emptyFieldValidation(jtf_list)) {
					saveClient(JTB_isCompany_CR.isSelected(), JTF_clientName_CR.getText(),JTF_clientPhone_CR.getText(),JTF_companyName_CR.getText(),JTF_companyPhone_CR.getText(),JTF_companyAddress_CR.getText(),JTF_companyCIF_CR.getText(),JTF_companyRegNR_CR.getText(),JTF_companyBank_CR.getText(),JTF_companyIBAN_CR.getText(), JTF_companyBranchOffice_CR.getText());
					
					panelAbandationHelper(panels.pop(), panels.peek(), false);
				}else {
					unsavedInformer();
				}
			}
		});
		JB_saveClient_CR.setFont(new Font("Tahoma", Font.BOLD, 24));
		JB_saveClient_CR.setHorizontalAlignment(SwingConstants.RIGHT);
		JP_south_CR.add(JB_saveClient_CR);
		
		//Add Auto Piece Panel
		
		panelAAP = new JPanel();
		centralPanel.add(panelAAP, "name_89212496705900");
		panelAAP.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_AAP = new JPanel();
		JP_west_AAP.setBackground(Color.WHITE);
		panelAAP.add(JP_west_AAP, BorderLayout.WEST);
		
		JLabel HC_autoPiece_AAP = new JLabel("");
		HC_autoPiece_AAP.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/auto_piece_512.png")));
		JP_west_AAP.add(HC_autoPiece_AAP);
		
		JPanel JP_center_AAP = new JPanel();
		JP_center_AAP.setBackground(Color.WHITE);
		panelAAP.add(JP_center_AAP, BorderLayout.CENTER);
		JP_center_AAP.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel JL_autoPieceID_AAP = new JLabel("ID:");
		JL_autoPieceID_AAP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_AAP.add(JL_autoPieceID_AAP, "cell 0 0,alignx left,aligny center");
		
		JTF_autoPieceID_AAP = new JTextField();
		JTF_autoPieceID_AAP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_autoPieceID_AAP);
			}
		});
		JTF_autoPieceID_AAP.setColumns(10);
		JP_center_AAP.add(JTF_autoPieceID_AAP, "cell 1 0,growx");
		
		JLabel JL_autoPieceName_AAP = new JLabel("Nume:");
		JL_autoPieceName_AAP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_AAP.add(JL_autoPieceName_AAP, "cell 0 1,alignx left,aligny center");
		
		JTF_autoPieceName_AAP = new JTextField();
		JTF_autoPieceName_AAP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_autoPieceName_AAP);
			}
		});
		JTF_autoPieceName_AAP.setColumns(10);
		JP_center_AAP.add(JTF_autoPieceName_AAP, "cell 1 1,growx");
		
		JLabel JL_autoPieceUniteName_AAP = new JLabel("Unitate:");
		JL_autoPieceUniteName_AAP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_AAP.add(JL_autoPieceUniteName_AAP, "cell 0 2,alignx left,aligny center");
		
		JTF_autoPieceUniteName_AAP = new JTextField();
		JTF_autoPieceUniteName_AAP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_autoPieceUniteName_AAP);
			}
		});
		JTF_autoPieceUniteName_AAP.setColumns(10);
		JP_center_AAP.add(JTF_autoPieceUniteName_AAP, "cell 1 2,growx");
		
		JPanel JP_south_AAP = new JPanel();
		JP_south_AAP.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) JP_south_AAP.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelAAP.add(JP_south_AAP, BorderLayout.SOUTH);
		
		JButton JB_saveAutoPiece_AAP = new JButton("Salveaza");
		JB_saveAutoPiece_AAP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_autoPieceID_AAP);
				jtf_list.add(JTF_autoPieceName_AAP);
				jtf_list.add(JTF_autoPieceUniteName_AAP);
				
				if(emptyFieldValidation(jtf_list)) {
					SaveAutoPiece(JTF_autoPieceID_AAP.getText(), JTF_autoPieceName_AAP.getText(), JTF_autoPieceUniteName_AAP.getText());
					
					panelAbandationHelper(panels.pop(), panels.peek(), false);
				}else {
					unsavedInformer();
				}
			}
		});
		JB_saveAutoPiece_AAP.setHorizontalAlignment(SwingConstants.RIGHT);
		JB_saveAutoPiece_AAP.setFont(new Font("Tahoma", Font.BOLD, 24));
		JP_south_AAP.add(JB_saveAutoPiece_AAP);
		
		panelANJ = new JPanel();
		centralPanel.add(panelANJ, "name_91014716898300");
		panelANJ.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_ANJ = new JPanel();
		JP_west_ANJ.setBackground(Color.WHITE);
		panelANJ.add(JP_west_ANJ, BorderLayout.WEST);
		
		JLabel HC_job_ANJ = new JLabel("");
		HC_job_ANJ.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/job_512.png")));
		JP_west_ANJ.add(HC_job_ANJ);
		
		JPanel JP_center_ANJ = new JPanel();
		JP_center_ANJ.setBackground(Color.WHITE);
		panelANJ.add(JP_center_ANJ, BorderLayout.CENTER);
		JP_center_ANJ.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel JL_jobName_ANJ = new JLabel("Denumirea lucrarii:");
		JL_jobName_ANJ.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANJ.add(JL_jobName_ANJ, "cell 0 0,alignx left,aligny center");
		
		JTF_jobName_ANJ = new JTextField();
		JTF_jobName_ANJ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_jobName_ANJ);
			}
		});
		JTF_jobName_ANJ.setColumns(10);
		JP_center_ANJ.add(JTF_jobName_ANJ, "cell 1 0,growx");
		
		JLabel JB_jobPrice_ANJ = new JLabel("Tarifa lucrarii:");
		JB_jobPrice_ANJ.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANJ.add(JB_jobPrice_ANJ, "cell 0 1,alignx left,aligny center");
		
		JTF_jobPrice_ANJ = new JTextField();
		JTF_jobPrice_ANJ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_jobPrice_ANJ);
			}
		});
		JTF_jobPrice_ANJ.setColumns(10);
		JP_center_ANJ.add(JTF_jobPrice_ANJ, "cell 1 1,growx");
		
		JPanel JP_south_ANJ = new JPanel();
		JP_south_ANJ.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) JP_south_ANJ.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelANJ.add(JP_south_ANJ, BorderLayout.SOUTH);
		
		JButton JB_saveJob_ANJ = new JButton("Salveaza");
		JB_saveJob_ANJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_jobName_ANJ);
				jtf_list.add(JTF_jobPrice_ANJ);
				
				if(emptyFieldValidation(jtf_list)) {
					SaveJob(JTF_jobName_ANJ.getText(), Float.valueOf(JTF_jobPrice_ANJ.getText()));
					
					panelAbandationHelper(panels.pop(), panels.peek(), false);
				}else {
					unsavedInformer();
				}
			}
		});
		JB_saveJob_ANJ.setHorizontalAlignment(SwingConstants.RIGHT);
		JB_saveJob_ANJ.setFont(new Font("Tahoma", Font.BOLD, 24));
		JP_south_ANJ.add(JB_saveJob_ANJ);
		
		panelANU = new JPanel();
		centralPanel.add(panelANU, "name_91509655808200");
		panelANU.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_ANU = new JPanel();
		JP_west_ANU.setBackground(Color.WHITE);
		panelANU.add(JP_west_ANU, BorderLayout.WEST);
		
		JLabel HC_user_ANU = new JLabel("");
		HC_user_ANU.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/worker_512.png")));
		JP_west_ANU.add(HC_user_ANU);
		
		JPanel JP_center_ANU = new JPanel();
		JP_center_ANU.setBackground(Color.WHITE);
		panelANU.add(JP_center_ANU, BorderLayout.CENTER);
		JP_center_ANU.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel JL_userName_ANU = new JLabel("Numele:");
		JL_userName_ANU.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANU.add(JL_userName_ANU, "cell 0 0,alignx left,aligny center");
		
		JTF_userName_ANU = new JTextField();
		JTF_userName_ANU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_userName_ANU);
			}
		});
		JTF_userName_ANU.setColumns(10);
		JP_center_ANU.add(JTF_userName_ANU, "cell 1 0,growx");
		
		JLabel JB_userPassword_ANU = new JLabel("Parola:");
		JB_userPassword_ANU.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANU.add(JB_userPassword_ANU, "cell 0 1,alignx left,aligny center");
		
		JPF_userPassword_ANU = new JPasswordField();
		JPF_userPassword_ANU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JPF_userPassword_ANU);
			}
		});
		JP_center_ANU.add(JPF_userPassword_ANU, "cell 1 1,growx");
		
		JLabel JB_userPasswordRE_ANU = new JLabel("Parola incaodata:");
		JB_userPasswordRE_ANU.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANU.add(JB_userPasswordRE_ANU, "cell 0 2,alignx left,aligny center");
		
		JPF_userPasswordRE_ANU = new JPasswordField();
		JPF_userPasswordRE_ANU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JPF_userPasswordRE_ANU);
			}
		});
		JP_center_ANU.add(JPF_userPasswordRE_ANU, "cell 1 2,growx");
		
		JLabel JL_userRole_ANU = new JLabel("Role:");
		JL_userRole_ANU.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANU.add(JL_userRole_ANU, "cell 0 3,alignx left,aligny center");
		
		JCB_userRole_ANU = new JComboBox<Role>();
		JCB_userRole_ANU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        JComboBox jcb = (JComboBox) e.getSource();
		        Role role = (Role) jcb.getSelectedItem();
		        selectedRole = role;
			}
		});
		JP_center_ANU.add(JCB_userRole_ANU, "cell 1 3,growx");
		
		JPanel JP_south_ANU = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) JP_south_ANU.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		JP_south_ANU.setBackground(Color.WHITE);
		panelANU.add(JP_south_ANU, BorderLayout.SOUTH);
		
		JButton JB_saveUser_ANU = new JButton("Salveaza");
		JB_saveUser_ANU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UserRegistrtationValidation(JTF_userName_ANU, JPF_userPassword_ANU, JPF_userPasswordRE_ANU)) {
					SaveUser(selectedRole.getId(),JTF_userName_ANU.getText(), String.valueOf(JPF_userPassword_ANU.getPassword()));
					
					panelAbandationHelper(panels.pop(), panels.peek(), false);
				}else {
					unsavedInformer();
				}
			}
		});
		JB_saveUser_ANU.setFont(new Font("Tahoma", Font.BOLD, 24));
		JP_south_ANU.add(JB_saveUser_ANU);
		
		panelANS = new JPanel();
		centralPanel.add(panelANS, "name_92237706474900");
		panelANS.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_ANS = new JPanel();
		JP_west_ANS.setBackground(Color.WHITE);
		panelANS.add(JP_west_ANS, BorderLayout.WEST);
		
		JLabel BC_reception_ANS = new JLabel("");
		BC_reception_ANS.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/supplie_512.png")));
		JP_west_ANS.add(BC_reception_ANS);
		
		JPanel JP_center_ANS = new JPanel();
		JP_center_ANS.setBackground(Color.WHITE);
		panelANS.add(JP_center_ANS, BorderLayout.CENTER);
		JP_center_ANS.setLayout(new MigLayout("", "[][grow][][]", "[][][][][][][][][][][][][grow]"));
		
		JLabel JL_clientName_ANS = new JLabel("Furnizor:");
		JL_clientName_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANS.add(JL_clientName_ANS, "cell 0 0,alignx left,aligny center");
		
		JTF_clientName_ANS = new JTextField();
		JTF_clientName_ANS.setName("");
		JTF_clientName_ANS.setColumns(10);
		JP_center_ANS.add(JTF_clientName_ANS, "cell 1 0,growx");
		
		JButton JB_clientSelect_ANS = new JButton("Selecteaza");
		JB_clientSelect_ANS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_clientName_ANS);
				
				if(emptyFieldValidation(jtf_list)) {
					if(getClientByName(JTF_clientName_ANS.getText())) {
						panelStateChangeHelper(panelANS, "all", "selected");
						JTF_selectedClientName_ANS.setVisible(true);
						JTF_selectedClientName_ANS.setText(selectedClient.getContactname());
					}else {
						MissingStatementInformer("Client with this name is not found, or multiple exists with this specific name. Try search instead!");
					}
				}
			}
		});
		JB_clientSelect_ANS.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_center_ANS.add(JB_clientSelect_ANS, "cell 2 0,growx");
		
		JButton JB_clientSearch_ANS = new JButton("Căutare");
		JB_clientSearch_ANS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSelectionHelper(panels.peek(), panelCL);
				panelStateChangeHelper(panelANS, "all", "selected");
				
				SetDefaultTable(JT_clients_CL, new String[]{"Client", "Numele clientului", "Numarul de telefon", "Firm?"});				
				LoadClients();
				
				JTF_clientQuickSearchByStatus_CL.setText("true");
				
				comboFilter(JT_clients_CL,  
						new String[]{JTF_clientQuickSearchByName_CL.getText(), JTF_clientQuickSearchByPhone_CL.getText(), JTF_clientQuickSearchByStatus_CL.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JB_clientSearch_ANS.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_center_ANS.add(JB_clientSearch_ANS, "cell 3 0,growx");
		
		JTF_selectedClientName_ANS = new JTextField();
		JTF_selectedClientName_ANS.setName("permanent");
		JTF_selectedClientName_ANS.setHorizontalAlignment(SwingConstants.CENTER);
		JTF_selectedClientName_ANS.setFont(new Font("Tahoma", Font.BOLD, 22));
		JTF_selectedClientName_ANS.setEnabled(false);
		JTF_selectedClientName_ANS.setEditable(false);
		JP_center_ANS.add(JTF_selectedClientName_ANS, "cell 0 1 4 1,growx");
		JTF_selectedClientName_ANS.setColumns(10);
		
		JLabel JB_invoiceNR_ANS = new JLabel("NR de factura:");
		JB_invoiceNR_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANS.add(JB_invoiceNR_ANS, "cell 0 2,alignx left,aligny center");
		
		JTF_invoiceNR_ANS = new JTextField();
		JTF_invoiceNR_ANS.setName("permanent");
		JTF_invoiceNR_ANS.setColumns(10);
		JP_center_ANS.add(JTF_invoiceNR_ANS, "cell 1 2,growx");
		
		JLabel JL_dateIN_ANS = new JLabel("Date in:");
		JL_dateIN_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANS.add(JL_dateIN_ANS, "cell 0 3,alignx left,aligny center");
		
		JDateChooser JDC_dateIN_ANS = new JDateChooser();
		JP_center_ANS.add(JDC_dateIN_ANS, "cell 1 3,growx,aligny center");
		
		JLabel JL_dueDate_ANS = new JLabel("Due date:");
		JL_dueDate_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANS.add(JL_dueDate_ANS, "cell 0 4,alignx left,aligny center");
		
		JDateChooser JDC_dueDate_ANS = new JDateChooser();
		JP_center_ANS.add(JDC_dueDate_ANS, "cell 1 4,growx,aligny center");
		
		JLabel lblNewLabel_12 = new JLabel("Detalii piesei");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		JP_center_ANS.add(lblNewLabel_12, "cell 0 5 4 1,alignx center");
		
		JLabel JB_pieceText_ANS = new JLabel("Piece ID:");
		JB_pieceText_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANS.add(JB_pieceText_ANS, "cell 0 6,alignx left,aligny center");
		
		JTL_pieceID_ANS = new JTextField();
		JTL_pieceID_ANS.setName("primary");
		JTL_pieceID_ANS.setColumns(10);
		JP_center_ANS.add(JTL_pieceID_ANS, "cell 1 6,growx");
		
		JButton JB_pieceSelect_ANS = new JButton("Selecteaza");
		JB_pieceSelect_ANS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTL_pieceID_ANS);
				
				if(emptyFieldValidation(jtf_list)) {
					if(getAutoPieceByID(JTL_pieceID_ANS.getText())) {
						panelStateChangeHelper(panelANS, "permanent", null);
						JTL_pieceID_ANS.setText(selectedAutoPiece.getId());
					}else {
						MissingStatementInformer("Auto piece with this ID is not exists!");
					}
				}
			}
		});
		JB_pieceSelect_ANS.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_pieceSelect_ANS.setName("primary");
		JB_pieceSelect_ANS.setEnabled(false);
		JP_center_ANS.add(JB_pieceSelect_ANS, "cell 2 6,growx");
		
		JButton JB_pieceSearch_ANS = new JButton("Căutare");
		JB_pieceSearch_ANS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStateChangeHelper(panelANS, "permanent", null);
				itemSelectionHelper(panels.peek(), panelAPL);
				
				SetDefaultTable(JT_pieces_APL, new String[]{"Auto_piece", "COD", "Nume", "Unitate/Masura"});
				LoadPieces();
			}
		});
		JB_pieceSearch_ANS.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_pieceSearch_ANS.setName("primary");
		JB_pieceSearch_ANS.setEnabled(false);
		JP_center_ANS.add(JB_pieceSearch_ANS, "cell 3 6,growx");
		
		JLabel JB_pieceQuantity_ANS = new JLabel("Quantity:");
		JB_pieceQuantity_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANS.add(JB_pieceQuantity_ANS, "cell 0 7,alignx left,aligny center");
		
		JTF_pieceQuantity_ANS = new JTextField();
		JTF_pieceQuantity_ANS.setName("primary");
		JTF_pieceQuantity_ANS.setColumns(10);
		JP_center_ANS.add(JTF_pieceQuantity_ANS, "cell 1 7,growx");
		
		JLabel JB_piecePriceIN_ANS = new JLabel("Price IN:");
		JB_piecePriceIN_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANS.add(JB_piecePriceIN_ANS, "cell 0 8,alignx left,aligny center");
		
		JTF_piecePriceIN_ANS = new JTextField();
		JTF_piecePriceIN_ANS.setName("primary");
		JTF_piecePriceIN_ANS.setColumns(10);
		JP_center_ANS.add(JTF_piecePriceIN_ANS, "cell 1 8,growx");
		
		JLabel JB_piecePriceOUT_ANS = new JLabel("Price OUT:");
		JB_piecePriceOUT_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANS.add(JB_piecePriceOUT_ANS, "cell 0 9,alignx left,aligny center");
		
		JTF_piecePriceOUT_ANS = new JTextField();
		JTF_piecePriceOUT_ANS.setName("primary");
		JTF_piecePriceOUT_ANS.setColumns(10);
		JP_center_ANS.add(JTF_piecePriceOUT_ANS, "cell 1 9,growx");
		
		JLabel JB_pieceTVA_ANS = new JLabel("TVA:");
		JB_pieceTVA_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_center_ANS.add(JB_pieceTVA_ANS, "cell 0 10,alignx left,aligny center");
		
		JTF_pieceVAT_ANS = new JTextField();
		JTF_pieceVAT_ANS.setName("primary");
		JTF_pieceVAT_ANS.setColumns(10);
		JP_center_ANS.add(JTF_pieceVAT_ANS, "cell 1 10,growx");
		
		JButton JB_addPieceToList_ANS = new JButton("Adauga pe list");
		JB_addPieceToList_ANS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//all required textfields
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTL_pieceID_ANS);
				jtf_list.add(JTF_pieceQuantity_ANS);
				jtf_list.add(JTF_piecePriceIN_ANS);
				jtf_list.add(JTF_piecePriceOUT_ANS);
				jtf_list.add(JTF_pieceVAT_ANS);
				
				//for number format validation
				List<JTextField> jtf_list_nf = new ArrayList<JTextField>();
				jtf_list_nf.add(JTF_pieceQuantity_ANS);
				jtf_list_nf.add(JTF_piecePriceIN_ANS);
				jtf_list_nf.add(JTF_piecePriceOUT_ANS);
				jtf_list_nf.add(JTF_pieceVAT_ANS);
				
				
				if(emptyFieldValidation(jtf_list) && numberFormatValidation(jtf_list_nf)) {
					if(selectedAutoPiece.getId().equals(JTL_pieceID_ANS.getText()) || getAutoPieceByID(JTL_pieceID_ANS.getText())) {
						AddNewAutoPieceToReception(JTF_pieceQuantity_ANS.getText(), JTF_piecePriceIN_ANS.getText(), JTF_piecePriceOUT_ANS.getText(), JTF_pieceVAT_ANS.getText());
						
						panelStateChangeHelper(panelANS, "permanent", null);
					}else {
						MissingStatementInformer("Auto piece with this ID is not found!");
					}
				}else {
					MissingStatementInformer("You have to provide the auto piece and its informations correclty!");
				}
			}
		});
		JB_addPieceToList_ANS.setName("primary");
		JB_addPieceToList_ANS.setFont(new Font("Tahoma", Font.BOLD, 20));
		JB_addPieceToList_ANS.setEnabled(false);
		JP_center_ANS.add(JB_addPieceToList_ANS, "cell 2 11 2 1,growx");
		
		JScrollPane SP_pieces_ANS = new JScrollPane();
		JP_center_ANS.add(SP_pieces_ANS, "cell 0 12 4 1,grow");
		
		JT_pieces_ANS = new JTable();
		JT_pieces_ANS.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		SP_pieces_ANS.setViewportView(JT_pieces_ANS);
		
		JPanel JP_south_ANS = new JPanel();
		JP_south_ANS.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) JP_south_ANS.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panelANS.add(JP_south_ANS, BorderLayout.SOUTH);
		
		JButton JB_saveSupplie_ANS = new JButton("Salveaza");
		JB_saveSupplie_ANS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_selectedClientName_ANS);
				
				if(emptyFieldValidation(jtf_list)) {
					if(!selectedClient.getContactname().equals(JTF_selectedClientName_ANS.getText())) {
						getClientByName(JTF_clientName_ANS.getText());
					}
					jtf_list.clear();
					jtf_list.add(JTF_invoiceNR_ANS);
					
					if(emptyFieldValidation(jtf_list)) {			
						List<JDateChooser> jdc_list = new ArrayList<JDateChooser>();
						jdc_list.add(JDC_dateIN_ANS);
						jdc_list.add(JDC_dueDate_ANS);
						
						if(dateFormatValidation(jdc_list)) {
							DefaultTableModel dtm = (DefaultTableModel) JT_pieces_ANS.getModel();
							if(dtm.getRowCount()>0) {						
								SaveReception(JTF_invoiceNR_ANS.getText(), JDC_dateIN_ANS.getDate(), JDC_dueDate_ANS.getDate());
								
								panelAbandationHelper(panels.pop(), panels.peek(), false);
								dtm.setRowCount(0);
								JDC_dateIN_ANS.setCalendar(null);
								JDC_dueDate_ANS.setCalendar(null);
							}else {
								MissingStatementInformer("You have to add values to the table first!");
							}
						}else {
							MissingStatementInformer("You have to privide the correct date(s) first!");
						}
					}else {
						MissingStatementInformer("You have to set the invoice number first!");
					}
				}else {
					MissingStatementInformer("You have to select a client first!");
				}
			}
		});
		JB_saveSupplie_ANS.setFont(new Font("Tahoma", Font.BOLD, 24));
		JP_south_ANS.add(JB_saveSupplie_ANS);
		
		//Client List Panel
		
		panelCL = new JPanel();
		centralPanel.add(panelCL, "name_102720732643100");
		panelCL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_CL = new JPanel();
		panelCL.add(JP_west_CL, BorderLayout.WEST);
		JP_west_CL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_infoHeader_CL = new JPanel();
		JP_west_CL.add(JP_infoHeader_CL, BorderLayout.NORTH);
		
		JLabel lblNewLabel_15 = new JLabel("Detalii clientului");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_infoHeader_CL.add(lblNewLabel_15);
		
		JPanel JP_infoDetails_CL = new JPanel();
		JP_west_CL.add(JP_infoDetails_CL, BorderLayout.CENTER);
		JP_infoDetails_CL.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][]"));
		
		JLabel JL_clientNameInfo_CL = new JLabel("Numele:");
		JL_clientNameInfo_CL.setName("");
		JP_infoDetails_CL.add(JL_clientNameInfo_CL, "cell 0 0,alignx trailing");
		
		JTF_clientNameInfo_CL = new JTextField();
		JTF_clientNameInfo_CL.setName("");
		JTF_clientNameInfo_CL.setColumns(20);
		JP_infoDetails_CL.add(JTF_clientNameInfo_CL, "cell 1 0,growx");
		
		JLabel JL_clientPhoneInfo_CL = new JLabel("Numarul de telefon:");
		JL_clientPhoneInfo_CL.setName("");
		JP_infoDetails_CL.add(JL_clientPhoneInfo_CL, "cell 0 1,alignx trailing");
		
		JTF_clientPhoneInfo_CL = new JTextField();
		JTF_clientPhoneInfo_CL.setName("");
		JTF_clientPhoneInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_clientPhoneInfo_CL, "cell 1 1,growx");
		
		JLabel JL_clientCompanyInfo_CL = new JLabel("Statutul clientului:");
		JL_clientCompanyInfo_CL.setName("");
		JP_infoDetails_CL.add(JL_clientCompanyInfo_CL, "cell 0 2,alignx trailing");
		
		JTF_clientCompanyInfo_CL = new JTextField();
		JTF_clientCompanyInfo_CL.setName("");
		JTF_clientCompanyInfo_CL.setEditable(false);
		JTF_clientCompanyInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_clientCompanyInfo_CL, "cell 1 2,growx");
		
		JLabel JL_companyNameInfo_CL = new JLabel("Numele companiei:");
		JL_companyNameInfo_CL.setVisible(false);
		JL_companyNameInfo_CL.setName("secondary");
		JP_infoDetails_CL.add(JL_companyNameInfo_CL, "cell 0 3,alignx trailing");
		
		JTF_companyNameInfo_CL = new JTextField();
		JTF_companyNameInfo_CL.setVisible(false);
		JTF_companyNameInfo_CL.setName("secondary");
		JTF_companyNameInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_companyNameInfo_CL, "cell 1 3,growx");
		
		JLabel JL_companyAddressInfo_CL = new JLabel("Addresa companiei:");
		JL_companyAddressInfo_CL.setVisible(false);
		JL_companyAddressInfo_CL.setName("secondary");
		JP_infoDetails_CL.add(JL_companyAddressInfo_CL, "cell 0 4,alignx trailing");
		
		JTF_companyAddressInfo_CL = new JTextField();
		JTF_companyAddressInfo_CL.setVisible(false);
		JTF_companyAddressInfo_CL.setName("secondary");
		JTF_companyAddressInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_companyAddressInfo_CL, "cell 1 4,growx");
		
		JLabel JL_companyPhoneInfo_CL = new JLabel("Num. tel. comp.:");
		JL_companyPhoneInfo_CL.setVisible(false);
		JL_companyPhoneInfo_CL.setName("secondary");
		JP_infoDetails_CL.add(JL_companyPhoneInfo_CL, "cell 0 5,alignx trailing");
		
		JTF_companyPhoneInfo_CL = new JTextField();
		JTF_companyPhoneInfo_CL.setVisible(false);
		JTF_companyPhoneInfo_CL.setName("secondary");
		JTF_companyPhoneInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_companyPhoneInfo_CL, "cell 1 5,growx");
		
		JLabel JL_companyCIFInfo_CL = new JLabel("CIF:");
		JL_companyCIFInfo_CL.setVisible(false);
		JL_companyCIFInfo_CL.setName("secondary");
		JP_infoDetails_CL.add(JL_companyCIFInfo_CL, "cell 0 6,alignx trailing");
		
		JTF_companyCIFInfo_CL = new JTextField();
		JTF_companyCIFInfo_CL.setVisible(false);
		JTF_companyCIFInfo_CL.setName("secondary");
		JTF_companyCIFInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_companyCIFInfo_CL, "cell 1 6,growx");
		
		JLabel JL_companyRegNRInfo_CL = new JLabel("NR de irgesitrare:");
		JL_companyRegNRInfo_CL.setVisible(false);
		JL_companyRegNRInfo_CL.setName("secondary");
		JP_infoDetails_CL.add(JL_companyRegNRInfo_CL, "cell 0 7,alignx trailing");
		
		JTF_companyRegNRInfo_CL = new JTextField();
		JTF_companyRegNRInfo_CL.setVisible(false);
		JTF_companyRegNRInfo_CL.setName("secondary");
		JTF_companyRegNRInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_companyRegNRInfo_CL, "cell 1 7,growx");
		
		JLabel JL_companyBankInfo_CL = new JLabel("Bank:");
		JL_companyBankInfo_CL.setVisible(false);
		JL_companyBankInfo_CL.setName("secondary");
		JP_infoDetails_CL.add(JL_companyBankInfo_CL, "cell 0 8,alignx trailing");
		
		JTF_companyBankInfo_CL = new JTextField();
		JTF_companyBankInfo_CL.setVisible(false);
		JTF_companyBankInfo_CL.setName("secondary");
		JTF_companyBankInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_companyBankInfo_CL, "cell 1 8,growx");
		
		JLabel JL_companyIBANInfo_CL = new JLabel("IBAN:");
		JL_companyIBANInfo_CL.setVisible(false);
		JL_companyIBANInfo_CL.setName("secondary");
		JP_infoDetails_CL.add(JL_companyIBANInfo_CL, "cell 0 9,alignx trailing");
		
		JTF_companyIBANInfo_CL = new JTextField();
		JTF_companyIBANInfo_CL.setVisible(false);
		JTF_companyIBANInfo_CL.setName("secondary");
		JTF_companyIBANInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_companyIBANInfo_CL, "cell 1 9,growx");
		
		JLabel JL_companyBranchOfficeInfo_CL = new JLabel("Branch office:");
		JL_companyBranchOfficeInfo_CL.setVisible(false);
		JL_companyBranchOfficeInfo_CL.setName("secondary");
		JP_infoDetails_CL.add(JL_companyBranchOfficeInfo_CL, "cell 0 10,alignx trailing");
		
		JTF_companyBranchOfficeInfo_CL = new JTextField();
		JTF_companyBranchOfficeInfo_CL.setVisible(false);
		JTF_companyBranchOfficeInfo_CL.setName("secondary");
		JTF_companyBranchOfficeInfo_CL.setColumns(10);
		JP_infoDetails_CL.add(JTF_companyBranchOfficeInfo_CL, "cell 1 10,growx");
		
		JPanel JP_infoActions_CL = new JPanel();
		JP_west_CL.add(JP_infoActions_CL, BorderLayout.SOUTH);
		JP_infoActions_CL.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow]"));
		
		JButton JB_selectClient_CL = new JButton("Selectare");
		JB_selectClient_CL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPanel = panels.pop();
				if(panels.peek()==panelANS) {				
					JTF_selectedClientName_ANS.setVisible(true);
					JTF_selectedClientName_ANS.setText(selectedClient.getContactname());
				}else if(panels.peek()==panelANR) {
					JL_selectClient_ANR.setText(selectedClient.getContactname());
					
					SC_addClient_ANR.setEnabled(false);
					SC_editClient_ANR.setEnabled(true);
				}	
				panelAbandationHelper(currentPanel, panels.peek(), false);
			}
		});
		JB_selectClient_CL.setVisible(false);
		JB_selectClient_CL.setName("secondary");
		JB_selectClient_CL.setFont(new Font("Tahoma", Font.BOLD, 20));
		JB_selectClient_CL.setEnabled(false);
		JP_infoActions_CL.add(JB_selectClient_CL, "cell 0 0 2 1,growx");
		
		JButton JB_updateClient_CL = new JButton("Update");
		JB_updateClient_CL.setName("primary");
		JB_updateClient_CL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_updateClient_CL.setEnabled(false);
		JP_infoActions_CL.add(JB_updateClient_CL, "cell 0 1,growx");
		
		JButton JB_deleteClient_CL = new JButton("Delete");
		JB_deleteClient_CL.setName("primary");
		JB_deleteClient_CL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_deleteClient_CL.setEnabled(false);
		JP_infoActions_CL.add(JB_deleteClient_CL, "cell 1 1,growx");
		
		JPanel JP_center_CL = new JPanel();
		panelCL.add(JP_center_CL, BorderLayout.CENTER);
		JP_center_CL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_toolkit_CL = new JPanel();
		JP_center_CL.add(JP_toolkit_CL, BorderLayout.NORTH);
		JP_toolkit_CL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_tableAction_CL = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) JP_tableAction_CL.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		JP_toolkit_CL.add(JP_tableAction_CL, BorderLayout.NORTH);
		
		JLabel TC_addNewClient_CL = new JLabel("");
		TC_addNewClient_CL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panels.peek(), panelCR);
			}
		});
		TC_addNewClient_CL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		JP_tableAction_CL.add(TC_addNewClient_CL);
		
		JLabel TC_reloadClientsTable_CL = new JLabel("");
		TC_reloadClientsTable_CL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStateChangeHelper(panels.peek(), "all", "unselected");
				
				SetDefaultTable(JT_clients_CL, new String[]{"Client", "Numele clientului", "Numarul de telefon", "Firm?"});	
				LoadClients();
			}
		});
		TC_reloadClientsTable_CL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/reload_32.png")));
		JP_tableAction_CL.add(TC_reloadClientsTable_CL);
		
		JPanel JP_tableQuickSearch_CL = new JPanel();
		JP_toolkit_CL.add(JP_tableQuickSearch_CL, BorderLayout.SOUTH);
		JP_tableQuickSearch_CL.setLayout(new MigLayout("", "[grow][grow][grow]", "[]"));
		
		JTF_clientQuickSearchByName_CL = new JTextField();
		JTF_clientQuickSearchByName_CL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comboFilter(JT_clients_CL,  
						new String[]{JTF_clientQuickSearchByName_CL.getText(), JTF_clientQuickSearchByPhone_CL.getText(), JTF_clientQuickSearchByStatus_CL.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_clientQuickSearchByName_CL.setName("");
		JTF_clientQuickSearchByName_CL.setColumns(10);
		JP_tableQuickSearch_CL.add(JTF_clientQuickSearchByName_CL, "cell 0 0,growx");
		
		JTF_clientQuickSearchByPhone_CL = new JTextField();
		JTF_clientQuickSearchByPhone_CL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comboFilter(JT_clients_CL,  
						new String[]{JTF_clientQuickSearchByName_CL.getText(), JTF_clientQuickSearchByPhone_CL.getText(), JTF_clientQuickSearchByStatus_CL.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_clientQuickSearchByPhone_CL.setName("");
		JTF_clientQuickSearchByPhone_CL.setColumns(10);
		JP_tableQuickSearch_CL.add(JTF_clientQuickSearchByPhone_CL, "cell 1 0,growx");
		
		JTF_clientQuickSearchByStatus_CL = new JTextField();
		JTF_clientQuickSearchByStatus_CL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comboFilter(JT_clients_CL,  
						new String[]{JTF_clientQuickSearchByName_CL.getText(), JTF_clientQuickSearchByPhone_CL.getText(), JTF_clientQuickSearchByStatus_CL.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_clientQuickSearchByStatus_CL.setName("");
		JTF_clientQuickSearchByStatus_CL.setColumns(10);
		JP_tableQuickSearch_CL.add(JTF_clientQuickSearchByStatus_CL, "cell 2 0,growx");
		
		JScrollPane scrollPane = new JScrollPane();
		JP_center_CL.add(scrollPane, BorderLayout.CENTER);
		
		JT_clients_CL = new JTable();
		JT_clients_CL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_clients_CL.convertRowIndexToModel(JT_clients_CL.getSelectedRow());
				TableModel model = JT_clients_CL.getModel();
				selectedClient = (Client) model.getValueAt(index, 0);
				
				if(selectedClient.getIscompany()) {
					//setting company parameters to visible and empty, and labels to visible as well					
					//companyDataSetter(true, true);
					panelStateChangeHelper(panelCL, "secondary", "selected");
					
					//Getting the selected company by ID
					//getClientByID(selectedClientID);
					selectedCompany = selectedClient.getCompany();
					
					//Load data into the company's parameters					
					JTF_companyNameInfo_CL.setText(selectedCompany.getCompanyname());
					JTF_companyAddressInfo_CL.setText(selectedCompany.getCompanyaddress());
					JTF_companyPhoneInfo_CL.setText(selectedCompany.getCompanyphone());
					JTF_companyCIFInfo_CL.setText(selectedCompany.getCif());
					JTF_companyRegNRInfo_CL.setText(selectedCompany.getRegnr());
					JTF_companyBankInfo_CL.setText(selectedCompany.getBank());
					JTF_companyIBANInfo_CL.setText(selectedCompany.getIban());
					JTF_companyBranchOfficeInfo_CL.setText(selectedCompany.getBranchoffice());
					
				}else {
					panelStateChangeHelper(panelCL, "primary", "selected");
				}
				
				//basic client data
				JTF_clientNameInfo_CL.setText(selectedClient.getContactname());
				JTF_clientPhoneInfo_CL.setText(selectedClient.getContactphone());
				JTF_clientCompanyInfo_CL.setText(String.valueOf(selectedClient.getIscompany()));
			}
		});
		JT_clients_CL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(JT_clients_CL);
		
		JPanel JP_navigation_CL = new JPanel();
		JP_center_CL.add(JP_navigation_CL, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_16 = new JLabel("Navigation here");
		JP_navigation_CL.add(lblNewLabel_16);
		
		panelAPL = new JPanel();
		centralPanel.add(panelAPL, "name_105867788077900");
		panelAPL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_APL = new JPanel();
		panelAPL.add(JP_west_APL, BorderLayout.WEST);
		JP_west_APL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_infoHeader_APL = new JPanel();
		JP_west_APL.add(JP_infoHeader_APL, BorderLayout.NORTH);
		
		JLabel lblNewLabel_15_1 = new JLabel("Detalii piesului");
		lblNewLabel_15_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_infoHeader_APL.add(lblNewLabel_15_1);
		
		JPanel JP_infoDetails_APL = new JPanel();
		JP_west_APL.add(JP_infoDetails_APL, BorderLayout.CENTER);
		JP_infoDetails_APL.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel pieceIDInfo = new JLabel("Piece ID:");
		JP_infoDetails_APL.add(pieceIDInfo, "cell 0 0,alignx trailing");
		
		JTF_pieceIDInfo_APL = new JTextField();
		JTF_pieceIDInfo_APL.setEditable(false);
		JTF_pieceIDInfo_APL.setColumns(25);
		JP_infoDetails_APL.add(JTF_pieceIDInfo_APL, "cell 1 0,growx");
		
		JLabel pieceNameInfo = new JLabel("Numele piecei:");
		JP_infoDetails_APL.add(pieceNameInfo, "cell 0 1,alignx trailing");
		
		JTF_pieceNameInfo_APL = new JTextField();
		JTF_pieceNameInfo_APL.setColumns(10);
		JP_infoDetails_APL.add(JTF_pieceNameInfo_APL, "cell 1 1,growx");
		
		JLabel pieceUnitInfo = new JLabel("Unit:");
		JP_infoDetails_APL.add(pieceUnitInfo, "cell 0 2,alignx trailing");
		
		JTF_pieceUnitNameInfo_APL = new JTextField();
		JTF_pieceUnitNameInfo_APL.setColumns(10);
		JP_infoDetails_APL.add(JTF_pieceUnitNameInfo_APL, "cell 1 2,growx");
		
		JPanel JP_infoActions_APL = new JPanel();
		JP_west_APL.add(JP_infoActions_APL, BorderLayout.SOUTH);
		JP_infoActions_APL.setLayout(new MigLayout("", "[grow][grow]", "[][]"));
		
		JButton JB_selectPiece_APL = new JButton("Selectare");
		JB_selectPiece_APL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPanel = panels.pop();
				if(panels.peek()==panelANS) {				
					JTL_pieceID_ANS.setText(selectedAutoPiece.getId());
				}else if(panels.peek()==panelAR) {
					if(selectPiece.equals("from")) {
						JTF_pieceNameFrom_AR.setText(selectedAutoPiece.getId());
						JTF_fromPieceIDInfo_AR.setText(selectedAutoPiece.getId());
						
						SetDefaultTable(JT_pieces_AR, new String[]{"Auto_piece", "COD", "Nume", "Unitate/Masura"});
						LoadReplacables(JTF_fromPieceIDInfo_AR.getText());
					}else if(selectPiece.equals("to")) {						
						AddNewAutoPieceToReplaced(JTF_fromPieceIDInfo_AR.getText(),selectedAutoPiece.getId());
						
						SetDefaultTable(JT_pieces_AR, new String[]{"Auto_piece", "COD", "Nume", "Unitate/Masura"});
						LoadReplacables(JTF_fromPieceIDInfo_AR.getText());
					}
				}
				//section specific part
				selectPiece=null;
					
				panelAbandationHelper(currentPanel, panels.peek(), false);
			}
		});
		JB_selectPiece_APL.setVisible(false);
		JB_selectPiece_APL.setName("secondary");
		JB_selectPiece_APL.setFont(new Font("Tahoma", Font.BOLD, 20));
		JB_selectPiece_APL.setEnabled(false);
		JP_infoActions_APL.add(JB_selectPiece_APL, "cell 0 0 2 1,growx");
		
		JButton JB_updatePiece_APL = new JButton("Update");
		JB_updatePiece_APL.setName("primary");
		JB_updatePiece_APL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_updatePiece_APL.setEnabled(false);
		JP_infoActions_APL.add(JB_updatePiece_APL, "cell 0 1,growx");
		
		JButton JB_deletePiece_APL = new JButton("Delete");
		JB_deletePiece_APL.setName("primary");
		JB_deletePiece_APL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_deletePiece_APL.setEnabled(false);
		JP_infoActions_APL.add(JB_deletePiece_APL, "cell 1 1,growx");
		
		JPanel JP_center_APL = new JPanel();
		panelAPL.add(JP_center_APL, BorderLayout.CENTER);
		JP_center_APL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_toolkit_APL = new JPanel();
		JP_center_APL.add(JP_toolkit_APL, BorderLayout.NORTH);
		JP_toolkit_APL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_tableAction_APL = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) JP_tableAction_APL.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		JP_toolkit_APL.add(JP_tableAction_APL, BorderLayout.NORTH);
		
		JLabel TC_addNewAutoPiece_APL = new JLabel("");
		TC_addNewAutoPiece_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panels.peek(), panelAAP);
			}
		});
		TC_addNewAutoPiece_APL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		JP_tableAction_APL.add(TC_addNewAutoPiece_APL);
		
		JLabel TC_reloadAutoPiecesTable_APL = new JLabel("");
		TC_reloadAutoPiecesTable_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStateChangeHelper(panels.peek(), "all", "unselected");
				
				SetDefaultTable(JT_pieces_APL, new String[]{"Auto_piece","COD", "Nume", "Unitate/Masura"});
				LoadPieces();
			}
		});
		TC_reloadAutoPiecesTable_APL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/reload_32.png")));
		JP_tableAction_APL.add(TC_reloadAutoPiecesTable_APL);
		
		JPanel JP_tableQuickSearch_APL = new JPanel();
		JP_toolkit_APL.add(JP_tableQuickSearch_APL, BorderLayout.SOUTH);
		JP_tableQuickSearch_APL.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JTF_pieceQuickSearch_APL = new JTextField();
		JTF_pieceQuickSearch_APL.setColumns(10);
		JP_tableQuickSearch_APL.add(JTF_pieceQuickSearch_APL, "cell 0 0,growx");
		
		JPanel JP_navigation_APL = new JPanel();
		JP_center_APL.add(JP_navigation_APL, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_16_1 = new JLabel("Navigation here");
		JP_navigation_APL.add(lblNewLabel_16_1);
		
		JScrollPane JSP_pieces_APL = new JScrollPane();
		JP_center_APL.add(JSP_pieces_APL, BorderLayout.CENTER);
		
		JT_pieces_APL = new JTable();
		JT_pieces_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = JT_pieces_APL.convertRowIndexToModel(JT_pieces_APL.getSelectedRow());
				TableModel model = JT_pieces_APL.getModel();
				selectedAutoPiece = (Auto_pieces) model.getValueAt(index, 0);
				
				panelStateChangeHelper(panelAPL, null, "selected");

				JTF_pieceIDInfo_APL.setText(selectedAutoPiece.getId());
				JTF_pieceNameInfo_APL.setText(selectedAutoPiece.getAutopiecename());
				JTF_pieceUnitNameInfo_APL.setText(selectedAutoPiece.getAutopieceunitename());
			}
		});
		JT_pieces_APL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		JSP_pieces_APL.setViewportView(JT_pieces_APL);
		
		panelSL = new JPanel();
		centralPanel.add(panelSL, "name_159613447226300");
		panelSL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_SL = new JPanel();
		panelSL.add(JP_west_SL, BorderLayout.WEST);
		JP_west_SL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_infoHeader_SL = new JPanel();
		JP_west_SL.add(JP_infoHeader_SL, BorderLayout.NORTH);
		
		JLabel JL_supplieDetails_SL = new JLabel("Detalii supplie:");
		JL_supplieDetails_SL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_infoHeader_SL.add(JL_supplieDetails_SL);
		
		JPanel JP_infoDetails_SL = new JPanel();
		JP_west_SL.add(JP_infoDetails_SL, BorderLayout.CENTER);
		JP_infoDetails_SL.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel JL_clientNameInfo_SL = new JLabel("Numele furnizorului:");
		JP_infoDetails_SL.add(JL_clientNameInfo_SL, "cell 0 0,alignx trailing");
		
		JTF_clientNameInfo_SL = new JTextField();
		JTF_clientNameInfo_SL.setColumns(20);
		JP_infoDetails_SL.add(JTF_clientNameInfo_SL, "cell 1 0,growx");
		
		JLabel JL_invoiceNRInfo_SL = new JLabel("Invoice number:");
		JP_infoDetails_SL.add(JL_invoiceNRInfo_SL, "cell 0 1,alignx trailing");
		
		JTF_invoiceNRInfo_SL = new JTextField();
		JTF_invoiceNRInfo_SL.setColumns(10);
		JP_infoDetails_SL.add(JTF_invoiceNRInfo_SL, "cell 1 1,growx");
		
		JLabel JL_dateINInfo_SL = new JLabel("Date in:");
		JP_infoDetails_SL.add(JL_dateINInfo_SL, "cell 0 2,alignx trailing");
		
		JDateChooser JDC_dateINInfo_SL = new JDateChooser();
		JP_infoDetails_SL.add(JDC_dateINInfo_SL, "cell 1 2,grow");
		
		JLabel JL_dueDATEInfo_SL = new JLabel("Due date:");
		JP_infoDetails_SL.add(JL_dueDATEInfo_SL, "cell 0 3,alignx trailing");
		
		JDateChooser JDC_dueDateInfo_SL = new JDateChooser();
		JP_infoDetails_SL.add(JDC_dueDateInfo_SL, "cell 1 3,grow");
		
		JPanel JP_infoActions_SL = new JPanel();
		JP_west_SL.add(JP_infoActions_SL, BorderLayout.SOUTH);
		JP_infoActions_SL.setLayout(new MigLayout("", "[grow][grow]", "[][]"));
		
		JButton JB_listAutoPieces_SL = new JButton("List piese auto");
		JB_listAutoPieces_SL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedReception!=null) {
					panelSelectionHelper(panelSL, panelRAPL);
					
					SetDefaultTable(JT_rapl_RAPL, new String[]{"Auto_piece","Auto piece ID", "Quantity", "Date IN", "Unite Price IN", "Unite Price OUT", "TVA"});		
					loadReceptionAutoPieces(selectedReception.getId());
				}
			}
		});
		JB_listAutoPieces_SL.setName("primary");
		JB_listAutoPieces_SL.setFont(new Font("Tahoma", Font.BOLD, 20));
		JB_listAutoPieces_SL.setEnabled(false);
		JP_infoActions_SL.add(JB_listAutoPieces_SL, "cell 0 0 2 1,growx");
		
		JButton JB_updateSupplie_SL = new JButton("Update");
		JB_updateSupplie_SL.setName("primary");
		JB_updateSupplie_SL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_updateSupplie_SL.setEnabled(false);
		JP_infoActions_SL.add(JB_updateSupplie_SL, "cell 0 1,growx");
		
		JButton JB_deleteSupplie_SL = new JButton("Delete");
		JB_deleteSupplie_SL.setName("primary");
		JB_deleteSupplie_SL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_deleteSupplie_SL.setEnabled(false);
		JP_infoActions_SL.add(JB_deleteSupplie_SL, "cell 1 1,growx");
		
		JPanel SP_center_SL = new JPanel();
		panelSL.add(SP_center_SL, BorderLayout.CENTER);
		SP_center_SL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_toolkit_SL = new JPanel();
		SP_center_SL.add(JP_toolkit_SL, BorderLayout.NORTH);
		JP_toolkit_SL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_tableActions_SL = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) JP_tableActions_SL.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		JP_toolkit_SL.add(JP_tableActions_SL, BorderLayout.NORTH);
		
		JLabel TC_addSupplie_ = new JLabel("");
		TC_addSupplie_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panels.peek(), panelANS);
			}
		});
		TC_addSupplie_.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		TC_addSupplie_.setToolTipText("Reload table");
		JP_tableActions_SL.add(TC_addSupplie_);
		
		JLabel TC_reloadReceptionTable_SL = new JLabel("");
		TC_reloadReceptionTable_SL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStateChangeHelper(panels.peek(), "all", "unselected");
				
				SetDefaultTable(JT_supplies_SL, new String[]{"Reception", "Furnizor", "Număr de factură", "Date IN", "Due Date"});				
				loadReception();
			}
		});
		TC_reloadReceptionTable_SL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/reload_32.png")));
		TC_reloadReceptionTable_SL.setToolTipText("Reload table");
		JP_tableActions_SL.add(TC_reloadReceptionTable_SL);
		
		JPanel JP_tableQuickSearch_SL = new JPanel();
		JP_toolkit_SL.add(JP_tableQuickSearch_SL, BorderLayout.SOUTH);
		JP_tableQuickSearch_SL.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[]"));
		
		JTF_clientNameQuickSearch_SL = new JTextField();
		JTF_clientNameQuickSearch_SL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comboFilter(JT_supplies_SL,  
						new String[]{JTF_clientNameQuickSearch_SL.getText(), JTF_invoiceNRQuickSearch_SL.getText()}, 
						new int[] {1, 2});
			}
		});
		JTF_clientNameQuickSearch_SL.setColumns(10);
		JP_tableQuickSearch_SL.add(JTF_clientNameQuickSearch_SL, "cell 0 0,growx");
		
		JTF_invoiceNRQuickSearch_SL = new JTextField();
		JTF_invoiceNRQuickSearch_SL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comboFilter(JT_supplies_SL,  
						new String[]{JTF_clientNameQuickSearch_SL.getText(), JTF_invoiceNRQuickSearch_SL.getText()}, 
						new int[] {1, 2});
			}
		});
		JTF_invoiceNRQuickSearch_SL.setColumns(10);
		JP_tableQuickSearch_SL.add(JTF_invoiceNRQuickSearch_SL, "cell 1 0,growx");
		
		JDateChooser JDC_dateINQuickSearch_SL = new JDateChooser();
		JDC_dateINQuickSearch_SL.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dateIN;
				try {
					dateIN = sdf.format(JDC_dateINQuickSearch_SL.getDate());
					dateFilter(JT_supplies_SL, dateIN, 3);
				}catch(Exception ex){
					//dateIN = sdf.format(new Date());
				}
				
				//dateFilter(JT_supplies_SL, dateIN, 3);
			}
		});
		JP_tableQuickSearch_SL.add(JDC_dateINQuickSearch_SL, "cell 2 0,grow");
		
		JDateChooser JDC_dueDateQuickSearch_SL = new JDateChooser();
		JDC_dueDateQuickSearch_SL.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dueDate;
				try {
					dueDate = sdf.format(JDC_dueDateQuickSearch_SL.getDate());
					dateFilter(JT_supplies_SL, dueDate, 4);
				}catch(Exception ex){
					//dateIN = sdf.format(new Date());
				}
				
				//dateFilter(JT_supplies_SL, dateIN, 4);
			}
		});
		JP_tableQuickSearch_SL.add(JDC_dueDateQuickSearch_SL, "cell 3 0,grow");
		
		JScrollPane JSP_supplies_SL = new JScrollPane();
		SP_center_SL.add(JSP_supplies_SL, BorderLayout.CENTER);
		
		JT_supplies_SL = new JTable();
		JT_supplies_SL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = JT_supplies_SL.convertRowIndexToModel(JT_supplies_SL.getSelectedRow());
				TableModel model = JT_supplies_SL.getModel();
				selectedReception = (Reception) model.getValueAt(index, 0);
				JTF_clientNameInfo_SL.setText(selectedReception.getClients().getContactname());
				JTF_invoiceNRInfo_SL.setText(selectedReception.getIncominginvoicenr());
				JDC_dateINInfo_SL.setDate(selectedReception.getDatein());
				JDC_dueDateInfo_SL.setDate(selectedReception.getDuedate());
				
				panelStateChangeHelper(panelSL, null, "selected");
			}
		});
		JT_supplies_SL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		JSP_supplies_SL.setViewportView(JT_supplies_SL);
		
		JPanel JP_navigation_SL = new JPanel();
		SP_center_SL.add(JP_navigation_SL, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_16_1_1 = new JLabel("Navigation here");
		JP_navigation_SL.add(lblNewLabel_16_1_1);
		
		panelRAPL = new JPanel();
		centralPanel.add(panelRAPL, "name_160690813697700");
		panelRAPL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_RAPL = new JPanel();
		panelRAPL.add(JP_west_RAPL, BorderLayout.WEST);
		JP_west_RAPL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_infoHeader_RAPL = new JPanel();
		JP_west_RAPL.add(JP_infoHeader_RAPL, BorderLayout.NORTH);
		
		JLabel JL_raplDetails_RAPL = new JLabel("Detalii piese de auto al furnizarii:");
		JL_raplDetails_RAPL.setHorizontalAlignment(SwingConstants.CENTER);
		JL_raplDetails_RAPL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_infoHeader_RAPL.add(JL_raplDetails_RAPL);
		
		JPanel JP_infoDetails_RAPL = new JPanel();
		JP_west_RAPL.add(JP_infoDetails_RAPL, BorderLayout.CENTER);
		JP_infoDetails_RAPL.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		
		JLabel JL_recInvoiceNRInfo_RAPL = new JLabel("Reception invoice nr:");
		JP_infoDetails_RAPL.add(JL_recInvoiceNRInfo_RAPL, "cell 0 0,alignx trailing");
		
		JTF_recInvoiceNRInfo_RAPL = new JTextField();
		JTF_recInvoiceNRInfo_RAPL.setColumns(20);
		JP_infoDetails_RAPL.add(JTF_recInvoiceNRInfo_RAPL, "cell 1 0,growx");
		
		JLabel JL_autoPieceIDInfo_RAPL = new JLabel("Tarifa jobului:");
		JP_infoDetails_RAPL.add(JL_autoPieceIDInfo_RAPL, "cell 0 1,alignx trailing");
		
		JTF_autoPieceIDInfo_RAPL = new JTextField();
		JTF_autoPieceIDInfo_RAPL.setColumns(10);
		JP_infoDetails_RAPL.add(JTF_autoPieceIDInfo_RAPL, "cell 1 1,growx");
		
		JLabel JL_quantityInfo_RAPL = new JLabel("Quantity:");
		JP_infoDetails_RAPL.add(JL_quantityInfo_RAPL, "cell 0 2,alignx trailing");
		
		JTF_quantityInfo_RAPL = new JTextField();
		JTF_quantityInfo_RAPL.setColumns(10);
		JP_infoDetails_RAPL.add(JTF_quantityInfo_RAPL, "cell 1 2,growx");
		
		JLabel JL_priceINInfo_RAPL = new JLabel("Price IN:");
		JP_infoDetails_RAPL.add(JL_priceINInfo_RAPL, "cell 0 3,alignx trailing");
		
		JTF_priceINInfo_RAPL = new JTextField();
		JTF_priceINInfo_RAPL.setColumns(10);
		JP_infoDetails_RAPL.add(JTF_priceINInfo_RAPL, "cell 1 3,growx");
		
		JLabel JL_priceOUTInfo_RAPL = new JLabel("Price OUT:");
		JP_infoDetails_RAPL.add(JL_priceOUTInfo_RAPL, "cell 0 4,alignx trailing");
		
		JTF_priceOUTInfo_RAPL = new JTextField();
		JTF_priceOUTInfo_RAPL.setColumns(10);
		JP_infoDetails_RAPL.add(JTF_priceOUTInfo_RAPL, "cell 1 4,growx");
		
		JLabel JL_vatInfo_RAPL = new JLabel("TVA:");
		JP_infoDetails_RAPL.add(JL_vatInfo_RAPL, "cell 0 5,alignx trailing");
		
		JTF_vatInfo_RAPL = new JTextField();
		JTF_vatInfo_RAPL.setColumns(10);
		JP_infoDetails_RAPL.add(JTF_vatInfo_RAPL, "cell 1 5,growx");
		
		JPanel JP_infoActions_RAPL = new JPanel();
		JP_west_RAPL.add(JP_infoActions_RAPL, BorderLayout.SOUTH);
		JP_infoActions_RAPL.setLayout(new MigLayout("", "[grow][grow]", "[]"));
		
		JButton JB_updateRAP_RAPL = new JButton("Update");
		JB_updateRAP_RAPL.setName("primary");
		JB_updateRAP_RAPL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_updateRAP_RAPL.setEnabled(false);
		JP_infoActions_RAPL.add(JB_updateRAP_RAPL, "cell 0 0,growx");
		
		JButton JB_deleteRAP_RAPL = new JButton("Delete");
		JB_deleteRAP_RAPL.setName("primary");
		JB_deleteRAP_RAPL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_deleteRAP_RAPL.setEnabled(false);
		JP_infoActions_RAPL.add(JB_deleteRAP_RAPL, "cell 1 0,growx");
		
		JPanel JP_center_RAPL = new JPanel();
		panelRAPL.add(JP_center_RAPL, BorderLayout.CENTER);
		JP_center_RAPL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_toolkit_RAPL = new JPanel();
		JP_center_RAPL.add(JP_toolkit_RAPL, BorderLayout.NORTH);
		JP_toolkit_RAPL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_tableActions_RAPL = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) JP_tableActions_RAPL.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		JP_toolkit_RAPL.add(JP_tableActions_RAPL, BorderLayout.NORTH);
		
		JLabel TC_addAutoPieceToReception_RAPL = new JLabel("");
		TC_addAutoPieceToReception_RAPL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		TC_addAutoPieceToReception_RAPL.setToolTipText("Reload table");
		TC_addAutoPieceToReception_RAPL.setEnabled(false);
		JP_tableActions_RAPL.add(TC_addAutoPieceToReception_RAPL);
		
		JLabel TC_reloadReceptionAutoPieces_RAPL = new JLabel("");
		TC_reloadReceptionAutoPieces_RAPL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/reload_32.png")));
		TC_reloadReceptionAutoPieces_RAPL.setToolTipText("Reload table");
		JP_tableActions_RAPL.add(TC_reloadReceptionAutoPieces_RAPL);
		
		JPanel JP_tableQuickSearch_RAPL = new JPanel();
		JP_toolkit_RAPL.add(JP_tableQuickSearch_RAPL, BorderLayout.SOUTH);
		JP_tableQuickSearch_RAPL.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JTF_rapQuickSearch_RAPL = new JTextField();
		JTF_rapQuickSearch_RAPL.setColumns(10);
		JP_tableQuickSearch_RAPL.add(JTF_rapQuickSearch_RAPL, "cell 0 0,growx");
		
		JPanel JP_navigation_RAPL = new JPanel();
		JP_center_RAPL.add(JP_navigation_RAPL, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_16_1_1_1 = new JLabel("Navigation here");
		JP_navigation_RAPL.add(lblNewLabel_16_1_1_1);
		
		JScrollPane JSP_pieces_RAPL = new JScrollPane();
		JP_center_RAPL.add(JSP_pieces_RAPL, BorderLayout.CENTER);
		
		JT_rapl_RAPL = new JTable();
		JT_rapl_RAPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = JT_rapl_RAPL.convertRowIndexToModel(JT_rapl_RAPL.getSelectedRow());
				TableModel model = JT_rapl_RAPL.getModel();
				selectedRAPL = (Receptions_auto_pieces) model.getValueAt(index, 0);
				
				JTF_recInvoiceNRInfo_RAPL.setText(selectedRAPL.getReceptions().getIncominginvoicenr());
				JTF_autoPieceIDInfo_RAPL.setText(selectedRAPL.getAutopiecesid());
				JTF_quantityInfo_RAPL.setText(String.valueOf(selectedRAPL.getQuantity()));
				JTF_priceINInfo_RAPL.setText(String.valueOf(selectedRAPL.getUnitepricein()));
				JTF_priceOUTInfo_RAPL.setText(String.valueOf(selectedRAPL.getUnitepriceout()));
				JTF_vatInfo_RAPL.setText(String.valueOf(selectedRAPL.getVatitem()));
				
				panelStateChangeHelper(panelRAPL, null, "selected");
			}
		});
		JSP_pieces_RAPL.setViewportView(JT_rapl_RAPL);
		
		panelIM = new JPanel();
		centralPanel.add(panelIM, "name_161656944563700");
		panelIM.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_IM = new JPanel();
		panelIM.add(JP_west_IM, BorderLayout.WEST);
		JP_west_IM.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_infoHeader_IM = new JPanel();
		JP_west_IM.add(JP_infoHeader_IM, BorderLayout.NORTH);
		
		JLabel JL_inventoryDetails_IM = new JLabel("Detalii iventory:");
		JL_inventoryDetails_IM.setHorizontalAlignment(SwingConstants.CENTER);
		JL_inventoryDetails_IM.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_infoHeader_IM.add(JL_inventoryDetails_IM);
		
		JPanel JP_infoDetails_IM = new JPanel();
		JP_west_IM.add(JP_infoDetails_IM, BorderLayout.CENTER);
		JP_infoDetails_IM.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		
		JLabel JL_pieceIdInfo_IM = new JLabel("Piece ID:");
		JP_infoDetails_IM.add(JL_pieceIdInfo_IM, "cell 0 0,alignx trailing");
		
		JTF_pieceIDInfo_IM = new JTextField();
		JTF_pieceIDInfo_IM.setColumns(20);
		JP_infoDetails_IM.add(JTF_pieceIDInfo_IM, "cell 1 0,growx");
		
		JLabel JL_clientNameInfo_IM = new JLabel("Numele furnizorului:");
		JP_infoDetails_IM.add(JL_clientNameInfo_IM, "cell 0 1,alignx trailing");
		
		JTF_clientNameInfo_IM = new JTextField();
		JTF_clientNameInfo_IM.setColumns(10);
		JP_infoDetails_IM.add(JTF_clientNameInfo_IM, "cell 1 1,growx");
		
		JLabel JL_quantityInfo_IM = new JLabel("Quantity:");
		JP_infoDetails_IM.add(JL_quantityInfo_IM, "cell 0 2,alignx trailing");
		
		JTF_quantityInfo_IM = new JTextField();
		JTF_quantityInfo_IM.setColumns(10);
		JP_infoDetails_IM.add(JTF_quantityInfo_IM, "cell 1 2,growx");
		
		JLabel JL_unitePriceINInfo_IM = new JLabel("Unite price in:");
		JP_infoDetails_IM.add(JL_unitePriceINInfo_IM, "cell 0 3,alignx trailing");
		
		JTF_unitePriceINInfo_IM = new JTextField();
		JTF_unitePriceINInfo_IM.setColumns(10);
		JP_infoDetails_IM.add(JTF_unitePriceINInfo_IM, "cell 1 3,growx");
		
		JLabel JL_unitePriceOutInfo_IM = new JLabel("Unite price out:");
		JP_infoDetails_IM.add(JL_unitePriceOutInfo_IM, "cell 0 4,alignx trailing");
		
		JTF_unitePriceOUTInfo_IM = new JTextField();
		JTF_unitePriceOUTInfo_IM.setColumns(10);
		JP_infoDetails_IM.add(JTF_unitePriceOUTInfo_IM, "cell 1 4,growx");
		
		JLabel JL_dateINInfo_IM = new JLabel("Date in:");
		JP_infoDetails_IM.add(JL_dateINInfo_IM, "cell 0 5,alignx trailing");
		
		JDateChooser JDC_dateINInfo_IM = new JDateChooser();
		JP_infoDetails_IM.add(JDC_dateINInfo_IM, "cell 1 5,grow");
		
		JPanel JP_infoActions_IM = new JPanel();
		JP_west_IM.add(JP_infoActions_IM, BorderLayout.SOUTH);
		JP_infoActions_IM.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JButton JB_selectInventoryItem_IM = new JButton("Selectare");
		JB_selectInventoryItem_IM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPanel = panels.pop();
				JPanel nextPanel = null;

				if(panels.peek()==panelSII) {
					nextPanel = panelSII;
					
					JTF_inventoryItemName_SII.setText(selectedInventoryItem.getAuto_pieces().getAutopiecename());
					JTF_inventoryItemPrice_SII.setText(String.valueOf(selectedInventoryItem.getUnitepriceout()));
				}else {
					System.out.println("Error in panel navigation.");
					nextPanel = panelSII;
				}	
				panelAbandationHelper(currentPanel, nextPanel, false);
			}
		});
		JB_selectInventoryItem_IM.setVisible(false);
		JB_selectInventoryItem_IM.setName("secondary");
		JB_selectInventoryItem_IM.setFont(new Font("Tahoma", Font.BOLD, 20));
		JB_selectInventoryItem_IM.setEnabled(false);
		JP_infoActions_IM.add(JB_selectInventoryItem_IM, "cell 0 0,growx");
		
		JPanel JP_center_IM = new JPanel();
		panelIM.add(JP_center_IM, BorderLayout.CENTER);
		JP_center_IM.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_toolkit_IM = new JPanel();
		JP_center_IM.add(JP_toolkit_IM, BorderLayout.NORTH);
		JP_toolkit_IM.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_tableActions_IM = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) JP_tableActions_IM.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		JP_toolkit_IM.add(JP_tableActions_IM, BorderLayout.NORTH);
		
		JLabel TC_addNewReception_IM = new JLabel("");
		TC_addNewReception_IM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panels.peek(), panelANS);
			}
		});
		TC_addNewReception_IM.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		TC_addNewReception_IM.setToolTipText("Reload table");
		JP_tableActions_IM.add(TC_addNewReception_IM);
		
		JLabel TC_reloadInventoryTable_IM = new JLabel("");
		TC_reloadInventoryTable_IM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStateChangeHelper(panels.peek(), "all", "unselected");
				
				SetDefaultTable(JT_inventory_IM, new String[]{"Inventory", "Piese de auto", "Furnizor", "Quantity", "Price IN", "Price OUT", "Date"});				
				loadInventory();
			}
		});
		TC_reloadInventoryTable_IM.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/reload_32.png")));
		TC_reloadInventoryTable_IM.setToolTipText("Reload table");
		JP_tableActions_IM.add(TC_reloadInventoryTable_IM);
		
		JPanel JP_tableQuickSearch_IM = new JPanel();
		JP_toolkit_IM.add(JP_tableQuickSearch_IM, BorderLayout.SOUTH);
		JP_tableQuickSearch_IM.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow]", "[]"));
		
		JTF_autoPieceQuickSearch_IM = new JTextField();
		JTF_autoPieceQuickSearch_IM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comboFilter(JT_inventory_IM,  
						new String[]{JTF_autoPieceQuickSearch_IM.getText(), JTF_clientQuickSearch_IM.getText(), JTF_dateINQuickSearch_IM.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_autoPieceQuickSearch_IM.setColumns(10);
		JP_tableQuickSearch_IM.add(JTF_autoPieceQuickSearch_IM, "cell 0 0,growx");
		
		JTF_clientQuickSearch_IM = new JTextField();
		JTF_clientQuickSearch_IM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comboFilter(JT_inventory_IM,  
						new String[]{JTF_autoPieceQuickSearch_IM.getText(), JTF_clientQuickSearch_IM.getText(), JTF_dateINQuickSearch_IM.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_clientQuickSearch_IM.setColumns(10);
		JP_tableQuickSearch_IM.add(JTF_clientQuickSearch_IM, "cell 1 0,growx");
		
		temp1 = new JTextField();
		temp1.setVisible(false);
		temp1.setColumns(10);
		JP_tableQuickSearch_IM.add(temp1, "cell 2 0,growx");
		
		temp2 = new JTextField();
		temp2.setVisible(false);
		temp2.setColumns(10);
		JP_tableQuickSearch_IM.add(temp2, "cell 3 0,growx");
		
		temp3 = new JTextField();
		temp3.setVisible(false);
		temp3.setColumns(10);
		JP_tableQuickSearch_IM.add(temp3, "cell 4 0,growx");
		
		JTF_dateINQuickSearch_IM = new JTextField();
		JTF_dateINQuickSearch_IM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				comboFilter(JT_inventory_IM,  
						new String[]{JTF_autoPieceQuickSearch_IM.getText(), JTF_clientQuickSearch_IM.getText(), JTF_dateINQuickSearch_IM.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_dateINQuickSearch_IM.setColumns(10);
		JP_tableQuickSearch_IM.add(JTF_dateINQuickSearch_IM, "cell 5 0,growx");
		
		JScrollPane JSP_inventory_IM = new JScrollPane();
		JP_center_IM.add(JSP_inventory_IM, BorderLayout.CENTER);
		
		JT_inventory_IM = new JTable();
		JT_inventory_IM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = JT_inventory_IM.convertRowIndexToModel(JT_inventory_IM.getSelectedRow());
				TableModel model = JT_inventory_IM.getModel();
				selectedInventoryItem = (Inventory) model.getValueAt(index, 0);
				JTF_pieceIDInfo_IM.setText(selectedInventoryItem.getAutopiecesid());
				JTF_clientNameInfo_IM.setText(selectedInventoryItem.getClients().getContactname());
				JTF_quantityInfo_IM.setText(String.valueOf(selectedInventoryItem.getQuantity()));
				JTF_unitePriceINInfo_IM.setText(String.valueOf(selectedInventoryItem.getUnitepricein()));
				JTF_unitePriceOUTInfo_IM.setText(String.valueOf(selectedInventoryItem.getUnitepriceout()));
				JDC_dateINInfo_IM.setDate(selectedInventoryItem.getDatein());	
				
				panelStateChangeHelper(panelIM, null, "selected");
			}
		});
		JT_inventory_IM.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		JSP_inventory_IM.setViewportView(JT_inventory_IM);
		
		JPanel JP_navigations_IM = new JPanel();
		JP_center_IM.add(JP_navigations_IM, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_16_1_1_1_1 = new JLabel("Navigation here");
		JP_navigations_IM.add(lblNewLabel_16_1_1_1_1);
		
		panelJL = new JPanel();
		centralPanel.add(panelJL, "name_163450278878900");
		panelJL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_JL = new JPanel();
		panelJL.add(JP_west_JL, BorderLayout.WEST);
		JP_west_JL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_infoHeader_JL = new JPanel();
		JP_west_JL.add(JP_infoHeader_JL, BorderLayout.NORTH);
		
		JLabel JL_jobsDetails_JL = new JLabel("Detalii jobului:");
		JL_jobsDetails_JL.setHorizontalAlignment(SwingConstants.CENTER);
		JL_jobsDetails_JL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_infoHeader_JL.add(JL_jobsDetails_JL);
		
		JPanel JP_infoDetails_JL = new JPanel();
		JP_west_JL.add(JP_infoDetails_JL, BorderLayout.CENTER);
		JP_infoDetails_JL.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel JL_jobNameInfo_JL = new JLabel("Numele jobului:");
		JP_infoDetails_JL.add(JL_jobNameInfo_JL, "cell 0 0,alignx trailing");
		
		JTF_jobNameInfo_JL = new JTextField();
		JTF_jobNameInfo_JL.setEditable(false);
		JTF_jobNameInfo_JL.setColumns(20);
		JP_infoDetails_JL.add(JTF_jobNameInfo_JL, "cell 1 0,growx");
		
		JLabel JL_jobPriceInfo_JL = new JLabel("Tarifa jobului:");
		JP_infoDetails_JL.add(JL_jobPriceInfo_JL, "cell 0 1,alignx trailing");
		
		JTF_jobPriceInfo_JL = new JTextField();
		JTF_jobPriceInfo_JL.setColumns(10);
		JP_infoDetails_JL.add(JTF_jobPriceInfo_JL, "cell 1 1,growx");
		
		JPanel JP_infoActions_JL = new JPanel();
		JP_west_JL.add(JP_infoActions_JL, BorderLayout.SOUTH);
		JP_infoActions_JL.setLayout(new MigLayout("", "[grow][grow]", "[][]"));
		
		JButton JB_selectJob_JL = new JButton("Selectare");
		JB_selectJob_JL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPanel = panels.pop();
				JPanel nextPanel = null;

				if(panels.peek()==panelSJ) {
					nextPanel = panelSJ;
					
					JTF_jobName_SJ.setText(selectedJob.getJobname());
					JTF_jobPrice_SJ.setText(String.valueOf(selectedJob.getJobprice()));
				}else {
					System.out.println("Error in panel navigation.");
				}	
				panelAbandationHelper(currentPanel, nextPanel, false);
			}
		});
		JB_selectJob_JL.setVisible(false);
		JB_selectJob_JL.setName("secondary");
		JB_selectJob_JL.setFont(new Font("Tahoma", Font.BOLD, 20));
		JB_selectJob_JL.setEnabled(false);
		JP_infoActions_JL.add(JB_selectJob_JL, "cell 0 0 2 1,growx");
		
		JButton JB_updateJob_JL = new JButton("Update");
		JB_updateJob_JL.setName("primary");
		JB_updateJob_JL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_updateJob_JL.setEnabled(false);
		JP_infoActions_JL.add(JB_updateJob_JL, "cell 0 1,growx");
		
		JButton JB_deleteJob_JL = new JButton("Delete");
		JB_deleteJob_JL.setName("primary");
		JB_deleteJob_JL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_deleteJob_JL.setEnabled(false);
		JP_infoActions_JL.add(JB_deleteJob_JL, "cell 1 1,growx");
		
		JPanel JP_center_JL = new JPanel();
		panelJL.add(JP_center_JL, BorderLayout.CENTER);
		JP_center_JL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_toolkit_JL = new JPanel();
		JP_center_JL.add(JP_toolkit_JL, BorderLayout.NORTH);
		JP_toolkit_JL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_tableActions_JL = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) JP_tableActions_JL.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		JP_toolkit_JL.add(JP_tableActions_JL, BorderLayout.NORTH);
		
		JLabel TC_addNewJob_JL = new JLabel("");
		TC_addNewJob_JL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panels.peek(), panelANJ);
			}
		});
		TC_addNewJob_JL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		TC_addNewJob_JL.setToolTipText("Reload table");
		JP_tableActions_JL.add(TC_addNewJob_JL);
		
		JLabel TC_reloadJobsTable_JL = new JLabel("");
		TC_reloadJobsTable_JL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStateChangeHelper(panels.peek(), "all", "unselected");
				
				SetDefaultTable(JT_jobs_JL, new String[]{"Job", "Numele jobului", "Tarifa jobului"});
				LoadJobs();
			}
		});
		TC_reloadJobsTable_JL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/reload_32.png")));
		TC_reloadJobsTable_JL.setToolTipText("Reload table");
		JP_tableActions_JL.add(TC_reloadJobsTable_JL);
		
		JPanel JP_tableQuickSearch_JL = new JPanel();
		JP_toolkit_JL.add(JP_tableQuickSearch_JL, BorderLayout.SOUTH);
		JP_tableQuickSearch_JL.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JTF_jobQuickSearch_JL = new JTextField();
		JTF_jobQuickSearch_JL.setColumns(10);
		JP_tableQuickSearch_JL.add(JTF_jobQuickSearch_JL, "cell 0 0,growx");
		
		JPanel JP_navigation_JL = new JPanel();
		JP_center_JL.add(JP_navigation_JL, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_16_1_1_1_1_1 = new JLabel("Navigation here");
		JP_navigation_JL.add(lblNewLabel_16_1_1_1_1_1);
		
		JScrollPane JSP_jobs_JL = new JScrollPane();
		JP_center_JL.add(JSP_jobs_JL, BorderLayout.CENTER);
		
		JT_jobs_JL = new JTable();
		JT_jobs_JL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = JT_jobs_JL.convertRowIndexToModel(JT_jobs_JL.getSelectedRow());
				TableModel model = JT_jobs_JL.getModel();
				selectedJob = (Job) model.getValueAt(index, 0);
				JTF_jobNameInfo_JL.setText(selectedJob.getJobname());
				JTF_jobPriceInfo_JL.setText(String.valueOf(selectedJob.getJobprice()!=0?selectedJob.getJobprice():""));
				
				panelStateChangeHelper(panelJL, null, "selected");
			}
		});
		JSP_jobs_JL.setViewportView(JT_jobs_JL);
		
		panelUL = new JPanel();
		centralPanel.add(panelUL, "name_164353666082500");
		panelUL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_UL = new JPanel();
		panelUL.add(JP_west_UL, BorderLayout.WEST);
		JP_west_UL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_infoHeader_UL = new JPanel();
		JP_west_UL.add(JP_infoHeader_UL, BorderLayout.NORTH);
		
		JLabel JL_userDetails_UL = new JLabel("Detalii lucratorului:");
		JL_userDetails_UL.setHorizontalAlignment(SwingConstants.CENTER);
		JL_userDetails_UL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_infoHeader_UL.add(JL_userDetails_UL);
		
		JPanel JP_infoDetails_UL = new JPanel();
		JP_west_UL.add(JP_infoDetails_UL, BorderLayout.CENTER);
		JP_infoDetails_UL.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel JL_userNameInfo_UL = new JLabel("Numele lucratorului:");
		JP_infoDetails_UL.add(JL_userNameInfo_UL, "cell 0 0,alignx trailing");
		
		JTF_userNameInfo_UL = new JTextField();
		JTF_userNameInfo_UL.setColumns(20);
		JP_infoDetails_UL.add(JTF_userNameInfo_UL, "cell 1 0,growx");
		
		JLabel JL_userRoleInfo_UL = new JLabel("Role:");
		JP_infoDetails_UL.add(JL_userRoleInfo_UL, "cell 0 1,alignx trailing");
		
		JComboBox JCB_userRoleInfo_UL = new JComboBox();
		JCB_userRoleInfo_UL.setEditable(true);
		JP_infoDetails_UL.add(JCB_userRoleInfo_UL, "cell 1 1,growx");
		
		JPanel JP_infoActions_UL = new JPanel();
		JP_west_UL.add(JP_infoActions_UL, BorderLayout.SOUTH);
		JP_infoActions_UL.setLayout(new MigLayout("", "[grow][grow]", "[][]"));
		
		JButton JB_deleteUser_UL_1 = new JButton("Selectare");
		JB_deleteUser_UL_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JB_deleteUser_UL_1.setVisible(false);
		JB_deleteUser_UL_1.setName("secondary");
		JB_deleteUser_UL_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		JB_deleteUser_UL_1.setEnabled(false);
		JP_infoActions_UL.add(JB_deleteUser_UL_1, "cell 0 0 2 1,growx");
		
		JButton JB_updateUser_UL = new JButton("Update");
		JB_updateUser_UL.setName("primary");
		JB_updateUser_UL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_updateUser_UL.setEnabled(false);
		JP_infoActions_UL.add(JB_updateUser_UL, "cell 0 1,growx");
		
		JButton JB_deleteUser_UL = new JButton("Delete");
		JB_deleteUser_UL.setName("primary");
		JB_deleteUser_UL.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_deleteUser_UL.setEnabled(false);
		JP_infoActions_UL.add(JB_deleteUser_UL, "cell 1 1,growx");
		
		JPanel JP_center_UL = new JPanel();
		panelUL.add(JP_center_UL, BorderLayout.CENTER);
		JP_center_UL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_toolkit_UL = new JPanel();
		JP_center_UL.add(JP_toolkit_UL, BorderLayout.NORTH);
		JP_toolkit_UL.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_tableActions_UL = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) JP_tableActions_UL.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		JP_toolkit_UL.add(JP_tableActions_UL, BorderLayout.NORTH);
		
		JLabel TC_addNewUser_UL = new JLabel("");
		TC_addNewUser_UL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panels.peek(), panelANU);
			}
		});
		TC_addNewUser_UL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		TC_addNewUser_UL.setToolTipText("Reload table");
		JP_tableActions_UL.add(TC_addNewUser_UL);
		
		JLabel TC_reloadUsersTable_UL = new JLabel("");
		TC_reloadUsersTable_UL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelStateChangeHelper(panels.peek(), "all", "unselected");
				
				SetDefaultTable(JT_users_UL, new String[]{"User", "Numele lucratorului", "Rolul"});				
				LoadUsers();
			}
		});
		TC_reloadUsersTable_UL.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/reload_32.png")));
		TC_reloadUsersTable_UL.setToolTipText("Reload table");
		JP_tableActions_UL.add(TC_reloadUsersTable_UL);
		
		JPanel JP_tableQuickSearch_UL = new JPanel();
		JP_toolkit_UL.add(JP_tableQuickSearch_UL, BorderLayout.SOUTH);
		JP_tableQuickSearch_UL.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JTF_userQuickSearch_UL = new JTextField();
		JTF_userQuickSearch_UL.setColumns(10);
		JP_tableQuickSearch_UL.add(JTF_userQuickSearch_UL, "cell 0 0,growx");
		
		JPanel JP_navigation_UL = new JPanel();
		JP_center_UL.add(JP_navigation_UL, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_16_1_1_1_1_1_1 = new JLabel("Navigation here");
		JP_navigation_UL.add(lblNewLabel_16_1_1_1_1_1_1);
		
		JScrollPane JSP_users_UL = new JScrollPane();
		JP_center_UL.add(JSP_users_UL, BorderLayout.CENTER);
		
		JT_users_UL = new JTable();
		JT_users_UL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = JT_users_UL.convertRowIndexToModel(JT_users_UL.getSelectedRow());
				TableModel model = JT_users_UL.getModel();
				selectedUser = (User) model.getValueAt(index, 0);
				JTF_userNameInfo_UL.setText(selectedUser.getUsername());
				JCB_userRoleInfo_UL.setSelectedItem(selectedUser.getRoles());
				
				panelStateChangeHelper(panelUL, null, "selected");
			}
		});
		JSP_users_UL.setViewportView(JT_users_UL);
		
		panelAR = new JPanel();
		centralPanel.add(panelAR, "name_164987554160300");
		panelAR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_north_AR = new JPanel();
		JP_north_AR.setBackground(Color.WHITE);
		panelAR.add(JP_north_AR, BorderLayout.NORTH);
		JP_north_AR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_fromHeader_AR = new JPanel();
		JP_fromHeader_AR.setBackground(new Color(220, 220, 220));
		FlowLayout flowLayout_11 = (FlowLayout) JP_fromHeader_AR.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		JP_north_AR.add(JP_fromHeader_AR, BorderLayout.NORTH);
		
		JLabel lblNewLabel_19 = new JLabel("From piece");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_fromHeader_AR.add(lblNewLabel_19);
		
		JPanel JP_fromActions_AR = new JPanel();
		JP_fromActions_AR.setBackground(new Color(220, 220, 220));
		FlowLayout flowLayout_12 = (FlowLayout) JP_fromActions_AR.getLayout();
		flowLayout_12.setAlignment(FlowLayout.LEFT);
		JP_north_AR.add(JP_fromActions_AR, BorderLayout.SOUTH);
		
		JLabel JL_pieceNameFrom_AR = new JLabel("Numele piesei:");
		JL_pieceNameFrom_AR.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_fromActions_AR.add(JL_pieceNameFrom_AR);
		
		JTF_pieceNameFrom_AR = new JTextField();
		JTF_pieceNameFrom_AR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_pieceNameFrom_AR);
			}
		});
		JTF_pieceNameFrom_AR.setName("permanent");
		JTF_pieceNameFrom_AR.setColumns(30);
		JP_fromActions_AR.add(JTF_pieceNameFrom_AR);
		
		JButton JB_pieceNameFromSelect_AR = new JButton("Selectare");
		JB_pieceNameFromSelect_AR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> jtf_list = new ArrayList<>();
				jtf_list.add(JTF_pieceNameFrom_AR);
				if(emptyFieldValidation(jtf_list)) {				
					SetDefaultTable(JT_pieces_AR, new String[]{"Auto_piece", "COD", "Nume", "Unitate/Masura"});
					LoadReplacables(JTF_pieceNameFrom_AR.getText());
					
					panelStateChangeHelper(panelAR, "primary", "primary");
					
					JTF_fromPieceIDInfo_AR.setText(selectedAutoPiece.getId());
				}
			}
		});
		JB_pieceNameFromSelect_AR.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_fromActions_AR.add(JB_pieceNameFromSelect_AR);
		
		JButton JB_pieceNameFromSearch_AR = new JButton("Căutare");
		JB_pieceNameFromSearch_AR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetDefaultTable(JT_pieces_APL, new String[]{"Auto_piece", "COD", "Nume", "Unitate/Masura"});
				LoadPieces();
				
				itemSelectionHelper(panelAR, panelAPL);
				panelStateChangeHelper(panelAR, "primary", "primary");
				
				selectPiece = "from";
			}
		});
		JB_pieceNameFromSearch_AR.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_fromActions_AR.add(JB_pieceNameFromSearch_AR);
		
		JPanel JP_west_AR = new JPanel();
		JP_west_AR.setBackground(Color.WHITE);
		panelAR.add(JP_west_AR, BorderLayout.WEST);
		JP_west_AR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_infoHeader_AR = new JPanel();
		JP_infoHeader_AR.setBackground(new Color(245, 245, 245));
		JP_west_AR.add(JP_infoHeader_AR, BorderLayout.NORTH);
		
		JLabel JL_toPieceDetails_AR = new JLabel("Detalii piesei TO");
		JL_toPieceDetails_AR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_toPieceDetails_AR.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_infoHeader_AR.add(JL_toPieceDetails_AR);
		
		JPanel JP_infoDetails_AR = new JPanel();
		JP_infoDetails_AR.setBackground(new Color(245, 245, 245));
		JP_west_AR.add(JP_infoDetails_AR, BorderLayout.CENTER);
		JP_infoDetails_AR.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel JL_toPieceIDInfo_AR = new JLabel("ID:");
		JP_infoDetails_AR.add(JL_toPieceIDInfo_AR, "cell 0 0,alignx trailing");
		
		JTF_toPieceIDInfo_AR = new JTextField();
		JTF_toPieceIDInfo_AR.setEditable(false);
		JTF_toPieceIDInfo_AR.setName("primary");
		JTF_toPieceIDInfo_AR.setColumns(20);
		JP_infoDetails_AR.add(JTF_toPieceIDInfo_AR, "cell 1 0,growx");
		
		JLabel JL_toPieceNameInfo_AR = new JLabel("Numele:");
		JP_infoDetails_AR.add(JL_toPieceNameInfo_AR, "cell 0 1,alignx trailing");
		
		JTF_toPieceNameInfo_AR = new JTextField();
		JTF_toPieceNameInfo_AR.setEditable(false);
		JTF_toPieceNameInfo_AR.setName("primary");
		JTF_toPieceNameInfo_AR.setColumns(10);
		JP_infoDetails_AR.add(JTF_toPieceNameInfo_AR, "cell 1 1,growx");
		
		JLabel JL_toPieceUnitNameInfo_AR = new JLabel("Unitate:");
		JP_infoDetails_AR.add(JL_toPieceUnitNameInfo_AR, "cell 0 2,alignx trailing");
		
		JTF_toPieceUnitNameInfo_AR = new JTextField();
		JTF_toPieceUnitNameInfo_AR.setEditable(false);
		JTF_toPieceUnitNameInfo_AR.setName("primary");
		JTF_toPieceUnitNameInfo_AR.setColumns(10);
		JP_infoDetails_AR.add(JTF_toPieceUnitNameInfo_AR, "cell 1 2,growx");
		
		JPanel JP_infoActions_AR = new JPanel();
		JP_infoActions_AR.setBackground(new Color(245, 245, 245));
		JP_west_AR.add(JP_infoActions_AR, BorderLayout.SOUTH);
		JP_infoActions_AR.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JButton JB_deleteReplacable_AR = new JButton("Șterge din list");
		JB_deleteReplacable_AR.setName("primary");
		JB_deleteReplacable_AR.setFont(new Font("Tahoma", Font.BOLD, 20));
		JB_deleteReplacable_AR.setEnabled(false);
		JP_infoActions_AR.add(JB_deleteReplacable_AR, "cell 0 0,growx");
		
		JPanel JP_center_AR = new JPanel();
		JP_center_AR.setBackground(Color.WHITE);
		panelAR.add(JP_center_AR, BorderLayout.CENTER);
		JP_center_AR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_toolkit_AR = new JPanel();
		JP_toolkit_AR.setBackground(Color.WHITE);
		JP_center_AR.add(JP_toolkit_AR, BorderLayout.NORTH);
		JP_toolkit_AR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_tableActions_AR = new JPanel();
		JP_tableActions_AR.setBackground(new Color(245, 245, 245));
		FlowLayout flowLayout_15 = (FlowLayout) JP_tableActions_AR.getLayout();
		flowLayout_15.setAlignment(FlowLayout.LEFT);
		JP_toolkit_AR.add(JP_tableActions_AR, BorderLayout.NORTH);
		
		JLabel reloadReplacablesTable_1 = new JLabel("");
		reloadReplacablesTable_1.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		reloadReplacablesTable_1.setToolTipText("Reload table");
		JP_tableActions_AR.add(reloadReplacablesTable_1);
		
		JLabel reloadReplacablesTable = new JLabel("");
		reloadReplacablesTable.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/reload_32.png")));
		reloadReplacablesTable.setToolTipText("Reload table");
		JP_tableActions_AR.add(reloadReplacablesTable);
		
		JPanel JP_tableQuickSearch_AR = new JPanel();
		JP_tableQuickSearch_AR.setBackground(new Color(245, 245, 245));
		JP_toolkit_AR.add(JP_tableQuickSearch_AR, BorderLayout.SOUTH);
		JP_tableQuickSearch_AR.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JTF_autoPieceQuickSearch_AR = new JTextField();
		JP_tableQuickSearch_AR.add(JTF_autoPieceQuickSearch_AR, "cell 0 0,growx");
		JTF_autoPieceQuickSearch_AR.setColumns(10);
		
		JPanel JP_navigation_AR = new JPanel();
		JP_navigation_AR.setBackground(new Color(245, 245, 245));
		JP_center_AR.add(JP_navigation_AR, BorderLayout.SOUTH);
		
		JLabel JL_navigation_AR = new JLabel("Navigation here");
		JP_navigation_AR.add(JL_navigation_AR);
		
		JScrollPane JSP_pieces_AR = new JScrollPane();
		JP_center_AR.add(JSP_pieces_AR, BorderLayout.CENTER);
		
		JT_pieces_AR = new JTable();
		JT_pieces_AR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = JT_pieces_AR.getSelectedRow();
				TableModel model = JT_pieces_AR.getModel();
				selectedAutoPiece = (Auto_pieces) model.getValueAt(index, 0);
				
				panelStateChangeHelper(panelAR, null, "selected");
				
				JTF_toPieceIDInfo_AR.setText(selectedAutoPiece.getId());
				JTF_toPieceNameInfo_AR.setText(selectedAutoPiece.getAutopiecename());
				JTF_toPieceUnitNameInfo_AR.setText(selectedAutoPiece.getAutopieceunitename());
			}
		});
		JSP_pieces_AR.setViewportView(JT_pieces_AR);
		
		JPanel JP_south_AR = new JPanel();
		JP_south_AR.setBackground(Color.WHITE);
		panelAR.add(JP_south_AR, BorderLayout.SOUTH);
		JP_south_AR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_toHeader_AR = new JPanel();
		JP_toHeader_AR.setBackground(new Color(220, 220, 220));
		FlowLayout flowLayout_13 = (FlowLayout) JP_toHeader_AR.getLayout();
		flowLayout_13.setAlignment(FlowLayout.LEFT);
		JP_south_AR.add(JP_toHeader_AR, BorderLayout.NORTH);
		
		JLabel lblNewLabel_19_1 = new JLabel("To piece");
		lblNewLabel_19_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_toHeader_AR.add(lblNewLabel_19_1);
		
		JPanel JP_toActions_AR = new JPanel();
		JP_toActions_AR.setBackground(new Color(220, 220, 220));
		FlowLayout flowLayout_14 = (FlowLayout) JP_toActions_AR.getLayout();
		flowLayout_14.setAlignment(FlowLayout.LEFT);
		JP_south_AR.add(JP_toActions_AR, BorderLayout.SOUTH);
		
		JLabel JL_pieceNameTo_AR = new JLabel("Numele piesei:");
		JL_pieceNameTo_AR.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_toActions_AR.add(JL_pieceNameTo_AR);
		
		JTF_pieceNameTo_AR = new JTextField();
		JTF_pieceNameTo_AR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_pieceNameTo_AR);
			}
		});
		JTF_pieceNameTo_AR.setName("primary");
		JTF_pieceNameTo_AR.setColumns(30);
		JP_toActions_AR.add(JTF_pieceNameTo_AR);
		
		JButton JB_pieceNameToSelect_AR = new JButton("Selectare");
		JB_pieceNameToSelect_AR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> jtf_list = new ArrayList<>();
				jtf_list.add(JTF_pieceNameTo_AR);
				
				if(emptyFieldValidation(jtf_list)) {
					AddNewAutoPieceToReplaced(JTF_fromPieceIDInfo_AR.getText(),JTF_pieceNameTo_AR.getText());
					
					panelStateChangeHelper(panelAR, "permanent", "unselected");
					
				    SetDefaultTable(JT_pieces_AR, new String[]{"Auto_piece", "COD", "Nume", "Unitate/Masura"});
				    LoadReplacables(JTF_fromPieceIDInfo_AR.getText());	
				}
			}
		});
		JB_pieceNameToSelect_AR.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_toActions_AR.add(JB_pieceNameToSelect_AR);
		
		JButton JB_pieceNameToSearch_AR = new JButton("Căutare");
		JB_pieceNameToSearch_AR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSelectionHelper(panelAR, panelAPL);
				panelStateChangeHelper(panelAR, "primary", "primary");
				
				SetDefaultTable(JT_pieces_APL, new String[]{"Auto_piece", "COD", "Nume", "Unitate/Masura"});
				LoadPieces();
				
				selectPiece = "to";
			}
		});
		JB_pieceNameToSearch_AR.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_toActions_AR.add(JB_pieceNameToSearch_AR);
		
		JPanel JP_east_AR = new JPanel();
		JP_east_AR.setBackground(Color.WHITE);
		panelAR.add(JP_east_AR, BorderLayout.EAST);
		JP_east_AR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_fromInfoHeader_AR = new JPanel();
		JP_fromInfoHeader_AR.setBackground(new Color(245, 245, 245));
		JP_east_AR.add(JP_fromInfoHeader_AR, BorderLayout.NORTH);
		
		JLabel JL_fromPieceDetails_AR = new JLabel("Detalii piesei FROM");
		JL_fromPieceDetails_AR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_fromPieceDetails_AR.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_fromInfoHeader_AR.add(JL_fromPieceDetails_AR);
		
		JPanel JP_fromInfoDetails = new JPanel();
		JP_fromInfoDetails.setBackground(new Color(245, 245, 245));
		JP_east_AR.add(JP_fromInfoDetails, BorderLayout.CENTER);
		JP_fromInfoDetails.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel JL_fromPieceIDInfo_AR_1 = new JLabel("ID:");
		JP_fromInfoDetails.add(JL_fromPieceIDInfo_AR_1, "cell 0 0,alignx trailing");
		
		JTF_fromPieceIDInfo_AR = new JTextField();
		JTF_fromPieceIDInfo_AR.setName("permanent");
		JTF_fromPieceIDInfo_AR.setEditable(false);
		JTF_fromPieceIDInfo_AR.setColumns(20);
		JP_fromInfoDetails.add(JTF_fromPieceIDInfo_AR, "cell 1 0,growx");
		
		JLabel JL_fromPieceNameInfo_AR_1 = new JLabel("Numele:");
		JP_fromInfoDetails.add(JL_fromPieceNameInfo_AR_1, "cell 0 1,alignx trailing");
		
		JTF_fromPieceNameInfo_AR = new JTextField();
		JTF_fromPieceNameInfo_AR.setName("permanent");
		JTF_fromPieceNameInfo_AR.setEditable(false);
		JTF_fromPieceNameInfo_AR.setColumns(10);
		JP_fromInfoDetails.add(JTF_fromPieceNameInfo_AR, "cell 1 1,growx");
		
		JLabel JL_fromPieceUnitNameInfo_AR_1 = new JLabel("Unitate:");
		JP_fromInfoDetails.add(JL_fromPieceUnitNameInfo_AR_1, "cell 0 2,alignx trailing");
		
		JTF_fromPieceUnitNameInfo_AR = new JTextField();
		JTF_fromPieceUnitNameInfo_AR.setName("permanent");
		JTF_fromPieceUnitNameInfo_AR.setEditable(false);
		JTF_fromPieceUnitNameInfo_AR.setColumns(10);
		JP_fromInfoDetails.add(JTF_fromPieceUnitNameInfo_AR, "cell 1 2,growx");
		
		panelSC = new JPanel();
		centralPanel.add(panelSC, "name_169568180679500");
		panelSC.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_SC = new JPanel();
		panelSC.add(JP_west_SC, BorderLayout.WEST);
		
		JLabel HC_car_SC = new JLabel("");
		HC_car_SC.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/client_512.png")));
		JP_west_SC.add(HC_car_SC);
		
		JPanel JP_center_SC = new JPanel();
		panelSC.add(JP_center_SC, BorderLayout.CENTER);
		JP_center_SC.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_carSelectionHeader_SC = new JPanel();
		JP_center_SC.add(JP_carSelectionHeader_SC, BorderLayout.NORTH);
		
		JLabel lblAdaugaMasinaNoua = new JLabel("Adauga masina noua");
		lblAdaugaMasinaNoua.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdaugaMasinaNoua.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_carSelectionHeader_SC.add(lblAdaugaMasinaNoua);
		
		JPanel JP_carSelectionDetails_SC = new JPanel();
		JP_center_SC.add(JP_carSelectionDetails_SC, BorderLayout.CENTER);
		JP_carSelectionDetails_SC.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		
		JLabel JL_carLicenseNumber_AA = new JLabel("Numarul de înmatriculare:");
		JL_carLicenseNumber_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_carSelectionDetails_SC.add(JL_carLicenseNumber_AA, "cell 0 0,alignx trailing");
		
		JTF_carLicenseNumber_AA = new JTextField();
		JTF_carLicenseNumber_AA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				textfieldBorderResetter(JTF_carLicenseNumber_AA);
			}
		});
		JTF_carLicenseNumber_AA.setColumns(10);
		JP_carSelectionDetails_SC.add(JTF_carLicenseNumber_AA, "cell 1 0,growx");
		
		JLabel JL_carBrand_AA = new JLabel("Brand:");
		JL_carBrand_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_carSelectionDetails_SC.add(JL_carBrand_AA, "cell 0 1,alignx trailing");
		
		JTF_carBrand_AA = new JTextField();
		JTF_carBrand_AA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_carBrand_AA);
			}
		});
		JTF_carBrand_AA.setColumns(10);
		JP_carSelectionDetails_SC.add(JTF_carBrand_AA, "cell 1 1,growx");
		
		JLabel JL_carModel_AA = new JLabel("Model:");
		JL_carModel_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_carSelectionDetails_SC.add(JL_carModel_AA, "cell 0 2,alignx trailing");
		
		JTF_carModel_AA = new JTextField();
		JTF_carModel_AA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_carModel_AA);
			}
		});
		JTF_carModel_AA.setColumns(10);
		JP_carSelectionDetails_SC.add(JTF_carModel_AA, "cell 1 2,growx");
		
		JLabel JL_carChassisNR_AA = new JLabel("Serie sasiu:");
		JL_carChassisNR_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_carSelectionDetails_SC.add(JL_carChassisNR_AA, "cell 0 3,alignx trailing");
		
		JTF_carChassisNR_AA = new JTextField();
		JTF_carChassisNR_AA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_carChassisNR_AA);
			}
		});
		JTF_carChassisNR_AA.setColumns(10);
		JP_carSelectionDetails_SC.add(JTF_carChassisNR_AA, "cell 1 3,growx");
		
		JLabel JL_carEngineNR_AA = new JLabel("Serie motor:");
		JL_carEngineNR_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_carSelectionDetails_SC.add(JL_carEngineNR_AA, "cell 0 4,alignx trailing");
		
		JTF_carEngineNR_AA = new JTextField();
		JTF_carEngineNR_AA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_carEngineNR_AA);
			}
		});
		JTF_carEngineNR_AA.setColumns(10);
		JP_carSelectionDetails_SC.add(JTF_carEngineNR_AA, "cell 1 4,growx");
		
		JLabel JL_carMilometer_AA = new JLabel("Milometer(NR KM):");
		JL_carMilometer_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_carSelectionDetails_SC.add(JL_carMilometer_AA, "cell 0 5,alignx trailing");
		
		JTF_carMilometer_AA = new JTextField();
		JTF_carMilometer_AA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_carMilometer_AA);
			}
		});
		JTF_carMilometer_AA.setColumns(10);
		JP_carSelectionDetails_SC.add(JTF_carMilometer_AA, "cell 1 5,growx");
		
		JPanel JP_carSelectionActions_SC = new JPanel();
		FlowLayout flowLayout_16 = (FlowLayout) JP_carSelectionActions_SC.getLayout();
		flowLayout_16.setAlignment(FlowLayout.RIGHT);
		JP_center_SC.add(JP_carSelectionActions_SC, BorderLayout.SOUTH);
		
		JButton JB_clearCar_AA = new JButton("Anulare");
		JB_clearCar_AA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStateChangeHelper(panels.peek(), "all", null);
			}
		});
		JB_clearCar_AA.setFont(new Font("Tahoma", Font.PLAIN, 24));
		JP_carSelectionActions_SC.add(JB_clearCar_AA);
		
		JButton JB_addCar_AA = new JButton("Adauga nou");
		JB_addCar_AA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_carLicenseNumber_AA);
				jtf_list.add(JTF_carBrand_AA);
				jtf_list.add(JTF_carModel_AA);
				jtf_list.add(JTF_carChassisNR_AA);
				jtf_list.add(JTF_carEngineNR_AA);
				jtf_list.add(JTF_carMilometer_AA);
				
				if(emptyFieldValidation(jtf_list)) {
					
					saveCar(JTF_carLicenseNumber_AA.getText(), JTF_carBrand_AA.getText(), JTF_carModel_AA.getText(), JTF_carChassisNR_AA.getText(), JTF_carEngineNR_AA.getText(), Integer.valueOf(JTF_carMilometer_AA.getText()));
					JL_selectCar_ANR.setText(selectedCar.getLicenseNumber());

					SC_addCar_ANR.setEnabled(false);
					SC_editCar_ANR.setEnabled(true);
					
					panelAbandationHelper(panels.pop(), panels.peek(), false);
					
				}else {
					unsavedInformer();
				}
			}
		});
		JB_addCar_AA.setFont(new Font("Tahoma", Font.PLAIN, 24));
		JP_carSelectionActions_SC.add(JB_addCar_AA);
		
		JPanel JP_east_SC = new JPanel();
		panelSC.add(JP_east_SC, BorderLayout.EAST);
		JP_east_SC.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_prevCars_SC = new JPanel();
		JP_east_SC.add(JP_prevCars_SC, BorderLayout.NORTH);
		
		JLabel JL_prevInfo_AA = new JLabel("Mașini recente");
		JL_prevInfo_AA.setHorizontalAlignment(SwingConstants.CENTER);
		JL_prevInfo_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JP_prevCars_SC.add(JL_prevInfo_AA);
		
		JScrollPane JP_prevCars_AA = new JScrollPane();
		JP_east_SC.add(JP_prevCars_AA, BorderLayout.CENTER);
		
		JT_prevCars_AA = new JTable();
		JP_prevCars_AA.setViewportView(JT_prevCars_AA);
		
		panelSII = new JPanel();
		centralPanel.add(panelSII, "name_171816382133500");
		panelSII.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_SII = new JPanel();
		panelSII.add(JP_west_SII, BorderLayout.WEST);
		
		JLabel HC_inventory_SII = new JLabel("");
		HC_inventory_SII.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/inventory_512.png")));
		JP_west_SII.add(HC_inventory_SII);
		
		JPanel JP_center_SII = new JPanel();
		panelSII.add(JP_center_SII, BorderLayout.CENTER);
		JP_center_SII.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_addInventoyItem_SII = new JPanel();
		FlowLayout flowLayout_17 = (FlowLayout) JP_addInventoyItem_SII.getLayout();
		flowLayout_17.setAlignment(FlowLayout.LEFT);
		JP_center_SII.add(JP_addInventoyItem_SII, BorderLayout.NORTH);
		
		JLabel lblNewLabel_21 = new JLabel("Numele piesului:");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_addInventoyItem_SII.add(lblNewLabel_21);
		
		JTF_inventoryItemSearch_SII = new JTextField();
		JTF_inventoryItemSearch_SII.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_inventoryItemSearch_SII);
			}
		});
		JTF_inventoryItemSearch_SII.setColumns(30);
		JP_addInventoyItem_SII.add(JTF_inventoryItemSearch_SII);
		
		JButton JB_selectInventoryItem_SII = new JButton("Selectare");
		JB_selectInventoryItem_SII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_inventoryItemSearch_SII);
				
				if(emptyFieldValidation(jtf_list)) {
					if(getInventoryItemByAutoPieceID(JTF_inventoryItemSearch_SII.getText())) {
						panelStateChangeHelper(panels.peek(), "all", "primary");
						
						JTF_inventoryItemName_SII.setText(selectedInventoryItem.getAuto_pieces().getAutopiecename());
						JTF_inventoryItemPrice_SII.setText(String.valueOf(selectedInventoryItem.getUnitepriceout()));
					}else {
						MissingStatementInformer("The item you have entered does not exist, or it is out of stock!");
					}
				}else {
					MissingStatementInformer("You have to provide an inventory item first!");
				}
			}
		});
		JB_selectInventoryItem_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addInventoyItem_SII.add(JB_selectInventoryItem_SII);
		
		JButton JB_searchInventory_SII = new JButton("Cautare");
		JB_searchInventory_SII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSelectionHelper(panelSII, panelIM);
				
				SetDefaultTable(JT_inventory_IM, new String[]{"Inventory", "Piese de auto", "Furnizor", "Quantity", "Price IN", "Price OUT", "Date"});				
				loadInventory();
			}
		});
		JB_searchInventory_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addInventoyItem_SII.add(JB_searchInventory_SII);
		
		JPanel JP_addInventoryDetails_SII = new JPanel();
		JP_center_SII.add(JP_addInventoryDetails_SII, BorderLayout.CENTER);
		JP_addInventoryDetails_SII.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel JL_inventoryItemName_SII = new JLabel("Denumire:");
		JL_inventoryItemName_SII.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JP_addInventoryDetails_SII.add(JL_inventoryItemName_SII, "cell 0 0,alignx trailing");
		
		JTF_inventoryItemName_SII = new JTextField();
		JTF_inventoryItemName_SII.setEditable(false);
		JTF_inventoryItemName_SII.setColumns(10);
		JP_addInventoryDetails_SII.add(JTF_inventoryItemName_SII, "cell 1 0,growx");
		
		JLabel JL_inventoryItemPrice_SII = new JLabel("Pret:");
		JL_inventoryItemPrice_SII.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JP_addInventoryDetails_SII.add(JL_inventoryItemPrice_SII, "cell 0 1,alignx trailing");
		
		JTF_inventoryItemPrice_SII = new JTextField();
		JTF_inventoryItemPrice_SII.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_inventoryItemPrice_SII);
			}
		});
		JTF_inventoryItemPrice_SII.setColumns(10);
		JP_addInventoryDetails_SII.add(JTF_inventoryItemPrice_SII, "cell 1 1,growx");
		
		JLabel JL_invenoryItemQuantity_SII = new JLabel("Quantity:");
		JL_invenoryItemQuantity_SII.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JP_addInventoryDetails_SII.add(JL_invenoryItemQuantity_SII, "cell 0 2,alignx trailing");
		
		JTF_invenotyItemQuantity_SII = new JTextField();
		JTF_invenotyItemQuantity_SII.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_invenotyItemQuantity_SII);
			}
		});
		JTF_invenotyItemQuantity_SII.setColumns(10);
		JP_addInventoryDetails_SII.add(JTF_invenotyItemQuantity_SII, "cell 1 2,growx");
		
		JPanel JP_addInventoryActions_SII = new JPanel();
		FlowLayout fl_JP_addInventoryActions_SII = (FlowLayout) JP_addInventoryActions_SII.getLayout();
		fl_JP_addInventoryActions_SII.setAlignment(FlowLayout.RIGHT);
		JP_center_SII.add(JP_addInventoryActions_SII, BorderLayout.SOUTH);
		
		JButton JB_updateRegistrationInventory_SII = new JButton("Actualizara");
		JB_updateRegistrationInventory_SII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		JB_updateRegistrationInventory_SII.setVisible(false);
		JB_updateRegistrationInventory_SII.setName("secondary");
		JB_updateRegistrationInventory_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addInventoryActions_SII.add(JB_updateRegistrationInventory_SII);
		
		JButton JB_clearInvenoryItem_SII = new JButton("Anulare");
		JB_clearInvenoryItem_SII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStateChangeHelper(panels.peek(), "all", null);
			}
		});
		JB_clearInvenoryItem_SII.setName("");
		JB_clearInvenoryItem_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addInventoryActions_SII.add(JB_clearInvenoryItem_SII);
		
		JButton JB_addInventoryItemToList_SII = new JButton("Adauga la list");
		JB_addInventoryItemToList_SII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedInventoryItem!=null) {
					List<JTextField> jtf_list = new ArrayList<JTextField>();
					jtf_list.add(JTF_inventoryItemPrice_SII);
					jtf_list.add(JTF_invenotyItemQuantity_SII);
					
					if(emptyFieldValidation(jtf_list)) {
						saveRegistrationInventory(Float.valueOf(JTF_inventoryItemPrice_SII.getText()), Float.valueOf(JTF_invenotyItemQuantity_SII.getText()));
						
						SetDefaultTable(JT_inventory_SII, new String[]{"Inventory", "Piece ID","Numele piesei", "Pret final", "Quantity"});
						loadRegistrationInventory(selectedRegistration.getId());
						
						panelStateChangeHelper(panelSII, "all", null);
					}
				}else {
					MissingStatementInformer("Select a inventory item first!");
				}
			}
		});
		JB_addInventoryItemToList_SII.setName("");
		JB_addInventoryItemToList_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addInventoryActions_SII.add(JB_addInventoryItemToList_SII);
		
		JPanel JP_east_SII = new JPanel();
		panelSII.add(JP_east_SII, BorderLayout.EAST);
		JP_east_SII.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_inventoryHeader_SII = new JPanel();
		JP_east_SII.add(JP_inventoryHeader_SII, BorderLayout.NORTH);
		
		JLabel lblNewLabel_20 = new JLabel("Inventory");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_inventoryHeader_SII.add(lblNewLabel_20);
		
		JScrollPane JSP_inventory_SII = new JScrollPane();
		JP_east_SII.add(JSP_inventory_SII, BorderLayout.CENTER);
		
		JT_inventory_SII = new JTable();
		JT_inventory_SII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_inventory_SII.convertRowIndexToModel(JT_inventory_SII.getSelectedRow());
				TableModel model = JT_inventory_SII.getModel();
				selectedRegistrationInventory = (Registrations_inventory) model.getValueAt(index, 0);
				
				JTF_inventoryItemName_SII.setText(selectedRegistrationInventory.getInventory().getAutopiecesid());
				JTF_inventoryItemPrice_SII.setText(String.valueOf(selectedRegistrationInventory.getNewuniteprice()));
				JTF_invenotyItemQuantity_SII.setText(String.valueOf(selectedRegistrationInventory.getQuantity()));
				
				JB_updateRegistrationInventory_SII.setVisible(true);
				JB_addInventoryItemToList_SII.setVisible(false);
			}
		});
		JSP_inventory_SII.setViewportView(JT_inventory_SII);
		
		JPanel JP_south_SII = new JPanel();
		FlowLayout flowLayout_18 = (FlowLayout) JP_south_SII.getLayout();
		flowLayout_18.setAlignment(FlowLayout.RIGHT);
		panelSII.add(JP_south_SII, BorderLayout.SOUTH);
		
		JButton JB_saveInventory_SII = new JButton("Salveaza");
		JB_saveInventory_SII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = finalizateRegistrationInventory(selectedRegistration.getId());
				
				SetDefaultTable(JT_info_ANR, new String[]{"Piece ID", "Pret final", "Quantity"});
				loadRegistrationInfo(selectedRegistration.getId(), "Registrations_inventory");
				
				JL_selectPiece_ANR.setText("Piese selectate: " + count);
				SC_addPiece_ANR.setEnabled(false);
				SC_editPiece_ANR.setEnabled(true);
				SC_infoPiece_ANR.setEnabled(true);
				panelAbandationHelper(panels.pop(), panels.peek(), false);
			}
		});
		JB_saveInventory_SII.setFont(new Font("Tahoma", Font.BOLD, 24));
		JP_south_SII.add(JB_saveInventory_SII);
		
		panelSJ = new JPanel();
		centralPanel.add(panelSJ, "name_173847816686300");
		panelSJ.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_SJ = new JPanel();
		panelSJ.add(JP_west_SJ, BorderLayout.WEST);
		
		JLabel HC_inventory_SII_1 = new JLabel("");
		HC_inventory_SII_1.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/job_512.png")));
		JP_west_SJ.add(HC_inventory_SII_1);
		
		JPanel JP_center_SJ = new JPanel();
		panelSJ.add(JP_center_SJ, BorderLayout.CENTER);
		JP_center_SJ.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_addJobHeader_SJ = new JPanel();
		FlowLayout flowLayout_20 = (FlowLayout) JP_addJobHeader_SJ.getLayout();
		flowLayout_20.setAlignment(FlowLayout.LEFT);
		JP_center_SJ.add(JP_addJobHeader_SJ, BorderLayout.NORTH);
		
		JLabel lblNewLabel_23 = new JLabel("Job:");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_addJobHeader_SJ.add(lblNewLabel_23);
		
		JTF_jobSearch_SJ = new JTextField();
		JTF_jobSearch_SJ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_jobSearch_SJ);
			}
		});
		JTF_jobSearch_SJ.setColumns(30);
		JP_addJobHeader_SJ.add(JTF_jobSearch_SJ);
		
		JButton JB_selectJob_SJ = new JButton("Selectare");
		JB_selectJob_SJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_jobSearch_SJ);
				
				if(emptyFieldValidation(jtf_list)) {
					if(getJobByName(JTF_jobSearch_SJ.getText())) {
						JTF_jobName_SJ.setText(selectedJob.getJobname());
						JTF_jobPrice_SJ.setText(String.valueOf(selectedJob.getJobprice()));
					}
				}
			}
		});
		JB_selectJob_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addJobHeader_SJ.add(JB_selectJob_SJ);
		
		JButton JB_searchJob_SJ = new JButton("Cautare");
		JB_searchJob_SJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSelectionHelper(panelSJ, panelJL);
				
				SetDefaultTable(JT_jobs_JL, new String[]{"Job", "Numele jobului", "Tarifa jobului"});				
				LoadJobs();
			}
		});
		JB_searchJob_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addJobHeader_SJ.add(JB_searchJob_SJ);
		
		JPanel JP_addJobDetails_SJ = new JPanel();
		JP_center_SJ.add(JP_addJobDetails_SJ, BorderLayout.CENTER);
		JP_addJobDetails_SJ.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel JL_jobName_SJ = new JLabel("Denumire:");
		JL_jobName_SJ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JP_addJobDetails_SJ.add(JL_jobName_SJ, "cell 0 0,alignx trailing");
		
		JTF_jobName_SJ = new JTextField();
		JTF_jobName_SJ.setEditable(false);
		JTF_jobName_SJ.setColumns(10);
		JP_addJobDetails_SJ.add(JTF_jobName_SJ, "cell 1 0,growx");
		
		JLabel JL_jobPrice_SJ = new JLabel("Tarifa:");
		JL_jobPrice_SJ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JP_addJobDetails_SJ.add(JL_jobPrice_SJ, "cell 0 1,alignx trailing");
		
		JTF_jobPrice_SJ = new JTextField();
		JTF_jobPrice_SJ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_jobPrice_SJ);
			}
		});
		JTF_jobPrice_SJ.setColumns(10);
		JP_addJobDetails_SJ.add(JTF_jobPrice_SJ, "cell 1 1,growx");
		
		JPanel JP_addJobActions_SJ = new JPanel();
		FlowLayout fl_JP_addJobActions_SJ = (FlowLayout) JP_addJobActions_SJ.getLayout();
		fl_JP_addJobActions_SJ.setAlignment(FlowLayout.RIGHT);
		JP_center_SJ.add(JP_addJobActions_SJ, BorderLayout.SOUTH);
		
		JButton JB_updateRegistrationJob_SJ = new JButton("Actualizare");
		JB_updateRegistrationJob_SJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		JB_updateRegistrationJob_SJ.setVisible(false);
		JB_updateRegistrationJob_SJ.setName("secondary");
		JB_updateRegistrationJob_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addJobActions_SJ.add(JB_updateRegistrationJob_SJ);
		
		JButton JB_addJobToList_SJ = new JButton("Adauga la list");
		JB_addJobToList_SJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedJob!=null) {
					List<JTextField> jtf_list = new ArrayList<JTextField>();
					jtf_list.add(JTF_jobName_SJ);
					jtf_list.add(JTF_jobPrice_SJ);
					
					if(emptyFieldValidation(jtf_list)) {
						saveRegistrationJob(Float.parseFloat(JTF_jobPrice_SJ.getText()));
						
						SetDefaultTable(JT_jobs_SJ, new String[]{"Job", "Numele jobului", "Tarif final"});
						loadRegistrationJob(selectedRegistration.getId());
						
						panelStateChangeHelper(panelSJ, "all", null);
					}
				}else {
					System.out.println("Select a job first.");
				}
			}
		});
		
		JButton JB_clearJob_SJ = new JButton("Anulare");
		JB_clearJob_SJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStateChangeHelper(panelSJ, "all", null);
			}
		});
		JB_clearJob_SJ.setName("");
		JB_clearJob_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addJobActions_SJ.add(JB_clearJob_SJ);
		JB_addJobToList_SJ.setName("");
		JB_addJobToList_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JP_addJobActions_SJ.add(JB_addJobToList_SJ);
		
		JPanel JP_east_SJ = new JPanel();
		panelSJ.add(JP_east_SJ, BorderLayout.EAST);
		JP_east_SJ.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_jobSelectionHeader_SJ = new JPanel();
		JP_east_SJ.add(JP_jobSelectionHeader_SJ, BorderLayout.NORTH);
		
		JLabel lblNewLabel_22 = new JLabel("Jobs");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 18));
		JP_jobSelectionHeader_SJ.add(lblNewLabel_22);
		
		JScrollPane JSP_jobs_SJ = new JScrollPane();
		JP_east_SJ.add(JSP_jobs_SJ, BorderLayout.CENTER);
		
		JT_jobs_SJ = new JTable();
		JT_jobs_SJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_jobs_SJ.convertRowIndexToModel(JT_jobs_SJ.getSelectedRow());
				TableModel model = JT_jobs_SJ.getModel();
				selectedRegistrationJob = (Registration_job) model.getValueAt(index, 0);
				
				JTF_jobName_SJ.setText(selectedRegistrationJob.getJobs().getJobname());
				JTF_jobPrice_SJ.setText(String.valueOf(selectedRegistrationJob.getNewjobprice()));
				
				JB_updateRegistrationJob_SJ.setVisible(true);
				JB_addJobToList_SJ.setVisible(false);
			}
		});
		JSP_jobs_SJ.setViewportView(JT_jobs_SJ);
		
		JPanel JP_south_SJ = new JPanel();
		FlowLayout flowLayout_19 = (FlowLayout) JP_south_SJ.getLayout();
		flowLayout_19.setAlignment(FlowLayout.RIGHT);
		panelSJ.add(JP_south_SJ, BorderLayout.SOUTH);
		
		JButton JB_saveJob_SJ = new JButton("Salveaza");
		JB_saveJob_SJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = finalizateRegistrationJob(selectedRegistration.getId());
				
				SetDefaultTable(JT_info_ANR, new String[]{"Numele jobului", "Tarif final"});
				loadRegistrationInfo(selectedRegistration.getId(), "Registration_job");
				
				JL_selectJob_ANR.setText("Joburi selectate: " + count);
				SC_addJob_ANR.setEnabled(false);
				SC_editJob_ANR.setEnabled(true);
				SC_infoJob_ANR.setEnabled(true);
				panelAbandationHelper(panels.pop(), panels.peek(), false);
			}
		});
		JB_saveJob_SJ.setFont(new Font("Tahoma", Font.BOLD, 24));
		JP_south_SJ.add(JB_saveJob_SJ);
		
		//Add New Registration Panel
		
		panelANR = new JPanel();
		centralPanel.add(panelANR, "name_175425534413200");
		panelANR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_west_ANR = new JPanel();
		panelANR.add(JP_west_ANR, BorderLayout.CENTER);
		JP_west_ANR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_registrationHeader_ANR = new JPanel();
		JP_west_ANR.add(JP_registrationHeader_ANR, BorderLayout.NORTH);
		JP_registrationHeader_ANR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_regMain_ANR = new JPanel();
		JP_registrationHeader_ANR.add(JP_regMain_ANR, BorderLayout.CENTER);
		JP_regMain_ANR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_regNR_ANR = new JPanel();
		JP_regMain_ANR.add(JP_regNR_ANR, BorderLayout.NORTH);
		JP_regNR_ANR.setLayout(new MigLayout("", "[260px][400px][197px][213px]", "[39px]"));
		
		JLabel JL_registrationNumber_ANR_1 = new JLabel("Registration ID:");
		JP_regNR_ANR.add(JL_registrationNumber_ANR_1, "cell 0 0,alignx left,aligny top");
		JL_registrationNumber_ANR_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JTF_registrationNumber_ANR = new JTextField();
		JTF_registrationNumber_ANR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				textfieldBorderResetter(JTF_registrationNumber_ANR);
			}
		});
		JP_regNR_ANR.add(JTF_registrationNumber_ANR, "cell 1 0,growx,aligny center");
		JTF_registrationNumber_ANR.setFont(new Font("Tahoma", Font.BOLD, 20));
		JTF_registrationNumber_ANR.setColumns(20);
		
		JButton JB_generateNewRegistrationNumber_ANR = new JButton("Genereaza noua");
		JB_generateNewRegistrationNumber_ANR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateRegistrationNumber();
			}
		});
		JP_regNR_ANR.add(JB_generateNewRegistrationNumber_ANR, "cell 2 0,alignx left,aligny center");
		JB_generateNewRegistrationNumber_ANR.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton JB_saveRegistrtation_ANR = new JButton("Salveaza numarul");
		JB_saveRegistrtation_ANR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrationNumberValadation(JTF_registrationNumber_ANR.getText());
			}
		});
		JP_regNR_ANR.add(JB_saveRegistrtation_ANR, "cell 3 0,alignx left,aligny center");
		JB_saveRegistrtation_ANR.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel JP_regDate_ANR = new JPanel();
		JP_regMain_ANR.add(JP_regDate_ANR, BorderLayout.SOUTH);
		JP_regDate_ANR.setLayout(new MigLayout("", "[260px][400px]", "[39px]"));
		
		JLabel JL_registrationDate_ANR = new JLabel("Registration Date:");
		JP_regDate_ANR.add(JL_registrationDate_ANR, "cell 0 0,alignx left,aligny top");
		JL_registrationDate_ANR.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JDC_registrationNumber_ANR = new JDateChooser();
		JP_regDate_ANR.add(JDC_registrationNumber_ANR, "cell 1 0,growx,aligny center");
		JDC_registrationNumber_ANR.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel JP_registrationDetails_ANR = new JPanel();
		JP_west_ANR.add(JP_registrationDetails_ANR, BorderLayout.CENTER);
		JP_registrationDetails_ANR.setLayout(new MigLayout("", "[][][][][]", "[][][][][]"));
		
		JLabel SMC_client_ANR = new JLabel("");
		SMC_client_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/natural_person_128.png")));
		JP_registrationDetails_ANR.add(SMC_client_ANR, "cell 0 0");
		
		JL_selectClient_ANR = new JLabel("Selectati client");
		JL_selectClient_ANR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_selectClient_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JP_registrationDetails_ANR.add(JL_selectClient_ANR, "cell 1 0,growx");
		
		SC_addClient_ANR = new JLabel("");
		SC_addClient_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_addClient_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				itemSelectionHelper(panelANR, panelCL);
				
				SetDefaultTable(JT_clients_CL, new String[]{"Client", "Numele clientului", "Numarul de telefon", "Firm?"});				
				LoadClients();
			}
		});
		SC_addClient_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_new_64.png")));
		JP_registrationDetails_ANR.add(SC_addClient_ANR, "cell 2 0");
		
		SC_editClient_ANR = new JLabel("");
		SC_editClient_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_editClient_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				itemSelectionHelper(panelANR, panelCL);
				
				SetDefaultTable(JT_clients_CL, new String[]{"Client", "Numele clientului", "Numarul de telefon", "Firm?"});				
				LoadClients();
			}
		});
		SC_editClient_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/edit_64.png")));
		SC_editClient_ANR.setEnabled(false);
		JP_registrationDetails_ANR.add(SC_editClient_ANR, "cell 3 0");
		
		SC_infoClient_ANR = new JLabel("");
		SC_infoClient_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_infoClient_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/info_64.png")));
		SC_infoClient_ANR.setEnabled(false);
		JP_registrationDetails_ANR.add(SC_infoClient_ANR, "cell 4 0");
		
		JLabel SMC_car_ANR = new JLabel("");
		SMC_car_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/car_128.png")));
		JP_registrationDetails_ANR.add(SMC_car_ANR, "cell 0 1");
		
		JL_selectCar_ANR = new JLabel("Selectati masina");
		JL_selectCar_ANR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_selectCar_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JP_registrationDetails_ANR.add(JL_selectCar_ANR, "cell 1 1,growx");
		
		SC_addCar_ANR = new JLabel("");
		SC_addCar_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_addCar_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelSelectionHelper(panelANR, panelSC);
				
				SetDefaultTable(JT_prevCars_AA, new String[]{"Car", "Brand", "Model", "NR de inmatruculare", "Serie sasiu"});
				loadPreviousCars();
			}
		});
		SC_addCar_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_new_64.png")));
		JP_registrationDetails_ANR.add(SC_addCar_ANR, "cell 2 1");
		
		SC_editCar_ANR = new JLabel("");
		SC_editCar_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_editCar_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/edit_64.png")));
		SC_editCar_ANR.setEnabled(false);
		JP_registrationDetails_ANR.add(SC_editCar_ANR, "cell 3 1");
		
		SC_infoCar_ANR = new JLabel("");
		SC_infoCar_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_infoCar_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/info_64.png")));
		SC_infoCar_ANR.setEnabled(false);
		JP_registrationDetails_ANR.add(SC_infoCar_ANR, "cell 4 1");
		
		JLabel SMC_piece_ANR = new JLabel("");
		SMC_piece_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/inventory_128.png")));
		JP_registrationDetails_ANR.add(SMC_piece_ANR, "cell 0 2");
		
		JL_selectPiece_ANR = new JLabel("Selectati piesele din stoc");
		JL_selectPiece_ANR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_selectPiece_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JP_registrationDetails_ANR.add(JL_selectPiece_ANR, "cell 1 2,growx");
		
		SC_addPiece_ANR = new JLabel("");
		SC_addPiece_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_addPiece_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelANR, panelSII);
				
				SetDefaultTable(JT_inventory_SII, new String[]{"Piece ID","Numele piesei", "Pret final", "Quantity"});
			}
		});
		SC_addPiece_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_new_64.png")));
		JP_registrationDetails_ANR.add(SC_addPiece_ANR, "cell 2 2");
		
		SC_editPiece_ANR = new JLabel("");
		SC_editPiece_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_editPiece_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelANR, panelSII);
				
				SetDefaultTable(JT_inventory_SII, new String[]{"Inventory item", "Piece ID","Numele piesei", "Pret final", "Quantity"});
				loadRegistrationInventory(selectedRegistration.getId());
			}
		});
		SC_editPiece_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/edit_64.png")));
		SC_editPiece_ANR.setEnabled(false);
		JP_registrationDetails_ANR.add(SC_editPiece_ANR, "cell 3 2");
		
		SC_infoPiece_ANR = new JLabel("");
		SC_infoPiece_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_infoPiece_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SetDefaultTable(JT_info_ANR, new String[]{"Piece ID", "Pret final", "Quantity"});
				loadRegistrationInfo(selectedRegistration.getId(), "Registrations_inventory");
			}
		});
		SC_infoPiece_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/info_64.png")));
		SC_infoPiece_ANR.setEnabled(false);
		JP_registrationDetails_ANR.add(SC_infoPiece_ANR, "cell 4 2");
		
		JLabel SMC_job_ANR = new JLabel("");
		SMC_job_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/job0_128.png")));
		JP_registrationDetails_ANR.add(SMC_job_ANR, "cell 0 3");
		
		JL_selectJob_ANR = new JLabel("Selectati joburi");
		JL_selectJob_ANR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_selectJob_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JP_registrationDetails_ANR.add(JL_selectJob_ANR, "cell 1 3,growx");
		
		SC_addJob_ANR = new JLabel("");
		SC_addJob_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_addJob_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelANR, panelSJ);
				
				SetDefaultTable(JT_jobs_SJ, new String[]{"Numele jobului", "Tarif final"});
			}
		});
		SC_addJob_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_new_64.png")));
		JP_registrationDetails_ANR.add(SC_addJob_ANR, "cell 2 3");
		
		SC_editJob_ANR = new JLabel("");
		SC_editJob_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_editJob_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSelectionHelper(panelANR, panelSJ);
				
				SetDefaultTable(JT_jobs_SJ, new String[]{"Job", "Numele jobului", "Tarif final"});
				loadRegistrationJob(selectedRegistration.getId());
			}
		});
		SC_editJob_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/edit_64.png")));
		SC_editJob_ANR.setEnabled(false);
		JP_registrationDetails_ANR.add(SC_editJob_ANR, "cell 3 3");
		
		SC_infoJob_ANR = new JLabel("");
		SC_infoJob_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_infoJob_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetDefaultTable(JT_info_ANR, new String[]{"Numele jobului", "Tarif final",});
				loadRegistrationInfo(selectedRegistration.getId(), "Registration_job");
			}
		});
		SC_infoJob_ANR.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/info_64.png")));
		SC_infoJob_ANR.setEnabled(false);
		JP_registrationDetails_ANR.add(SC_infoJob_ANR, "cell 4 3");
		
		JPanel JP_east_ANR = new JPanel();
		panelANR.add(JP_east_ANR, BorderLayout.EAST);
		JP_east_ANR.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_infoHeader_ANR = new JPanel();
		JP_east_ANR.add(JP_infoHeader_ANR, BorderLayout.NORTH);
		
		JLabel JL_infoHeader_ANR = new JLabel("Informatie rapida");
		JL_infoHeader_ANR.setFont(new Font("Tahoma", Font.BOLD, 26));
		JP_infoHeader_ANR.add(JL_infoHeader_ANR);
		
		JScrollPane JSP_info_ANR = new JScrollPane();
		JP_east_ANR.add(JSP_info_ANR, BorderLayout.CENTER);
		
		JT_info_ANR = new JTable();
		JSP_info_ANR.setViewportView(JT_info_ANR);
		
		JPanel JP_south_ANR = new JPanel();
		panelANR.add(JP_south_ANR, BorderLayout.SOUTH);
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.WHITE);
		frmServiceManagerSoftware.getContentPane().add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(Color.WHITE);
		northPanel.add(navigationPanel, BorderLayout.WEST);
		navigationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		back = new JLabel("");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setVisible(false);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelAbandationHelper(panels.pop(), panels.peek(), true);
			}
		});
		back.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/return_32.png")));
		navigationPanel.add(back);
		
		home = new JLabel("");
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/home1_32.png")));
		navigationPanel.add(home);
		
		JPanel activeActionPanelNamePanel = new JPanel();
		activeActionPanelNamePanel.setBackground(Color.WHITE);
		northPanel.add(activeActionPanelNamePanel, BorderLayout.CENTER);
		
		JLabel panelTitle = new JLabel("Dashboard");
		panelTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		activeActionPanelNamePanel.add(panelTitle);
		
		JPanel userActionsPanel = new JPanel();
		userActionsPanel.setBackground(Color.WHITE);
		northPanel.add(userActionsPanel, BorderLayout.EAST);
		userActionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		userActionsPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(ServiceFrame.class.getResource("/images/add_32.png")));
		userActionsPanel.add(lblNewLabel_11);
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.WHITE);
		frmServiceManagerSoftware.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("Trimfa Egon");
		southPanel.add(lblNewLabel_3);
	}

	
	//APPLICATION METHODS
	//Panel navigation, component state modifiers, component validators, modals, others
	
	//Navigates to new panel
	private void panelSelectionHelper(JPanel from, JPanel to) {
		//panel change on input
		from.setVisible(false);
		to.setVisible(true);
		
		//add panel to stack
		panels.push(to);
		
		//If we are on the Dashboard, the back arrow shouldnt be visible
		if(panels.size()<2) {
			back.setVisible(false);
		}else {
			back.setVisible(true);
		}
	}
	//Navigates to the previous panel
	private void panelAbandationHelper(JPanel from, JPanel to, Boolean checkForUnsaved) {
		if(checkForUnsaved && unsavedFieldHelper(from)) {
			if(backDialog()) {
				//panel change on input
				from.setVisible(false);
				to.setVisible(true);
					
				//If we are on the Dashboard, the back arrow shouldnt be visible
				if(panels.size()<2) {
					back.setVisible(false);
				}else {
					back.setVisible(true);
				}
				
				panelStateChangeHelper(from, "all", "primary");	
			}else {
				panels.add(from);
			}
		}else {
			//panel change on input
			from.setVisible(false);
			to.setVisible(true);
			
			//If we are on the Dashboard, the back arrow shouldnt be visible
			if(panels.size()<2) {
				back.setVisible(false);
			}else {
				back.setVisible(true);
			}
			
			panelStateChangeHelper(from, "all", "primary");	
		}
	}
	//Navigates to a given panel to select an item from there
	private void itemSelectionHelper(JPanel from, JPanel to) {
		from.setVisible(false);
		to.setVisible(true);
		
		panels.push(to);
		currentPanel = to;
		
		panelStateChangeHelper(to, "primary", "secondary");
	}
	//Sets every components state to desired
	private void panelStateChangeHelper(Container container, String fieldmode, String buttonmode) {
		for (Component component : container.getComponents()) {
			if(component instanceof JPanel) panelStateChangeHelper((Container)component, fieldmode, buttonmode);
			if(fieldmode!=null) {
	            if (component instanceof JTextField) {
	            	JTextField textfield = (JTextField) component;
	            	Border border = new JTextField().getBorder();
	            	
	            	try {
	            		if(fieldmode.equals("all")) {
		                	textfield.setText(null);
		                	textfield.setBorder(border);
	            		}
	            		if(textfield.getName()!=null && !textfield.getName().isEmpty()){
	            			String name = textfield.getName();
	            			
		            		if(fieldmode.equals("primary") || fieldmode.equals("all")) {
		                		if(name.equals("primary")) {
		                			textfield.setVisible(true);
		                		}else if(name.equals("secondary")) {
		                			textfield.setVisible(false);
		                		}
		            		}else if(fieldmode.equals("secondary")) {
		                		if(name.equals("primary")) {
		                			textfield.setVisible(false);
		                		}else if(name.equals("secondary")) {
		                			textfield.setVisible(true);
		                		}
		            		}
		            			
		            		//JTextField specific fieldmode, specific field vale remains as it is
	                		if(!name.equals("permanent")) {
	    		                textfield.setText(null);
	    		                textfield.setBorder(border);
	                		}
	            		}
	            	}catch(Exception ex) {
	            		System.out.println(ex.toString());
	            	}
	            }
	            if (component instanceof JLabel) {
	            	JLabel label = (JLabel) component;
	            	
	            	try {
	            		if(label.getName()!=null && !label.getName().isEmpty()) {
	                		if(fieldmode.equals("primary") || fieldmode.equals("all")) {
	                			if(label.getName().equals("primary")) {
	                				label.setVisible(true);
	                			}else if(label.getName().equals("secondary")) {
	                				label.setVisible(false);
	                			}
	                		}else if(fieldmode.equals("secondary")) {
	                			if(label.getName().equals("primary")) {
	                				label.setVisible(false);
	                			}else if(label.getName().equals("secondary")) {
	                				label.setVisible(true);
	                			}
	                		}
	                	}
	            	}catch(Exception ex) {
	            		System.out.println(ex.toString());
	            	}
	            }
			}
			if(buttonmode!=null) {
	            if (component instanceof JButton) {
	            	JButton button = (JButton) component;
	            	button.setEnabled(false);
	            	
	            	try {            		
	                	if(button.getName()!=null && !button.getName().isEmpty()) {
	                		if(buttonmode.equals("primary")) {
	                			if(button.getName().equals("primary")) {
	                				button.setVisible(true);
	                			}else if(button.getName().equals("secondary")) {
	                				button.setVisible(false);
	                			}
	                		}else if(buttonmode.equals("secondary")) {
	                			if(button.getName().equals("primary")) {
	                				button.setVisible(false);
	                			}else if(button.getName().equals("secondary")) {
	                				button.setVisible(true);
	                			}
	                		//selected, sets button enable status to true
	                		}else if(buttonmode.equals("selected")) {
		                    	button.setEnabled(true);
		                	//unselected, sets button enable status to false
	                		}else if(buttonmode.equals("unselected")) {
		                    	button.setEnabled(false);
	                		}
	                	}else {
	                		button.setEnabled(true);
	                	}
	            	}catch(Exception ex) {
	            		System.out.println(ex.toString());
	            	}
	            }
			}
        }
	}
	//Checks if there is any unsaved textfields on the given panel
	private Boolean unsavedFieldHelper(Container container) {
		for (Component component : container.getComponents()) {
			//if component:JPanel=> Boolean unsaved = unsavedFieldHelper(container); return unsaved;
			if(component instanceof JTextField) {
				if(!((JTextField) component).getText().isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}
	//Resets the table to my preferred default state
	private void SetDefaultTable(JTable table, String[] cols) {
			table.setRowSorter(null);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 21));
			table.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			DefaultTableModel dtm = new DefaultTableModel(cols, 0);
			table.setModel(dtm);
	}
	//Sets textfield border to the system default
	private void textfieldBorderResetter(JTextField textfield) {
		Border border = new JTextField().getBorder();
		
		if(textfield.getBorder()!=border) {
			textfield.setBorder(border);
		}
	}
	//Notifies the user that there are unsaved data
	private void unsavedInformer() {
		JOptionPane.showMessageDialog(null, "Unele câmpuri nu sunt completate corect.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	//Notifies the user that there are missing data
	private void MissingStatementInformer(String statement) {
		JOptionPane.showMessageDialog(null, statement, "Warning", JOptionPane.WARNING_MESSAGE);
	}
	//Returns true if all fields cointains any value
	private Boolean emptyFieldValidation(List<JTextField> jtf_list) {
		int invalids = 0;
		for(JTextField jtf: jtf_list) {
			if(jtf.getText().isEmpty()) {
				Border border = BorderFactory.createLineBorder(Color.RED, 2);
				jtf.setBorder(border);
				
				invalids++;
			}
		}
		if(invalids>0) {
			return false;
		}
		return true;
	}
	//Returns true if all fields are numeric(Float) values
	private Boolean numberFormatValidation(List<JTextField> jtf_list) {
		int invalids = 0;
		for(JTextField jtf: jtf_list) {
			try {
				Float.valueOf(jtf.getText());
			}catch(Exception ex) {			
				Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
				jtf.setBorder(border);
				
				invalids++;				
			}
		}
		if(invalids>0) {
			return false;
		}
		return true;
	}
	//Returns true if all date field are contains correct value
	private Boolean dateFormatValidation(List<JDateChooser> jdc_list) {
		int invalids = 0;
	    
		for(JDateChooser jdc: jdc_list) {
			if(jdc.getDate()==null) {
				invalids++;
			}
		}
		
		if(invalids>0) {
			return false;
		}
		return true;
	}
	//Returns true if all user creation credintials are valid --temporaly
	private Boolean UserRegistrtationValidation(JTextField uname, JPasswordField upwd, JPasswordField upwdre) {
		int invalids = 0;
		char[] pwd = upwd.getPassword();
		char[] pwdRE = upwdre.getPassword();
		
		if(uname.getText().isEmpty()) {
			Border border = BorderFactory.createLineBorder(Color.RED, 2);
			uname.setBorder(border);
			
			invalids++;
		}
		
		if(pwd.length<6) {
			Border border = BorderFactory.createLineBorder(Color.RED, 2);
			upwd.setBorder(border);
			
			invalids++;
		}
		if(pwdRE.length<6) {
			Border border = BorderFactory.createLineBorder(Color.RED, 2);
			upwdre.setBorder(border);
			
			invalids++;
		}
		if(!Arrays.equals(pwd, pwdRE)) {
			Border border = BorderFactory.createLineBorder(Color.RED, 2);
			upwd.setBorder(border);
			upwdre.setBorder(border);
			
			invalids++;
		}
		
		if(invalids>0) {
			return false;
		}
		return true;
	}
	//Delete confirmation dialog
 	private Boolean DeleteConfirmation() {
		int i = JOptionPane.showConfirmDialog(null, "Sigur doriți să ștergeți?",  "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(i == JOptionPane.YES_OPTION) {
			return true;
		}
		
		return false;
	}
 	//Panel abandation dialog
 	private Boolean backDialog() {
		int i = JOptionPane.showConfirmDialog(null, "Ești sigur că vrei să faci un pas înapoi? Datele dvs. nesalvate vor fi pierdute.",  "Back", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(i == JOptionPane.YES_OPTION) {
			return true;
		}else {
			return false;
		}
	}
 	//Exit confirmation dialog
	private void exitDialog() {
		int i = JOptionPane.showConfirmDialog(null, "Ești sigur că vrei să renunți?",  "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if(i == JOptionPane.OK_OPTION) {
		    //Closing the session
			session.close();
			System.exit(0);
		}
	}
	//Combined(multi) fields based table filter
	private void comboFilter(JTable table, String text[], int idxs[]) {	
	    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel()); //Optimalization needed
	    List<RowFilter<TableModel, Integer>> filters = new ArrayList<RowFilter<TableModel, Integer>>(idxs.length);
	    
	    try {
		    if (text != null && text.length > 0) {
		        for (int i = 0; i < idxs.length; i++) {
		            if (text[i] != null && text[i].length() > 0) {
		                RowFilter<TableModel, Integer> filter = RowFilter.regexFilter("(?i)" + text[i], idxs[i]);
		                filters.add(filter);
		            }
		        }
		        RowFilter<TableModel, Integer> filter = RowFilter.andFilter(filters);
            	System.out.println("Filter: " + filter.toString());
		        sorter.setRowFilter(filter);
		    } else {
		        sorter.setRowFilter(null);
		    }

		    table.setRowSorter(sorter);
	    }catch(Exception e) {
	    	System.out.println(e.toString());
	    }
	}
	//One field base tabled filter
	private void simpleFilter(JTable table, String querry) {
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(table.getModel());
		
		table.setRowSorter(rowSorter);
		
		rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + querry));
	}
	//Date filter --temporaly
	private void dateFilter(JTable table, String querry, int column) {
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(table.getModel());
		
		table.setRowSorter(rowSorter);
		
		rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + querry, column));
	}
	
	//Hibernate CRUD
	private void LoadClients() {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			List<Client> clients= (List<Client>)session.createQuery("from Client").list();
			
			DefaultTableModel dtm = (DefaultTableModel) JT_clients_CL.getModel();
			
			for(Client c:clients) 
			{
			    Object[] row= {c ,c.getContactname(), c.getContactphone(), String.valueOf(c.getIscompany())};
			    dtm.addRow( row );
			}

			JT_clients_CL.setModel(dtm);
			JT_clients_CL.removeColumn(JT_clients_CL.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void LoadPieces() {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			List<Auto_pieces> pieces = (List<Auto_pieces>) session.createQuery("from Auto_pieces").list();

			DefaultTableModel dtm = (DefaultTableModel) JT_pieces_APL.getModel();

			for (Auto_pieces a : pieces) {
				Object[] row = { a, a.getId(), a.getAutopiecename(), a.getAutopieceunitename() };
				dtm.addRow(row);
			}

			JT_pieces_APL.setModel(dtm);
			JT_pieces_APL.removeColumn(JT_pieces_APL.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
		
	private void LoadJobs() {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			List<Job> jobs= (List<Job>)session.createQuery("from Job").list();
			
			DefaultTableModel dtm = (DefaultTableModel) JT_jobs_JL.getModel();
			
			for(Job j:jobs) 
			{
			    Object[] row= {j , j.getJobname(), j.getJobprice()};
			    dtm.addRow( row );
			}

			JT_jobs_JL.setModel(dtm);
			JT_jobs_JL.removeColumn(JT_jobs_JL.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void LoadReplacables(String pieceid) {
		try {		
			//Begin transaction
			session.beginTransaction();

			DefaultTableModel dtm = (DefaultTableModel) JT_pieces_AR.getModel();
			dtm.setRowCount(0);
			
			Query<Auto_pieces> querry;
			querry = session.createQuery("from Auto_pieces where id=:id");
			querry.setParameter("id", pieceid);
			
			Auto_pieces selectedPiece = (Auto_pieces) querry.uniqueResult();
			selectedAutoPiece = selectedPiece;
			System.out.println(selectedPiece.toString());
			
			if(selectedPiece==null) System.out.println("No result.");
			Auto_pieces replacablePiece;
			
			for (Replaced rep : selectedPiece.getReplaceables()) 
			{
				querry = session.createQuery("from Auto_pieces where id=:id");
				querry.setParameter("id", rep.getAutopiecesidto());
				
				replacablePiece = (Auto_pieces) querry.uniqueResult();
				
				Object[] row = { replacablePiece, replacablePiece.getId(), replacablePiece.getAutopiecename(), replacablePiece.getAutopieceunitename() };
				System.out.println(replacablePiece.toString());
				dtm.addRow(row);
			}
			
			JT_pieces_AR.setModel(dtm);
			JT_pieces_AR.removeColumn(JT_pieces_AR.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private void LoadRoles(JComboBox comboBox) {
		try {
			//Set Combobox parameters
			comboBox.setMaximumRowCount(5);
			
			//Begin transaction
			session.beginTransaction();
		    
			List<Role> roles= (List<Role>)session.createQuery("from Role").list();
			
			for(Role r:roles) {
				comboBox.addItem(r);
			}
			
			/*
			//Removes the additional items -- deprecated
			if(JCB_userRole_ANU.getItemCount()>roles.size()) {
				int comboCount = JCB_userRole_ANU.getItemCount();
				int rolesCount = roles.size();
				for(int i=roles.size(); i<comboCount; i++) {
					JCB_userRole_ANU.removeItemAt(rolesCount);
				}
			}*/
			      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void LoadUsers() {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			List<User> users= (List<User>)session.createQuery("from User").list();
			
			DefaultTableModel dtm = (DefaultTableModel) JT_users_UL.getModel();
			
			for(User u:users) 
			{
			    Object[] row= {u , u.getUsername(), u.getRoles().getRolename()};
			    dtm.addRow( row );
			}

			JT_users_UL.setModel(dtm);
			JT_users_UL.removeColumn(JT_users_UL.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void loadInventory() {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			List<Inventory> inventory= (List<Inventory>)session.createQuery("from Inventory").list();
			
			DefaultTableModel dtm = (DefaultTableModel) JT_inventory_IM.getModel();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate;
			
			for(Inventory i:inventory) 
			{
				try {
					formattedDate = sdf.format(i.getDatein());
				}catch(Exception ex){
					formattedDate = null;
				}
				
			    Object[] row= {i, i.getAuto_pieces().getId(), i.getClients().getContactname(), i.getQuantity(), i.getUnitepricein(),
			    		i.getUnitepriceout(), formattedDate};
			    dtm.addRow( row );
			}

			JT_inventory_IM.setModel(dtm);
			JT_inventory_IM.removeColumn(JT_inventory_IM.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void loadReception() {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			List<Reception> receptions= (List<Reception>)session.createQuery("from Reception").list();
			//System.out.println(receptions.toString());
			
			DefaultTableModel dtm = (DefaultTableModel) JT_supplies_SL.getModel();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDateIN;
			String formattedDueDate;
			
			for(Reception r:receptions) 
			{
				try {
					formattedDateIN = sdf.format(r.getDatein());
					formattedDueDate = sdf.format(r.getDuedate());
				}catch(Exception ex){
					formattedDateIN = null;
					formattedDueDate = null;
				}
				
			    Object[] row= {r, r.getClients().getContactname(), r.getIncominginvoicenr(), formattedDateIN, formattedDueDate};
			    dtm.addRow( row );
			}

			JT_supplies_SL.setModel(dtm);
			JT_supplies_SL.removeColumn(JT_supplies_SL.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	private void loadReceptionAutoPieces(int id) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			List<Receptions_auto_pieces> raps= (List<Receptions_auto_pieces>)session
					.createQuery("from Receptions_auto_pieces where receptionsid=:id")
					.setParameter("id", id)
					.list();
			
			DefaultTableModel dtm = (DefaultTableModel) JT_rapl_RAPL.getModel();
			
			for(Receptions_auto_pieces r:raps) 
			{
			    Object[] row= {r, r.getAutopiecesid(), r.getQuantity(), r.getQuantity(), r.getUnitepricein(), r.getUnitepriceout(), r.getVatitem()};
			    dtm.addRow( row );
			}

			JT_rapl_RAPL.setModel(dtm);
			JT_rapl_RAPL.removeColumn(JT_rapl_RAPL.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void loadPreviousCars() {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			Car car = null;
			
			List<Registration> registrations = new ArrayList<Registration>();
			registrations.addAll(selectedClient.getRegistrations());
			
			DefaultTableModel dtm = (DefaultTableModel) JT_prevCars_AA.getModel();
			
			for(Registration r:registrations) 
			{
				car = r.getCars();
				
			    Object[] row= {car, car.getBrand() , car.getModel(), car.getLicenseNumber(), car.getChassisnr()};
			    dtm.addRow( row );
			}

			JT_prevCars_AA.setModel(dtm);
			JT_prevCars_AA.removeColumn(JT_prevCars_AA.getColumnModel().getColumn(0));
			
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void loadRegistrationInventory(int registrationsid) {
		try {
			//Begin transaction
			session.beginTransaction();
			
			List<Registrations_inventory> registrations_inventory= (List<Registrations_inventory>)session
					.createQuery("from Registrations_inventory where registrationsid=:registrationsid")
					.setParameter("registrationsid", registrationsid)
					.list();
			
			DefaultTableModel dtm = (DefaultTableModel) JT_inventory_SII.getModel();
			
			for(Registrations_inventory ri:registrations_inventory) 
			{
			    Object[] row= {ri, ri.getInventory().getAutopiecesid() , ri.getInventory().getAuto_pieces().getAutopiecename(), ri.getNewuniteprice(), ri.getQuantity()};
			    dtm.addRow( row );
			}
			JT_inventory_SII.setModel(dtm);
			JT_inventory_SII.removeColumn(JT_inventory_SII.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void loadRegistrationJob(int registrationsid) {
		System.out.println(registrationsid);
		try {
			//Begin transaction
			session.beginTransaction();
			
			List<Registration_job> registration_job= (List<Registration_job>)session
					.createQuery("from Registration_job where registrationsid=:registrationsid")
					.setParameter("registrationsid", registrationsid)
					.list();
			
			DefaultTableModel dtm = (DefaultTableModel) JT_jobs_SJ.getModel();
			
			for(Registration_job rj:registration_job) 
			{
			    Object[] row= {rj, rj.getJobs().getJobname(), rj.getNewjobprice()};
			    dtm.addRow( row );
			}
			JT_jobs_SJ.setModel(dtm);
			JT_jobs_SJ.removeColumn(JT_jobs_SJ.getColumnModel().getColumn(0));
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void loadRegistrationInfo(int registrationsid, String entityname) {
		try {
			//Begin transaction
			session.beginTransaction();
			
			DefaultTableModel dtm = (DefaultTableModel) JT_info_ANR.getModel();
			
			//NEEDS IMPROVEMENTS
			if(entityname.equals("Registrations_inventory")) {
				List<Registrations_inventory> registrations_inventory= (List<Registrations_inventory>)session
						.createQuery("from Registrations_inventory where registrationsid=:registrationsid")
						.setParameter("registrationsid", registrationsid)
						.list();
				
				for(Registrations_inventory ri:registrations_inventory) 
				{
				    Object[] row= {ri.getInventory().getAutopiecesid() , ri.getNewuniteprice(), ri.getQuantity()};
				    dtm.addRow( row );
				}
			}else if(entityname.equals("Registration_job")) {
				List<Registration_job> registration_job= (List<Registration_job>)session
						.createQuery("from Registration_job where registrationsid=:registrationsid")
						.setParameter("registrationsid", registrationsid)
						.list();
				
				for(Registration_job rj:registration_job) 
				{
				    Object[] row= {rj.getJobs().getJobname() , rj.getNewjobprice()};
				    dtm.addRow( row );
				}
			}else {
				System.out.println("Unknown entity name: " + entityname);
			}
			JT_info_ANR.setModel(dtm);
			
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void saveClient(Boolean isCompany, String clientName,String clientPhone,String companyName,String companyPhone,String companyAdress,String companyCIF,String companyRegNR,String companyBank,String companyIBAN, String companyOffice) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
		    //Create new Client object
		    Client newClient = new Client(clientName, clientPhone, isCompany);
		    
		    //Save Client
		    session.save(newClient);
		    
		    //Save company data if condition
		    if(isCompany) {
				//Create new Company object
				Company newCompany = new Company(newClient.getId(), companyPhone, companyName, companyAdress, companyCIF,companyRegNR, companyBank, companyIBAN, companyOffice);
			    
			    //Save Company
			    newCompany.setClients(newClient);
			    session.save(newCompany);
		    }
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void SaveAutoPiece(String autoPieceID, String autoPieceName, String autoPieceUniteName) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
		    //Create new Client object
		    Auto_pieces auto_piece = new Auto_pieces(autoPieceID, autoPieceName, autoPieceUniteName);
		    
		    //Save Client
		    session.save(auto_piece);
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void SaveJob(String jobName, Float jobPrice) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
		    //Create new Client object
		    Job job = new Job(jobName, jobPrice);
		    
		    //Save Client
		    session.save(job);
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void SaveReception(String incomingInvoiceNR, Date dateIN, Date dueDate) {
		try {
			//Begin transaction
			session.beginTransaction();
			
			Reception reception = null;
			
		    //Create new Reception object
			reception = new Reception(selectedClient.getId(), incomingInvoiceNR, dateIN, dueDate);	    
			    
			//Save Reception
			session.save(reception);
			
		    //Committing the transaction
		    session.getTransaction().commit();
		    
			//Reopen the session factory, needed for releasing the cash, further research is required
			session.close();
			session = HibernateUtil.getSessionFactory().openSession();
		    
		    SaveReceptionAutoPiece(reception.getId());
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void SaveReceptionAutoPiece(int receptionID) {
		try {
	    //Begin transaction
	    session.beginTransaction();
	    
		Receptions_auto_pieces receptions_auto_pieces = null;  

		TableModel model = JT_pieces_ANS.getModel();
		for(int i=0; i<model.getRowCount(); i++) {	    	
			receptions_auto_pieces = new Receptions_auto_pieces(receptionID, model.getValueAt(i, 0).toString(), 
		    Float.valueOf(model.getValueAt(i, 3).toString()),
		    Float.valueOf(model.getValueAt(i, 4).toString()),
		    Float.valueOf(model.getValueAt(i, 5).toString()),
		    Float.valueOf(model.getValueAt(i, 6).toString()));
		    	
			//Save Receptions_auto_pieces
			session.save(receptions_auto_pieces);		    	
		}
	    session.getTransaction().commit();
	    
		//Reopen the session factory, needed for releasing the cash, further research is required
		session.close();
		session = HibernateUtil.getSessionFactory().openSession();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void SaveUser(int userRole, String userName, String userPassword) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
		    //Create new Client object
		    User newUser = new User(userRole, userName, userPassword);
		    
		    //Save Client
		    session.save(newUser);
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void saveCar(String licenseNumber, String brand, String model, String chassisNR, String engineNR, Integer miloMeter) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
		    //Create new Client object
		    Car car = new Car(licenseNumber, brand, model, chassisNR, engineNR, miloMeter);
		    
		    //Save Client
		    session.save(car);
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    selectedCar = car;
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void saveRegistration(String registrationNR, Date registrationDate) {	
		try {
			//Begin transaction
			session.beginTransaction();
			
		    //Create new Registration object
			Registration registration = new Registration(registrationNR, registrationDate);
			
		    //Store the registration
		    selectedRegistration = registration;
			    
			//Save Registration
			session.save(registration);
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}

	private void saveRegistrationInventory(Float newUnitPprice, Float quantity) {		
		try {
			//Begin transaction
			session.beginTransaction();
		
			//Create new Registration Inventory object
			Registrations_inventory registrations_inventory = new Registrations_inventory(selectedRegistration.getId(), selectedInventoryItem.getId(), newUnitPprice, quantity);
			
			//Save Registration Inventory
			session.save(registrations_inventory);
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
	    //Committing the transaction
	    session.getTransaction().commit();
	    
		//Reopen the session factory, needed for releasing the cash, further research is required
		session.close();
		session = HibernateUtil.getSessionFactory().openSession();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}

	private void saveRegistrationJob(Float newjobprice) {
		try {
			//Begin transaction
			session.beginTransaction();
		
			//Create new Registration Job(Job registration) object
			Registration_job registration_job = new Registration_job(selectedJob.getId(), selectedRegistration.getId(), newjobprice);

			//Save Registration Inventory
			session.save(registration_job);		
			
		    //Committing the transaction
		    session.getTransaction().commit();
		    
			//Reopen the session factory, needed for releasing the cash, further research is required
			session.close();
			session = HibernateUtil.getSessionFactory().openSession();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	private void AddNewAutoPieceToReplaced(String from, String to) {	
		try {
			//Begin transaction
			session.beginTransaction();
			
			//Validate from and to pieces, if they exist or not
			Query<Auto_pieces> querry;
			
			querry = session.createQuery("from Auto_pieces where id=:id");
			querry.setParameter("id", from);
			
			Auto_pieces selectedPiece = (Auto_pieces) querry.uniqueResult();
			
			querry = session.createQuery("from Auto_pieces where id=:id");
			querry.setParameter("id", to);
			
			Auto_pieces replacablePiece = (Auto_pieces) querry.uniqueResult();
			
			if(selectedPiece!=null && replacablePiece!=null) {
			    //Create new Replaced object
				Replaced replaced = new Replaced(from, to);
				session.save(replaced);
				
			    //Committing the first transaction
			    session.getTransaction().commit();
			    
				//Open new transaction
				session.beginTransaction();
				
				//Calling the replaced_insert2 SP
				Query query = session.createSQLQuery("call replaced_insert2(:from,:to)")
						.setParameter("from", from)
						.setParameter("to", to);
				
				query.executeUpdate();
				
			    //Committing the second transaction
			    session.getTransaction().commit();
			    
				//Reopen the session factory, needed for releasing the cash, further research is required
				session.close();
				session = HibernateUtil.getSessionFactory().openSession();			
			    
			    //Shotting down the session factory
			    //HibernateUtil.shutDown();
			}else {
				System.out.println("Pieces are not provided or not exists.");
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

	private void AddNewAutoPieceToReception(String quantity, String priceIN, String priceOUT, String priceVAT) {
		DefaultTableModel dtm = (DefaultTableModel) JT_pieces_ANS.getModel();
		
		dtm.insertRow(dtm.getRowCount(), new Object[] { selectedAutoPiece.getId(), selectedAutoPiece.getAutopiecename(), selectedAutoPiece.getAutopieceunitename(),
				quantity, priceIN, priceOUT, priceVAT});
	}

	private Boolean getAutoPieceByID(String id) {
		Boolean exists;
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Auto_pieces> querry = session.createQuery("from Auto_pieces where id=:id");
			querry.setParameter("id", id);
			Auto_pieces autoPiece = (Auto_pieces) querry.uniqueResult();
			
		    if(autoPiece!=null){
		    	selectedAutoPiece = autoPiece;
		    	exists = true;
		    }else {
		    	exists = false;
		    }
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			exists = false;
		}
		return exists;
	}

	private Boolean getClientByName(String clientName) {
		boolean exist;
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Client> querry = session.createQuery("from Client where contactname=:contactname and iscompany = true ");
			querry.setParameter("contactname", clientName);
			
			Client client = querry.uniqueResult();
			
			if(client!=null) {
				selectedClient = client;
				exist = true;
			}else {
				exist = false;
			}		
			
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			exist = false;
		}
		return exist;
	}

	private Boolean getInventoryItemByAutoPieceID(String name) {
		Boolean exists;
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Inventory> querry = session.createQuery("from Inventory where autopiecesid=:autopiecesid and quantity>0 order by datein desc");
			querry.setParameter("autopiecesid", name);
			querry.setFirstResult(0);
			querry.setMaxResults(1);
			
			Inventory inventoryItem = querry.uniqueResult();
			
			if(inventoryItem!=null) {
				selectedInventoryItem = inventoryItem;
				exists = true;
			}else {
				//no result
				exists = false;
			}
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			//not unique result (or other exception)
			System.out.println(ex.toString());
			exists = false;
		}
		return exists;
	}

	private Boolean getJobByName(String name) {
		Boolean exists;
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Job> querry = session.createQuery("from Job where jobname=:jobname ");
			querry.setParameter("jobname", name);
			
			Job job = querry.uniqueResult();
			
			if(job!=null) {
				selectedJob = job;
				exists = true;
			}else {
				//no result
				exists = false;
			}
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    return exists;
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return false;
		}
	}

	//Finalizate Registration Inventory
	private Integer finalizateRegistrationInventory(int registrationID){
		int count = 0;
		try {			
			//Begin transaction
			session.beginTransaction();
		    
			List<Registrations_inventory> registrations_inventory= (List<Registrations_inventory>)session
					.createQuery("from Registrations_inventory where registrationsid=:registrationsid")
					.setParameter("registrationsid", registrationID)
					.list();
			
			count = registrations_inventory.size();
		      
		    //Committing the transaction
			session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			count = 0;
		}
		return count;		
	}
	//Finalizate Registration Job
	private Integer finalizateRegistrationJob(int registrationID){
		int count = 0;
		try {		
			//Begin transaction
			session.beginTransaction();
		    
			List<Registration_job> registration_job= (List<Registration_job>)session
					.createQuery("from Registration_job where registrationsid=:registrationsid")
					.setParameter("registrationsid", registrationID)
					.list();
			
			count = registration_job.size();
		      
		    //Committing the transaction
			session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			count = 0;
		}
		return count;
		
	}
	//Checks if the registration number already exists, or not
	private Boolean registrationNumberValadation(String registrationNR) {
		Boolean exists = null;
		try {
			//Begin transaction
			session.beginTransaction();
		    
			Query<Registration> querry = session.createQuery("from Registration where regnr=:regnr ");
			querry.setParameter("regnr", registrationNR);
			
			Registration registration = querry.uniqueResult();
			
			if(registration!=null) {
				System.out.println("Registration number already exists. Again.");
				JOptionPane.showMessageDialog(null, "Numărul de înregistrare dat există deja. Alege altul.");
				exists=true;
			}else {
				exists=false;
			}

		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		return exists;
	}
	//Generating random registration number
	//Generating unique string for registration number with 24 characters
	private void generateRegistrationNumber() {
		try {
			int count = 24;
			final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			
			StringBuilder builder = new StringBuilder();
			while (count-- != 0) {
				int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
				builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}
			
			String generatedString = builder.toString();
			
			//Checking if there is already a Registrtation number with this generated String
			//Begin transaction
			session.beginTransaction();
		    
			Query<Registration> querry = session.createQuery("from Registration where regnr=:regnr ");
			querry.setParameter("regnr", generatedString);
			int nr = querry.list().size();
			
			if(nr>=1) {
				System.out.println("Registration number already exists. Again.");
				generateRegistrationNumber();
			}else {
				JTF_registrationNumber_ANR.setText(generatedString);
			}

		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}

}
