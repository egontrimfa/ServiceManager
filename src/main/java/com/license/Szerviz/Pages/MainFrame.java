package com.license.Szerviz.Pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Szerviz.Entities.Auto_pieces;
import com.license.Szerviz.Entities.Car;
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;
import com.license.Szerviz.Entities.Inventory;
import com.license.Szerviz.Entities.Job;
import com.license.Szerviz.Entities.Registration_job;
import com.license.Szerviz.Entities.Reception;
import com.license.Szerviz.Entities.Receptions_auto_pieces;
import com.license.Szerviz.Entities.Registration;
import com.license.Szerviz.Entities.Registrations_inventory;
import com.license.Szerviz.Entities.Replaced;
import com.license.Szerviz.Entities.Role;
import com.license.Szerviz.Entities.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTree;

public class MainFrame extends JFrame {
	////////////////////////////////////////////////////////////////////
	//--------//Variables and JComponent Registration Section//--------//
	/////////////////////////////////////////////////////////////////////
	
	private static final long serialVersionUID = 3195004581454923665L;

	static MainFrame mainFrame = new MainFrame();
	
	//DEFINED
	private static Session session;
	private int xx,xy;
	private int selectedClientID = 0;
	private String selectedPieceID;
	private int selectedRoleID = 0;
	private int selectedUserID = 0;
	private int selectedJobID = 0;
	private int selectedInventoryID = 0;
	private int selectedSupplieID = 0;
	private int selectedRAPID = 0;
	private String selectPiece;
	private int selectedRegistrationID = 0;
	static private TableRowSorter<TableModel> rowSorter;
	
	private Client selectedClient;
	private Company selectedCompany;
	private Auto_pieces selectedAutoPiece;
	private Reception selectedReception;
	private Car selectedCar;
	private Inventory selectedInventoryItem;
	private Registrations_inventory selectedRegistrationInventory;
	private Registration_job selectedRegistrationJob;
	private Job selectedJob;
	
	private String previousPanel = "panelDB";
	
	//contentPane	
	private JPanel contentPane;
	static private JPanel panelDB;
	static private JPanel panelCR;
	static private JPanel panelLPR;
	static private JPanel panelNPR;
	static private JPanel panelCL;
	static private JPanel panelAPL;
	static private JPanel panelAR;
	static private JPanel panelANS;
	static private JPanel panelAAP;
	static private JPanel panelANJ;
	static private JPanel panelJL;
	static private JPanel panelANU;
	static private JPanel panelUL;
	static private JPanel panelAA;
	static private JPanel panelANR;
	static private JPanel panelIM;
	static private JPanel panelSL;
	static private JPanel panelRAPL;
	static private JPanel panelSJ;
	static private JPanel panelSII;
	
	//panelNPR
	private JTextField JTF_clientName_NPR;
	private JTextField JTF_clientPhone_NPR;
	
	//panelLPR
	private JTextField JTF_clientName_LPR;
	private JTextField JTF_clientPhone_LPR;
	private JTextField JTF_companyName_LPR;
	private JTextField JTF_companyPhone_LPR;
	private JTextField JTF_companyAddress_LPR;
	private JTextField JTF_companyCIF_LPR;
	private JTextField JTF_companyRegNR_LPR;
	private JTextField JTF_companyBank_LPR;
	private JTextField JTF_companyIBAN_LPR;
	private JTextField JTF_companyBranchOffice_LPR;
	
	//panelCL
	private static JTable JT_clients_CL;
	private JTextField JTF_clientNameInfo_CL;
	private JTextField JTF_clientPhoneInfo_CL;
	private JTextField JTF_clientCompanyInfo_CL;
	private JTextField JTF_clientQuickSearchByName_CL;
	private JTextField JTF_companyNameInfo_CL;
	private JTextField JTF_companyAddressInfo_CL;
	private JTextField JTF_companyPhoneInfo_CL;
	private JTextField JTF_companyCIFInfo_CL;
	private JTextField JTF_companyRegNRInfo_CL;
	private JTextField JTF_companyBankInfo_CL;
	private JTextField JTF_companyIBANInfo_CL;
	private JTextField JTF_companyBranchOfficeInfo_CL;
	private JLabel JL_companyNameInfo_CL;
	private JLabel JL_companyAddressInfo_CL;
	private JLabel JL_companyPhoneInfo_CL;
	private JLabel JL_companyCIFInfo_CL;
	private JLabel JL_companyRegNRInfo_CL;
	private JLabel JL_companyBankInfo_CL;
	private JLabel JL_companyIBANInfo_CL;
	private JLabel JL_companyBranchOfficeInfo_CL;
	private JButton JB_updateClient_CL;
	private JButton JB_deleteClient_CL;
	private JButton JB_selectClient_CL;
	
	//panelAPL
	private static JTable JT_pieces_APL;
	private JTextField JTF_pieceIDInfo_APL;
	private JTextField JTF_pieceNameInfo_APL;
	private JTextField JTF_pieceUnitNameInfo_APL;
	private JTextField JTF_pieceQuickSearch_APL;
	private JButton JB_updatePiece_APL;
	private JButton JB_deletePiece_APL;
	private JButton JB_selectPiece_APL;
	
	//panelAR
	private static JTable JT_pieces_AR;
	private JTextField JTF_pieceNameFrom_AR;
	private JTextField JTF_pieceIDInfo_AR;
	private JTextField JTF_pieceNameInfo_AR;
	private JTextField JTF_pieceUnitNameInfo_AR;
	private JTextField JTF_newReplacable_AR;
	private JTextField JTF_pieceNameTo_AR;
	private JButton JB_deleteReplacable_AR;
	
	//panelAR
	private JTextField JTL_pieceID_ANS;
	private JTextField JTF_clientName_ANS;
	private JTextField JTF_invoiceNR_ANS;
	private JTable JT_pieces_ANS;
	private JTextField JTF_autoPieceID_AAP;
	private JTextField JTF_autoPieceName_AAP;
	private JTextField JTF_autoPieceUniteName_AAP;
	private JTextField JTF_clientQuickSearchByPhone_CL;
	private JTextField JTF_clientQuickSearchByStatus_CL;
	private JTextField JTF_selectedClientName_ANS;
	private JTextField JTF_pieceQuantity_ANS;
	private JTextField JTF_piecePriceOUT_ANS;
	private JTextField JTF_piecePriceIN_ANS;
	private JTextField JTF_pieceVAT_ANS;
	private JTextField JTF_jobName_ANJ;
	private JTextField JTF_jobPrice_ANJ;
	
	//panelJL
	private static JTable JT_jobs_JL;
	//private JTextField JTF_jobIDInfo_JL;
	private JTextField JTF_jobNameInfo_JL;
	private JTextField JTF_jobPriceInfo_JL;
	private JTextField JTF_jobQuickSearch_JL;
	private JButton JB_updateJob_JL;
	private JButton JB_deleteJob_JL;
	private JButton JB_selectJob_JL;
	
	//panelANU
	private JTextField JTF_userName_ANU;
	private JPasswordField JPF_userPassword_ANU;
	private JPasswordField JPF_userPasswordRE_ANU;
	private JComboBox<Role> JCB_userRole_ANU;
	
	//panelUL
	private static JTable JT_users_UL;
	private JTextField JTF_userNameInfo_UL;
	private JTextField JTF_userQuickSearch_UL;
	private JButton JB_updateUser_UL;
	private JButton JB_deleteUser_UL;
	private JButton JB_selectUser_UL;
	private JComboBox<Role> JCB_userRoleInfo_UL;
	
	//panelAA
	private JTable JT_prevCars_AA;
	private JTextField JTF_carBrand_AA;
	private JTextField JTF_carModel_AA;
	private JTextField JTF_carLicenseNumber_AA;
	private JTextField JTF_carChassisNR_AA;
	private JTextField JTF_carEngineNR_AA;
	private JTextField JTF_carMilometer_AA;
	private JButton JB_addCar_AA;
	
	//panelIM
	private static JTable JT_inventory_IM;
	private JTextField JTF_pieceIDInfo_IM;
	private JTextField JTF_clientNameInfo_IM;
	private JTextField JTF_quantityInfo_IM;
	private JTextField JTF_unitePriceINInfo_IM;
	private JTextField JTF_unitePriceOUTInfo_IM;
	private JDateChooser JDC_dateINInfo_IM;
	private JButton JB_updateInventoryItem_IM;
	private JButton JB_deleteInventoryItem_IM;
	private JButton JB_selectInventoryItem_IM;
	private JTextField JTF_clientQuickSearch_IM;
	private JTextField JTF_autoPieceQuickSearch_IM;
	private JTextField JTF_dateINQuickSearch_IM;
	
	//panelSL
	private static JTable JT_supplies_SL;
	private JTextField JTF_clientNameInfo_SL;
	private JTextField JTF_invoiceNRInfo_SL;
	private JButton JB_updateSupplie_SL;
	private JButton JB_deleteSupplie_SL;
	private JButton JB_selectSupplie_SL;
	private JDateChooser JDC_dateINInfo_SL;
	private JDateChooser JDC_dueDateInfo_SL;
	private JTextField JTF_clientNameQuickSearch_SL;
	private JTextField JTF_invoiceNRQuickSearch_SL;
	private JDateChooser JDC_dateINQuickSearch_SL;
	private JDateChooser JDC_dueDateQuickSearch_SL;
	
	//panelRAPL
	private static JTable JT_rapl_RAPL;
	private JTextField JTF_recInvoiceNRInfo_RAPL;
	private JTextField JTF_autoPieceIDInfo_RAPL;
	private JTextField JTF_quantityInfo_RAPL;
	private JTextField JTF_priceINInfo_RAPL;
	private JTextField JTF_priceOUTInfo_RAPL;
	private JTextField JTF_vatInfo_RAPL;
	private JButton JB_updateRAP_RAPL;
	private JButton JB_deleteRAP_RAPL;
	private JButton JB_selectRAP_RAPL;
	private JTextField JTF_rapQuickSearch_RAPL;
	
	//panelANR
	private JTable JT_info_ANR;
	private JTextField JTF_registrationNumber_ANR;
	private JLabel JL_selectClient_ANR;
	private JLabel JL_selectCar_ANR;
	private JLabel JL_selectWorker_ANR;
	private JLabel JL_selectPiece_ANR;
	private JLabel JL_selectJob_ANR;
	private JLabel SC_addClient_ANR;
	private JLabel SC_editClient_ANR;
	private JLabel SC_addCar_ANR;
	private JLabel SC_editCar_ANR;
	private JLabel SC_addWorker_ANR;
	private JLabel SC_editWorker_ANR;
	private JLabel SC_addPiece_ANR;
	private JLabel SC_editPiece_ANR;
	private JLabel SC_addJob_ANR;
	private JLabel SC_editJob_ANR;
	private JDateChooser JDC_registrationNumber_ANR;
	
	//panelSJ
	private JTable JT_jobs_SJ;
	private JTextField JTF_jobName_SJ;
	private JTextField JTF_jobPrice_SJ;
	private JTextField JTF_jobSearch_SJ;
	private JButton JB_addJobToList_SJ;
	private JButton JB_updateRegistrationJob_SJ;
	
	//panelSII
	private JTable JT_inventory_SII;
	private JTextField JTF_inventoryItemName_SII;
	private JTextField JTF_inventoryItemPrice_SII;
	private JTextField JTF_invenotyItemQuantity_SII;
	private JTextField JTF_inventoryItemSearch_SII;
	private JButton JB_addInventoryItemToList_SII;
	private JButton JB_updateRegistrationInventory_SII;
	private JButton JB_clearInvenoryItem_SII;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame.setUndecorated(true);
					mainFrame.setVisible(true);
					
					//Global settings
					UIManager.put("OptionPane.minimumSize", new Dimension(350,75));
					
