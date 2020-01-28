package com.license.Szerviz.Pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Query;
import org.hibernate.Session;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Szerviz.Entities.Client;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClientList extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	static ClientList clientList = new ClientList();
	//Dashboard dashboardCL = new Dashboard();
	private static JTable table;
	private JTextField clientName;
	private JTextField clientPhone;
	private JTextField isCompany;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientList.setUndecorated(true);
					clientList.setVisible(true);
					
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
				    HibernateUtil.shutDown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1325, 645);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            ClientList.this.setLocation(x - xx, y - xy);  
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(350, 97, 945, 488);
		contentPane.add(scrollPane);
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 97, 326, 488);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNumele = new JLabel("Numele:");
		lblNumele.setBounds(12, 56, 48, 16);
		panel.add(lblNumele);
		
		JLabel lblDetaliiClientului = new JLabel("Detalii clientului");
		lblDetaliiClientului.setBounds(100, 13, 134, 20);
		lblDetaliiClientului.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblDetaliiClientului);
		
		clientName = new JTextField();
		clientName.setBounds(131, 53, 183, 22);
		panel.add(clientName);
		clientName.setColumns(10);
		
		JLabel lblNumarulDeTelefon = new JLabel("Numarul de telefon:");
		lblNumarulDeTelefon.setBounds(12, 85, 116, 16);
		panel.add(lblNumarulDeTelefon);
		
		clientPhone = new JTextField();
		clientPhone.setBounds(131, 82, 183, 22);
		panel.add(clientPhone);
		clientPhone.setColumns(10);
		
		JLabel lblStatutulClientului = new JLabel("Statutul clientului:");
		lblStatutulClientului.setBounds(12, 114, 103, 16);
		panel.add(lblStatutulClientului);
		
		isCompany = new JTextField();
		isCompany.setBounds(131, 111, 183, 22);
		panel.add(isCompany);
		isCompany.setColumns(10);
		
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
		exit.setIcon(new ImageIcon(ClientRegistration.class.getResource("/images/exit0.png")));
		exit.setBounds(1236, 13, 59, 32);
		contentPane.add(exit);
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*clientList.setVisible(false);
				dashboardCL.setVisible(true);
				dashboardCL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
			}
		});
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setToolTipText("BACK");
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setIcon(new ImageIcon(ClientRegistration.class.getResource("/images/back-arrow.png")));
		back.setBounds(12, 13, 52, 32);
		contentPane.add(back);
	}
}
