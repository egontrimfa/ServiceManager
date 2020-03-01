package com.license.Szerviz.Pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
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
import com.license.Szerviz.Entities.Client;
import com.license.Szerviz.Entities.Company;
import com.license.Szerviz.Entities.Job;
import com.license.Szerviz.Entities.Reception;
import com.license.Szerviz.Entities.Receptions_auto_pieces;
import com.license.Szerviz.Entities.Replaced;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
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
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JSeparator;

public class MainFrame extends JFrame {
	
	//!!! -- Jump To Line/Section: (CONTROL + L) -- !!!//
	
	//>>>Variables and JComponent Registration Section: 60
	//>>>Dasboard Section: 185
	//>>>Client Registration Section: 269
	//>>>Legal Person Registration Section: 336
	//>>>Natural Person Registration Section: 493
	//>>>Client List Section: 570
	//>>>Auto Piece List Section: 854
	//>>>Add Replace Section: 1050
	//>>>Add New Supplie Section: 1488
	//>>>Add New Auto Piece: 1639
	//>>>CRUD & Other Methods Section: 1289

	/////////////////////////////////////////////////////////////////////
	//--------//Variables and JComponent Registration Section//--------//
	////////////////////////////////////////////////////////////////////
	
	private static final long serialVersionUID = 3195004581454923665L;

	static MainFrame mainFrame = new MainFrame();
	
	//DEFINED
	private static Session session;
	private int xx,xy;
	private int selectedClientID;
	private String selectedPieceID;
	private int selectedJobID;
	private String selectPiece;
	static private TableRowSorter<TableModel> rowSorter;
	private Client selectedClient;
	private Company selectedCompany;
	private Auto_pieces selectedAutoPiece;
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
	private JTextField JTF_jobIDInfo_JL;
	private JTextField JTF_jobNameInfo_JL;
	private JTextField JTF_jobPriceInfo_JL;
	private JTextField JTF_jobQuickSearch_JL;
	private JButton JB_updateJob_JL;
	private JButton JB_deleteJob_JL;
	private JButton JB_selectJob_JL;
	
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
		MCard_addReplace_DB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/part_switch0.png")));
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
		exitDB.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitDB.setBounds(1236, 13, 59, 32);
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
		
		////////////////////////////////////////////////////
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
		JSP_clients_CL.setBounds(436, 140, 849, 445);
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
				
				if(previousPanel.equals("panelANS")) {
					JB_selectClient_CL.setEnabled(true);
				}
			}
		});

		JSP_clients_CL.setViewportView(JT_clients_CL);
		
		JPanel JP_clientInfo_CL = new JPanel();
		JP_clientInfo_CL.setBounds(12, 97, 412, 488);
		panelCL.add(JP_clientInfo_CL);
		JP_clientInfo_CL.setLayout(null);
		
		JLabel JL_clientNameInfo_CL = new JLabel("Numele:");
		JL_clientNameInfo_CL.setBounds(12, 56, 48, 16);
		JP_clientInfo_CL.add(JL_clientNameInfo_CL);
		
		JLabel JL_clientDeatails_CL = new JLabel("Detalii clientului");
		JL_clientDeatails_CL.setBounds(100, 13, 134, 20);
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
		JB_updateClient_CL.setBounds(69, 426, 116, 37);
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
		JB_deleteClient_CL.setBounds(239, 426, 116, 37);
		JP_clientInfo_CL.add(JB_deleteClient_CL);
		
		JB_selectClient_CL = new JButton("Selectare");
		JB_selectClient_CL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNavigationHelper(panelCL, panelANS);
				
				JTF_clientName_ANS.setText(JTF_clientNameInfo_CL.getText());
				getClientByID(selectedClientID);
				JTF_selectedClientName_ANS.setVisible(true);
				JTF_selectedClientName_ANS.setText(selectedClient.getContactname());
				
				JB_selectClient_CL.setVisible(false);
				JB_updateClient_CL.setVisible(true);
				JB_deleteClient_CL.setVisible(true);			
			}
		});
		JB_selectClient_CL.setEnabled(false);
		JB_selectClient_CL.setVisible(false);
		JB_selectClient_CL.setBounds(69, 426, 286, 49);
		JP_clientInfo_CL.add(JB_selectClient_CL);
		
		JPanel JP_clientQuickSearch_CL = new JPanel();
		JP_clientQuickSearch_CL.setBounds(436, 97, 849, 37);
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
		JTF_clientQuickSearchByPhone_CL.setBounds(287, 13, 275, 22);
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
		JTF_clientQuickSearchByStatus_CL.setBounds(574, 13, 275, 22);
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
		exitCL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit0.png")));
		exitCL.setBounds(1236, 13, 59, 32);
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
		backCL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backCL.setBounds(12, 13, 52, 32);
		panelCL.add(backCL);
		
		JLabel reloadTable = new JLabel("");
		reloadTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reloadTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JT_clients_CL.setRowSorter(null);
				SetDefaultTable(JT_clients_CL, new String[]{"ID", "Numele clientului", "Numarul de telefon", "Firm?"});	
				LoadClients();
			}
		});
		reloadTable.setToolTipText("Reload table");
		reloadTable.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload0.png")));
		reloadTable.setBounds(1179, 13, 45, 32);
		panelCL.add(reloadTable);
		
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
				
				JT_clients_CL.setRowSorter(null);
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
				}else {
					//TODO
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
					
					PanelJLResetter();
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
				//TODO
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
				
				PanelJLResetter();
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
				PanelJLResetter();
				
				PanelNavigationHelper(panelJL, nextPanel);
			}
		});
		backJL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backJL.setToolTipText("BACK");
		backJL.setHorizontalAlignment(SwingConstants.CENTER);
		backJL.setIcon(new ImageIcon(MainFrame.class.getResource("/images/back-arrow.png")));
		backJL.setBounds(12, 13, 52, 32);
		panelJL.add(backJL);
		
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
		
	}
	
	////////////////////////////////////////////////////
	//--------//CRUD & Other Methods Section//--------//
	///////////////////////////////////////////////////
	
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
		    			model.getValueAt(i, 4).toString().isEmpty()?0:Float.valueOf(model.getValueAt(i, 3).toString()),
		    			model.getValueAt(i, 5).toString().isEmpty()?0:Float.valueOf(model.getValueAt(i, 3).toString()),
		    			model.getValueAt(i, 6).toString().isEmpty()?0:Float.valueOf(model.getValueAt(i, 3).toString()));
		    	
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
	
	private void filterAutoPieces(String querry) {
		rowSorter = new TableRowSorter<TableModel>(JT_pieces_APL.getModel());
		
		JT_pieces_APL.setRowSorter(rowSorter);
		
		rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + querry));
	}
	
	private void getClientByID(int id) {	
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
	private void PanelJLResetter() {
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

	private void pieceDataResetter() {
		List<JTextField> jtf_list = new ArrayList<JTextField>();
		jtf_list.add(JTF_pieceIDInfo_APL);
		jtf_list.add(JTF_pieceNameInfo_APL);
		jtf_list.add(JTF_pieceUnitNameInfo_APL);
		
		List<JButton> jb_list = new ArrayList<JButton>();
		jb_list.add(JB_updatePiece_APL);
		
		GeneralResetter(jtf_list, null, jb_list, true, false);
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

	//return true if the user truly wants to delete the document
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