					//Creating global session -- testing
					session = HibernateUtil.getSessionFactory().openSession();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1830, 850);
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
		panelDB.setName("panelDB");
		contentPane.add(panelDB, "name_1108443134470599");
		panelDB.setLayout(null);
		
		JLabel MCard_newClient_DB = new JLabel("");
		MCard_newClient_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_newClient_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelCR);
			}
		});
		MCard_newClient_DB.setToolTipText("Adaugă client nou");
		MCard_newClient_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/new_client1.png")));
		MCard_newClient_DB.setBounds(12, 88, 154, 154);
		panelDB.add(MCard_newClient_DB);
		
		JLabel MCard_listClients_DB = new JLabel("");
		MCard_listClients_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_listClients_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelCL);
								
				SetDefaultTable(JT_clients_CL, new String[]{"ID", "Numele clientului", "Numarul de telefon", "Firm?"});				
				LoadClients();
			}
		});
		MCard_listClients_DB.setToolTipText("Clienţii");
		MCard_listClients_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/list_clients1.png")));
		MCard_listClients_DB.setBounds(12, 255, 154, 154);
		panelDB.add(MCard_listClients_DB);
		
		JLabel MCard_listPieces_DB = new JLabel("");
		MCard_listPieces_DB.setToolTipText("Piese");
		MCard_listPieces_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_listPieces_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelAPL);
				
				SetDefaultTable(JT_pieces_APL, new String[]{"COD", "Nume", "Unitate/Masura"});
				LoadPieces();
			}
		});
		MCard_listPieces_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/list_parts0.png")));
		MCard_listPieces_DB.setBounds(178, 255, 154, 154);
		panelDB.add(MCard_listPieces_DB);
		
		JLabel MCard_addReplace_DB = new JLabel("");
		MCard_addReplace_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelAR);
				
				SetDefaultTable(JT_pieces_AR, new String[]{"COD", "Nume", "Unitate/Masura"});
			}
		});
		MCard_addReplace_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_addReplace_DB.setToolTipText("Piese de schimb");
		MCard_addReplace_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/auto_piece_replace_154.png")));
		MCard_addReplace_DB.setBounds(178, 422, 154, 154);
		panelDB.add(MCard_addReplace_DB);
		
		JLabel MCard_addSupplie_DB = new JLabel("");
		MCard_addSupplie_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelANS);
				
				SetDefaultTable(JT_pieces_ANS, new String[]{"COD", "Nume", "Unitate/Masura", "Quantity", "IN", "OUT", "TVA"});
			}
		});
		MCard_addSupplie_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_addSupplie_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/supplier2.png")));
		MCard_addSupplie_DB.setBounds(343, 88, 154, 154);
		panelDB.add(MCard_addSupplie_DB);
		
		JLabel MCard_addPieces_DB = new JLabel("");
		MCard_addPieces_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelAAP);
			}
		});
		MCard_addPieces_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_addPieces_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/addPiece0.png")));
		MCard_addPieces_DB.setBounds(178, 88, 154, 154);
		panelDB.add(MCard_addPieces_DB);
		
		JLabel exitDB = new JLabel("");
		exitDB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitDB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitDB.setToolTipText("EXIT");
		exitDB.setHorizontalAlignment(SwingConstants.CENTER);
		exitDB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit_32.png")));
		exitDB.setBounds(1758, 10, 32, 32);
		panelDB.add(exitDB);
		
		JLabel MCard_addJob_DB = new JLabel("");
		MCard_addJob_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelDB, panelANJ);
			}
		});
		MCard_addJob_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/addjob0.png")));
		MCard_addJob_DB.setToolTipText("Adauga job nou");
		MCard_addJob_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_addJob_DB.setBounds(509, 88, 154, 154);
		panelDB.add(MCard_addJob_DB);
		
		JLabel MCard_listJobs_DB = new JLabel("");
		MCard_listJobs_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelJL);
				
				SetDefaultTable(JT_jobs_JL, new String[]{"ID", "Numele jobului", "Tarifa jobului"});				
				LoadJobs();
			}
		});
		MCard_listJobs_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_listJobs_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/jobsList0.png")));
		MCard_listJobs_DB.setToolTipText("Joburi");
		MCard_listJobs_DB.setBounds(509, 255, 154, 154);
		panelDB.add(MCard_listJobs_DB);
		
		JLabel MCard_addUser_DB = new JLabel("");
		MCard_addUser_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelDB, panelANU);
				if(JCB_userRole_ANU.getItemCount()==0) {
					LoadRoles(JCB_userRole_ANU);
				}
			    
			    selectedRoleID = 1;
			}
		});
		MCard_addUser_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_addUser_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/worker0.png")));
		MCard_addUser_DB.setBounds(675, 88, 154, 154);
		panelDB.add(MCard_addUser_DB);
		
		JLabel MCard_listUsers_DB = new JLabel("");
		MCard_listUsers_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelDB, panelUL);
				
				SetDefaultTable(JT_users_UL, new String[]{"ID", "Numele lucratorului", "Rolul"});				
				LoadUsers();
				
				if(JCB_userRoleInfo_UL.getItemCount()==0) {
					LoadRoles(JCB_userRoleInfo_UL);
				}
			    
			    selectedRoleID = 1;
			}
		});
		MCard_listUsers_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_listUsers_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/worker2.png")));
		MCard_listUsers_DB.setBounds(675, 255, 154, 154);
		panelDB.add(MCard_listUsers_DB);
		
		JLabel MCard_inventoryManagement_DB = new JLabel("");
		MCard_inventoryManagement_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelIM);
				
				SetDefaultTable(JT_inventory_IM, new String[]{"ID", "Piese de auto", "Furnizor", "Quantity", "Price IN", "Price OUT", "Date"});				
				loadInventory();
			}
		});
		MCard_inventoryManagement_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_inventoryManagement_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/inventory_manager_154.png")));
		MCard_inventoryManagement_DB.setBounds(343, 422, 154, 154);
		panelDB.add(MCard_inventoryManagement_DB);
		
		JLabel MCard_listSupplies_DB = new JLabel("");
		MCard_listSupplies_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelSL);
				
				SetDefaultTable(JT_supplies_SL, new String[]{"ID", "Furnizor", "Număr de factură", "Date IN", "Due Date"});				
				loadSupplies();
			}
		});
		MCard_listSupplies_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_listSupplies_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/supplier_list_154.png")));
		MCard_listSupplies_DB.setBounds(344, 255, 154, 154);
		panelDB.add(MCard_listSupplies_DB);
		
		JLabel MCard_addRegistration_DB = new JLabel("");
		MCard_addRegistration_DB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelDB, panelANR);
				
				generateRegistrationNumber();
				JDC_registrationNumber_ANR.setDate(new Date());
				saveRegistration(0, 0, JTF_registrationNumber_ANR.getText(), JDC_registrationNumber_ANR.getDate());
			}
		});
		MCard_addRegistration_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add_registration_154.png")));
		MCard_addRegistration_DB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MCard_addRegistration_DB.setBounds(841, 88, 154, 154);
		panelDB.add(MCard_addRegistration_DB);
		
		///////////////////////////////////////////////////
		//--------//Client Registration Section//--------//
		///////////////////////////////////////////////////
		
		panelCR = new JPanel();
		panelCR.setName("panelCR");
		contentPane.add(panelCR, "name_1108447015053600");
		panelCR.setLayout(null);
		
		JLabel BCard_naturalRegistration_CR = new JLabel("");
		BCard_naturalRegistration_CR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BCard_naturalRegistration_CR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelCR, panelNPR);
			}
		});
		BCard_naturalRegistration_CR.setAlignmentX(Component.CENTER_ALIGNMENT);
		BCard_naturalRegistration_CR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/persfizik0.png")));
		BCard_naturalRegistration_CR.setVerticalAlignment(SwingConstants.TOP);
		BCard_naturalRegistration_CR.setBounds(55, 163, 581, 378);
		panelCR.add(BCard_naturalRegistration_CR);
		
		JLabel BCard_legalRegistration_CR = new JLabel("");
		BCard_legalRegistration_CR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BCard_legalRegistration_CR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelCR, panelLPR);
			}
		});
		BCard_legalRegistration_CR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/PERSJUR0.png")));
		BCard_legalRegistration_CR.setVerticalAlignment(SwingConstants.TOP);
		BCard_legalRegistration_CR.setAlignmentX(0.5f);
		BCard_legalRegistration_CR.setBounds(675, 163, 581, 378);
		panelCR.add(BCard_legalRegistration_CR);
		
		JLabel exitCR = new JLabel("");
		exitCR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitCR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
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
				PanelNavigationHelper(panelCR, panelDB);
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
		panelLPR.setName("panelLPR");
		contentPane.add(panelLPR, "name_1108449335953499");
		panelLPR.setLayout(null);
		
		JLabel HCard_legalClient_LPR = new JLabel("");
		HCard_legalClient_LPR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/manager-4.png")));
		HCard_legalClient_LPR.setBounds(50, 42, 457, 531);
		panelLPR.add(HCard_legalClient_LPR);
		
		JTF_clientName_LPR = new JTextField();
		JTF_clientName_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_clientName_LPR.getBorder()!=null) {
					JTF_clientName_LPR.setBorder(null);
				}
			}
		});
		JTF_clientName_LPR.setBounds(896, 138, 365, 22);
		panelLPR.add(JTF_clientName_LPR);
		JTF_clientName_LPR.setColumns(10);
		
		JLabel JL_clientName_LPR = new JLabel("Numele contactului");
		JL_clientName_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_clientName_LPR.setBounds(896, 106, 151, 16);
		panelLPR.add(JL_clientName_LPR);
		
		JLabel JL_clientPhone_LPR = new JLabel("Numarul de telefon al contactului");
		JL_clientPhone_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_clientPhone_LPR.setBounds(896, 181, 261, 16);
		panelLPR.add(JL_clientPhone_LPR);
		
		JTF_clientPhone_LPR = new JTextField();
		JTF_clientPhone_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_clientPhone_LPR.getBorder()!=null) {
					JTF_clientPhone_LPR.setBorder(null);
				}
			}
		});
		JTF_clientPhone_LPR.setColumns(10);
		JTF_clientPhone_LPR.setBounds(896, 218, 365, 22);
		panelLPR.add(JTF_clientPhone_LPR);
		
		JButton JB_saveClient_LPR = new JButton("Salveaza");
		JB_saveClient_LPR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_clientName_LPR);
				jtf_list.add(JTF_clientPhone_LPR);
				jtf_list.add(JTF_companyName_LPR);
				jtf_list.add(JTF_companyPhone_LPR);
				jtf_list.add(JTF_companyAddress_LPR);
				jtf_list.add(JTF_companyCIF_LPR);
				jtf_list.add(JTF_companyRegNR_LPR);
				jtf_list.add(JTF_companyBank_LPR);
				jtf_list.add(JTF_companyIBAN_LPR);
				jtf_list.add(JTF_companyBranchOffice_LPR);
				
				if(InputValidation(jtf_list)) {
					SaveLegalPerson();
					
					PanelNavigationHelper(panelLPR, panelCR);
									
					GeneralResetter(jtf_list, null, null, true, null);	
				}else {
					//Set warning pop-up here
					unsavedInformer();
				}
			}
		});
		JB_saveClient_LPR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/save-button.png")));
		JB_saveClient_LPR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JB_saveClient_LPR.setBounds(792, 493, 197, 41);
		panelLPR.add(JB_saveClient_LPR);
		
		JLabel JL_companyName_LPR = new JLabel("Numele companiei");
		JL_companyName_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_companyName_LPR.setBounds(519, 103, 151, 22);
		panelLPR.add(JL_companyName_LPR);
		
		JTF_companyName_LPR = new JTextField();
		JTF_companyName_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_companyName_LPR.getBorder()!=null) {
					JTF_companyName_LPR.setBorder(null);
				}
			}
		});
		JTF_companyName_LPR.setColumns(10);
		JTF_companyName_LPR.setBounds(519, 138, 365, 22);
		panelLPR.add(JTF_companyName_LPR);
		
		JLabel JL_companyPhone_LPR = new JLabel("Numarul de telefon al companiei");
		JL_companyPhone_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_companyPhone_LPR.setBounds(519, 173, 261, 32);
		panelLPR.add(JL_companyPhone_LPR);
		
		JTF_companyPhone_LPR = new JTextField();
		JTF_companyPhone_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_companyPhone_LPR.getBorder()!=null) {
					JTF_companyPhone_LPR.setBorder(null);
				}
			}
		});
		JTF_companyPhone_LPR.setColumns(10);
		JTF_companyPhone_LPR.setBounds(519, 218, 365, 22);
		panelLPR.add(JTF_companyPhone_LPR);
		
		JLabel JL_companyAddress_LPR = new JLabel("Addresa companiei");
		JL_companyAddress_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_companyAddress_LPR.setBounds(519, 253, 161, 32);
		panelLPR.add(JL_companyAddress_LPR);
		
		JTF_companyAddress_LPR = new JTextField();
		JTF_companyAddress_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_companyAddress_LPR.getBorder()!=null) {
					JTF_companyAddress_LPR.setBorder(null);
				}
			}
		});
		JTF_companyAddress_LPR.setColumns(10);
		JTF_companyAddress_LPR.setBounds(519, 298, 365, 22);
		panelLPR.add(JTF_companyAddress_LPR);
		
		JLabel JL_companyCIF_LPR = new JLabel("CIF");
		JL_companyCIF_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_companyCIF_LPR.setBounds(519, 333, 161, 32);
		panelLPR.add(JL_companyCIF_LPR);
		
		JTF_companyCIF_LPR = new JTextField();
		JTF_companyCIF_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_companyCIF_LPR.getBorder()!=null) {
					JTF_companyCIF_LPR.setBorder(null);
				}
			}
		});
		JTF_companyCIF_LPR.setColumns(10);
		JTF_companyCIF_LPR.setBounds(519, 378, 365, 22);
		panelLPR.add(JTF_companyCIF_LPR);
		
		JLabel JL_companyRegNR_LPR = new JLabel("Numarul de inregistrare");
		JL_companyRegNR_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_companyRegNR_LPR.setBounds(519, 413, 197, 32);
		panelLPR.add(JL_companyRegNR_LPR);
		
		JTF_companyRegNR_LPR = new JTextField();
		JTF_companyRegNR_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_companyRegNR_LPR.getBorder()!=null) {
					JTF_companyRegNR_LPR.setBorder(null);
				}
			}
		});
		JTF_companyRegNR_LPR.setColumns(10);
		JTF_companyRegNR_LPR.setBounds(519, 458, 365, 22);
		panelLPR.add(JTF_companyRegNR_LPR);
		
		JLabel JL_companyBank_LPR = new JLabel("Bank");
		JL_companyBank_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_companyBank_LPR.setBounds(896, 253, 161, 32);
		panelLPR.add(JL_companyBank_LPR);
		
		JTF_companyBank_LPR = new JTextField();
		JTF_companyBank_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_companyBank_LPR.getBorder()!=null) {
					JTF_companyBank_LPR.setBorder(null);
				}
			}
		});
		JTF_companyBank_LPR.setColumns(10);
		JTF_companyBank_LPR.setBounds(896, 298, 365, 22);
		panelLPR.add(JTF_companyBank_LPR);
		
		JLabel JL_companyIBAN_LPR = new JLabel("IBAN");
		JL_companyIBAN_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_companyIBAN_LPR.setBounds(896, 333, 161, 32);
		panelLPR.add(JL_companyIBAN_LPR);
		
		JTF_companyIBAN_LPR = new JTextField();
		JTF_companyIBAN_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_companyIBAN_LPR.getBorder()!=null) {
					JTF_companyIBAN_LPR.setBorder(null);
				}
			}
		});
		JTF_companyIBAN_LPR.setColumns(10);
		JTF_companyIBAN_LPR.setBounds(896, 378, 365, 22);
		panelLPR.add(JTF_companyIBAN_LPR);
		
		JLabel JL_companyBranchOffice_LPR = new JLabel("Office");
		JL_companyBranchOffice_LPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_companyBranchOffice_LPR.setBounds(896, 413, 161, 32);
		panelLPR.add(JL_companyBranchOffice_LPR);
		
		JTF_companyBranchOffice_LPR = new JTextField();
		JTF_companyBranchOffice_LPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_companyBranchOffice_LPR.getBorder()!=null) {
					JTF_companyBranchOffice_LPR.setBorder(null);
				}
			}
		});
		JTF_companyBranchOffice_LPR.setColumns(10);
		JTF_companyBranchOffice_LPR.setBounds(896, 458, 365, 22);
		panelLPR.add(JTF_companyBranchOffice_LPR);
		
		JLabel exitLPR = new JLabel("");
		exitLPR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitLPR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
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
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_clientName_LPR);
				jtf_list.add(JTF_clientPhone_LPR);
				jtf_list.add(JTF_companyName_LPR);
				jtf_list.add(JTF_companyPhone_LPR);
				jtf_list.add(JTF_companyAddress_LPR);
				jtf_list.add(JTF_companyCIF_LPR);
				jtf_list.add(JTF_companyRegNR_LPR);
				jtf_list.add(JTF_companyBank_LPR);
				jtf_list.add(JTF_companyIBAN_LPR);
				jtf_list.add(JTF_companyBranchOffice_LPR);
				
				//I can reduce the condition tree to one branch but then the confirmation to go back will be displayed if all text fields are empty as well
				//not just when there is some text in them, and I did not want that
				
				if(unsavedChecker(jtf_list)) {
					if(backDialog()) {
						PanelNavigationHelper(panelLPR, panelCR);
						
						TextFieldBorderResetter(jtf_list);
						GeneralResetter(jtf_list, null, null, true, null);
					}
				}else {
					PanelNavigationHelper(panelLPR, panelCR);
					
					TextFieldBorderResetter(jtf_list);
				}
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
		panelNPR.setName("panelNPR");
		contentPane.add(panelNPR, "name_1108451248100400");
		panelNPR.setLayout(null);
		
		JLabel HCrad_naturalClient_NPR = new JLabel("");
		HCrad_naturalClient_NPR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/person-4.png")));
		HCrad_naturalClient_NPR.setBounds(50, 42, 457, 531);
		panelNPR.add(HCrad_naturalClient_NPR);
		
		JTF_clientName_NPR = new JTextField();
		JTF_clientName_NPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(JTF_clientName_NPR.getBorder()!=null) {
					JTF_clientName_NPR.setBorder(null);
				}
			}
		});
		JTF_clientName_NPR.setBounds(732, 144, 365, 22);
		panelNPR.add(JTF_clientName_NPR);
		JTF_clientName_NPR.setColumns(10);
		
		JLabel JB_clientName_NPR = new JLabel("Numele clientului");
		JB_clientName_NPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JB_clientName_NPR.setBounds(732, 115, 139, 16);
		panelNPR.add(JB_clientName_NPR);
		
		JLabel JB_clientPhone_NPR = new JLabel("Numarul de telefon");
		JB_clientPhone_NPR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JB_clientPhone_NPR.setBounds(732, 189, 151, 16);
		panelNPR.add(JB_clientPhone_NPR);
		
		JTF_clientPhone_NPR = new JTextField();
		JTF_clientPhone_NPR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(JTF_clientPhone_NPR.getBorder()!=null) {
					JTF_clientPhone_NPR.setBorder(null);
				}
			}
		});
		JTF_clientPhone_NPR.setColumns(10);
		JTF_clientPhone_NPR.setBounds(732, 218, 365, 22);
		panelNPR.add(JTF_clientPhone_NPR);
		
		JButton JB_saveClient_NPR = new JButton("Salveaza");
		JB_saveClient_NPR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_clientName_NPR);
				jtf_list.add(JTF_clientPhone_NPR);
				
				if(InputValidation(jtf_list)) {
					SaveNaturalClient();
					
					PanelNavigationHelper(panelNPR, panelCR);
									
					GeneralResetter(jtf_list, null, null, true, null);	
				}else {
					unsavedInformer();
				}
			}
		});
		JB_saveClient_NPR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/save-button.png")));
		JB_saveClient_NPR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JB_saveClient_NPR.setBounds(810, 253, 197, 41);
		panelNPR.add(JB_saveClient_NPR);
		
		JLabel exitNPR = new JLabel("");
		exitNPR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitNPR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
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
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_clientName_NPR);
				jtf_list.add(JTF_clientPhone_NPR);
				
				if(unsavedChecker(jtf_list)) {
					if(backDialog()) {
						PanelNavigationHelper(panelNPR, panelCR);
						
						TextFieldBorderResetter(jtf_list);
						GeneralResetter(jtf_list, null, null, true, null);
					}
				}else {
					PanelNavigationHelper(panelNPR, panelCR);
					
					TextFieldBorderResetter(jtf_list);
				}
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
		panelCL.setName("panelCL");
		contentPane.add(panelCL, "name_1108453295279800");
		panelCL.setLayout(null);
		
		JScrollPane JSP_clients_CL = new JScrollPane();
		JSP_clients_CL.setBounds(434, 140, 1356, 640);
		panelCL.add(JSP_clients_CL);
		
		JT_clients_CL = new JTable();
		JT_clients_CL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_clients_CL.convertRowIndexToModel(JT_clients_CL.getSelectedRow());
				TableModel model = JT_clients_CL.getModel();
				JTF_clientNameInfo_CL.setText(model.getValueAt(index, 1).toString());
				JTF_clientPhoneInfo_CL.setText(model.getValueAt(index, 2).toString());
				JTF_clientCompanyInfo_CL.setText(model.getValueAt(index, 3).toString());
				selectedClientID = Integer.parseInt(model.getValueAt(index, 0).toString());
				
				if(JTF_clientCompanyInfo_CL.getText().equals("true")) {
					//setting company parameters to visible and empty, and labels to visible as well					
					companyDataSetter(true, true);
					
					//Getting the selected company by ID
					getClientByID(selectedClientID);
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
					companyDataSetter(false, true);
				}
				
				if(previousPanel.equals("panelANS") || previousPanel.equals("panelANR")) {
					JB_selectClient_CL.setEnabled(true);
				}
			}
		});

		JSP_clients_CL.setViewportView(JT_clients_CL);
		
		JPanel JP_clientInfo_CL = new JPanel();
		JP_clientInfo_CL.setBounds(10, 97, 412, 683);
		panelCL.add(JP_clientInfo_CL);
		JP_clientInfo_CL.setLayout(null);
		
		JLabel JL_clientNameInfo_CL = new JLabel("Numele:");
		JL_clientNameInfo_CL.setBounds(12, 56, 48, 16);
		JP_clientInfo_CL.add(JL_clientNameInfo_CL);
		
		JLabel JL_clientDeatails_CL = new JLabel("Detalii clientului");
		JL_clientDeatails_CL.setHorizontalAlignment(SwingConstants.CENTER);
		JL_clientDeatails_CL.setBounds(12, 13, 388, 20);
		JL_clientDeatails_CL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_clientInfo_CL.add(JL_clientDeatails_CL);
		
		JTF_clientNameInfo_CL = new JTextField();
		JTF_clientNameInfo_CL.setBounds(131, 53, 269, 22);
		JP_clientInfo_CL.add(JTF_clientNameInfo_CL);
		JTF_clientNameInfo_CL.setColumns(10);
		
		JLabel JL_clientPhoneInfo_CL = new JLabel("Numarul de telefon:");
		JL_clientPhoneInfo_CL.setBounds(12, 85, 116, 16);
		JP_clientInfo_CL.add(JL_clientPhoneInfo_CL);
		
		JTF_clientPhoneInfo_CL = new JTextField();
		JTF_clientPhoneInfo_CL.setBounds(131, 82, 269, 22);
		JP_clientInfo_CL.add(JTF_clientPhoneInfo_CL);
		JTF_clientPhoneInfo_CL.setColumns(10);
		
		JLabel JL_clientCompanyInfo_CL = new JLabel("Statutul clientului:");
		JL_clientCompanyInfo_CL.setBounds(12, 114, 103, 16);
		JP_clientInfo_CL.add(JL_clientCompanyInfo_CL);
		
		JTF_clientCompanyInfo_CL = new JTextField();
		JTF_clientCompanyInfo_CL.setEditable(false);
		JTF_clientCompanyInfo_CL.setBounds(131, 111, 269, 22);
		JP_clientInfo_CL.add(JTF_clientCompanyInfo_CL);
		JTF_clientCompanyInfo_CL.setColumns(10);
		
		JTF_companyNameInfo_CL = new JTextField();
		JTF_companyNameInfo_CL.setVisible(false);
		JTF_companyNameInfo_CL.setBounds(131, 146, 269, 22);
		JP_clientInfo_CL.add(JTF_companyNameInfo_CL);
		JTF_companyNameInfo_CL.setColumns(10);
		
		JTF_companyAddressInfo_CL = new JTextField();
		JTF_companyAddressInfo_CL.setVisible(false);
		JTF_companyAddressInfo_CL.setColumns(10);
		JTF_companyAddressInfo_CL.setBounds(131, 181, 269, 22);
		JP_clientInfo_CL.add(JTF_companyAddressInfo_CL);
		
		JTF_companyPhoneInfo_CL = new JTextField();
		JTF_companyPhoneInfo_CL.setVisible(false);
		JTF_companyPhoneInfo_CL.setColumns(10);
		JTF_companyPhoneInfo_CL.setBounds(131, 216, 269, 22);
		JP_clientInfo_CL.add(JTF_companyPhoneInfo_CL);
		
		JTF_companyCIFInfo_CL = new JTextField();
		JTF_companyCIFInfo_CL.setVisible(false);
		JTF_companyCIFInfo_CL.setColumns(10);
		JTF_companyCIFInfo_CL.setBounds(131, 251, 269, 22);
		JP_clientInfo_CL.add(JTF_companyCIFInfo_CL);
		
		JTF_companyRegNRInfo_CL = new JTextField();
		JTF_companyRegNRInfo_CL.setVisible(false);
		JTF_companyRegNRInfo_CL.setColumns(10);
		JTF_companyRegNRInfo_CL.setBounds(131, 286, 269, 22);
		JP_clientInfo_CL.add(JTF_companyRegNRInfo_CL);
		
		JTF_companyBankInfo_CL = new JTextField();
		JTF_companyBankInfo_CL.setVisible(false);
		JTF_companyBankInfo_CL.setColumns(10);
		JTF_companyBankInfo_CL.setBounds(131, 321, 269, 22);
		JP_clientInfo_CL.add(JTF_companyBankInfo_CL);
		
		JTF_companyIBANInfo_CL = new JTextField();
		JTF_companyIBANInfo_CL.setVisible(false);
		JTF_companyIBANInfo_CL.setColumns(10);
		JTF_companyIBANInfo_CL.setBounds(131, 356, 269, 22);
		JP_clientInfo_CL.add(JTF_companyIBANInfo_CL);
		
		JTF_companyBranchOfficeInfo_CL = new JTextField();
		JTF_companyBranchOfficeInfo_CL.setVisible(false);
		JTF_companyBranchOfficeInfo_CL.setColumns(10);
		JTF_companyBranchOfficeInfo_CL.setBounds(131, 391, 269, 22);
		JP_clientInfo_CL.add(JTF_companyBranchOfficeInfo_CL);
		
		JL_companyNameInfo_CL = new JLabel("Numele companiei:");
		JL_companyNameInfo_CL.setVisible(false);
		JL_companyNameInfo_CL.setBounds(12, 149, 116, 16);
		JP_clientInfo_CL.add(JL_companyNameInfo_CL);
		
		JL_companyAddressInfo_CL = new JLabel("Addresa companiei:");
		JL_companyAddressInfo_CL.setVisible(false);
		JL_companyAddressInfo_CL.setBounds(12, 184, 116, 16);
		JP_clientInfo_CL.add(JL_companyAddressInfo_CL);
		
		JL_companyPhoneInfo_CL = new JLabel("Num. tel. comp.:");
		JL_companyPhoneInfo_CL.setVisible(false);
		JL_companyPhoneInfo_CL.setBounds(12, 219, 103, 16);
		JP_clientInfo_CL.add(JL_companyPhoneInfo_CL);
		
		JL_companyCIFInfo_CL = new JLabel("CIF:");
		JL_companyCIFInfo_CL.setVisible(false);
		JL_companyCIFInfo_CL.setBounds(12, 254, 103, 16);
		JP_clientInfo_CL.add(JL_companyCIFInfo_CL);
		
		JL_companyRegNRInfo_CL = new JLabel("NR de irgesitrare:");
		JL_companyRegNRInfo_CL.setVisible(false);
		JL_companyRegNRInfo_CL.setBounds(12, 289, 103, 16);
		JP_clientInfo_CL.add(JL_companyRegNRInfo_CL);
		
		JL_companyBankInfo_CL = new JLabel("Bank:");
		JL_companyBankInfo_CL.setVisible(false);
		JL_companyBankInfo_CL.setBounds(12, 324, 103, 16);
		JP_clientInfo_CL.add(JL_companyBankInfo_CL);
		
		JL_companyIBANInfo_CL = new JLabel("IBAN:");
		JL_companyIBANInfo_CL.setVisible(false);
		JL_companyIBANInfo_CL.setBounds(12, 359, 103, 16);
		JP_clientInfo_CL.add(JL_companyIBANInfo_CL);
		
		JL_companyBranchOfficeInfo_CL = new JLabel("Branch office:");
		JL_companyBranchOfficeInfo_CL.setVisible(false);
		JL_companyBranchOfficeInfo_CL.setBounds(12, 394, 103, 16);
		JP_clientInfo_CL.add(JL_companyBranchOfficeInfo_CL);
		
		JB_updateClient_CL = new JButton("Update");
		JB_updateClient_CL.setEnabled(false);
		JB_updateClient_CL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JB_updateClient_CL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(selectedClientID>0) {
					if(JTF_clientCompanyInfo_CL.getText().equals("true")) {
						updateLegalClient(selectedClientID, JTF_clientNameInfo_CL.getText(), JTF_clientPhoneInfo_CL.getText(), JTF_companyNameInfo_CL.getText(), JTF_companyAddressInfo_CL.getText(), 
								JTF_companyPhoneInfo_CL.getText(), JTF_companyCIFInfo_CL.getText(), JTF_companyRegNRInfo_CL.getText(), JTF_companyBankInfo_CL.getText(), JTF_companyIBANInfo_CL.getText(), JTF_companyBranchOfficeInfo_CL.getText());
					}else {
						updateNaturalClient(selectedClientID, JTF_clientNameInfo_CL.getText(), JTF_clientPhoneInfo_CL.getText());
					}
				}else {
					System.out.println("You have to select a client first!");
				}
			}
		});
		JB_updateClient_CL.setBounds(70, 621, 116, 37);
		JP_clientInfo_CL.add(JB_updateClient_CL);
		
		JB_deleteClient_CL = new JButton("Delete");
		JB_deleteClient_CL.setEnabled(false);
		JB_deleteClient_CL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(selectedClientID>0) {
					if(DeleteConfirmation()) {
						deleteClient(selectedClientID);
					}
				}else {
					System.out.println("You have to select a client first!");
				}
			}
		});
		JB_deleteClient_CL.setBounds(240, 621, 116, 37);
		JP_clientInfo_CL.add(JB_deleteClient_CL);
		
		JB_selectClient_CL = new JButton("Selectare");
		JB_selectClient_CL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				getClientByID(selectedClientID);
				if(previousPanel.equals("panelANS")) {
					nextPanel = panelANS;
					
					JTF_clientName_ANS.setText(JTF_clientNameInfo_CL.getText());
					JTF_selectedClientName_ANS.setVisible(true);
					JTF_selectedClientName_ANS.setText(selectedClient.getContactname());
				}else if(previousPanel.equals("panelANR")) {
					nextPanel = panelANR;
					
					JL_selectClient_ANR.setText(selectedClient.getContactname());
				}	
				PanelNavigationHelper(panelCL, nextPanel);
				
				JB_selectClient_CL.setVisible(false);
				JB_updateClient_CL.setVisible(true);
				JB_deleteClient_CL.setVisible(true);	
			}
		});
		JB_selectClient_CL.setEnabled(false);
		JB_selectClient_CL.setVisible(false);
		JB_selectClient_CL.setBounds(70, 495, 286, 50);
		JP_clientInfo_CL.add(JB_selectClient_CL);
		
		JButton JB_addNewClient_CL = new JButton("Adauga client nou");
		JB_addNewClient_CL.setBounds(70, 558, 286, 50);
		JP_clientInfo_CL.add(JB_addNewClient_CL);
		
		JPanel JP_clientQuickSearch_CL = new JPanel();
		JP_clientQuickSearch_CL.setBounds(434, 97, 1356, 37);
		panelCL.add(JP_clientQuickSearch_CL);
		JP_clientQuickSearch_CL.setLayout(null);
		
		JTF_clientQuickSearchByName_CL = new JTextField();
		
		//Quick search methods
		
		JTF_clientQuickSearchByName_CL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				comboFilter(JT_clients_CL,  
						new String[]{JTF_clientQuickSearchByName_CL.getText(), JTF_clientQuickSearchByPhone_CL.getText(), JTF_clientQuickSearchByStatus_CL.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		
		JTF_clientQuickSearchByName_CL.setBounds(0, 13, 275, 22);
		JP_clientQuickSearch_CL.add(JTF_clientQuickSearchByName_CL);
		JTF_clientQuickSearchByName_CL.setColumns(10);
		
		JTF_clientQuickSearchByPhone_CL = new JTextField();
		JTF_clientQuickSearchByPhone_CL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				comboFilter(JT_clients_CL,  
						new String[]{JTF_clientQuickSearchByName_CL.getText(), JTF_clientQuickSearchByPhone_CL.getText(), JTF_clientQuickSearchByStatus_CL.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_clientQuickSearchByPhone_CL.setColumns(10);
		JTF_clientQuickSearchByPhone_CL.setBounds(566, 13, 275, 22);
		JP_clientQuickSearch_CL.add(JTF_clientQuickSearchByPhone_CL);
		
		JTF_clientQuickSearchByStatus_CL = new JTextField();
		JTF_clientQuickSearchByStatus_CL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				comboFilter(JT_clients_CL,  
						new String[]{JTF_clientQuickSearchByName_CL.getText(), JTF_clientQuickSearchByPhone_CL.getText(), JTF_clientQuickSearchByStatus_CL.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_clientQuickSearchByStatus_CL.setColumns(10);
		JTF_clientQuickSearchByStatus_CL.setBounds(1079, 13, 275, 22);
		JP_clientQuickSearch_CL.add(JTF_clientQuickSearchByStatus_CL);
		
		JLabel exitCL = new JLabel("");
		exitCL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitCL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitCL.setToolTipText("EXIT");
		exitCL.setHorizontalAlignment(SwingConstants.CENTER);
		exitCL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit_32.png")));
		exitCL.setBounds(1758, 10, 32, 32);
		panelCL.add(exitCL);
		
		JLabel backCL = new JLabel("");
		backCL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				
				if(previousPanel.equals("panelDB")) {
					nextPanel = panelDB;
				}else {
					if(previousPanel.equals("panelANS")) {
						nextPanel = panelANS;
					}
					if(previousPanel.equals("panelANR")) {
						nextPanel = panelANR;
					}
					
					JB_selectClient_CL.setVisible(false);
					JB_updateClient_CL.setVisible(true);
					JB_deleteClient_CL.setVisible(true);
				}
				
				//add textfield clears
				
				PanelNavigationHelper(panelCL, nextPanel);
			}
		});
		backCL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backCL.setToolTipText("BACK");
		backCL.setHorizontalAlignment(SwingConstants.CENTER);
		backCL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/return_32.png")));
		backCL.setBounds(10, 10, 32, 32);
		panelCL.add(backCL);
		
		JLabel reloadTable = new JLabel("");
		reloadTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetDefaultTable(JT_clients_CL, new String[]{"ID", "Numele clientului", "Numarul de telefon", "Firm?"});	
				LoadClients();
			}
		});
		reloadTable.setToolTipText("Reload table");
		reloadTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload_32.png")));
		reloadTable.setBounds(1670, 10, 32, 32);
		panelCL.add(reloadTable);
		
		JLabel TinyCard_addNewClient_CL = new JLabel("");
		TinyCard_addNewClient_CL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add_32.png")));
		TinyCard_addNewClient_CL.setToolTipText("Reload table");
		TinyCard_addNewClient_CL.setBounds(1626, 10, 32, 32);
		panelCL.add(TinyCard_addNewClient_CL);
		
		JLabel label = new JLabel("");
		label.setToolTipText("EXIT");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(1714, 10, 32, 32);
		panelCL.add(label);
		
		///////////////////////////////////////////////
		//--------//Auto Piece List Section//--------//
		//////////////////////////////////////////////
		
		panelAPL = new JPanel();
		panelAPL.setName("panelAPL");
		contentPane.add(panelAPL, "name_1653769756360800");
		panelAPL.setLayout(null);
		
		JScrollPane JSP_pieces_APL = new JScrollPane();
		JSP_pieces_APL.setBounds(436, 140, 849, 445);
		panelAPL.add(JSP_pieces_APL);
		
		JT_pieces_APL = new JTable();
		JT_pieces_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_pieces_APL.convertRowIndexToModel(JT_pieces_APL.getSelectedRow());
				TableModel model = JT_pieces_APL.getModel();
				JTF_pieceIDInfo_APL.setText(model.getValueAt(index, 0).toString());
				JTF_pieceNameInfo_APL.setText(model.getValueAt(index, 1)!=null?model.getValueAt(index, 1).toString():"");
				JTF_pieceUnitNameInfo_APL.setText(model.getValueAt(index, 2)!=null?model.getValueAt(index, 2).toString():"");
				selectedPieceID = JTF_pieceIDInfo_APL.getText();
				
				if(previousPanel.equals("panelDB")) {
				    List<JButton> jb_list = new ArrayList<JButton>();
				    jb_list.add(JB_updatePiece_APL);
				    jb_list.add(JB_deletePiece_APL);
				    
				    GeneralResetter(null, null, jb_list, null, true);
				}else {
					JB_selectPiece_APL.setEnabled(true);
				}
	
			}
		});
		JSP_pieces_APL.setViewportView(JT_pieces_APL);
		
		JPanel JP_pieceInfo_APL = new JPanel();
		JP_pieceInfo_APL.setBounds(12, 97, 412, 488);
		panelAPL.add(JP_pieceInfo_APL);
		JP_pieceInfo_APL.setLayout(null);
		
		JLabel JL_pieceDetails_APL = new JLabel("Detalii piesului:");
		JL_pieceDetails_APL.setBounds(145, 13, 134, 20);
		JL_pieceDetails_APL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_pieceInfo_APL.add(JL_pieceDetails_APL);
		
		JLabel pieceIDInfo = new JLabel("Piece ID:");
		pieceIDInfo.setBounds(12, 56, 107, 16);
		JP_pieceInfo_APL.add(pieceIDInfo);
		
		JTF_pieceIDInfo_APL = new JTextField();
		JTF_pieceIDInfo_APL.setEditable(false);
		JTF_pieceIDInfo_APL.setBounds(131, 53, 269, 22);
		JP_pieceInfo_APL.add(JTF_pieceIDInfo_APL);
		JTF_pieceIDInfo_APL.setColumns(10);
		
		JLabel pieceNameInfo = new JLabel("Numele piecei:");
		pieceNameInfo.setBounds(12, 85, 107, 16);
		JP_pieceInfo_APL.add(pieceNameInfo);
		
		JTF_pieceNameInfo_APL = new JTextField();
		JTF_pieceNameInfo_APL.setBounds(131, 82, 269, 22);
		JP_pieceInfo_APL.add(JTF_pieceNameInfo_APL);
		JTF_pieceNameInfo_APL.setColumns(10);
		
		JLabel pieceUnitInfo = new JLabel("Unit:");
		pieceUnitInfo.setBounds(12, 114, 103, 16);
		JP_pieceInfo_APL.add(pieceUnitInfo);
		
		JTF_pieceUnitNameInfo_APL = new JTextField();
		JTF_pieceUnitNameInfo_APL.setBounds(131, 111, 269, 22);
		JP_pieceInfo_APL.add(JTF_pieceUnitNameInfo_APL);
		JTF_pieceUnitNameInfo_APL.setColumns(10);
		
		JB_updatePiece_APL = new JButton("Update");
		JB_updatePiece_APL.setEnabled(false);
		JB_updatePiece_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JTF_pieceIDInfo_APL!=null) {
					updateAutoPiece(JTF_pieceIDInfo_APL.getText(), JTF_pieceNameInfo_APL.getText(), JTF_pieceUnitNameInfo_APL.getText());
				}else {
					System.out.println("Please select an auto piece first!");
				}
			}
		});
		JB_updatePiece_APL.setBounds(69, 426, 116, 37);
		JP_pieceInfo_APL.add(JB_updatePiece_APL);
		
		JB_deletePiece_APL = new JButton("Delete");
		JB_deletePiece_APL.setEnabled(false);
		JB_deletePiece_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!JTF_pieceIDInfo_APL.getText().isEmpty()) {
					if(DeleteConfirmation()) {
						deleteAutoPiece(JTF_pieceIDInfo_APL.getText());
					}
				}else {
					System.out.println("You have to select an auto piece before.");
				}
			}
		});
		JB_deletePiece_APL.setBounds(239, 426, 116, 37);
		JP_pieceInfo_APL.add(JB_deletePiece_APL);
		
		JB_selectPiece_APL = new JButton("Selectare");
		JB_selectPiece_APL.setVisible(false);
		JB_selectPiece_APL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				if(previousPanel.equals("panelANS")) {
					nextPanel = panelANS;
					
					JTL_pieceID_ANS.setText(JTF_pieceIDInfo_APL.getText());
				}else if(previousPanel.equals("panelAR")) {
					nextPanel = panelAR;
					
					if(selectPiece.equals("from")) {
						JTF_pieceNameFrom_AR.setText(JTF_pieceIDInfo_APL.getText());
					}else if(selectPiece.equals("to")) {
						JTF_pieceNameTo_AR.setText(JTF_pieceIDInfo_APL.getText());
					}
					
					selectPiece=null;
				}
				
				PanelNavigationHelper(panelAPL, nextPanel);
				
				JB_selectPiece_APL.setVisible(false);
				JB_updatePiece_APL.setVisible(true);
				JB_deletePiece_APL.setVisible(true);
			}
		});
		JB_selectPiece_APL.setEnabled(false);
		JB_selectPiece_APL.setBounds(69, 185, 286, 71);
		JP_pieceInfo_APL.add(JB_selectPiece_APL);
		
		JLabel reloadPiecesTable = new JLabel("");
		reloadPiecesTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadPiecesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetDefaultTable(JT_pieces_APL, new String[]{"COD", "Nume", "Unitate/Masura"});
				LoadPieces();
			}
		});
		reloadPiecesTable.setToolTipText("Reload table");
		reloadPiecesTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload0.png")));
		reloadPiecesTable.setBounds(1179, 13, 45, 32);
		panelAPL.add(reloadPiecesTable);
		
		JPanel JP_pieceQuickSearch_APL = new JPanel();
		JP_pieceQuickSearch_APL.setBounds(436, 97, 849, 37);
		panelAPL.add(JP_pieceQuickSearch_APL);
		JP_pieceQuickSearch_APL.setLayout(null);
		
		JLabel JL_pieceQuickSearch_APL = new JLabel("Căutare:");
		JL_pieceQuickSearch_APL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JL_pieceQuickSearch_APL.setBounds(12, 13, 60, 16);
		JP_pieceQuickSearch_APL.add(JL_pieceQuickSearch_APL);
		
		JTF_pieceQuickSearch_APL = new JTextField();
		
		//Quick search method
		
		JTF_pieceQuickSearch_APL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				simpleFilter(JT_pieces_APL, JTF_pieceQuickSearch_APL.getText());
			}
		});
		
		JTF_pieceQuickSearch_APL.setBounds(84, 11, 753, 22);
		JP_pieceQuickSearch_APL.add(JTF_pieceQuickSearch_APL);
		JTF_pieceQuickSearch_APL.setColumns(10);
		
		JLabel exitAPL = new JLabel("");
		exitAPL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitAPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitAPL.setToolTipText("EXIT");
		exitAPL.setHorizontalAlignment(SwingConstants.CENTER);
		exitAPL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitAPL.setBounds(1236, 13, 59, 32);
		panelAPL.add(exitAPL);
		
		JLabel backAPL = new JLabel("");
		backAPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				if(previousPanel.equals("panelDB")) {
					nextPanel = panelDB;
				}else {
					if(previousPanel.equals("panelANS") || previousPanel.equals("panelAR")){ //Optimize IT
						if(previousPanel.equals("panelANS")) {
							nextPanel = panelANS;
						}else if(previousPanel.equals("panelAR")) {
							nextPanel = panelAR;		
							selectPiece = null;
						}
						JB_selectPiece_APL.setVisible(false);
						JB_updatePiece_APL.setVisible(true);
						JB_deletePiece_APL.setVisible(true);
					}
				}	
				PanelNavigationHelper(panelAPL, nextPanel);
			}
		});
		backAPL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backAPL.setToolTipText("BACK");
		backAPL.setHorizontalAlignment(SwingConstants.CENTER);
		backAPL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backAPL.setBounds(12, 13, 52, 32);
		panelAPL.add(backAPL);
		
		////////////////////////////////////////////
		//--------//Add Replace Section//--------//
		///////////////////////////////////////////
		
		panelAR = new JPanel();
		panelAR.setName("panelAR");
		contentPane.add(panelAR, "name_1892004559992900");
		
		JPanel JP_chosePieceFrom_AR = new JPanel();
		JP_chosePieceFrom_AR.setBounds(12, 89, 1273, 82);
		panelAR.add(JP_chosePieceFrom_AR);
		JP_chosePieceFrom_AR.setLayout(null);
		
		JLabel JL_pieceNameFrom_AR = new JLabel("Numele piesei:");
		JL_pieceNameFrom_AR.setFont(new Font("Tahoma", Font.BOLD, 18));
		JL_pieceNameFrom_AR.setBounds(12, 27, 134, 21);
		JP_chosePieceFrom_AR.add(JL_pieceNameFrom_AR);
		
		JTF_pieceNameFrom_AR = new JTextField();
		JTF_pieceNameFrom_AR.setBounds(158, 28, 453, 22);
		JP_chosePieceFrom_AR.add(JTF_pieceNameFrom_AR);
		JTF_pieceNameFrom_AR.setColumns(10);
		
		JButton JB_pieceNameFromSearch_AR = new JButton("Căutare");
		JB_pieceNameFromSearch_AR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelAR, panelAPL);
				
				SetDefaultTable(JT_pieces_APL, new String[]{"COD", "Nume", "Unitate/Masura"});
				LoadPieces();
				
				selectPiece = "from";
				
				JB_selectPiece_APL.setVisible(true);
				JB_updatePiece_APL.setVisible(false);
				JB_deletePiece_APL.setVisible(false);
			}
		});
		JB_pieceNameFromSearch_AR.setBounds(732, 27, 97, 25);
		JP_chosePieceFrom_AR.add(JB_pieceNameFromSearch_AR);
		
		JButton JB_pieceNameFromSelect_AR = new JButton("Selectare");
		JB_pieceNameFromSelect_AR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoadReplacables(JTF_pieceNameFrom_AR.getText());
				JTF_newReplacable_AR.setText(JTF_pieceNameFrom_AR.getText());
				JTF_pieceNameTo_AR.setText(null);
				JB_deleteReplacable_AR.setEnabled(false);
			}
		});
		JB_pieceNameFromSelect_AR.setBounds(623, 27, 97, 25);
		JP_chosePieceFrom_AR.add(JB_pieceNameFromSelect_AR);
		
		JPanel JP_showReplaceablePieces_AR = new JPanel();
		JP_showReplaceablePieces_AR.setBounds(12, 184, 1273, 251);
		panelAR.add(JP_showReplaceablePieces_AR);
		JP_showReplaceablePieces_AR.setLayout(null);
		
		JPanel JP_pieceInfo_AR = new JPanel();
		JP_pieceInfo_AR.setBounds(0, 0, 368, 251);
		JP_showReplaceablePieces_AR.add(JP_pieceInfo_AR);
		JP_pieceInfo_AR.setLayout(null);
		
		JLabel JL_pieceIDInfo_AR = new JLabel("ID:");
		JL_pieceIDInfo_AR.setBounds(12, 73, 56, 16);
		JP_pieceInfo_AR.add(JL_pieceIDInfo_AR);
		
		JLabel JL_pieceNameInfo_AR = new JLabel("Numele:");
		JL_pieceNameInfo_AR.setBounds(12, 102, 56, 16);
		JP_pieceInfo_AR.add(JL_pieceNameInfo_AR);
		
		JLabel JL_pieceUnitNameInfo_AR = new JLabel("Unitate:");
		JL_pieceUnitNameInfo_AR.setBounds(12, 131, 56, 16);
		JP_pieceInfo_AR.add(JL_pieceUnitNameInfo_AR);
		
		JTF_pieceIDInfo_AR = new JTextField();
		JTF_pieceIDInfo_AR.setBounds(80, 70, 276, 22);
		JP_pieceInfo_AR.add(JTF_pieceIDInfo_AR);
		JTF_pieceIDInfo_AR.setColumns(10);
		
		JTF_pieceNameInfo_AR = new JTextField();
		JTF_pieceNameInfo_AR.setBounds(80, 99, 276, 22);
		JP_pieceInfo_AR.add(JTF_pieceNameInfo_AR);
		JTF_pieceNameInfo_AR.setColumns(10);
		
		JTF_pieceUnitNameInfo_AR = new JTextField();
		JTF_pieceUnitNameInfo_AR.setBounds(80, 128, 276, 22);
		JP_pieceInfo_AR.add(JTF_pieceUnitNameInfo_AR);
		JTF_pieceUnitNameInfo_AR.setColumns(10);
		
		JB_deleteReplacable_AR = new JButton("Ștergere");
		JB_deleteReplacable_AR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!JTF_pieceIDInfo_AR.getText().isEmpty()) {
					if(DeleteConfirmation()) {
						DeleteFromReplaced(JTF_pieceIDInfo_AR.getText());
					}
				}else {
					System.out.println("You have to select an auto pice before.");
				}
			}
		});
		JB_deleteReplacable_AR.setEnabled(false);
		JB_deleteReplacable_AR.setBounds(101, 181, 160, 43);
		JP_pieceInfo_AR.add(JB_deleteReplacable_AR);
		
		JLabel JL_pieceDetails_AR = new JLabel("Detalii piesei");
		JL_pieceDetails_AR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JL_pieceDetails_AR.setBounds(130, 13, 98, 22);
		JP_pieceInfo_AR.add(JL_pieceDetails_AR);
		
		JScrollPane JSP_pieces_AR = new JScrollPane();
		JSP_pieces_AR.setBounds(380, 0, 893, 251);
		JP_showReplaceablePieces_AR.add(JSP_pieces_AR);
		
		JT_pieces_AR = new JTable();
		JT_pieces_AR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_pieces_AR.getSelectedRow();
				TableModel model = JT_pieces_AR.getModel();
				JTF_pieceIDInfo_AR.setText(model.getValueAt(index, 0).toString());
				JTF_pieceNameInfo_AR.setText(model.getValueAt(index, 1)!=null?model.getValueAt(index, 1).toString():"");
				JTF_pieceUnitNameInfo_AR.setText(model.getValueAt(index, 2)!=null?model.getValueAt(index, 2).toString():"");
				JB_deleteReplacable_AR.setEnabled(true);
			}
		});
		JT_pieces_AR.setRowHeight(30);
		JT_pieces_AR.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 21));
		JT_pieces_AR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JSP_pieces_AR.setViewportView(JT_pieces_AR);
		
		JPanel JP_chosePieceTo_AR = new JPanel();
		JP_chosePieceTo_AR.setBounds(12, 448, 1273, 127);
		panelAR.add(JP_chosePieceTo_AR);
		JP_chosePieceTo_AR.setLayout(null);
		
		JLabel JL_newReplacable = new JLabel("Adauga piese de schimb nou, pentru");
		JL_newReplacable.setBounds(12, 13, 209, 16);
		JP_chosePieceTo_AR.add(JL_newReplacable);
		
		JTF_newReplacable_AR = new JTextField();
		JTF_newReplacable_AR.setEditable(false);
		JTF_newReplacable_AR.setBounds(233, 10, 234, 22);
		JP_chosePieceTo_AR.add(JTF_newReplacable_AR);
		JTF_newReplacable_AR.setColumns(10);
		
		JLabel JL_pieceNameTo_AR = new JLabel("Numele piesei:");
		JL_pieceNameTo_AR.setFont(new Font("Tahoma", Font.BOLD, 18));
		JL_pieceNameTo_AR.setBounds(12, 64, 134, 21);
		JP_chosePieceTo_AR.add(JL_pieceNameTo_AR);
		
		JTF_pieceNameTo_AR = new JTextField();
		JTF_pieceNameTo_AR.setColumns(10);
		JTF_pieceNameTo_AR.setBounds(158, 65, 453, 22);
		JP_chosePieceTo_AR.add(JTF_pieceNameTo_AR);
		
		JButton JB_pieceNameToSelect_AR = new JButton("Selectare");
		JB_pieceNameToSelect_AR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddNewAutoPieceToReplaced(JTF_newReplacable_AR.getText(),JTF_pieceNameTo_AR.getText());
			}
		});
		JB_pieceNameToSelect_AR.setBounds(623, 64, 97, 25);
		JP_chosePieceTo_AR.add(JB_pieceNameToSelect_AR);
		
		JButton JB_pieceNameToSearch_AR = new JButton("Căutare");
		JB_pieceNameToSearch_AR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelAR, panelAPL);
				
				SetDefaultTable(JT_pieces_APL, new String[]{"COD", "Nume", "Unitate/Masura"});
				LoadPieces();
				
				selectPiece = "to";
				
				JB_selectPiece_APL.setVisible(true);
				JB_updatePiece_APL.setVisible(false);
				JB_deletePiece_APL.setVisible(false);
			}
		});
		JB_pieceNameToSearch_AR.setBounds(732, 64, 97, 25);
		JP_chosePieceTo_AR.add(JB_pieceNameToSearch_AR);
		
		JLabel exitAR = new JLabel("");
		exitAR.setBounds(1236, 13, 59, 32);
		exitAR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitAR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		panelAR.setLayout(null);
		exitAR.setToolTipText("EXIT");
		exitAR.setHorizontalAlignment(SwingConstants.CENTER);
		exitAR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		panelAR.add(exitAR);
		
		JLabel reloadReplacablesTable = new JLabel("");
		reloadReplacablesTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadReplacablesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadReplacables(JTF_newReplacable_AR.getText());
			}
		});
		reloadReplacablesTable.setToolTipText("Reload table");
		reloadReplacablesTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload0.png")));
		reloadReplacablesTable.setBounds(1179, 13, 45, 32);
		panelAR.add(reloadReplacablesTable);
		
		JLabel backAR = new JLabel("");
		backAR.setBounds(12, 13, 52, 32);
		backAR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelAR, panelDB);
				
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_pieceIDInfo_AR);
				jtf_list.add(JTF_pieceNameInfo_AR);
				jtf_list.add(JTF_pieceUnitNameInfo_AR);
				jtf_list.add(JTF_pieceNameFrom_AR);
				jtf_list.add(JTF_newReplacable_AR);
				jtf_list.add(JTF_pieceNameTo_AR);
				
				List<JButton> jb_list = new ArrayList<JButton>();
				jb_list.add(JB_deleteReplacable_AR);
				
				GeneralResetter(jtf_list, null, jb_list, true, false);
			}
		});
		backAR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backAR.setToolTipText("BACK");
		backAR.setHorizontalAlignment(SwingConstants.CENTER);
		backAR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		panelAR.add(backAR);
		
		///////////////////////////////////////////////
		//--------//Add New Supplie Section//--------//
		//////////////////////////////////////////////
		
		panelANS = new JPanel();
		panelANS.setName("panelANS");
		contentPane.add(panelANS, "name_452027607461600");
		panelANS.setLayout(null);
		
		JLabel MLCard_newSupplie_ANS = new JLabel("");
		MLCard_newSupplie_ANS.setIcon(new ImageIcon(MainFrame.class.getResource("/images/cart.png")));
		MLCard_newSupplie_ANS.setBounds(12, 58, 256, 256);
		panelANS.add(MLCard_newSupplie_ANS);
		
		JLabel JB_pieceText_ANS = new JLabel("Piece ID:");
		JB_pieceText_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JB_pieceText_ANS.setBounds(280, 221, 140, 26);
		panelANS.add(JB_pieceText_ANS);
		
		JTL_pieceID_ANS = new JTextField();
		JTL_pieceID_ANS.setBounds(432, 223, 300, 22);
		panelANS.add(JTL_pieceID_ANS);
		JTL_pieceID_ANS.setColumns(10);
		
		JButton JB_pieceSearch_ANS = new JButton("Căutare");
		JB_pieceSearch_ANS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelANS, panelAPL);
				
				SetDefaultTable(JT_pieces_APL, new String[]{"COD", "Nume", "Unitate/Masura"});
				LoadPieces();
				
				JB_selectPiece_APL.setVisible(true);
				JB_updatePiece_APL.setVisible(false);
				JB_deletePiece_APL.setVisible(false);
			}
		});
		JB_pieceSearch_ANS.setBounds(280, 256, 220, 25);
		panelANS.add(JB_pieceSearch_ANS);
		
		JButton JB_addPieceToList_ANS = new JButton("Adauga pe list");
		JB_addPieceToList_ANS.setFont(new Font("Tahoma", Font.BOLD, 16));
		JB_addPieceToList_ANS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(getPieceByID(JTL_pieceID_ANS.getText())) {
					List<JTextField> jtf_list = new ArrayList<JTextField>();
					jtf_list.add(JTL_pieceID_ANS);
					jtf_list.add(JTF_pieceQuantity_ANS);
					jtf_list.add(JTF_piecePriceIN_ANS);
					jtf_list.add(JTF_piecePriceOUT_ANS);
					jtf_list.add(JTF_pieceVAT_ANS);
					
					AddNewAutoPieceToReception(jtf_list);
					
					GeneralResetter(jtf_list, null, null, true, null);
				}else {
					MissingStatementInformer("Auto piece with this ID is not found!");
				}
			}
		});
		JB_addPieceToList_ANS.setBounds(1008, 220, 180, 94);
		panelANS.add(JB_addPieceToList_ANS);
		
		JLabel JL_clientName_ANS = new JLabel("Furnizor:");
		JL_clientName_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_clientName_ANS.setBounds(280, 58, 140, 24);
		panelANS.add(JL_clientName_ANS);
		
		JTF_clientName_ANS = new JTextField();
		JTF_clientName_ANS.setColumns(10);
		JTF_clientName_ANS.setBounds(432, 60, 300, 22);
		panelANS.add(JTF_clientName_ANS);
		
		JButton JB_clientSelect_ANS = new JButton("Selecteaza");
		JB_clientSelect_ANS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(getClientIDByName(JTF_clientName_ANS.getText())) {
					getClientByID(selectedClientID);
					JTF_selectedClientName_ANS.setVisible(true);
					JTF_selectedClientName_ANS.setText(selectedClient.getContactname());
				}
			}
		});
		JB_clientSelect_ANS.setBounds(744, 58, 140, 25);
		panelANS.add(JB_clientSelect_ANS);
		
		JButton JB_addNewLegalClient_ANS = new JButton("Adauga nou");
		JB_addNewLegalClient_ANS.setBounds(1048, 58, 140, 25);
		panelANS.add(JB_addNewLegalClient_ANS);
		
		JLabel JB_invoiceNR_ANS = new JLabel("NR de factura:");
		JB_invoiceNR_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JB_invoiceNR_ANS.setBounds(280, 145, 140, 25);
		panelANS.add(JB_invoiceNR_ANS);
		
		JTF_invoiceNR_ANS = new JTextField();
		JTF_invoiceNR_ANS.setBounds(432, 148, 756, 22);
		panelANS.add(JTF_invoiceNR_ANS);
		JTF_invoiceNR_ANS.setColumns(10);
		
		final JDateChooser JDC_dateIN_ANS = new JDateChooser();
		JDC_dateIN_ANS.setBounds(432, 186, 300, 22);
		panelANS.add(JDC_dateIN_ANS);
		
		final JDateChooser JDC_dueDate_ANS = new JDateChooser();
		JDC_dueDate_ANS.setBounds(896, 186, 292, 22);
		panelANS.add(JDC_dueDate_ANS);
		
		JLabel JL_dateIN_ANS = new JLabel("Date in:");
		JL_dateIN_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_dateIN_ANS.setBounds(280, 183, 140, 25);
		panelANS.add(JL_dateIN_ANS);
		
		JLabel JL_dueDate_ANS = new JLabel("Due date:");
		JL_dueDate_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_dueDate_ANS.setBounds(744, 186, 140, 22);
		panelANS.add(JL_dueDate_ANS);
		
		JButton JB_addNewPiece_ANS = new JButton("Adauga nou");
		JB_addNewPiece_ANS.setBounds(512, 256, 220, 25);
		panelANS.add(JB_addNewPiece_ANS);
		
		JScrollPane SP_pieces_ANS = new JScrollPane();
		SP_pieces_ANS.setBounds(12, 327, 1176, 248);
		panelANS.add(SP_pieces_ANS);
		
		JT_pieces_ANS = new JTable();
		SP_pieces_ANS.setViewportView(JT_pieces_ANS);
		
		JButton JB_saveSupplie_ANS = new JButton("OK");
		JB_saveSupplie_ANS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(selectedClient!=null) {
					DefaultTableModel dtm = (DefaultTableModel) JT_pieces_ANS.getModel();
					if(dtm.getRowCount()>0) {
						List<JTextField> jtf_list = new ArrayList<JTextField>();
						jtf_list.add(JTF_clientName_ANS);
						jtf_list.add(JTF_invoiceNR_ANS);
						jtf_list.add(JTL_pieceID_ANS);
						jtf_list.add(JTF_pieceQuantity_ANS);
						jtf_list.add(JTF_piecePriceIN_ANS);
						jtf_list.add(JTF_piecePriceOUT_ANS);
						jtf_list.add(JTF_pieceVAT_ANS);
						
						List<JDateChooser> jdc_list = new ArrayList<JDateChooser>();
						jdc_list.add(JDC_dateIN_ANS);
						jdc_list.add(JDC_dueDate_ANS);
						
						SaveReception(jtf_list, jdc_list);
						
						//needs improvment
						GeneralResetter(jtf_list, null, null, true, null);
						selectedClient=null;
						dtm.setRowCount(0);
						JDC_dateIN_ANS.setCalendar(null);
						JDC_dueDate_ANS.setCalendar(null);
						
						JTF_selectedClientName_ANS.setText(null);
						JTF_selectedClientName_ANS.setVisible(false);
					}else {
						MissingStatementInformer("You have to add values first to the table!");
					}
				}else {
					MissingStatementInformer("You have to select a client first!");
				}
			}
		});
		JB_saveSupplie_ANS.setFont(new Font("Tahoma", Font.BOLD, 18));
		JB_saveSupplie_ANS.setBounds(1200, 327, 85, 248);
		panelANS.add(JB_saveSupplie_ANS);
		
		JButton JB_clientSearch_ANS = new JButton("Căutare");
		JB_clientSearch_ANS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelANS, panelCL);
				
				SetDefaultTable(JT_clients_CL, new String[]{"ID", "Numele clientului", "Numarul de telefon", "Firm?"});				
				LoadClients();
				
				JTF_clientQuickSearchByStatus_CL.setText("true");
				
				comboFilter(JT_clients_CL,  
						new String[]{JTF_clientQuickSearchByName_CL.getText(), JTF_clientQuickSearchByPhone_CL.getText(), JTF_clientQuickSearchByStatus_CL.getText()}, 
						new int[] {1, 2, 3});
				
				JB_selectClient_CL.setVisible(true);
				JB_updateClient_CL.setVisible(false);
				JB_deleteClient_CL.setVisible(false);
			}
		});
		JB_clientSearch_ANS.setBounds(896, 58, 140, 25);
		panelANS.add(JB_clientSearch_ANS);
		
		JTF_selectedClientName_ANS = new JTextField();
		JTF_selectedClientName_ANS.setForeground(Color.BLACK);
		JTF_selectedClientName_ANS.setHorizontalAlignment(SwingConstants.CENTER);
		JTF_selectedClientName_ANS.setFont(new Font("Tahoma", Font.BOLD, 22));
		JTF_selectedClientName_ANS.setEditable(false);
		JTF_selectedClientName_ANS.setVisible(false);
		JTF_selectedClientName_ANS.setColumns(10);
		JTF_selectedClientName_ANS.setBounds(280, 97, 908, 35);
		panelANS.add(JTF_selectedClientName_ANS);
		
		JLabel JB_pieceQuantity_ANS = new JLabel("Quantity:");
		JB_pieceQuantity_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JB_pieceQuantity_ANS.setBounds(280, 288, 140, 26);
		panelANS.add(JB_pieceQuantity_ANS);
		
		JTF_pieceQuantity_ANS = new JTextField();
		JTF_pieceQuantity_ANS.setColumns(10);
		JTF_pieceQuantity_ANS.setBounds(432, 290, 300, 22);
		panelANS.add(JTF_pieceQuantity_ANS);
		
		JLabel JB_piecePriceOUT_ANS = new JLabel("Price OUT:");
		JB_piecePriceOUT_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JB_piecePriceOUT_ANS.setBounds(744, 256, 140, 26);
		panelANS.add(JB_piecePriceOUT_ANS);
		
		JTF_piecePriceOUT_ANS = new JTextField();
		JTF_piecePriceOUT_ANS.setColumns(10);
		JTF_piecePriceOUT_ANS.setBounds(896, 257, 100, 22);
		panelANS.add(JTF_piecePriceOUT_ANS);
		
		JLabel JB_piecePriceIN_ANS = new JLabel("Price IN:");
		JB_piecePriceIN_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JB_piecePriceIN_ANS.setBounds(744, 221, 91, 26);
		panelANS.add(JB_piecePriceIN_ANS);
		
		JTF_piecePriceIN_ANS = new JTextField();
		JTF_piecePriceIN_ANS.setColumns(10);
		JTF_piecePriceIN_ANS.setBounds(896, 221, 100, 22);
		panelANS.add(JTF_piecePriceIN_ANS);
		
		JLabel exitANS = new JLabel("");
		exitANS.setBounds(1236, 13, 59, 32);
		exitANS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitANS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitANS.setToolTipText("EXIT");
		exitANS.setHorizontalAlignment(SwingConstants.CENTER);
		exitANS.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		panelANS.add(exitANS);
		
		JLabel backANS = new JLabel("");
		backANS.setBounds(12, 13, 52, 32);
		backANS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelANS, panelDB);
			}
		});
		backANS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backANS.setToolTipText("BACK");
		backANS.setHorizontalAlignment(SwingConstants.CENTER);
		backANS.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		panelANS.add(backANS);
		
		JLabel JB_pieceTVA_ANS = new JLabel("TVA:");
		JB_pieceTVA_ANS.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JB_pieceTVA_ANS.setBounds(744, 288, 140, 26);
		panelANS.add(JB_pieceTVA_ANS);
		
		JTF_pieceVAT_ANS = new JTextField();
		JTF_pieceVAT_ANS.setColumns(10);
		JTF_pieceVAT_ANS.setBounds(896, 293, 100, 22);
		panelANS.add(JTF_pieceVAT_ANS);
		
		///////////////////////////////////////////////
		//--------//Add New Auto Piece//--------///////
		///////////////////////////////////////////////
		
		panelAAP = new JPanel();
		panelAAP.setName("panelAAP");
		contentPane.add(panelAAP, "name_874772029786500");
		panelAAP.setLayout(null);
		
		JLabel MLCard_newPiece_AAP = new JLabel("");
		MLCard_newPiece_AAP.setIcon(new ImageIcon(MainFrame.class.getResource("/images/autoPiece0.png")));
		MLCard_newPiece_AAP.setBounds(12, 58, 254, 254);
		panelAAP.add(MLCard_newPiece_AAP);
		
		JLabel JL_autoPieceID_AAP = new JLabel("ID:");
		JL_autoPieceID_AAP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_autoPieceID_AAP.setBounds(278, 58, 140, 24);
		panelAAP.add(JL_autoPieceID_AAP);
		
		JTF_autoPieceID_AAP = new JTextField();
		JTF_autoPieceID_AAP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(JTF_autoPieceID_AAP.getBorder()!=null) {
					JTF_autoPieceID_AAP.setBorder(null);
				}
			}
		});
		JTF_autoPieceID_AAP.setColumns(10);
		JTF_autoPieceID_AAP.setBounds(430, 60, 300, 22);
		panelAAP.add(JTF_autoPieceID_AAP);
		
		JLabel JL_autoPieceName_AAP = new JLabel("Nume:");
		JL_autoPieceName_AAP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_autoPieceName_AAP.setBounds(278, 95, 140, 24);
		panelAAP.add(JL_autoPieceName_AAP);
		
		JTF_autoPieceName_AAP = new JTextField();
		JTF_autoPieceName_AAP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_autoPieceName_AAP.getBorder()!=null) {
					JTF_autoPieceName_AAP.setBorder(null);
				}
			}
		});
		JTF_autoPieceName_AAP.setColumns(10);
		JTF_autoPieceName_AAP.setBounds(430, 97, 300, 22);
		panelAAP.add(JTF_autoPieceName_AAP);
		
		JLabel JL_autoPieceUniteName_AAP = new JLabel("Unitate:");
		JL_autoPieceUniteName_AAP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_autoPieceUniteName_AAP.setBounds(278, 132, 140, 24);
		panelAAP.add(JL_autoPieceUniteName_AAP);
		
		JTF_autoPieceUniteName_AAP = new JTextField();
		JTF_autoPieceUniteName_AAP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_autoPieceUniteName_AAP.getBorder()!=null) {
					JTF_autoPieceUniteName_AAP.setBorder(null);
				}
			}
		});
		JTF_autoPieceUniteName_AAP.setColumns(10);
		JTF_autoPieceUniteName_AAP.setBounds(430, 134, 300, 22);
		panelAAP.add(JTF_autoPieceUniteName_AAP);
		
		JButton JB_savePiece_AAP = new JButton("Salveaza");
		JB_savePiece_AAP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_autoPieceID_AAP);
				jtf_list.add(JTF_autoPieceName_AAP);
				jtf_list.add(JTF_autoPieceUniteName_AAP);
				
				if(InputValidation(jtf_list)) {
					SaveAutoPiece(jtf_list);
					
					PanelNavigationHelper(panelAAP, panelDB);
									
					GeneralResetter(jtf_list, null, null, true, null);	
				}else {
					//Set warning pop-up here
					unsavedInformer();
				}
			}
		});
		JB_savePiece_AAP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JB_savePiece_AAP.setBounds(430, 169, 197, 41);
		panelAAP.add(JB_savePiece_AAP);
		
		JLabel exitAAP = new JLabel("");
		exitAAP.setBounds(1236, 13, 59, 32);
		exitAAP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitAAP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitAAP.setToolTipText("EXIT");
		exitAAP.setHorizontalAlignment(SwingConstants.CENTER);
		exitAAP.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		panelAAP.add(exitAAP);
		
		JLabel backAAP = new JLabel("");
		backAAP.setBounds(12, 13, 52, 32);
		backAAP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_autoPieceID_AAP);
				jtf_list.add(JTF_autoPieceName_AAP);
				jtf_list.add(JTF_autoPieceUniteName_AAP);
				
				//I can reduce the condition tree to one branch but then the confirmation to go back will be displayed if all text fields are empty as well
				//not just when there is some text in them, and I did not want that
				
				if(unsavedChecker(jtf_list)) {
					if(backDialog()) {
						PanelNavigationHelper(panelAAP, panelDB);
						
						TextFieldBorderResetter(jtf_list);
						GeneralResetter(jtf_list, null, null, true, null);
					}
				}else {
					PanelNavigationHelper(panelAAP, panelDB);
					
					TextFieldBorderResetter(jtf_list);
				}
			}
		});
		backAAP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backAAP.setToolTipText("BACK");
		backAAP.setHorizontalAlignment(SwingConstants.CENTER);
		backAAP.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		panelAAP.add(backAAP);
		
		///////////////////////////////////////////
		//--------//Add New Job Section//--------//
		///////////////////////////////////////////
		
		panelANJ = new JPanel();
		contentPane.add(panelANJ, "name_1325770650059500");
		panelANJ.setLayout(null);
		
		JLabel MLCard_newJob_ANJ = new JLabel("");
		MLCard_newJob_ANJ.setIcon(new ImageIcon(MainFrame.class.getResource("/images/addJob1.png")));
		MLCard_newJob_ANJ.setBounds(12, 58, 512, 512);
		panelANJ.add(MLCard_newJob_ANJ);
		
		JLabel JL_jobName_ANJ = new JLabel("Denumirea lucrarii:");
		JL_jobName_ANJ.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_jobName_ANJ.setBounds(536, 58, 180, 24);
		panelANJ.add(JL_jobName_ANJ);
		
		JTF_jobName_ANJ = new JTextField();
		JTF_jobName_ANJ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(JTF_jobName_ANJ.getBorder()!=null) {
					JTF_jobName_ANJ.setBorder(null);
				}
			}
		});
		JTF_jobName_ANJ.setColumns(10);
		JTF_jobName_ANJ.setBounds(728, 58, 300, 22);
		panelANJ.add(JTF_jobName_ANJ);
		
		JLabel JB_jobPrice_ANJ = new JLabel("Tarifa lucrarii:");
		JB_jobPrice_ANJ.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JB_jobPrice_ANJ.setBounds(536, 95, 180, 24);
		panelANJ.add(JB_jobPrice_ANJ);
		
		JTF_jobPrice_ANJ = new JTextField();
		JTF_jobPrice_ANJ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_jobPrice_ANJ.getBorder()!=null) {
					JTF_jobPrice_ANJ.setBorder(null);
				}
			}
		});
		JTF_jobPrice_ANJ.setColumns(10);
		JTF_jobPrice_ANJ.setBounds(728, 95, 300, 22);
		panelANJ.add(JTF_jobPrice_ANJ);
		
		JButton JB_saveJob_ANJ = new JButton("Salveaza");
		JB_saveJob_ANJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_jobName_ANJ);
				jtf_list.add(JTF_jobPrice_ANJ);
				
				if(InputValidation(jtf_list)) {
					SaveJob(jtf_list);
					
					PanelNavigationHelper(panelANJ, panelDB);
									
					GeneralResetter(jtf_list, null, null, true, null);	
				}else {
					//Set warning pop-up here
					unsavedInformer();
				}
			}
		});
		JB_saveJob_ANJ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JB_saveJob_ANJ.setBounds(728, 130, 197, 41);
		panelANJ.add(JB_saveJob_ANJ);
		
		JLabel exitANJ = new JLabel("");
		exitANJ.setBounds(1236, 13, 59, 32);
		exitANJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitANJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitANJ.setToolTipText("EXIT");
		exitANJ.setHorizontalAlignment(SwingConstants.CENTER);
		exitANJ.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		panelANJ.add(exitANJ);
		
		JLabel backANJ = new JLabel("");
		backANJ.setBounds(12, 13, 52, 32);
		backANJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_jobName_ANJ);
				jtf_list.add(JTF_jobPrice_ANJ);
				
				//I can reduce the condition tree to one branch but then the confirmation to go back will be displayed if all text fields are empty as well
				//not just when there is some text in them, and I did not want that
				
				if(unsavedChecker(jtf_list)) {
					if(backDialog()) {
						PanelNavigationHelper(panelANJ, panelDB);
						
						TextFieldBorderResetter(jtf_list);
						GeneralResetter(jtf_list, null, null, true, null);
					}
				}else {
					PanelNavigationHelper(panelANJ, panelDB);
					
					TextFieldBorderResetter(jtf_list);
				}
			}
		});
		backANJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backANJ.setToolTipText("BACK");
		backANJ.setHorizontalAlignment(SwingConstants.CENTER);
		backANJ.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		panelANJ.add(backANJ);
		
		/////////////////////////////////////////
		//--------//Job List Section//--------//
		////////////////////////////////////////
		
		panelJL = new JPanel();
		panelJL.setName("panelJL");
		contentPane.add(panelJL, "name_2546791077200");
		panelJL.setLayout(null);
		
		JScrollPane JSP_jobs_JL = new JScrollPane();
		JSP_jobs_JL.setBounds(436, 140, 849, 445);
		panelJL.add(JSP_jobs_JL);
		
		JT_jobs_JL = new JTable();
		JT_jobs_JL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_jobs_JL.convertRowIndexToModel(JT_jobs_JL.getSelectedRow());
				TableModel model = JT_jobs_JL.getModel();
				JTF_jobNameInfo_JL.setText(model.getValueAt(index, 1)!=null?model.getValueAt(index, 1).toString():"");
				JTF_jobPriceInfo_JL.setText(model.getValueAt(index, 2)!=null?model.getValueAt(index, 2).toString():"");
				selectedJobID = Integer.valueOf(model.getValueAt(index, 0).toString());
				
				if(previousPanel.equals("panelDB")) {
				    List<JButton> jb_list = new ArrayList<JButton>();
				    jb_list.add(JB_updateJob_JL);
				    jb_list.add(JB_deleteJob_JL);
				    
				    GeneralResetter(null, null, jb_list, null, true);
				}else if(previousPanel.equals("panelSJ")) {
					JB_selectJob_JL.setEnabled(true);
				}else {
					System.out.println("Error in panel navigation.");
				}
	
			}
		});
		JSP_jobs_JL.setViewportView(JT_jobs_JL);
		
		JPanel JP_jobInfo_JL = new JPanel();
		JP_jobInfo_JL.setBounds(12, 97, 412, 488);
		panelJL.add(JP_jobInfo_JL);
		JP_jobInfo_JL.setLayout(null);
		
		JLabel JL_jobsDetails_JL = new JLabel("Detalii jobului:");
		JL_jobsDetails_JL.setBounds(145, 13, 134, 20);
		JL_jobsDetails_JL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_jobInfo_JL.add(JL_jobsDetails_JL);
		
		JLabel JL_jobNameInfo_JL = new JLabel("Numele jobului:");
		JL_jobNameInfo_JL.setBounds(12, 85, 107, 16);
		JP_jobInfo_JL.add(JL_jobNameInfo_JL);
		
		JTF_jobNameInfo_JL = new JTextField();
		JTF_jobNameInfo_JL.setEditable(false);
		JTF_jobNameInfo_JL.setBounds(131, 82, 269, 22);
		JP_jobInfo_JL.add(JTF_jobNameInfo_JL);
		JTF_jobNameInfo_JL.setColumns(10);
		
		JLabel JL_jobPriceInfo_JL = new JLabel("Tarifa jobului:");
		JL_jobPriceInfo_JL.setBounds(12, 114, 103, 16);
		JP_jobInfo_JL.add(JL_jobPriceInfo_JL);
		
		JTF_jobPriceInfo_JL = new JTextField();
		JTF_jobPriceInfo_JL.setBounds(131, 111, 269, 22);
		JP_jobInfo_JL.add(JTF_jobPriceInfo_JL);
		JTF_jobPriceInfo_JL.setColumns(10);
		
		JB_updateJob_JL = new JButton("Update");
		JB_updateJob_JL.setEnabled(false);
		JB_updateJob_JL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(selectedJobID>0) {
					UpdateJob(JTF_jobNameInfo_JL.getText(), Float.valueOf(JTF_jobPriceInfo_JL.getText()));
					
					panelJLResetter();
				}
			}
		});
		JB_updateJob_JL.setBounds(69, 426, 116, 37);
		JP_jobInfo_JL.add(JB_updateJob_JL);
		
		JB_deleteJob_JL = new JButton("Delete");
		JB_deleteJob_JL.setEnabled(false);
		JB_deleteJob_JL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO
			}
		});
		JB_deleteJob_JL.setBounds(239, 426, 116, 37);
		JP_jobInfo_JL.add(JB_deleteJob_JL);
		
		JB_selectJob_JL = new JButton("Selectare");
		JB_selectJob_JL.setVisible(false);
		JB_selectJob_JL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				getJobByID(selectedJobID);
				if(previousPanel.equals("panelSJ")) {
					nextPanel = panelSJ;
					
					JTF_jobName_SJ.setText(selectedJob.getJobname());
					JTF_jobPrice_SJ.setText(String.valueOf(selectedJob.getJobprice()));
				}else {
					System.out.println("Error in panel navigation.");
				}	
				PanelNavigationHelper(panelJL, nextPanel);
				
				panelJLResetter();
			}
		});
		JB_selectJob_JL.setEnabled(false);
		JB_selectJob_JL.setBounds(69, 185, 286, 71);
		JP_jobInfo_JL.add(JB_selectJob_JL);
		
		JLabel reloadJobsTable = new JLabel("");
		reloadJobsTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadJobsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JT_jobs_JL.setRowSorter(null);
				
				SetDefaultTable(JT_jobs_JL, new String[]{"ID", "Numele jobului", "Tarifa jobului"});
				LoadJobs();
				
				panelJLResetter();
			}
		});
		reloadJobsTable.setToolTipText("Reload table");
		reloadJobsTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload0.png")));
		reloadJobsTable.setBounds(1179, 13, 45, 32);
		panelJL.add(reloadJobsTable);
		
		JPanel JP_jobQuickSearch_JL = new JPanel();
		JP_jobQuickSearch_JL.setBounds(436, 97, 849, 37);
		panelJL.add(JP_jobQuickSearch_JL);
		JP_jobQuickSearch_JL.setLayout(null);
		
		JLabel JL_pieceQuickSearch_JL = new JLabel("Căutare:");
		JL_pieceQuickSearch_JL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JL_pieceQuickSearch_JL.setBounds(12, 13, 60, 16);
		JP_jobQuickSearch_JL.add(JL_pieceQuickSearch_JL);
		
		JTF_jobQuickSearch_JL = new JTextField();
		
		//Quick search method
		
		JTF_jobQuickSearch_JL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				simpleFilter(JT_jobs_JL, JTF_jobQuickSearch_JL.getText());
			}
		});	
		JTF_jobQuickSearch_JL.setBounds(84, 11, 753, 22);
		JP_jobQuickSearch_JL.add(JTF_jobQuickSearch_JL);
		JTF_jobQuickSearch_JL.setColumns(10);
		
		JLabel exitJL = new JLabel("");
		exitJL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitJL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitJL.setToolTipText("EXIT");
		exitJL.setHorizontalAlignment(SwingConstants.CENTER);
		exitJL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitJL.setBounds(1236, 13, 59, 32);
		panelJL.add(exitJL);
		
		JLabel backJL = new JLabel("");
		backJL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				
				if(previousPanel.equals("panelDB")) {
					nextPanel = panelDB;
				}else {
					//TODO
				}				
				panelJLResetter();
				
				PanelNavigationHelper(panelJL, nextPanel);
			}
		});
		backJL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backJL.setToolTipText("BACK");
		backJL.setHorizontalAlignment(SwingConstants.CENTER);
		backJL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backJL.setBounds(12, 13, 52, 32);
		panelJL.add(backJL);
		
		////////////////////////////////////////////
		//--------//Add New User Section//--------//
		////////////////////////////////////////////
		
		panelANU = new JPanel();
		contentPane.add(panelANU, "name_116966522239800");
		panelANU.setLayout(null);
		
		JLabel MLCard_newUser_ANU = new JLabel("");
		MLCard_newUser_ANU.setIcon(new ImageIcon(MainFrame.class.getResource("/images/worker1.png")));
		MLCard_newUser_ANU.setBounds(12, 58, 512, 512);
		panelANU.add(MLCard_newUser_ANU);
		
		JLabel JL_userName_ANU = new JLabel("Numele:");
		JL_userName_ANU.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_userName_ANU.setBounds(536, 58, 180, 24);
		panelANU.add(JL_userName_ANU);
		
		JTF_userName_ANU = new JTextField();
		JTF_userName_ANU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(JTF_userName_ANU.getBorder()!=null) {
					JTF_userName_ANU.setBorder(null);
				}
			}
		});
		JTF_userName_ANU.setColumns(10);
		JTF_userName_ANU.setBounds(728, 58, 300, 22);
		panelANU.add(JTF_userName_ANU);
		
		JLabel JB_userPassword_ANU = new JLabel("Parola:");
		JB_userPassword_ANU.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JB_userPassword_ANU.setBounds(536, 95, 180, 24);
		panelANU.add(JB_userPassword_ANU);
		
		JPF_userPassword_ANU = new JPasswordField();
		JPF_userPassword_ANU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(JPF_userPassword_ANU.getBorder()!=null) {
					JPF_userPassword_ANU.setBorder(null);
				}
			}
		});
		JPF_userPassword_ANU.setBounds(728, 95, 300, 24);
		panelANU.add(JPF_userPassword_ANU);
		
		JLabel JB_userPasswordRE_ANU = new JLabel("Parola incaodata:");
		JB_userPasswordRE_ANU.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JB_userPasswordRE_ANU.setBounds(536, 132, 180, 24);
		panelANU.add(JB_userPasswordRE_ANU);
		
		JPF_userPasswordRE_ANU = new JPasswordField();
		JPF_userPasswordRE_ANU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JPF_userPasswordRE_ANU.getBorder()!=null) {
					JPF_userPasswordRE_ANU.setBorder(null);
				}
			}
		});
		JPF_userPasswordRE_ANU.setBounds(728, 132, 300, 24);
		panelANU.add(JPF_userPasswordRE_ANU);
		
		JLabel JL_userRole_ANU = new JLabel("Role:");
		JL_userRole_ANU.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_userRole_ANU.setBounds(536, 169, 180, 24);
		panelANU.add(JL_userRole_ANU);
		
		JCB_userRole_ANU = new JComboBox<Role>();
		JCB_userRole_ANU.addActionListener(r -> {
	        JComboBox jcb = (JComboBox) r.getSource();
	        Role role = (Role) jcb.getSelectedItem();
	        selectedRoleID = role.getId();
	      });
		JCB_userRole_ANU.setBounds(728, 169, 300, 24);
		panelANU.add(JCB_userRole_ANU);
		
		JButton JB_saveUser_ANU = new JButton("Salveaza");
		JB_saveUser_ANU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				if(UserRegistrtationValidation(JTF_userName_ANU, JPF_userPassword_ANU, JPF_userPasswordRE_ANU)) {
					SaveUser(JTF_userName_ANU, JPF_userPassword_ANU, selectedRoleID);
					
					PanelNavigationHelper(panelANU, panelDB);
									
					JTF_userName_ANU.setText(null);
					JPF_userPassword_ANU.setText(null);
					JPF_userPasswordRE_ANU.setText(null);
					JCB_userRole_ANU.setSelectedIndex(0);
				}else {
					//Set warning pop-up here
					unsavedInformer();
				}
			}
		});
		JB_saveUser_ANU.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JB_saveUser_ANU.setBounds(728, 217, 197, 41);
		panelANU.add(JB_saveUser_ANU);
		
		JLabel exitANU = new JLabel("");
		exitANU.setBounds(1236, 13, 59, 32);
		exitANU.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitANU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitANU.setToolTipText("EXIT");
		exitANU.setHorizontalAlignment(SwingConstants.CENTER);
		exitANU.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		panelANU.add(exitANU);
		
		JLabel backANU = new JLabel("");
		backANU.setBounds(12, 13, 52, 32);
		backANU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				//I can reduce the condition tree to one branch but then the confirmation to go back will be displayed if all text fields are empty as well
				//not just when there is some text in them, and I did not want that
				
				if(JTF_userName_ANU.getText().length()>0 || JPF_userPassword_ANU.getPassword().length>0 || JPF_userPasswordRE_ANU.getPassword().length>0) {
					if(backDialog()) {
						PanelNavigationHelper(panelANU, panelDB);
						
						JTF_userName_ANU.setText(null);
						JTF_userName_ANU.setBorder(null);
						JPF_userPassword_ANU.setText(null);
						JPF_userPassword_ANU.setBorder(null);
						JPF_userPasswordRE_ANU.setText(null);
						JPF_userPasswordRE_ANU.setBorder(null);
					}
				}else {
					PanelNavigationHelper(panelANU, panelDB);
					
					JTF_userName_ANU.setBorder(null);
					JPF_userPassword_ANU.setBorder(null);
					JPF_userPasswordRE_ANU.setBorder(null);
				}
			}
		});
		backANU.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backANU.setToolTipText("BACK");
		backANU.setHorizontalAlignment(SwingConstants.CENTER);
		backANU.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		panelANU.add(backANU);
		
		/////////////////////////////////////////
		//--------//User List Section//--------//
		/////////////////////////////////////////
		
		panelUL = new JPanel();
		panelUL.setName("panelUL");
		contentPane.add(panelUL, "name_271145984886000");
		panelUL.setLayout(null);
		
		JScrollPane JSP_users_UL = new JScrollPane();
		JSP_users_UL.setBounds(436, 140, 849, 445);
		panelUL.add(JSP_users_UL);
		
		JT_users_UL = new JTable();
		JT_users_UL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_users_UL.convertRowIndexToModel(JT_users_UL.getSelectedRow());
				TableModel model = JT_users_UL.getModel();
				JTF_userNameInfo_UL.setText(model.getValueAt(index, 1)!=null?model.getValueAt(index, 1).toString():"");
				if(!(model.getValueAt(index, 2).toString().isEmpty())) {
					JCB_userRoleInfo_UL.setSelectedItem(getRoleByName(model.getValueAt(index, 2).toString()));
				}
				
				if(selectedUserID==0) {
					if(previousPanel.equals("panelDB")) {
					    List<JButton> jb_list = new ArrayList<JButton>();
					    jb_list.add(JB_updateUser_UL);
					    jb_list.add(JB_deleteUser_UL);
					    
					    GeneralResetter(null, null, jb_list, null, true);
					}else {
						//TODO
					}
					JCB_userRoleInfo_UL.setEnabled(true);
				}
	
				selectedUserID = Integer.valueOf(model.getValueAt(index, 0).toString());
			}
		});
		JSP_users_UL.setViewportView(JT_users_UL);
		
		JPanel JP_userInfo_UL = new JPanel();
		JP_userInfo_UL.setBounds(12, 97, 412, 488);
		panelUL.add(JP_userInfo_UL);
		JP_userInfo_UL.setLayout(null);
		
		JLabel JL_userDetails_UL = new JLabel("Detalii jobului:");
		JL_userDetails_UL.setBounds(145, 13, 134, 20);
		JL_userDetails_UL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_userInfo_UL.add(JL_userDetails_UL);
		
		JLabel JL_userNameInfo_UL = new JLabel("Numele lucratorului:");
		JL_userNameInfo_UL.setBounds(12, 85, 134, 16);
		JP_userInfo_UL.add(JL_userNameInfo_UL);
		
		JTF_userNameInfo_UL = new JTextField();
		JTF_userNameInfo_UL.setBounds(145, 82, 255, 22);
		JP_userInfo_UL.add(JTF_userNameInfo_UL);
		JTF_userNameInfo_UL.setColumns(10);
		
		JLabel JL_userRoleInfo_UL = new JLabel("Role:");
		JL_userRoleInfo_UL.setBounds(12, 114, 103, 16);
		JP_userInfo_UL.add(JL_userRoleInfo_UL);
		
		JB_updateUser_UL = new JButton("Update");
		JB_updateUser_UL.setEnabled(false);
		JB_updateUser_UL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(selectedUserID>0) {
					updateUser(JTF_userNameInfo_UL.getText());
					
					panelULResetter();
				}
			}
		});
		JB_updateUser_UL.setBounds(69, 426, 116, 37);
		JP_userInfo_UL.add(JB_updateUser_UL);
		
		JB_deleteUser_UL = new JButton("Delete");
		JB_deleteUser_UL.setEnabled(false);
		JB_deleteUser_UL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO
			}
		});
		JB_deleteUser_UL.setBounds(239, 426, 116, 37);
		JP_userInfo_UL.add(JB_deleteUser_UL);
		
		JB_selectUser_UL = new JButton("Selectare");
		JB_selectUser_UL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		JB_selectUser_UL.setVisible(false);
		JB_selectUser_UL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		JB_selectUser_UL.setEnabled(false);
		JB_selectUser_UL.setBounds(69, 185, 286, 71);
		JP_userInfo_UL.add(JB_selectUser_UL);
		
		JCB_userRoleInfo_UL = new JComboBox();
		JCB_userRoleInfo_UL.addActionListener(r -> {
	        JComboBox jcb = (JComboBox) r.getSource();
	        Role role = (Role) jcb.getSelectedItem();
	        selectedRoleID = role.getId();
	        System.out.println(selectedRoleID);
	      });
		JCB_userRoleInfo_UL.setEnabled(false);
		JCB_userRoleInfo_UL.setBounds(145, 117, 255, 20);
		JP_userInfo_UL.add(JCB_userRoleInfo_UL);
		
		JLabel reloadUsersTable = new JLabel("");
		reloadUsersTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadUsersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JT_users_UL.setRowSorter(null);
				
				SetDefaultTable(JT_users_UL, new String[]{"ID", "Numele lucratorului", "Rolul"});				
				LoadUsers();
				
				panelULResetter();
			}
		});
		reloadUsersTable.setToolTipText("Reload table");
		reloadUsersTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload0.png")));
		reloadUsersTable.setBounds(1179, 13, 45, 32);
		panelUL.add(reloadUsersTable);
		
		JPanel JP_userQuickSearch_UL = new JPanel();
		JP_userQuickSearch_UL.setBounds(436, 97, 849, 37);
		panelUL.add(JP_userQuickSearch_UL);
		JP_userQuickSearch_UL.setLayout(null);
		
		JLabel JL_userQuickSearch_UL = new JLabel("Căutare:");
		JL_userQuickSearch_UL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JL_userQuickSearch_UL.setBounds(12, 13, 60, 16);
		JP_userQuickSearch_UL.add(JL_userQuickSearch_UL);
		
		JTF_userQuickSearch_UL = new JTextField();
		
		//Quick search method
		
		JTF_userQuickSearch_UL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//TODO
			}
		});	
		JTF_userQuickSearch_UL.setBounds(84, 11, 753, 22);
		JP_userQuickSearch_UL.add(JTF_userQuickSearch_UL);
		JTF_userQuickSearch_UL.setColumns(10);
		
		JLabel exitUL = new JLabel("");
		exitUL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitUL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitUL.setToolTipText("EXIT");
		exitUL.setHorizontalAlignment(SwingConstants.CENTER);
		exitUL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitUL.setBounds(1236, 13, 59, 32);
		panelUL.add(exitUL);
		
		JLabel backUL = new JLabel("");
		backUL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				
				if(previousPanel.equals("panelDB")) {
					nextPanel = panelDB;
				}else {
					//TODO
				}				
				panelULResetter();
				
				PanelNavigationHelper(panelUL, nextPanel);

			}
		});
		backUL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backUL.setToolTipText("BACK");
		backUL.setHorizontalAlignment(SwingConstants.CENTER);
		backUL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backUL.setBounds(12, 13, 52, 32);
		panelUL.add(backUL);
		
		////////////////////////////////////////
		//--------//Add Auto Section//--------//
		////////////////////////////////////////
		
		panelAA = new JPanel();
		panelAA.setName("panelAA");
		contentPane.add(panelAA, "name_174016408126300");
		panelAA.setLayout(null);
		
		JLabel MLCard_addAuto_ANS = new JLabel("");
		MLCard_addAuto_ANS.setIcon(new ImageIcon(MainFrame.class.getResource("/images/car0.png")));
		MLCard_addAuto_ANS.setBounds(10, 55, 256, 309);
		panelAA.add(MLCard_addAuto_ANS);
		
		JLabel JL_carBrand_AA = new JLabel("Brand:");
		JL_carBrand_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_carBrand_AA.setBounds(278, 124, 63, 24);
		panelAA.add(JL_carBrand_AA);
		
		JTF_carBrand_AA = new JTextField();
		JTF_carBrand_AA.setColumns(10);
		JTF_carBrand_AA.setBounds(537, 128, 300, 22);
		panelAA.add(JTF_carBrand_AA);
		
		JLabel JL_carModel_AA = new JLabel("Model:");
		JL_carModel_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_carModel_AA.setBounds(278, 161, 63, 24);
		panelAA.add(JL_carModel_AA);
		
		JTF_carModel_AA = new JTextField();
		JTF_carModel_AA.setColumns(10);
		JTF_carModel_AA.setBounds(537, 165, 300, 22);
		panelAA.add(JTF_carModel_AA);
		
		JLabel JL_carLicenseNumber_AA = new JLabel("Numarul de înmatriculare:");
		JL_carLicenseNumber_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_carLicenseNumber_AA.setBounds(278, 87, 247, 24);
		panelAA.add(JL_carLicenseNumber_AA);
		
		JTF_carLicenseNumber_AA = new JTextField();
		JTF_carLicenseNumber_AA.setColumns(10);
		JTF_carLicenseNumber_AA.setBounds(537, 91, 300, 22);
		panelAA.add(JTF_carLicenseNumber_AA);
		
		JScrollPane JP_prevCars_AA = new JScrollPane();
		JP_prevCars_AA.setBounds(849, 87, 941, 272);
		panelAA.add(JP_prevCars_AA);
		
		JT_prevCars_AA = new JTable();
		JP_prevCars_AA.setViewportView(JT_prevCars_AA);
		
		JB_addCar_AA = new JButton("Adauga nou");
		JB_addCar_AA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_carLicenseNumber_AA);
				
				if(InputValidation(jtf_list)) {
					jtf_list.add(JTF_carBrand_AA);
					jtf_list.add(JTF_carModel_AA);
					jtf_list.add(JTF_carChassisNR_AA);
					jtf_list.add(JTF_carEngineNR_AA);
					jtf_list.add(JTF_carMilometer_AA);
					
					saveCar(jtf_list);
					JL_selectCar_ANR.setText(selectedCar.getLicenseNumber());

					PanelNavigationHelper(panelAA, panelANR);
									
					GeneralResetter(jtf_list, null, null, true, null);	
				}else {
					unsavedInformer();
				}
			}
		});
		JB_addCar_AA.setFont(new Font("Tahoma", Font.PLAIN, 24));
		JB_addCar_AA.setBounds(278, 309, 362, 50);
		panelAA.add(JB_addCar_AA);
		
		JLabel JL_prevInfo_AA = new JLabel("Mașini recente");
		JL_prevInfo_AA.setHorizontalAlignment(SwingConstants.CENTER);
		JL_prevInfo_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_prevInfo_AA.setBounds(849, 55, 941, 24);
		panelAA.add(JL_prevInfo_AA);
		
		JLabel exitAA = new JLabel("");
		exitAA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitAA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitAA.setToolTipText("EXIT");
		exitAA.setHorizontalAlignment(SwingConstants.CENTER);
		exitAA.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitAA.setBounds(1758, 10, 32, 32);
		panelAA.add(exitAA);
		
		JLabel backAA = new JLabel("");
		backAA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				PanelNavigationHelper(panelAA, panelDB);
			}
		});
		backAA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backAA.setToolTipText("BACK");
		backAA.setHorizontalAlignment(SwingConstants.CENTER);
		backAA.setIcon(new ImageIcon(MainFrame.class.getResource("/images/return_32.png")));
		backAA.setBounds(10, 10, 32, 32);
		panelAA.add(backAA);
		
		JLabel JL_carChassisNR_AA = new JLabel("Serie sasiu:");
		JL_carChassisNR_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_carChassisNR_AA.setBounds(278, 198, 107, 24);
		panelAA.add(JL_carChassisNR_AA);
		
		JTF_carChassisNR_AA = new JTextField();
		JTF_carChassisNR_AA.setColumns(10);
		JTF_carChassisNR_AA.setBounds(537, 202, 300, 22);
		panelAA.add(JTF_carChassisNR_AA);
		
		JLabel JL_carEngineNR_AA = new JLabel("Serie motor:");
		JL_carEngineNR_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_carEngineNR_AA.setBounds(278, 235, 116, 24);
		panelAA.add(JL_carEngineNR_AA);
		
		JTF_carEngineNR_AA = new JTextField();
		JTF_carEngineNR_AA.setColumns(10);
		JTF_carEngineNR_AA.setBounds(537, 239, 300, 22);
		panelAA.add(JTF_carEngineNR_AA);
		
		JLabel JL_carMilometer_AA = new JLabel("Milometer(NR KM):");
		JL_carMilometer_AA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JL_carMilometer_AA.setBounds(278, 272, 177, 24);
		panelAA.add(JL_carMilometer_AA);
		
		JTF_carMilometer_AA = new JTextField();
		JTF_carMilometer_AA.setColumns(10);
		JTF_carMilometer_AA.setBounds(537, 276, 300, 22);
		panelAA.add(JTF_carMilometer_AA);
		
		JLabel lblAdaugaMasinaNoua = new JLabel("Adauga masina noua");
		lblAdaugaMasinaNoua.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdaugaMasinaNoua.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAdaugaMasinaNoua.setBounds(278, 55, 559, 24);
		panelAA.add(lblAdaugaMasinaNoua);
		
		JButton JB_clearCar_AA = new JButton("Anulare");
		JB_clearCar_AA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_carLicenseNumber_AA);
				jtf_list.add(JTF_carBrand_AA);
				jtf_list.add(JTF_carModel_AA);
				jtf_list.add(JTF_carChassisNR_AA);
				jtf_list.add(JTF_carEngineNR_AA);
				jtf_list.add(JTF_carMilometer_AA);
				
				GeneralResetter(jtf_list, null, null, true, null);	
			}
		});
		JB_clearCar_AA.setFont(new Font("Tahoma", Font.PLAIN, 24));
		JB_clearCar_AA.setBounds(652, 309, 185, 50);
		panelAA.add(JB_clearCar_AA);
		
		////////////////////////////////////////////////////
		//--------//Add New Registration Section//--------//
		////////////////////////////////////////////////////
		
		panelANR = new JPanel();
		panelANR.setName("panelANR");
		contentPane.add(panelANR, "name_262951066585500");
		panelANR.setLayout(null);
		
		JLabel JL_registrationNumber_ANR = new JLabel("Registration ID:");
		JL_registrationNumber_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JL_registrationNumber_ANR.setBounds(10, 55, 257, 39);
		panelANR.add(JL_registrationNumber_ANR);
		
		JTF_registrationNumber_ANR = new JTextField();
		JTF_registrationNumber_ANR.setFont(new Font("Tahoma", Font.BOLD, 20));
		JTF_registrationNumber_ANR.setBounds(315, 55, 411, 38);
		panelANR.add(JTF_registrationNumber_ANR);
		JTF_registrationNumber_ANR.setColumns(10);
		
		JButton JB_saveRegistrtation_ANR = new JButton("Salveaza numarul");
		JB_saveRegistrtation_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registrationNumberValadation(JTF_registrationNumber_ANR.getText());
			}
		});
		JB_saveRegistrtation_ANR.setFont(new Font("Tahoma", Font.BOLD, 24));
		JB_saveRegistrtation_ANR.setBounds(10, 107, 464, 39);
		panelANR.add(JB_saveRegistrtation_ANR);
		
		JButton JB_generateNewRegistrationNumber_ANR = new JButton("Genereaza noua");
		JB_generateNewRegistrationNumber_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				generateRegistrationNumber();
			}
		});
		JB_generateNewRegistrationNumber_ANR.setFont(new Font("Tahoma", Font.BOLD, 20));
		JB_generateNewRegistrationNumber_ANR.setBounds(486, 106, 240, 39);
		panelANR.add(JB_generateNewRegistrationNumber_ANR);
		
		JLabel JL_registrationDate_ANR = new JLabel("Registration Date:");
		JL_registrationDate_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JL_registrationDate_ANR.setBounds(10, 159, 293, 39);
		panelANR.add(JL_registrationDate_ANR);
		
		JDC_registrationNumber_ANR = new JDateChooser();
		JDC_registrationNumber_ANR.setFont(new Font("Tahoma", Font.BOLD, 20));
		JDC_registrationNumber_ANR.setBounds(315, 158, 411, 39);
		panelANR.add(JDC_registrationNumber_ANR);
		
		JLabel SMC_client_ANR = new JLabel("");
		SMC_client_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/natural_person_128.png")));
		SMC_client_ANR.setBounds(10, 211, 128, 141);
		panelANR.add(SMC_client_ANR);
		
		SC_addClient_ANR = new JLabel("");
		SC_addClient_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_addClient_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelANR, panelCL);
				
				SetDefaultTable(JT_clients_CL, new String[]{"ID", "Numele clientului", "Numarul de telefon", "Firm?"});				
				LoadClients();
				
				JB_selectClient_CL.setVisible(true);
				JB_updateClient_CL.setVisible(false);
				JB_deleteClient_CL.setVisible(false);
			}
		});
		SC_addClient_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add_new_64.png")));
		SC_addClient_ANR.setBounds(150, 211, 64, 64);
		panelANR.add(SC_addClient_ANR);
		
		SC_editClient_ANR = new JLabel("");
		SC_editClient_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_editClient_ANR.setEnabled(false);
		SC_editClient_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit_64.png")));
		SC_editClient_ANR.setBounds(150, 288, 64, 64);
		panelANR.add(SC_editClient_ANR);
		
		JL_selectClient_ANR = new JLabel("Selectati client");
		JL_selectClient_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JL_selectClient_ANR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_selectClient_ANR.setBounds(226, 211, 500, 141);
		panelANR.add(JL_selectClient_ANR);
		
		JLabel SMC_car_ANR = new JLabel("");
		SMC_car_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/car_128.png")));
		SMC_car_ANR.setBounds(10, 365, 128, 141);
		panelANR.add(SMC_car_ANR);
		
		SC_addCar_ANR = new JLabel("");
		SC_addCar_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_addCar_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelANR, panelAA);
				
				SetDefaultTable(JT_prevCars_AA, new String[]{"Brand", "Model", "NR de inmatruculare", "Serie sasiu"});
				loadPreviousCars();
			}
		});
		SC_addCar_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add_new_64.png")));
		SC_addCar_ANR.setBounds(150, 365, 64, 64);
		panelANR.add(SC_addCar_ANR);
		
		SC_editCar_ANR = new JLabel("");
		SC_editCar_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_editCar_ANR.setEnabled(false);
		SC_editCar_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit_64.png")));
		SC_editCar_ANR.setBounds(150, 442, 64, 64);
		panelANR.add(SC_editCar_ANR);
		
		JL_selectCar_ANR = new JLabel("Selectati masina");
		JL_selectCar_ANR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_selectCar_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JL_selectCar_ANR.setBounds(226, 365, 500, 141);
		panelANR.add(JL_selectCar_ANR);
		
		JLabel SMC_worker_ANR = new JLabel("");
		SMC_worker_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/mechanic_128.png")));
		SMC_worker_ANR.setBounds(10, 519, 128, 141);
		panelANR.add(SMC_worker_ANR);
		
		SC_addWorker_ANR = new JLabel("");
		SC_addWorker_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_addWorker_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add_new_64.png")));
		SC_addWorker_ANR.setBounds(150, 519, 64, 64);
		panelANR.add(SC_addWorker_ANR);
		
		SC_editWorker_ANR = new JLabel("");
		SC_editWorker_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_editWorker_ANR.setEnabled(false);
		SC_editWorker_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit_64.png")));
		SC_editWorker_ANR.setBounds(150, 596, 64, 64);
		panelANR.add(SC_editWorker_ANR);
		
		JL_selectWorker_ANR = new JLabel("Selectati lucratori");
		JL_selectWorker_ANR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_selectWorker_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JL_selectWorker_ANR.setBounds(226, 519, 500, 141);
		panelANR.add(JL_selectWorker_ANR);
		
		JLabel SMC_piece_ANR = new JLabel("");
		SMC_piece_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/inventory_128.png")));
		SMC_piece_ANR.setBounds(738, 211, 128, 141);
		panelANR.add(SMC_piece_ANR);
		
		SC_addPiece_ANR = new JLabel("");
		SC_addPiece_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelANR, panelSII);
				
				SetDefaultTable(JT_inventory_SII, new String[]{"Piece ID","Numele piesei", "Pret final", "Quantity"});
			}
		});
		SC_addPiece_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_addPiece_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add_new_64.png")));
		SC_addPiece_ANR.setBounds(880, 211, 64, 64);
		panelANR.add(SC_addPiece_ANR);
		
		SC_editPiece_ANR = new JLabel("");
		SC_editPiece_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelANR, panelSII);
				
				SetDefaultTable(JT_inventory_SII, new String[]{"Inventory item", "Piece ID","Numele piesei", "Pret final", "Quantity"});
				loadRegistrationInventory(selectedRegistrationID);
			}
		});
		SC_editPiece_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_editPiece_ANR.setEnabled(false);
		SC_editPiece_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit_64.png")));
		SC_editPiece_ANR.setBounds(880, 288, 64, 64);
		panelANR.add(SC_editPiece_ANR);
		
		JL_selectPiece_ANR = new JLabel("Selectati piesele din stoc");
		JL_selectPiece_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetDefaultTable(JT_info_ANR, new String[]{"Piece ID", "Pret final", "Quantity"});
				loadRegistrationInfo(selectedRegistrationID, "Registrations_inventory");
			}
		});
		JL_selectPiece_ANR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_selectPiece_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JL_selectPiece_ANR.setBounds(956, 211, 400, 141);
		panelANR.add(JL_selectPiece_ANR);
		
		JLabel SMC_job_ANR = new JLabel("");
		SMC_job_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/job0_128.png")));
		SMC_job_ANR.setBounds(738, 365, 128, 141);
		panelANR.add(SMC_job_ANR);
		
		SC_addJob_ANR = new JLabel("");
		SC_addJob_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelANR, panelSJ);
				
				SetDefaultTable(JT_jobs_SJ, new String[]{"Numele jobului", "Tarif final"});
			}
		});
		SC_addJob_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_addJob_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add_new_64.png")));
		SC_addJob_ANR.setBounds(878, 365, 64, 64);
		panelANR.add(SC_addJob_ANR);
		
		SC_editJob_ANR = new JLabel("");
		SC_editJob_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelANR, panelSJ);
				
				SetDefaultTable(JT_jobs_SJ, new String[]{"Job", "Numele jobului", "Tarif final"});
				loadRegistrationJob(selectedRegistrationID);
			}
		});
		SC_editJob_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SC_editJob_ANR.setEnabled(false);
		SC_editJob_ANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit_64.png")));
		SC_editJob_ANR.setBounds(878, 442, 64, 64);
		panelANR.add(SC_editJob_ANR);
		
		JL_selectJob_ANR = new JLabel("Selectati joburi");
		JL_selectJob_ANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetDefaultTable(JT_info_ANR, new String[]{"Numele jobului", "Tarif final",});
				loadRegistrationInfo(selectedRegistrationID, "Registration_job");
			}
		});
		JL_selectJob_ANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JL_selectJob_ANR.setHorizontalAlignment(SwingConstants.CENTER);
		JL_selectJob_ANR.setFont(new Font("Tahoma", Font.BOLD, 32));
		JL_selectJob_ANR.setBounds(954, 365, 400, 141);
		panelANR.add(JL_selectJob_ANR);
		
		JLabel lblInfo = new JLabel("INFO");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInfo.setBounds(1366, 87, 424, 25);
		panelANR.add(lblInfo);
		
		JScrollPane JSP_info_ANR = new JScrollPane();
		JSP_info_ANR.setBounds(1366, 125, 424, 655);
		panelANR.add(JSP_info_ANR);
		
		JT_info_ANR = new JTable();
		JSP_info_ANR.setViewportView(JT_info_ANR);
		
		JLabel exitANR = new JLabel("");
		exitANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitANR.setToolTipText("EXIT");
		exitANR.setHorizontalAlignment(SwingConstants.CENTER);
		exitANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit_32.png")));
		exitANR.setBounds(1758, 10, 32, 32);
		panelANR.add(exitANR);
		
		JLabel backANR = new JLabel("");
		backANR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				PanelNavigationHelper(panelANR, panelDB);
			}
		});
		backANR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backANR.setToolTipText("BACK");
		backANR.setHorizontalAlignment(SwingConstants.CENTER);
		backANR.setIcon(new ImageIcon(MainFrame.class.getResource("/images/return_32.png")));
		backANR.setBounds(10, 10, 32, 32);
		panelANR.add(backANR);
		
		////////////////////////////////////////////////////
		//--------//Inventory Management Section//--------//
		////////////////////////////////////////////////////
		
		panelIM = new JPanel();
		panelIM.setName("panelIM");
		contentPane.add(panelIM, "name_306400352950000");
		panelIM.setLayout(null);
		
		JScrollPane JSP_inventory_IM = new JScrollPane();
		JSP_inventory_IM.setBounds(436, 140, 849, 445);
		panelIM.add(JSP_inventory_IM);
		
		JT_inventory_IM = new JTable();
		JT_inventory_IM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_inventory_IM.convertRowIndexToModel(JT_inventory_IM.getSelectedRow());
				TableModel model = JT_inventory_IM.getModel();
				JTF_pieceIDInfo_IM.setText(model.getValueAt(index, 1)!=null?model.getValueAt(index, 1).toString():"");
				JTF_clientNameInfo_IM.setText(model.getValueAt(index, 2)!=null?model.getValueAt(index, 2).toString():"");
				JTF_quantityInfo_IM.setText(model.getValueAt(index, 3)!=null?model.getValueAt(index, 3).toString():"");
				JTF_unitePriceINInfo_IM.setText(model.getValueAt(index, 4)!=null?model.getValueAt(index, 4).toString():"");
				JTF_unitePriceOUTInfo_IM.setText(model.getValueAt(index, 5)!=null?model.getValueAt(index, 5).toString():"");
				if(!model.getValueAt(index, 6).toString().equals("")) {
					try {
						JDC_dateINInfo_IM.setDate(new SimpleDateFormat("yyyy-mm-dd").parse(model.getValueAt(index, 6).toString()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}else {
					JDC_dateINInfo_IM.setDate(null);
				}
				selectedInventoryID = Integer.valueOf(model.getValueAt(index, 0).toString());
				
				if(previousPanel.equals("panelDB")) {
				    List<JButton> jb_list = new ArrayList<JButton>();
				    jb_list.add(JB_updateInventoryItem_IM);
				    jb_list.add(JB_deleteInventoryItem_IM);
				    
				    GeneralResetter(null, null, jb_list, null, true);
				}else if(previousPanel.equals("panelSII")) {
					JB_selectInventoryItem_IM.setEnabled(true);
				}else {
					System.out.println("Error in panel navigation.");
					System.out.println("Previous panel: " + previousPanel.toString());
				}
	
			}
		});
		JSP_inventory_IM.setViewportView(JT_inventory_IM);
		
		JPanel JP_inventoryInfo_IM = new JPanel();
		JP_inventoryInfo_IM.setBounds(12, 97, 412, 488);
		panelIM.add(JP_inventoryInfo_IM);
		JP_inventoryInfo_IM.setLayout(null);
		
		JLabel JL_inventoryDetails_IM = new JLabel("Detalii iventory:");
		JL_inventoryDetails_IM.setBounds(145, 13, 134, 20);
		JL_inventoryDetails_IM.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_inventoryInfo_IM.add(JL_inventoryDetails_IM);
		
		JLabel JL_pieceIdInfo_IM = new JLabel("Piece ID:");
		JL_pieceIdInfo_IM.setBounds(12, 85, 107, 16);
		JP_inventoryInfo_IM.add(JL_pieceIdInfo_IM);
		
		JTF_pieceIDInfo_IM = new JTextField();
		JTF_pieceIDInfo_IM.setBounds(140, 82, 260, 22);
		JP_inventoryInfo_IM.add(JTF_pieceIDInfo_IM);
		JTF_pieceIDInfo_IM.setColumns(10);
		
		JLabel JL_clientNameInfo_IM = new JLabel("Numele furnizorului:");
		JL_clientNameInfo_IM.setBounds(12, 114, 116, 16);
		JP_inventoryInfo_IM.add(JL_clientNameInfo_IM);
		
		JTF_clientNameInfo_IM = new JTextField();
		JTF_clientNameInfo_IM.setBounds(140, 111, 260, 22);
		JP_inventoryInfo_IM.add(JTF_clientNameInfo_IM);
		JTF_clientNameInfo_IM.setColumns(10);
		
		JB_updateInventoryItem_IM = new JButton("Update");
		JB_updateInventoryItem_IM.setEnabled(false);
		JB_updateInventoryItem_IM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO
			}
		});
		JB_updateInventoryItem_IM.setBounds(69, 426, 116, 37);
		JP_inventoryInfo_IM.add(JB_updateInventoryItem_IM);
		
		JB_deleteInventoryItem_IM = new JButton("Delete");
		JB_deleteInventoryItem_IM.setEnabled(false);
		JB_deleteInventoryItem_IM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO
			}
		});
		JB_deleteInventoryItem_IM.setBounds(239, 426, 116, 37);
		JP_inventoryInfo_IM.add(JB_deleteInventoryItem_IM);
		
		JB_selectInventoryItem_IM = new JButton("Selectare");
		JB_selectInventoryItem_IM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				getInventoryItemByID(selectedInventoryID);
				if(previousPanel.equals("panelSII")) {
					nextPanel = panelSII;
					
					JTF_inventoryItemName_SII.setText(selectedInventoryItem.getAutopieces().getAutopiecename());
					JTF_inventoryItemPrice_SII.setText(String.valueOf(selectedInventoryItem.getUnitepriceout()));
				}else {
					System.out.println("Error in panel navigation.");
				}	
				PanelNavigationHelper(panelIM, nextPanel);
				
				panelIMResetter();
			}
		});
		JB_selectInventoryItem_IM.setEnabled(false);
		JB_selectInventoryItem_IM.setBounds(69, 280, 286, 71);
		JP_inventoryInfo_IM.add(JB_selectInventoryItem_IM);
		
		JLabel JL_quantityInfo_IM = new JLabel("Quantity:");
		JL_quantityInfo_IM.setBounds(12, 146, 107, 16);
		JP_inventoryInfo_IM.add(JL_quantityInfo_IM);
		
		JTF_quantityInfo_IM = new JTextField();
		JTF_quantityInfo_IM.setColumns(10);
		JTF_quantityInfo_IM.setBounds(140, 143, 260, 22);
		JP_inventoryInfo_IM.add(JTF_quantityInfo_IM);
		
		JLabel JL_unitePriceINInfo_IM = new JLabel("Unite price in:");
		JL_unitePriceINInfo_IM.setBounds(12, 178, 107, 16);
		JP_inventoryInfo_IM.add(JL_unitePriceINInfo_IM);
		
		JTF_unitePriceINInfo_IM = new JTextField();
		JTF_unitePriceINInfo_IM.setColumns(10);
		JTF_unitePriceINInfo_IM.setBounds(140, 175, 260, 22);
		JP_inventoryInfo_IM.add(JTF_unitePriceINInfo_IM);
		
		JLabel JL_unitePriceOutInfo_IM = new JLabel("Unite price out:");
		JL_unitePriceOutInfo_IM.setBounds(12, 210, 107, 16);
		JP_inventoryInfo_IM.add(JL_unitePriceOutInfo_IM);
		
		JTF_unitePriceOUTInfo_IM = new JTextField();
		JTF_unitePriceOUTInfo_IM.setColumns(10);
		JTF_unitePriceOUTInfo_IM.setBounds(140, 204, 260, 22);
		JP_inventoryInfo_IM.add(JTF_unitePriceOUTInfo_IM);
		
		JDC_dateINInfo_IM = new JDateChooser();
		JDC_dateINInfo_IM.setBounds(140, 233, 260, 22);
		JP_inventoryInfo_IM.add(JDC_dateINInfo_IM);
		
		JLabel JL_dateINInfo_IM = new JLabel("Date in:");
		JL_dateINInfo_IM.setBounds(12, 239, 107, 16);
		JP_inventoryInfo_IM.add(JL_dateINInfo_IM);
		
		JLabel reloadInventoryTable = new JLabel("");
		reloadInventoryTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadInventoryTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelIMResetter();
				
				SetDefaultTable(JT_inventory_IM, new String[]{"ID", "Piese de auto", "Furnizor", "Quantity", "Price IN", "Price OUT", "Date"});				
				loadInventory();
			}
		});
		reloadInventoryTable.setToolTipText("Reload table");
		reloadInventoryTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload0.png")));
		reloadInventoryTable.setBounds(1179, 13, 45, 32);
		panelIM.add(reloadInventoryTable);
		
		JPanel JP_inventoryQuickSearch_IM = new JPanel();
		JP_inventoryQuickSearch_IM.setBounds(436, 97, 849, 37);
		panelIM.add(JP_inventoryQuickSearch_IM);
		JP_inventoryQuickSearch_IM.setLayout(null);
		
		//Quick search methods
		
		JTF_autoPieceQuickSearch_IM = new JTextField();
		JTF_autoPieceQuickSearch_IM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				comboFilter(JT_inventory_IM,  
						new String[]{JTF_autoPieceQuickSearch_IM.getText(), JTF_clientQuickSearch_IM.getText(), JTF_dateINQuickSearch_IM.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_autoPieceQuickSearch_IM.setBounds(0, 13, 141, 22);
		JP_inventoryQuickSearch_IM.add(JTF_autoPieceQuickSearch_IM);
		JTF_autoPieceQuickSearch_IM.setColumns(10);
		
		JTF_clientQuickSearch_IM = new JTextField();
		JTF_clientQuickSearch_IM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				comboFilter(JT_inventory_IM,  
						new String[]{JTF_autoPieceQuickSearch_IM.getText(), JTF_clientQuickSearch_IM.getText(), JTF_dateINQuickSearch_IM.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_clientQuickSearch_IM.setColumns(10);
		JTF_clientQuickSearch_IM.setBounds(141, 13, 141, 22);
		JP_inventoryQuickSearch_IM.add(JTF_clientQuickSearch_IM);
		
		JTF_dateINQuickSearch_IM = new JTextField();
		JTF_dateINQuickSearch_IM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				comboFilter(JT_inventory_IM,  
						new String[]{JTF_autoPieceQuickSearch_IM.getText(), JTF_clientQuickSearch_IM.getText(), JTF_dateINQuickSearch_IM.getText()}, 
						new int[] {1, 2, 3});
			}
		});
		JTF_dateINQuickSearch_IM.setColumns(10);
		JTF_dateINQuickSearch_IM.setBounds(708, 13, 141, 22);
		JP_inventoryQuickSearch_IM.add(JTF_dateINQuickSearch_IM);
		
		JLabel exitIM = new JLabel("");
		exitIM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitIM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitIM.setToolTipText("EXIT");
		exitIM.setHorizontalAlignment(SwingConstants.CENTER);
		exitIM.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitIM.setBounds(1236, 13, 59, 32);
		panelIM.add(exitIM);
		
		JLabel backIM = new JLabel("");
		backIM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				
				if(previousPanel.equals("panelDB")) {
					nextPanel = panelDB;
				}else if(previousPanel.equals("panelSII")){
					nextPanel = panelSII;
				}else {
					System.out.println("Error in panel navigation.");
				}				
				panelIMResetter();
				
				PanelNavigationHelper(panelIM, nextPanel);
			}
		});
		backIM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backIM.setToolTipText("BACK");
		backIM.setHorizontalAlignment(SwingConstants.CENTER);
		backIM.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backIM.setBounds(12, 13, 52, 32);
		panelIM.add(backIM);
		
		////////////////////////////////////////////
		//--------//Supplie List Section//--------//
		////////////////////////////////////////////
		
		panelSL = new JPanel();
		panelSL.setName("panelSL");
		contentPane.add(panelSL, "name_9670417171200");
		panelSL.setLayout(null);
		
		JScrollPane JSP_supplies_SL = new JScrollPane();
		JSP_supplies_SL.setBounds(436, 140, 849, 445);
		panelSL.add(JSP_supplies_SL);
		
		JT_supplies_SL = new JTable();
		JT_supplies_SL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_supplies_SL.convertRowIndexToModel(JT_supplies_SL.getSelectedRow());
				TableModel model = JT_supplies_SL.getModel();
				JTF_clientNameInfo_SL.setText(model.getValueAt(index, 1)!=null?model.getValueAt(index, 1).toString():"");
				JTF_invoiceNRInfo_SL.setText(model.getValueAt(index, 2)!=null?model.getValueAt(index, 2).toString():"");
				if(!model.getValueAt(index, 3).toString().equals("")) {
					try {
						JDC_dateINInfo_SL.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 3).toString()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}else {
					JDC_dateINInfo_SL.setDate(null);
				}
				if(!model.getValueAt(index, 4).toString().equals("")) {
					try {
						JDC_dueDateInfo_SL.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 4).toString()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}else {
					JDC_dueDateInfo_SL.setDate(null);
				}
				selectedSupplieID = Integer.valueOf(model.getValueAt(index, 0).toString());
				
				if(previousPanel.equals("panelDB") || previousPanel.equals("panelRAPL")) {
				    List<JButton> jb_list = new ArrayList<JButton>();
				    jb_list.add(JB_updateSupplie_SL);
				    jb_list.add(JB_deleteSupplie_SL);
				    jb_list.add(JB_selectSupplie_SL);
				    
				    GeneralResetter(null, null, jb_list, null, true);
				}else {
					//TODO
				}
			}
		});
		JSP_supplies_SL.setViewportView(JT_supplies_SL);
		
		JPanel JP_supplieInfo_SL = new JPanel();
		JP_supplieInfo_SL.setBounds(12, 97, 412, 488);
		panelSL.add(JP_supplieInfo_SL);
		JP_supplieInfo_SL.setLayout(null);
		
		JLabel JL_supplieDetails_SL = new JLabel("Detalii supplie:");
		JL_supplieDetails_SL.setBounds(145, 13, 134, 20);
		JL_supplieDetails_SL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_supplieInfo_SL.add(JL_supplieDetails_SL);
		
		JLabel JL_clientNameInfo_SL = new JLabel("Numele furnizorului:");
		JL_clientNameInfo_SL.setBounds(12, 85, 134, 16);
		JP_supplieInfo_SL.add(JL_clientNameInfo_SL);
		
		JTF_clientNameInfo_SL = new JTextField();
		JTF_clientNameInfo_SL.setBounds(145, 82, 255, 22);
		JP_supplieInfo_SL.add(JTF_clientNameInfo_SL);
		JTF_clientNameInfo_SL.setColumns(10);
		
		JLabel JL_invoiceNRInfo_SL = new JLabel("Invoice number:");
		JL_invoiceNRInfo_SL.setBounds(12, 117, 103, 16);
		JP_supplieInfo_SL.add(JL_invoiceNRInfo_SL);
		
		JB_updateSupplie_SL = new JButton("Update");
		JB_updateSupplie_SL.setEnabled(false);
		JB_updateSupplie_SL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO
			}
		});
		JB_updateSupplie_SL.setBounds(69, 426, 116, 37);
		JP_supplieInfo_SL.add(JB_updateSupplie_SL);
		
		JB_deleteSupplie_SL = new JButton("Delete");
		JB_deleteSupplie_SL.setEnabled(false);
		JB_deleteSupplie_SL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO
			}
		});
		JB_deleteSupplie_SL.setBounds(239, 426, 116, 37);
		JP_supplieInfo_SL.add(JB_deleteSupplie_SL);
		
		JB_selectSupplie_SL = new JButton("Selectare");
		JB_selectSupplie_SL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(selectedSupplieID>0) {
					PanelNavigationHelper(panelSL, panelRAPL);
					
					SetDefaultTable(JT_rapl_RAPL, new String[]{"Auto Piece ID", "Quantity", "Date IN", "Unite Price IN", "Unite Price OUT", "TVA"});		
					loadReceptionAutoPieces(selectedSupplieID);
					
					int temp = selectedSupplieID;
					panelSLResetter();
					selectedSupplieID = temp;
				}
			}
		});
		JB_selectSupplie_SL.setEnabled(false);
		JB_selectSupplie_SL.setBounds(69, 219, 286, 71);
		JP_supplieInfo_SL.add(JB_selectSupplie_SL);
		
		JTF_invoiceNRInfo_SL = new JTextField();
		JTF_invoiceNRInfo_SL.setColumns(10);
		JTF_invoiceNRInfo_SL.setBounds(145, 114, 255, 22);
		JP_supplieInfo_SL.add(JTF_invoiceNRInfo_SL);
		
		JLabel JL_dateINInfo_SL = new JLabel("Date in:");
		JL_dateINInfo_SL.setBounds(12, 155, 107, 16);
		JP_supplieInfo_SL.add(JL_dateINInfo_SL);
		
		JDC_dateINInfo_SL = new JDateChooser();
		JDC_dateINInfo_SL.setBounds(145, 149, 255, 22);
		JP_supplieInfo_SL.add(JDC_dateINInfo_SL);
		
		JLabel JL_dueDATEInfo_SL = new JLabel("Due date:");
		JL_dueDATEInfo_SL.setBounds(12, 190, 107, 16);
		JP_supplieInfo_SL.add(JL_dueDATEInfo_SL);
		
		JDC_dueDateInfo_SL = new JDateChooser();
		JDC_dueDateInfo_SL.setBounds(145, 184, 255, 22);
		JP_supplieInfo_SL.add(JDC_dueDateInfo_SL);
		
		JLabel reloadSuppliesTable = new JLabel("");
		reloadSuppliesTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadSuppliesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSLResetter();
				
				SetDefaultTable(JT_supplies_SL, new String[]{"ID", "Furnizor", "Număr de factură", "Date IN", "Due Date"});				
				loadSupplies();
			}
		});
		reloadSuppliesTable.setToolTipText("Reload table");
		reloadSuppliesTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload0.png")));
		reloadSuppliesTable.setBounds(1179, 13, 45, 32);
		panelSL.add(reloadSuppliesTable);
		
		JPanel JP_supplieQuickSearch_SL = new JPanel();
		JP_supplieQuickSearch_SL.setBounds(436, 97, 849, 37);
		panelSL.add(JP_supplieQuickSearch_SL);
		JP_supplieQuickSearch_SL.setLayout(null);
		
		//Quick search method
		
		JTF_clientNameQuickSearch_SL = new JTextField();		
		JTF_clientNameQuickSearch_SL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				comboFilter(JT_supplies_SL,  
						new String[]{JTF_clientNameQuickSearch_SL.getText(), JTF_invoiceNRQuickSearch_SL.getText()}, 
						new int[] {1, 2});
			}
		});	
		JTF_clientNameQuickSearch_SL.setBounds(0, 13, 212, 22);
		JP_supplieQuickSearch_SL.add(JTF_clientNameQuickSearch_SL);
		JTF_clientNameQuickSearch_SL.setColumns(10);
		
		JTF_invoiceNRQuickSearch_SL = new JTextField();
		JTF_invoiceNRQuickSearch_SL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				comboFilter(JT_supplies_SL,  
						new String[]{JTF_clientNameQuickSearch_SL.getText(), JTF_invoiceNRQuickSearch_SL.getText()}, 
						new int[] {1, 2});
			}
		});	
		JTF_invoiceNRQuickSearch_SL.setColumns(10);
		JTF_invoiceNRQuickSearch_SL.setBounds(212, 13, 212, 22);
		JP_supplieQuickSearch_SL.add(JTF_invoiceNRQuickSearch_SL);
		
		JDC_dateINQuickSearch_SL = new JDateChooser();
		JDC_dateINQuickSearch_SL.addPropertyChangeListener(
			new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent e) {	
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
		JDC_dateINQuickSearch_SL.setBounds(423, 13, 212, 22);
		JP_supplieQuickSearch_SL.add(JDC_dateINQuickSearch_SL);
		
		JDC_dueDateQuickSearch_SL = new JDateChooser();
		JDC_dueDateQuickSearch_SL.addPropertyChangeListener(
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent e) {				
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
		JDC_dueDateQuickSearch_SL.setBounds(637, 13, 212, 22);
		JP_supplieQuickSearch_SL.add(JDC_dueDateQuickSearch_SL);
		
		JLabel exitSL = new JLabel("");
		exitSL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitSL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitSL.setToolTipText("EXIT");
		exitSL.setHorizontalAlignment(SwingConstants.CENTER);
		exitSL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitSL.setBounds(1236, 13, 59, 32);
		panelSL.add(exitSL);
		
		JLabel backSL = new JLabel("");
		backSL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				
				if(previousPanel.equals("panelDB")) {
					nextPanel = panelDB;
				}else {
					//TODO
				}				
				panelSLResetter();
				
				PanelNavigationHelper(panelSL, nextPanel);

			}
		});
		backSL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backSL.setToolTipText("BACK");
		backSL.setHorizontalAlignment(SwingConstants.CENTER);
		backSL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backSL.setBounds(12, 13, 52, 32);
		panelSL.add(backSL);
		
		////////////////////////////////////////////////////
		//--------//Reception Auto Pieces Section//--------/
		////////////////////////////////////////////////////
		
		panelRAPL = new JPanel();
		panelRAPL.setName("panelRAPL");
		contentPane.add(panelRAPL, "name_71536934844800");
		panelRAPL.setLayout(null);
		
		JScrollPane JSP_pieces_RAPL = new JScrollPane();
		JSP_pieces_RAPL.setBounds(436, 140, 849, 445);
		panelRAPL.add(JSP_pieces_RAPL);
		
		JT_rapl_RAPL = new JTable();
		JT_rapl_RAPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_rapl_RAPL.convertRowIndexToModel(JT_rapl_RAPL.getSelectedRow());
				TableModel model = JT_rapl_RAPL.getModel();
				JTF_recInvoiceNRInfo_RAPL.setText(model.getValueAt(index, 0)!=null?model.getValueAt(index, 0).toString():"");
				JTF_autoPieceIDInfo_RAPL.setText(model.getValueAt(index, 1)!=null?model.getValueAt(index, 1).toString():"");
				JTF_quantityInfo_RAPL.setText(model.getValueAt(index, 2)!=null?model.getValueAt(index, 2).toString():"");
				JTF_priceINInfo_RAPL.setText(model.getValueAt(index, 3)!=null?model.getValueAt(index, 3).toString():"");
				JTF_priceOUTInfo_RAPL.setText(model.getValueAt(index, 4)!=null?model.getValueAt(index, 4).toString():"");
				JTF_vatInfo_RAPL.setText(model.getValueAt(index, 5)!=null?model.getValueAt(index, 5).toString():"");
				
				if(previousPanel.equals("panelSL")) {
				    List<JButton> jb_list = new ArrayList<JButton>();
				    jb_list.add(JB_updateRAP_RAPL);
				    jb_list.add(JB_deleteRAP_RAPL);
				    
				    GeneralResetter(null, null, jb_list, null, true);
				}else {
					//TODO
				}
	
			}
		});
		JSP_pieces_RAPL.setViewportView(JT_rapl_RAPL);
		
		JPanel JP_raplInfo_RAPL = new JPanel();
		JP_raplInfo_RAPL.setBounds(12, 97, 412, 488);
		panelRAPL.add(JP_raplInfo_RAPL);
		JP_raplInfo_RAPL.setLayout(null);
		
		JLabel JL_raplDetails_RAPL = new JLabel("Detalii piese de auto al furnizarii:");
		JL_raplDetails_RAPL.setHorizontalAlignment(SwingConstants.CENTER);
		JL_raplDetails_RAPL.setBounds(12, 13, 388, 20);
		JL_raplDetails_RAPL.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_raplInfo_RAPL.add(JL_raplDetails_RAPL);
		
		JLabel JL_recInvoiceNRInfo_RAPL = new JLabel("Reception invoice nr:");
		JL_recInvoiceNRInfo_RAPL.setBounds(12, 85, 120, 16);
		JP_raplInfo_RAPL.add(JL_recInvoiceNRInfo_RAPL);
		
		JTF_recInvoiceNRInfo_RAPL = new JTextField();
		JTF_recInvoiceNRInfo_RAPL.setBounds(145, 82, 255, 22);
		JP_raplInfo_RAPL.add(JTF_recInvoiceNRInfo_RAPL);
		JTF_recInvoiceNRInfo_RAPL.setColumns(10);
		
		JLabel JL_autoPieceIDInfo_RAPL = new JLabel("Tarifa jobului:");
		JL_autoPieceIDInfo_RAPL.setBounds(12, 114, 103, 16);
		JP_raplInfo_RAPL.add(JL_autoPieceIDInfo_RAPL);
		
		JTF_autoPieceIDInfo_RAPL = new JTextField();
		JTF_autoPieceIDInfo_RAPL.setBounds(145, 111, 255, 22);
		JP_raplInfo_RAPL.add(JTF_autoPieceIDInfo_RAPL);
		JTF_autoPieceIDInfo_RAPL.setColumns(10);
		
		JLabel JL_quantityInfo_RAPL = new JLabel("Quantity:");
		JL_quantityInfo_RAPL.setBounds(12, 146, 103, 16);
		JP_raplInfo_RAPL.add(JL_quantityInfo_RAPL);
		
		JTF_quantityInfo_RAPL = new JTextField();
		JTF_quantityInfo_RAPL.setColumns(10);
		JTF_quantityInfo_RAPL.setBounds(145, 143, 255, 22);
		JP_raplInfo_RAPL.add(JTF_quantityInfo_RAPL);
		
		JLabel JL_priceINInfo_RAPL = new JLabel("Price IN:");
		JL_priceINInfo_RAPL.setBounds(12, 178, 103, 16);
		JP_raplInfo_RAPL.add(JL_priceINInfo_RAPL);
		
		JTF_priceINInfo_RAPL = new JTextField();
		JTF_priceINInfo_RAPL.setColumns(10);
		JTF_priceINInfo_RAPL.setBounds(145, 175, 255, 22);
		JP_raplInfo_RAPL.add(JTF_priceINInfo_RAPL);
		
		JLabel JL_priceOUTInfo_RAPL = new JLabel("Price OUT:");
		JL_priceOUTInfo_RAPL.setBounds(12, 210, 103, 16);
		JP_raplInfo_RAPL.add(JL_priceOUTInfo_RAPL);
		
		JTF_priceOUTInfo_RAPL = new JTextField();
		JTF_priceOUTInfo_RAPL.setColumns(10);
		JTF_priceOUTInfo_RAPL.setBounds(145, 207, 255, 22);
		JP_raplInfo_RAPL.add(JTF_priceOUTInfo_RAPL);
		
		JLabel JL_vatInfo_RAPL = new JLabel("TVA:");
		JL_vatInfo_RAPL.setBounds(12, 242, 103, 16);
		JP_raplInfo_RAPL.add(JL_vatInfo_RAPL);
		
		JTF_vatInfo_RAPL = new JTextField();
		JTF_vatInfo_RAPL.setColumns(10);
		JTF_vatInfo_RAPL.setBounds(145, 239, 255, 22);
		JP_raplInfo_RAPL.add(JTF_vatInfo_RAPL);
		
		JB_updateRAP_RAPL = new JButton("Update");
		JB_updateRAP_RAPL.setEnabled(false);
		JB_updateRAP_RAPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO
			}
		});
		JB_updateRAP_RAPL.setBounds(69, 426, 116, 37);
		JP_raplInfo_RAPL.add(JB_updateRAP_RAPL);
		
		JB_deleteRAP_RAPL = new JButton("Delete");
		JB_deleteRAP_RAPL.setEnabled(false);
		JB_deleteRAP_RAPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO
			}
		});
		JB_deleteRAP_RAPL.setBounds(239, 426, 116, 37);
		JP_raplInfo_RAPL.add(JB_deleteRAP_RAPL);
		
		JB_selectRAP_RAPL = new JButton("Selectare");
		JB_selectRAP_RAPL.setVisible(false);
		JB_selectRAP_RAPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
		JB_selectRAP_RAPL.setEnabled(false);
		JB_selectRAP_RAPL.setBounds(69, 271, 286, 71);
		JP_raplInfo_RAPL.add(JB_selectRAP_RAPL);
		
		JLabel reloadRAPLTable = new JLabel("");
		reloadRAPLTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadRAPLTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				SetDefaultTable(JT_rapl_RAPL, new String[]{"Auto Piece ID", "Quantity", "Date IN", "Unite Price IN", "Unite Price OUT", "TVA"});
				loadReceptionAutoPieces(selectedSupplieID);
				
				panelRAPLResetter();
			}
		});
		reloadRAPLTable.setToolTipText("Reload table");
		reloadRAPLTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload0.png")));
		reloadRAPLTable.setBounds(1179, 13, 45, 32);
		panelRAPL.add(reloadRAPLTable);
		
		JPanel JP_rapQuickSearch_RAPL = new JPanel();
		JP_rapQuickSearch_RAPL.setBounds(436, 97, 849, 37);
		panelRAPL.add(JP_rapQuickSearch_RAPL);
		JP_rapQuickSearch_RAPL.setLayout(null);
		
		JLabel JL_rapQuickSearch_RAPL = new JLabel("Căutare:");
		JL_rapQuickSearch_RAPL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JL_rapQuickSearch_RAPL.setBounds(12, 13, 60, 16);
		JP_rapQuickSearch_RAPL.add(JL_rapQuickSearch_RAPL);
		
		//Quick search method
		
		JTF_rapQuickSearch_RAPL = new JTextField();
		JTF_rapQuickSearch_RAPL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//TODO
			}
		});	
		JTF_rapQuickSearch_RAPL.setBounds(84, 11, 753, 22);
		JP_rapQuickSearch_RAPL.add(JTF_rapQuickSearch_RAPL);
		JTF_rapQuickSearch_RAPL.setColumns(10);
		
		JLabel exitRAPL = new JLabel("");
		exitRAPL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitRAPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exitDialog();
			}
		});
		exitRAPL.setToolTipText("EXIT");
		exitRAPL.setHorizontalAlignment(SwingConstants.CENTER);
		exitRAPL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitRAPL.setBounds(1236, 13, 59, 32);
		panelRAPL.add(exitRAPL);
		
		JLabel backRAPL = new JLabel("");
		backRAPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel nextPanel = null;
				
				if(previousPanel.equals("panelSL")) {
					nextPanel = panelSL;
				}else {
					//TODO
				}				
				panelRAPLResetter();
				selectedSupplieID = 0;
				
				PanelNavigationHelper(panelRAPL, nextPanel);
				
				SetDefaultTable(JT_supplies_SL, new String[]{"ID", "Furnizor", "Număr de factură", "Date IN", "Due Date"});				
				loadSupplies();
			}
		});
		backRAPL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backRAPL.setToolTipText("BACK");
		backRAPL.setHorizontalAlignment(SwingConstants.CENTER);
		backRAPL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backRAPL.setBounds(12, 13, 52, 32);
		panelRAPL.add(backRAPL);
		
		//////////////////////////////////////////
		//--------//Select Job Section//--------//
		//////////////////////////////////////////
		
		panelSJ = new JPanel();
		panelSJ.setName("panelSJ");
		contentPane.add(panelSJ, "name_576580616234500");
		panelSJ.setLayout(null);
		
		JLabel MLCard_job_SJ = new JLabel("");
		MLCard_job_SJ.setIcon(new ImageIcon(MainFrame.class.getResource("/images/job_256.png")));
		MLCard_job_SJ.setBounds(10, 55, 256, 301);
		panelSJ.add(MLCard_job_SJ);
		
		JTF_jobSearch_SJ = new JTextField();
		JTF_jobSearch_SJ.setBounds(278, 55, 400, 22);
		panelSJ.add(JTF_jobSearch_SJ);
		JTF_jobSearch_SJ.setColumns(10);
		
		JButton JB_selectJob_SJ = new JButton("Selectare");
		JB_selectJob_SJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelSJDetailsResetter();
				
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_jobSearch_SJ);
				
				if(InputValidation(jtf_list)) {
					if(getJobByName(JTF_jobSearch_SJ.getText())) {
						JTF_jobName_SJ.setText(selectedJob.getJobname());
						JTF_jobPrice_SJ.setText(String.valueOf(selectedJob.getJobprice()));
					}
				}
			}
		});
		JB_selectJob_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_selectJob_SJ.setBounds(278, 90, 230, 40);
		panelSJ.add(JB_selectJob_SJ);
		
		JButton JB_searchJob_SJ = new JButton("Cautare");
		JB_searchJob_SJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSJDetailsResetter();
				
				PanelNavigationHelper(panelSJ, panelJL);
				
				SetDefaultTable(JT_jobs_JL, new String[]{"ID", "Numele jobului", "Tarifa jobului"});				
				LoadJobs();
				
				JB_selectJob_JL.setVisible(true);
				JB_updateJob_JL.setVisible(false);
				JB_deleteJob_JL.setVisible(false);
			}
		});
		JB_searchJob_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_searchJob_SJ.setBounds(520, 90, 158, 40);
		panelSJ.add(JB_searchJob_SJ);
		
		JLabel JL_jobDetails_SJ = new JLabel("Detalii jobului");
		JL_jobDetails_SJ.setHorizontalAlignment(SwingConstants.CENTER);
		JL_jobDetails_SJ.setFont(new Font("Tahoma", Font.BOLD, 16));
		JL_jobDetails_SJ.setBounds(278, 143, 400, 22);
		panelSJ.add(JL_jobDetails_SJ);
		
		JLabel JL_jobName_SJ = new JLabel("Denumire:");
		JL_jobName_SJ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JL_jobName_SJ.setBounds(278, 178, 75, 22);
		panelSJ.add(JL_jobName_SJ);
		
		JTF_jobName_SJ = new JTextField();
		JTF_jobName_SJ.setEditable(false);
		JTF_jobName_SJ.setBounds(365, 179, 311, 22);
		panelSJ.add(JTF_jobName_SJ);
		JTF_jobName_SJ.setColumns(10);
		
		JLabel JL_jobPrice_SJ = new JLabel("Tarifa:");
		JL_jobPrice_SJ.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JL_jobPrice_SJ.setBounds(278, 213, 75, 22);
		panelSJ.add(JL_jobPrice_SJ);
		
		JTF_jobPrice_SJ = new JTextField();
		JTF_jobPrice_SJ.setColumns(10);
		JTF_jobPrice_SJ.setBounds(365, 214, 311, 22);
		panelSJ.add(JTF_jobPrice_SJ);
		
		JB_addJobToList_SJ = new JButton("Adauga la list");
		JB_addJobToList_SJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(selectedJob!=null) {
					List<JTextField> jtf_list = new ArrayList<JTextField>();
					jtf_list.add(JTF_jobName_SJ);
					jtf_list.add(JTF_jobPrice_SJ);
					
					if(InputValidation(jtf_list)) {
						saveRegistrationJob(selectedJob.getId(), selectedRegistrationID, Float.parseFloat(JTF_jobPrice_SJ.getText()));
						
						SetDefaultTable(JT_jobs_SJ, new String[]{"Job", "Numele jobului", "Tarif final"});
						loadRegistrationJob(selectedRegistrationID);
						
						panelSJDetailsResetter();
					}
				}else {
					//MESSAGEBOX HERE
					System.out.println("Select a job first.");
				}
			}
		});
		JB_addJobToList_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_addJobToList_SJ.setBounds(278, 316, 230, 40);
		panelSJ.add(JB_addJobToList_SJ);
		
		JB_updateRegistrationJob_SJ = new JButton("Actualizare");
		JB_updateRegistrationJob_SJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(selectedRegistrationJob!=null) {
					List<JTextField> jtf_list = new ArrayList<JTextField>();
					jtf_list.add(JTF_jobName_SJ);
					jtf_list.add(JTF_jobPrice_SJ);
					
					if(InputValidation(jtf_list)) {
						updateRegistrationJob(Float.valueOf(JTF_jobPrice_SJ.getText()));
						
						panelSJDetailsResetter();
					}
				}else {
					//MESSAGEBOX HERE
					System.out.println("Select something from the table first.");
				}
			}
		});
		JB_updateRegistrationJob_SJ.setVisible(false);
		JB_updateRegistrationJob_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_updateRegistrationJob_SJ.setBounds(278, 316, 230, 40);
		panelSJ.add(JB_updateRegistrationJob_SJ);
		
		JButton JB_clearJob_SJ = new JButton("Anulare");
		JB_clearJob_SJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSJDetailsResetter();
			}
		});
		JB_clearJob_SJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_clearJob_SJ.setBounds(520, 316, 158, 40);
		panelSJ.add(JB_clearJob_SJ);
		
		JScrollPane JSP_jobs_SJ = new JScrollPane();
		JSP_jobs_SJ.setBounds(690, 55, 1100, 301);
		panelSJ.add(JSP_jobs_SJ);
		
		JT_jobs_SJ = new JTable();
		JT_jobs_SJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_jobs_SJ.convertRowIndexToModel(JT_jobs_SJ.getSelectedRow());
				TableModel model = JT_jobs_SJ.getModel();
				JTF_jobName_SJ.setText(model.getValueAt(index, 1).toString());
				JTF_jobPrice_SJ.setText(model.getValueAt(index, 2).toString());
				
				selectedRegistrationJob = (Registration_job) model.getValueAt(index, 0);
				
				JB_updateRegistrationJob_SJ.setVisible(true);
				JB_addJobToList_SJ.setVisible(false);
			}
		});
		JSP_jobs_SJ.setViewportView(JT_jobs_SJ);
		
		JButton JB_saveJob_SJ = new JButton("Salveaza");
		JB_saveJob_SJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSJDetailsResetter();
				finalizateRegistrationJob(selectedRegistrationID);
				
				SetDefaultTable(JT_info_ANR, new String[]{"Numele jobului", "Tarid final"});
				loadRegistrationInfo(selectedRegistrationID, "Registration_job");
				
				PanelNavigationHelper(panelSJ, panelANR);
			}
		});
		JB_saveJob_SJ.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JB_saveJob_SJ.setBounds(1490, 369, 300, 65);
		panelSJ.add(JB_saveJob_SJ);
		
		JLabel backSJ = new JLabel("");
		backSJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backSJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelSJ, panelANR);
			}
		});
		backSJ.setIcon(new ImageIcon(MainFrame.class.getResource("/images/return_32.png")));
		backSJ.setToolTipText("BACK");
		backSJ.setHorizontalAlignment(SwingConstants.CENTER);
		backSJ.setBounds(10, 10, 32, 32);
		panelSJ.add(backSJ);
		
		JLabel exitSJ = new JLabel("");
		exitSJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitSJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitDialog();
			}
		});
		exitSJ.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit_32.png")));
		exitSJ.setToolTipText("EXIT");
		exitSJ.setHorizontalAlignment(SwingConstants.CENTER);
		exitSJ.setBounds(1758, 10, 32, 32);
		panelSJ.add(exitSJ);
		
		/////////////////////////////////////////////////////
		//--------//Select Inventory Item Section//--------//
		/////////////////////////////////////////////////////
		
		panelSII = new JPanel();
		panelSII.setName("panelSII");
		contentPane.add(panelSII, "name_579914237106100");
		panelSII.setLayout(null);
		
		JLabel MLCard_inventory_SII = new JLabel("");
		MLCard_inventory_SII.setIcon(new ImageIcon(MainFrame.class.getResource("/images/inventory_256.png")));
		MLCard_inventory_SII.setBounds(10, 55, 256, 301);
		panelSII.add(MLCard_inventory_SII);
		
		JTF_inventoryItemSearch_SII = new JTextField();
		JTF_inventoryItemSearch_SII.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(JTF_inventoryItemSearch_SII.getBorder()!=null) {
					JTF_inventoryItemSearch_SII.setBorder(null);
				}
			}
		});
		JTF_inventoryItemSearch_SII.setBounds(278, 55, 400, 22);
		panelSII.add(JTF_inventoryItemSearch_SII);
		JTF_inventoryItemSearch_SII.setColumns(10);
		
		JButton JB_selectInventoryItem_SII = new JButton("Selectare");
		JB_selectInventoryItem_SII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSIIDetailsResetter();
				
				List<JTextField> jtf_list = new ArrayList<JTextField>();
				jtf_list.add(JTF_inventoryItemSearch_SII);
				
				if(InputValidation(jtf_list)) {
					if(getInventoryItemByAutoPieceID(JTF_inventoryItemSearch_SII.getText())) {
						JTF_inventoryItemName_SII.setText(selectedInventoryItem.getAutopieces().getAutopiecename());
						JTF_inventoryItemPrice_SII.setText(String.valueOf(selectedInventoryItem.getUnitepriceout()));
					}
				}
			}
		});
		JB_selectInventoryItem_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_selectInventoryItem_SII.setBounds(278, 90, 230, 40);
		panelSII.add(JB_selectInventoryItem_SII);
		
		JButton JB_searchInventory_SII = new JButton("Cautare");
		JB_searchInventory_SII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSIIDetailsResetter();
				
				PanelNavigationHelper(panelSII, panelIM);
				
				SetDefaultTable(JT_inventory_IM, new String[]{"ID", "Piese de auto", "Furnizor", "Quantity", "Price IN", "Price OUT", "Date"});				
				loadInventory();
				
				JB_selectInventoryItem_IM.setVisible(true);
				JB_updateInventoryItem_IM.setVisible(false);
				JB_deleteInventoryItem_IM.setVisible(false);
			}
		});
		JB_searchInventory_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_searchInventory_SII.setBounds(520, 90, 158, 40);
		panelSII.add(JB_searchInventory_SII);
		
		JLabel JL_inventoryItemDetails_SII = new JLabel("Detalii piesei");
		JL_inventoryItemDetails_SII.setHorizontalAlignment(SwingConstants.CENTER);
		JL_inventoryItemDetails_SII.setFont(new Font("Tahoma", Font.BOLD, 16));
		JL_inventoryItemDetails_SII.setBounds(278, 143, 400, 22);
		panelSII.add(JL_inventoryItemDetails_SII);
		
		JLabel JL_inventoryItemName_SII = new JLabel("Denumire:");
		JL_inventoryItemName_SII.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JL_inventoryItemName_SII.setBounds(278, 178, 75, 22);
		panelSII.add(JL_inventoryItemName_SII);
		
		JTF_inventoryItemName_SII = new JTextField();
		JTF_inventoryItemName_SII.setEditable(false);
		JTF_inventoryItemName_SII.setBounds(365, 179, 311, 22);
		panelSII.add(JTF_inventoryItemName_SII);
		JTF_inventoryItemName_SII.setColumns(10);
		
		JLabel JL_inventoryItemPrice_SII = new JLabel("Pret:");
		JL_inventoryItemPrice_SII.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JL_inventoryItemPrice_SII.setBounds(278, 213, 75, 22);
		panelSII.add(JL_inventoryItemPrice_SII);
		
		JTF_inventoryItemPrice_SII = new JTextField();
		JTF_inventoryItemPrice_SII.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_inventoryItemPrice_SII.getBorder()!=null) {
					JTF_inventoryItemPrice_SII.setBorder(null);
				}
			}
		});
		JTF_inventoryItemPrice_SII.setColumns(10);
		JTF_inventoryItemPrice_SII.setBounds(365, 214, 311, 22);
		panelSII.add(JTF_inventoryItemPrice_SII);
		
		JLabel JL_invenoryItemQuantity_SII = new JLabel("Quantity:");
		JL_invenoryItemQuantity_SII.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JL_invenoryItemQuantity_SII.setBounds(278, 248, 75, 22);
		panelSII.add(JL_invenoryItemQuantity_SII);
		
		JTF_invenotyItemQuantity_SII = new JTextField();
		JTF_invenotyItemQuantity_SII.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTF_invenotyItemQuantity_SII.getBorder()!=null) {
					JTF_invenotyItemQuantity_SII.setBorder(null);
				}
			}
		});
		JTF_invenotyItemQuantity_SII.setColumns(10);
		JTF_invenotyItemQuantity_SII.setBounds(365, 249, 311, 22);
		panelSII.add(JTF_invenotyItemQuantity_SII);
		
		JB_addInventoryItemToList_SII = new JButton("Adauga la list");
		JB_addInventoryItemToList_SII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(selectedInventoryItem!=null) {
					List<JTextField> jtf_list = new ArrayList<JTextField>();
					jtf_list.add(JTF_inventoryItemPrice_SII);
					jtf_list.add(JTF_invenotyItemQuantity_SII);
					
					if(InputValidation(jtf_list)) {
						saveRegistrationInventory(selectedRegistrationID, selectedInventoryItem.getId(), Float.valueOf(JTF_inventoryItemPrice_SII.getText()), Float.valueOf(JTF_invenotyItemQuantity_SII.getText()));
						
						SetDefaultTable(JT_inventory_SII, new String[]{"Inventory item", "Piece ID","Numele piesei", "Pret final", "Quantity"});
						loadRegistrationInventory(selectedRegistrationID);
						
						panelSIIDetailsResetter();
					}
				}else {
					//MESSAGEBOX HERE
					System.out.println("Select a inventory item first.");
				}
			}
		});
		JB_addInventoryItemToList_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_addInventoryItemToList_SII.setBounds(278, 316, 230, 40);
		panelSII.add(JB_addInventoryItemToList_SII);
		
		JB_updateRegistrationInventory_SII = new JButton("Actualizare");
		JB_updateRegistrationInventory_SII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(selectedRegistrationInventory!=null) {
					List<JTextField> jtf_list = new ArrayList<JTextField>();
					jtf_list.add(JTF_inventoryItemPrice_SII);
					jtf_list.add(JTF_invenotyItemQuantity_SII);
					
					if(InputValidation(jtf_list)) {
						updateRegistrationInventory(Float.valueOf(JTF_inventoryItemPrice_SII.getText()), Float.valueOf(JTF_invenotyItemQuantity_SII.getText()));
						
						panelSIIDetailsResetter();
					}
				}else {
					//MESSAGEBOX HERE
					System.out.println("Select something from the table first.");
				}
			}
		});
		JB_updateRegistrationInventory_SII.setVisible(false);
		JB_updateRegistrationInventory_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_updateRegistrationInventory_SII.setBounds(278, 316, 230, 40);
		panelSII.add(JB_updateRegistrationInventory_SII);
		
		JB_clearInvenoryItem_SII = new JButton("Anulare");
		JB_clearInvenoryItem_SII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelSIIDetailsResetter();
			}
		});
		JB_clearInvenoryItem_SII.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JB_clearInvenoryItem_SII.setBounds(520, 316, 158, 40);
		panelSII.add(JB_clearInvenoryItem_SII);
		
		JScrollPane JSP_inventory_SII = new JScrollPane();
		JSP_inventory_SII.setBounds(690, 55, 1100, 301);
		panelSII.add(JSP_inventory_SII);
		
		JT_inventory_SII = new JTable();
		JT_inventory_SII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = JT_inventory_SII.convertRowIndexToModel(JT_inventory_SII.getSelectedRow());
				TableModel model = JT_inventory_SII.getModel();
				JTF_inventoryItemName_SII.setText(model.getValueAt(index, 1).toString());
				JTF_inventoryItemPrice_SII.setText(model.getValueAt(index, 3).toString());
				JTF_invenotyItemQuantity_SII.setText(model.getValueAt(index, 4).toString());
				
				selectedRegistrationInventory = (Registrations_inventory) model.getValueAt(index, 0);
				
				JB_updateRegistrationInventory_SII.setVisible(true);
				JB_addInventoryItemToList_SII.setVisible(false);
			}
		});
		JSP_inventory_SII.setViewportView(JT_inventory_SII);
		
		JButton JB_saveInventory_SII = new JButton("Salveaza");
		JB_saveInventory_SII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSIIDetailsResetter();
				finalizateRegistrationInventory(selectedRegistrationID);
				
				SetDefaultTable(JT_info_ANR, new String[]{"Piece ID", "Pret final", "Quantity"});
				loadRegistrationInfo(selectedRegistrationID, "Registrations_inventory");
				
				PanelNavigationHelper(panelSII, panelANR);
			}
		});
		JB_saveInventory_SII.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JB_saveInventory_SII.setBounds(1490, 369, 300, 65);
		panelSII.add(JB_saveInventory_SII);
		
		JLabel backSII = new JLabel("");
		backSII.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backSII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelNavigationHelper(panelSII, panelANR);
			}
		});
		backSII.setIcon(new ImageIcon(MainFrame.class.getResource("/images/return_32.png")));
		backSII.setToolTipText("BACK");
		backSII.setHorizontalAlignment(SwingConstants.CENTER);
		backSII.setBounds(10, 10, 32, 32);
		panelSII.add(backSII);
		
		JLabel exitSII= new JLabel("");
		exitSII.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitSII.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitDialog();
			}
		});
		exitSII.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit_32.png")));
		exitSII.setToolTipText("EXIT");
		exitSII.setHorizontalAlignment(SwingConstants.CENTER);
		exitSII.setBounds(1758, 10, 32, 32);
		panelSII.add(exitSII);
		
		//On Creation
		panelDB.setVisible(true);
		panelCR.setVisible(false);
		panelLPR.setVisible(false);
		panelNPR.setVisible(false);
		panelCL.setVisible(false);
		panelAPL.setVisible(false);
		panelAR.setVisible(false);
		panelANS.setVisible(false);
		panelAAP.setVisible(false);
		panelANJ.setVisible(false);
		panelJL.setVisible(false);
		panelANU.setVisible(false);	
		panelUL.setVisible(false);	
		panelAA.setVisible(false);
		panelANR.setVisible(false);
		panelIM.setVisible(false);
		panelSL.setVisible(false);
		panelRAPL.setVisible(false);
		panelSJ.setVisible(false);
		panelSII.setVisible(false);
	}
	
	////////////////////////////////////////////////////
	//--------//CRUD & Other Methods Section//--------//
	////////////////////////////////////////////////////
	
	private void PanelNavigationHelper(JPanel from, JPanel to) {
		from.setVisible(false);
		to.setVisible(true);
		
		previousPanel = from.getName();
	}
	
	private void SetDefaultTable(JTable table, String[] cols) {
			table.setRowSorter(null);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 21));
			table.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			DefaultTableModel dtm = new DefaultTableModel(cols, 0);
			table.setModel(dtm);
	}
	
	private void generateRegistrationNumber() {
		try {
			//Generating unique String for Registration Number with 24 characters
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
	
	private void GeneralResetter(List<JTextField> jtf_list, List<JLabel> jl_list, List<JButton> jb_list, Boolean jtf_state, Boolean jb_state) {
		if(jtf_list!=null) {
			for(JTextField jtf: jtf_list) {
				jtf.setText(null);
				jtf.setVisible(jtf_state);
			}
		}
		//If the JTextField is visible, the matching JLabel should be visible as well, so I wanted to avoid using an other parameter
		if(jl_list!=null) {
			for(JLabel jl: jl_list) {
				jl.setVisible(jtf_state);
			}
		}
		if(jb_list!=null) {
			for(JButton jb: jb_list) {
				jb.setEnabled(jb_state);
			}
		}
	}
		
	private void TextFieldBorderResetter(List<JTextField> jtf_list) {
		for(JTextField jtf: jtf_list) {
			jtf.setBorder(null);
		}
	}
	
	private void LoadClients() {
		//Begin transaction
		session.beginTransaction();
	    
		List<Client> clients= (List<Client>)session.createQuery("from Client").list();
		
		DefaultTableModel dtm = (DefaultTableModel) JT_clients_CL.getModel();
		
		for(Client c:clients) 
		{
		    String[] row= {String.valueOf(c.getId()) ,c.getContactname(), c.getContactphone(), String.valueOf(c.getIscompany())};
		    dtm.addRow( row );
		}

		JT_clients_CL.setModel(dtm);
		JT_clients_CL.removeColumn(JT_clients_CL.getColumnModel().getColumn(0));
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	    
	    //Clear search filter and reset ClientList InfoPanel
		JTF_clientNameInfo_CL.setText(null);
		JTF_clientPhoneInfo_CL.setText(null);
		JTF_clientCompanyInfo_CL.setText(null);
		selectedClientID = 0;
	    JTF_clientQuickSearchByName_CL.setText(null);
	    JTF_clientQuickSearchByPhone_CL.setText(null);
	    JTF_clientQuickSearchByStatus_CL.setText(null);
	    companyDataSetter(false, false);
	}
	
	private void LoadPieces() {
		//Begin transaction
		session.beginTransaction();
	    
		List<Auto_pieces> pieces = (List<Auto_pieces>) session.createQuery("from Auto_pieces").list();
		String[] cols = { "Cod", "Nume", "Unitate/Masura" };

		DefaultTableModel dtm = new DefaultTableModel(cols, 0);

		for (Auto_pieces a : pieces) {
			String[] row = { a.getId(), a.getAutopiecename(), a.getAutopieceunitename() };
			dtm.addRow(row);
		}

		JT_pieces_APL.setModel(dtm);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	    
	    //Clear search filter and reset AutoPicesList InfoPanel
	    List<JTextField> jtf_list = new ArrayList<JTextField>();
	    jtf_list.add(JTF_pieceIDInfo_APL);
	    jtf_list.add(JTF_pieceNameInfo_APL);
	    jtf_list.add(JTF_pieceUnitNameInfo_APL);
	    jtf_list.add(JTF_pieceQuickSearch_APL);
	    
	    List<JButton> jb_list = new ArrayList<JButton>();
	    jb_list.add(JB_updatePiece_APL);
	    jb_list.add(JB_deletePiece_APL);
	    
	    GeneralResetter(jtf_list, null, jb_list, true, false);
	}
		
	private void LoadJobs() {
		//Begin transaction
		session.beginTransaction();
	    
		List<Job> jobs= (List<Job>)session.createQuery("from Job").list();
		
		DefaultTableModel dtm = (DefaultTableModel) JT_jobs_JL.getModel();
		
		for(Job j:jobs) 
		{
		    String[] row= {String.valueOf(j.getId()) , j.getJobname(), String.valueOf(j.getJobprice())};
		    dtm.addRow( row );
		}

		JT_jobs_JL.setModel(dtm);
		JT_jobs_JL.removeColumn(JT_jobs_JL.getColumnModel().getColumn(0));
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	private void LoadReplacables(String piece) {
		//Begin transaction
		session.beginTransaction();

		DefaultTableModel dtm = (DefaultTableModel) JT_pieces_AR.getModel();
		dtm.setRowCount(0);
		
		try {		
			Query<Auto_pieces> querry;
			querry = session.createQuery("from Auto_pieces where id=:id");
			querry.setParameter("id", piece);
			
			Auto_pieces selectedPiece = (Auto_pieces) querry.uniqueResult();
			Auto_pieces replacablePiece;
			
			for (Replaced rep : selectedPiece.getReplaceables()) 
			{
				querry = session.createQuery("from Auto_pieces where id=:id");
				querry.setParameter("id", rep.getAutopiecesidto());
				
				replacablePiece = (Auto_pieces) querry.uniqueResult();
				
				String[] row = { replacablePiece.getId(), replacablePiece.getAutopiecename(), replacablePiece.getAutopieceunitename() };
				dtm.addRow(row);
			}
			
			List<JTextField> jtf_list = new ArrayList<JTextField>();
			jtf_list.add(JTF_pieceIDInfo_AR);
			jtf_list.add(JTF_pieceNameInfo_AR);
			jtf_list.add(JTF_pieceUnitNameInfo_AR);
			
			List<JButton> jb_list = new ArrayList<JButton>();
			jb_list.add(JB_deleteReplacable_AR);
			
			GeneralResetter(jtf_list, null, jb_list, true, false);
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}

		JT_pieces_AR.setModel(dtm);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
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
			    String[] row= {String.valueOf(u.getId()) , u.getUsername(), u.getRoles().getRolename()};
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
				
			    String[] row= {String.valueOf(i.getId()) , i.getAutopieces().getId(), i.getClients().getContactname(), String.valueOf(i.getQuantity()), String.valueOf(i.getUnitepricein()),
			    		String.valueOf(i.getUnitepriceout()), formattedDate!=null?formattedDate:""};
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
	
	private void loadSupplies() {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			List<Reception> receptions= (List<Reception>)session.createQuery("from Reception").list();
			//System.out.println(receptions.toString());
			
			DefaultTableModel dtm = (DefaultTableModel) JT_supplies_SL.getModel();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDateIN;
			String formattedDueDate;
			//Date dateIN;
			//Date dueDate;
			
			for(Reception r:receptions) 
			{
				try {
					formattedDateIN = sdf.format(r.getDatein());
					formattedDueDate = sdf.format(r.getDuedate());
					//dateIN = sdf.parse(formattedDateIN);
					//dueDate = sdf.parse(formattedDueDate);
				}catch(Exception ex){
					//dateIN = null;
					//dueDate = null;
					formattedDateIN = null;
					formattedDueDate = null;
				}
				
			    Object[] row= {r.getId() , r.getClients().getContactname(), r.getIncominginvoicenr(), formattedDateIN!=null?formattedDateIN:"", formattedDueDate!=null?formattedDueDate:""};
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
	
	//Load the Reception Auto Pieces table, where the id is given by selection
	private void loadReceptionAutoPieces(int id) {
		//Begin transaction
		session.beginTransaction();
	    
		List<Receptions_auto_pieces> raps= (List<Receptions_auto_pieces>)session
				.createQuery("from Receptions_auto_pieces where receptionsid=:id")
				.setParameter("id", id)
				.list();
		
		DefaultTableModel dtm = (DefaultTableModel) JT_rapl_RAPL.getModel();
		
		for(Receptions_auto_pieces r:raps) 
		{
		    Object[] row= {r.getAutopiecesid(), r.getQuantity(), r.getQuantity(), r.getUnitepricein(), r.getUnitepriceout(), r.getVatitem()};
		    dtm.addRow( row );
		}

		JT_rapl_RAPL.setModel(dtm);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
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
				
			    Object[] row= {car.getBrand() , car.getModel(), car.getLicenseNumber(), car.getChassisnr()};
			    dtm.addRow( row );
			}

			JT_prevCars_AA.setModel(dtm);
		      
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
			    Object[] row= {ri, ri.getInventory().getAutopiecesid() , ri.getInventory().getAutopieces().getAutopiecename(), ri.getNewuniteprice(), ri.getQuantity()};
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
	
	private void SaveLegalPerson() {
		//Getting the textbox values
		String companyAdress = JTF_companyAddress_LPR.getText();
		String companyBank = JTF_companyBank_LPR.getText();
		String companyCIF = JTF_companyCIF_LPR.getText();
		String companyIBAN = JTF_companyIBAN_LPR.getText();
		String clientPhone = JTF_clientPhone_LPR.getText();
		String companyPhone = JTF_companyPhone_LPR.getText();
		String clientName = JTF_clientName_LPR.getText();
		String companyName = JTF_companyName_LPR.getText();
		String companyOffice = JTF_companyBranchOffice_LPR.getText();
		String companyRegNR = JTF_companyRegNR_LPR.getText();
	
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
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}

	private void SaveNaturalClient() {
		//Getting the textbox values
		String clientName = JTF_clientName_NPR.getText();
		String clientPhone = JTF_clientPhone_NPR.getText();
		
		//Begin transaction
		session.beginTransaction();
	    
	    //Create new Client object
	    Client newClient = new Client(clientName, clientPhone, false);
	    
	    //Save Client
	    session.save(newClient);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}

	private void SaveAutoPiece(List<JTextField> jtf_list) {
		//Begin transaction
		session.beginTransaction();
	    
	    //Create new Client object
	    Auto_pieces auto_piece = new Auto_pieces(jtf_list.get(0).getText(), jtf_list.get(1).getText(), jtf_list.get(2).getText());
	    
	    //Save Client
	    session.save(auto_piece);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	private void SaveJob(List<JTextField> jtf_list) {
		//Begin transaction
		session.beginTransaction();
	    
	    //Create new Client object
	    Job job = new Job(jtf_list.get(0).getText(), Float.valueOf(jtf_list.get(1).getText()));
	    
	    //Save Client
	    session.save(job);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	private void SaveReception(List<JTextField> jtf_list, List<JDateChooser> jdc_list) {
		//Begin transaction
		session.beginTransaction();
		
		Reception reception = null;
		
		try {
		    //Create new Reception object
			reception = new Reception(selectedClient.getId(), jtf_list.get(1).getText(), jdc_list.get(0).getDate(), jdc_list.get(1).getDate());	    
			    
			//Save Reception
			session.save(reception);
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    SaveReceptionAutoPiece(reception.getId());
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}

	private void SaveReceptionAutoPiece(int apid) {
	    //Begin transaction
	    session.beginTransaction();
	    
		Receptions_auto_pieces receptions_auto_pieces = null;
	    
		try {
			TableModel model = JT_pieces_ANS.getModel();
		    for(int i=0; i<model.getRowCount(); i++) {	    	
		    	receptions_auto_pieces = new Receptions_auto_pieces(apid, model.getValueAt(i, 0).toString(), 
		    			model.getValueAt(i, 3).toString().isEmpty()?0:Float.valueOf(model.getValueAt(i, 3).toString()),
		    			model.getValueAt(i, 4).toString().isEmpty()?0:Float.valueOf(model.getValueAt(i, 4).toString()),
		    			model.getValueAt(i, 5).toString().isEmpty()?0:Float.valueOf(model.getValueAt(i, 5).toString()),
		    			model.getValueAt(i, 6).toString().isEmpty()?0:Float.valueOf(model.getValueAt(i, 6).toString()));
		    	
			    //Save Receptions_auto_pieces
			    session.save(receptions_auto_pieces);		    	
		    }
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
	    session.getTransaction().commit();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	private void SaveUser(JTextField uname, JPasswordField upwd, int urole) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
		    //Create new Client object
		    User newUser = new User(urole, uname.getText(), new String(upwd.getPassword()));
		    
		    //Save Client
		    session.save(newUser);
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		    
		    selectedRoleID = 1;
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void saveCar(List<JTextField> jtf_list) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
		    //Create new Client object
		    Car car = new Car(jtf_list.get(0).getText(), jtf_list.get(1).getText(), jtf_list.get(2).getText(), jtf_list.get(3).getText(), jtf_list.get(4).getText(), Integer.parseInt(jtf_list.get(5).getText()));
		    
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
	
	private void saveRegistration(int carsid, int clientsid, String regnr, Date regdate) {
		//Begin transaction
		session.beginTransaction();
		
		Registration registration = null;
		
		try {
		    //Create new Registration object
			if(carsid==0) {
				if(clientsid==0) {
					registration = new Registration(regnr, regdate);	
				}else {
					registration = new Registration(clientsid, regnr, regdate);	
				}
			}else {
				registration = new Registration(carsid, clientsid, regnr, regdate);	  
			}
			    
			//Save Registration
			session.save(registration);
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Store the registration ID
	    selectedRegistrationID = registration.getId();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	private void saveRegistrationInventory(Integer registrationsid, Integer inventoryid, float newuniteprice, float quantity) {
		//Begin transaction
		session.beginTransaction();
		
		Registrations_inventory registrations_inventory =null;
		
		try {
			//Create new Registration Inventory object
			registrations_inventory = new Registrations_inventory(registrationsid, inventoryid, newuniteprice, quantity);
			
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

	private void saveRegistrationJob(Integer jobsid, Integer registrationsid, float newjobprice) {
		//Begin transaction
		session.beginTransaction();
		
		Registration_job registration_job = null;
		
		try {
			//Create new Registration Job(Job registration) object
			registration_job = new Registration_job(jobsid, registrationsid, newjobprice);

			//Save Registration Inventory
			session.save(registration_job);
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
	
	private void AddNewAutoPieceToReplaced(String from, String to) {
		//Begin transaction
		session.beginTransaction();
		
		try {
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
			    
			    LoadReplacables(from);						
			}else {
				System.out.println("Pieces are not provided or not exists.");
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
		
	private void AddNewAutoPieceToReception(List<JTextField> jtf_list) {
		DefaultTableModel dtm = (DefaultTableModel) JT_pieces_ANS.getModel();
		
		dtm.insertRow(dtm.getRowCount(), new Object[] { selectedAutoPiece.getId(), selectedAutoPiece.getAutopiecename(), selectedAutoPiece.getAutopieceunitename(),
				jtf_list.get(1).getText(), jtf_list.get(2).getText(), jtf_list.get(3).getText(), jtf_list.get(4).getText()});

		//JT_pieces_ANS.setModel(dtm);
	}
	
	private Role getRoleByName(String rname) {
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Role> querry = session.createQuery("from Role where rolename=:rolename");
			querry.setParameter("rolename", rname);
			List<Role> rl = (List<Role>) querry.list();
			int nr = querry.list().size();
      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
			if(nr>1) {
				System.out.println("Two or more with the same name. Try search please.");
			}else if(nr<1) {
				System.out.println("No result with this name.");
			}else {
			    return rl.get(0); //unique result found
			}
		    
			return null; //not(no) unique result
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
	
	
	private void getReceptionByID(int id) {
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Reception> querry = session.createQuery("from Reception where id=:id");
			querry.setParameter("id", id);
			selectedReception = (Reception) querry.uniqueResult();
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	
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
	
	private void simpleFilter(JTable table, String querry) {
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(table.getModel());
		
		table.setRowSorter(rowSorter);
		
		rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + querry));
	}

	private void dateFilter(JTable table, String querry, int column) {
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(table.getModel());
		
		table.setRowSorter(rowSorter);
		
		rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + querry, column));
	}
	
	private void getClientByID(int id) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			//Client client = (Client) session.load(Client.class, new Integer(id));
			
			Query<Client> querry = session.createQuery("from Client where id=:id");
			querry.setParameter("id", id);
			selectedClient = (Client) querry.uniqueResult();
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	
	private Boolean getPieceByID(String id) {
		//Begin transaction
		session.beginTransaction();
		
		Query<Auto_pieces> querry = session.createQuery("from Auto_pieces where id=:id");
		querry.setParameter("id", id);
		selectedAutoPiece = (Auto_pieces) querry.uniqueResult();
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    if(selectedAutoPiece==null) return false;
	    return true;
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	private void getInventoryItemByID(int id) {
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Inventory> querry = session.createQuery("from Inventory where id=:id");
			querry.setParameter("id", id);
			selectedInventoryItem = (Inventory) querry.uniqueResult();
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void getJobByID(int id) {
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Job> querry = session.createQuery("from Job where id=:id");
			querry.setParameter("id", id);
			selectedJob = (Job) querry.uniqueResult();
		      
		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private Boolean getClientIDByName(String name) {	
		//Begin transaction
		session.beginTransaction();
		
		Query<Client> querry = session.createQuery("from Client where contactname=:contactname and iscompany = true ");
		querry.setParameter("contactname", name);
		List<Client> cl = (List<Client>) querry.list();
		int nr = querry.list().size();
		Boolean exists = false;;
		if(nr>1) {
			System.out.println("Two or more with the same name. Try search please.");
		}else if(nr<1) {
			System.out.println("No result with this name.");
		}else {
			selectedClientID = cl.get(0).getId();
			exists = true;
		}
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    return exists;
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	//Resets all components value of the panel to the default(original/starting) value
	
	private Boolean getInventoryItemByAutoPieceID(String name) {
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Inventory> querry = session.createQuery("from Inventory where autopiecesid=:autopiecesid ");
			querry.setParameter("autopiecesid", name);
			List<Inventory> il = (List<Inventory>) querry.list();
			int nr = querry.list().size();
			Boolean exists = false;;
			if(nr>1) {
				System.out.println("Two or more with the same name. Try search please.");
			}else if(nr<1) {
				System.out.println("No result with this name.");
			}else {
				selectedInventoryItem = il.get(0);
				exists = true;
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

	private Boolean getJobByName(String name) {
		try {
			//Begin transaction
			session.beginTransaction();
			
			Query<Job> querry = session.createQuery("from Job where jobname=:jobname ");
			querry.setParameter("jobname", name);
			List<Job> jl = (List<Job>) querry.list();
			int nr = querry.list().size();
			Boolean exists = false;;
			if(nr>1) {
				System.out.println("Two or more with the same name. Try search please.");
			}else if(nr<1) {
				System.out.println("No result with this name.");
			}else {
				selectedJob = jl.get(0);
				exists = true;
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
	
	private void panelJLResetter() {
		//JTextField and JButton resetter				
		List<JTextField> jtf_list = new ArrayList<JTextField>();
		jtf_list.add(JTF_jobNameInfo_JL);
		jtf_list.add(JTF_jobPriceInfo_JL);
		jtf_list.add(JTF_jobQuickSearch_JL);
		
		List<JButton> jb_list = new ArrayList<JButton>();
		jb_list.add(JB_updateJob_JL);
		jb_list.add(JB_deleteJob_JL);
		
		GeneralResetter(jtf_list, null, jb_list, true, false);
		selectedJobID = 0;
	}

	private void panelULResetter() {
		//JTextField, JComboBox and JButton resetter				
		List<JTextField> jtf_list = new ArrayList<JTextField>();
		jtf_list.add(JTF_userNameInfo_UL);
		
		JCB_userRoleInfo_UL.setSelectedIndex(1);
		JCB_userRoleInfo_UL.setEnabled(false);
		
		List<JButton> jb_list = new ArrayList<JButton>();
		jb_list.add(JB_updateUser_UL);
		jb_list.add(JB_deleteUser_UL);
		
		GeneralResetter(jtf_list, null, jb_list, true, false);
		selectedUserID = 0;
		selectedRoleID = 1;
	}
		
	private void panelIMResetter() {
		//JTextField and JButton resetter				
		List<JTextField> jtf_list = new ArrayList<JTextField>();
		jtf_list.add(JTF_pieceIDInfo_IM);
		jtf_list.add(JTF_clientNameInfo_IM);
		jtf_list.add(JTF_quantityInfo_IM);
		jtf_list.add(JTF_unitePriceINInfo_IM);
		jtf_list.add(JTF_unitePriceOUTInfo_IM);
		jtf_list.add(JTF_clientQuickSearch_IM);
		jtf_list.add(JTF_autoPieceQuickSearch_IM);
		jtf_list.add(JTF_dateINQuickSearch_IM);
		
		JB_selectInventoryItem_IM.setVisible(false);
		JB_updateInventoryItem_IM.setVisible(true);
		JB_deleteInventoryItem_IM.setVisible(true);
		
		GeneralResetter(jtf_list, null, null, true, null);
		selectedInventoryID = 0;
		JDC_dateINInfo_IM.setDate(null);
		JT_inventory_IM.setRowSorter(null);
	}

	private void panelSLResetter() {
		//JTextField and JButton resetter				
		List<JTextField> jtf_list = new ArrayList<JTextField>();
		jtf_list.add(JTF_clientNameInfo_SL);
		jtf_list.add(JTF_invoiceNRInfo_SL);
		jtf_list.add(JTF_clientNameQuickSearch_SL);
		jtf_list.add(JTF_invoiceNRQuickSearch_SL);
		
		List<JButton> jb_list = new ArrayList<JButton>();
		jb_list.add(JB_updateSupplie_SL);
		jb_list.add(JB_deleteSupplie_SL);
		jb_list.add(JB_selectSupplie_SL);
		
		GeneralResetter(jtf_list, null, jb_list, true, false);
		selectedSupplieID = 0;
		JDC_dateINInfo_SL.setDate(null);
		JDC_dueDateInfo_SL.setDate(null);
		JDC_dateINQuickSearch_SL.setDate(null);
		JDC_dueDateQuickSearch_SL.setDate(null);
		JT_supplies_SL.setRowSorter(null);
	}
	
	
	private void panelRAPLResetter() {
		//JTextField and JButton resetter				
		List<JTextField> jtf_list = new ArrayList<JTextField>();
		jtf_list.add(JTF_recInvoiceNRInfo_RAPL);
		jtf_list.add(JTF_autoPieceIDInfo_RAPL);
		jtf_list.add(JTF_quantityInfo_RAPL);
		jtf_list.add(JTF_priceINInfo_RAPL);
		jtf_list.add(JTF_priceOUTInfo_RAPL);
		jtf_list.add(JTF_vatInfo_RAPL);
		jtf_list.add(JTF_rapQuickSearch_RAPL);
		
		List<JButton> jb_list = new ArrayList<JButton>();
		jb_list.add(JB_updateRAP_RAPL);
		jb_list.add(JB_deleteRAP_RAPL);
		jb_list.add(JB_selectRAP_RAPL);
		
		GeneralResetter(jtf_list, null, jb_list, true, false);
		selectedRAPID = 0;
		//selectedSupplieID = 0;
		JT_rapl_RAPL.setRowSorter(null);
	}
	
	private void panelSIIDetailsResetter() {
		List<JTextField> jtf_list = new ArrayList<JTextField>();
		jtf_list.add(JTF_inventoryItemName_SII);
		jtf_list.add(JTF_inventoryItemPrice_SII);
		jtf_list.add(JTF_invenotyItemQuantity_SII);
		
		GeneralResetter(jtf_list, null, null, true, null);
		
		selectedInventoryItem = null;
		selectedRegistrationInventory = null;
		
		JB_updateRegistrationInventory_SII.setVisible(false);
		JB_addInventoryItemToList_SII.setVisible(true);
	}
	
	private void panelSJDetailsResetter() {
		List<JTextField> jtf_list = new ArrayList<JTextField>();
		jtf_list.add(JTF_jobName_SJ);
		jtf_list.add(JTF_jobPrice_SJ);
		
		GeneralResetter(jtf_list, null, null, true, null);
		
		selectedJob = null;
		selectedRegistrationJob = null;
		
		JB_updateRegistrationJob_SJ.setVisible(false);
		JB_addJobToList_SJ.setVisible(true);
	}
	
	
	private void companyDataSetter(Boolean jtf_state, Boolean jb_state) {
		List<JTextField> jtf_list = new ArrayList<JTextField>();
		jtf_list.add(JTF_companyNameInfo_CL);
		jtf_list.add(JTF_companyAddressInfo_CL);
		jtf_list.add(JTF_companyPhoneInfo_CL);
		jtf_list.add(JTF_companyCIFInfo_CL);
		jtf_list.add(JTF_companyRegNRInfo_CL);
		jtf_list.add(JTF_companyBankInfo_CL);
		jtf_list.add(JTF_companyIBANInfo_CL);
		jtf_list.add(JTF_companyBranchOfficeInfo_CL);
		
		List<JLabel> jl_list = new ArrayList<JLabel>();
		jl_list.add(JL_companyNameInfo_CL);
		jl_list.add(JL_companyAddressInfo_CL);
		jl_list.add(JL_companyPhoneInfo_CL);
		jl_list.add(JL_companyCIFInfo_CL);
		jl_list.add(JL_companyRegNRInfo_CL);
		jl_list.add(JL_companyBankInfo_CL);
		jl_list.add(JL_companyIBANInfo_CL);
		jl_list.add(JL_companyBranchOfficeInfo_CL);
		jl_list.add(JL_companyNameInfo_CL);
		
		List<JButton> jb_list = new ArrayList<JButton>();
		jb_list.add(JB_updateClient_CL);
		jb_list.add(JB_deleteClient_CL);
		jb_list.add(JB_selectClient_CL);
		
		GeneralResetter(jtf_list, jl_list, jb_list, jtf_state, jb_state);
	}


	
	private void updateNaturalClient(int id, String cname, String cphone) {
		//Begin transaction
		session.beginTransaction();
	    
		Client client = (Client) session.get(Client.class, id);
		client.setContactname(cname);
		client.setContactphone(cphone);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Reload updated table
	    System.out.println("Updated Successfully");
		SetDefaultTable(JT_clients_CL, new String[]{"ID", "Numele clientului", "Numarul de telefon", "Firm?"});				
		LoadClients();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	private void updateLegalClient(int id, String cname, String cphone, String comname, String comadd, String comtel, String comcif, String comreg, String combank, String comiban, String combranch) {
		//Begin transaction
		session.beginTransaction();
	    
		Client client = (Client) session.get(Client.class, id);
		client.setContactname(cname);
		client.setContactphone(cphone);
		
		client.getCompany().setCompanyname(comname);
		client.getCompany().setCompanyaddress(comadd);
		client.getCompany().setCompanyphone(comtel);
		client.getCompany().setCif(comcif);
		client.getCompany().setRegnr(comreg);
		client.getCompany().setBank(combank);
		client.getCompany().setIban(comiban);
		client.getCompany().setBranchoffice(combranch);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Reload updated table
	    System.out.println("Updated Successfully");
		SetDefaultTable(JT_clients_CL, new String[]{"ID", "Numele clientului", "Numarul de telefon", "Firm?"});				
		LoadClients();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}

	private void updateAutoPiece(String pid, String pname, String punit) {
		//Begin transaction
		session.beginTransaction();
	    
		Auto_pieces auto_piece = (Auto_pieces) session.get(Auto_pieces.class, pid);
		auto_piece.setId(pid);
		auto_piece.setAutopiecename(pname);
		auto_piece.setAutopieceunitename(punit);
		
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Reload updated table
	    System.out.println("Updated Successfully");
		SetDefaultTable(JT_pieces_APL, new String[]{"COD", "Nume", "Unitate/Masura"});
		LoadPieces();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}

	private void UpdateJob(String jname, float jprice) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			Job job = (Job) session.get(Job.class, selectedJobID);
			job.setJobname(jname);
			job.setJobprice(jprice);
		      
		    //Committing the transaction
			session.getTransaction().commit();
		    
		    //Reload updated table
		    System.out.println("Updated Successfully");
			SetDefaultTable(JT_jobs_JL, new String[]{"ID", "Numele jobului", "Tarifa jobului"});
			LoadJobs();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void updateUser(String uname) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			User user = (User) session.get(User.class, selectedUserID);
			user.setUsername(uname);
			user.setRolesid(selectedRoleID);
		      
		    //Committing the transaction
			session.getTransaction().commit();
			
			//Reopen the session factory, needed for releasing the cash, further research is required
			session.close();
			session = HibernateUtil.getSessionFactory().openSession();
		    
		    //Reload updated table
		    System.out.println("Updated Successfully");
			SetDefaultTable(JT_users_UL, new String[]{"ID", "Numele lucratorului", "Rolul"});				
			LoadUsers();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void updateRegistrationInventory(float riprice, float riquantity) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			selectedRegistrationInventory.setNewuniteprice(riprice);
			selectedRegistrationInventory.setQuantity(riquantity);
		      
		    //Committing the transaction
			session.getTransaction().commit();
		    
		    //Reload updated table
		    System.out.println("Updated Successfully");
			SetDefaultTable(JT_inventory_SII, new String[]{"Inventory item", "Piece ID","Numele piesei", "Pret final", "Quantity"});
			loadRegistrationInventory(selectedRegistrationID);
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	private void updateRegistrationJob(float rjprice) {
		try {
			//Begin transaction
			session.beginTransaction();
		    
			selectedRegistrationJob.setNewjobprice(rjprice);
		      
		    //Committing the transaction
			session.getTransaction().commit();
		    
		    //Reload updated table
		    System.out.println("Updated Successfully");
			SetDefaultTable(JT_jobs_SJ, new String[]{"Job", "Piece ID","Numele jobului", "Tarif final"});
			loadRegistrationJob(selectedRegistrationID);
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	
	private void deleteClient(int id) {
		//Begin transaction
		session.beginTransaction();
	    
		Client client = (Client)session.load(Client.class, id);
		if(client.getCompany()!=null) {
			session.remove(client.getCompany());
		}
		session.remove(client);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Reload modified table
	    System.out.println("Deleted Successfully");
		SetDefaultTable(JT_clients_CL, new String[]{"ID", "Numele clientului", "Numarul de telefon", "Firm?"});				
		LoadClients();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}

	private void deleteAutoPiece(String pid) {
		//Begin transaction
		session.beginTransaction();
	    
		Auto_pieces auto_piece = (Auto_pieces)session.load(Auto_pieces.class, pid);
		session.remove(auto_piece);
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Reload modified table
	    System.out.println("Deleted Successfully");
		SetDefaultTable(JT_pieces_APL, new String[]{"COD", "Nume", "Unitate/Masura"});
		LoadPieces();
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();
	}
	
	private void DeleteFromReplaced(String piece) {
		//Begin transaction
		session.beginTransaction();
	    
		Query query = session.createSQLQuery("DELETE FROM replaced WHERE autopiecesidfrom=:piece OR autopiecesidto=:piece")
				.setParameter("piece", piece);
		
		query.executeUpdate();
	      
	    //Committing the transaction
	    session.getTransaction().commit();
	    
	    //Reload modified table
	    System.out.println("Deleted Successfully");
	    LoadReplacables(JTF_newReplacable_AR.getText());
	    
	    //Shotting down the session factory
	    //HibernateUtil.shutDown();	
	}
	
	//Finalizate Registration Inventory
	private void finalizateRegistrationInventory(int registrationsid){
		try {
			int count = 0;
			
			//Begin transaction
			session.beginTransaction();
		    
			List<Registrations_inventory> registrations_inventory= (List<Registrations_inventory>)session
					.createQuery("from Registrations_inventory where registrationsid=:registrationsid")
					.setParameter("registrationsid", registrationsid)
					.list();
			
			count = registrations_inventory.size();
		      
		    //Committing the transaction
			session.getTransaction().commit();
			
			JL_selectPiece_ANR.setText(count + " piese selectate.");
			SC_addPiece_ANR.setEnabled(false);
			SC_editPiece_ANR.setEnabled(true);
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
	}
	
	private void finalizateRegistrationJob(int registrationsid){
		try {
			int count = 0;
			
			//Begin transaction
			session.beginTransaction();
		    
			List<Registration_job> registration_job= (List<Registration_job>)session
					.createQuery("from Registration_job where registrationsid=:registrationsid")
					.setParameter("registrationsid", registrationsid)
					.list();
			
			count = registration_job.size();
		      
		    //Committing the transaction
			session.getTransaction().commit();
			
			JL_selectJob_ANR.setText(count + " joburi selectate.");
			SC_addJob_ANR.setEnabled(false);
			SC_editJob_ANR.setEnabled(true);
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
	}
	
	//Is there unsaved (not empty) textfields
	private Boolean unsavedChecker(List<JTextField> jtf_list) {
		for(JTextField jtf: jtf_list) {
			if(!jtf.getText().isEmpty()) return true;
		}
		return false;
	}
	
	private void unsavedInformer() {
		JOptionPane.showMessageDialog(mainFrame, "Unele câmpuri nu sunt completate corect.", "Warning", JOptionPane.WARNING_MESSAGE);
	}

	//informs the user with a pop-up if something important is missing
	private void MissingStatementInformer(String statement) {
		JOptionPane.showMessageDialog(mainFrame, statement, "Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	//Return true if all inputs are valid, else false
	
	private Boolean InputValidation(List<JTextField> jtf_list) {
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
	
	//return true if the user truly wants to delete the document
	
	private void registrationNumberValadation(String regnr) {
		try {
			//Checking if there is already a Registrtation number with this generated String
			//Begin transaction
			session.beginTransaction();
		    
			Query<Registration> querry = session.createQuery("from Registration where regnr=:regnr ");
			querry.setParameter("regnr", regnr);
			int nr = querry.list().size();
			
			if(nr>=1) {
				System.out.println("Registration number already exists. Again.");
				JOptionPane.showMessageDialog(mainFrame, "Numărul de înregistrare dat există deja. Alege altul.");
				JTF_registrationNumber_ANR.setText(null);
			}else {
				JTF_registrationNumber_ANR.setText(regnr);
			}

		    //Committing the transaction
		    session.getTransaction().commit();
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
 	private Boolean DeleteConfirmation() {
		int i = JOptionPane.showConfirmDialog(mainFrame, "Sigur doriți să ștergeți?",  "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(i == JOptionPane.YES_OPTION) {
			return true;
		}
		
		return false;
	}
	
 	private Boolean backDialog() {
		int i = JOptionPane.showConfirmDialog(mainFrame, "Ești sigur că vrei să faci un pas înapoi? Datele dvs. nesalvate vor fi pierdute.",  "Back", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(i == JOptionPane.YES_OPTION) {
			return true;
		}else {
			return false;
		}
	}
	
	private void exitDialog() {
		int i = JOptionPane.showConfirmDialog(mainFrame, "Ești sigur că vrei să renunți?",  "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if(i == JOptionPane.OK_OPTION) {
		    //Closing the session
			session.close();
			System.exit(0);
		}
	}
}
