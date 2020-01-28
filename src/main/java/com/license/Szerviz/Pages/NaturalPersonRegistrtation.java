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

public class NaturalPersonRegistrtation extends JFrame {

	private JPanel contentPane;
	
	int xx,xy;
	private JTextField txtNumeleClientului;
	private JTextField txtNumarulDeTelefon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NaturalPersonRegistrtation frame = new NaturalPersonRegistrtation();
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
	
	public NaturalPersonRegistrtation() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1325, 645);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            NaturalPersonRegistrtation.this.setLocation(x - xx, y - xy);  
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
		exit.setIcon(new ImageIcon(NaturalPersonRegistrtation.class.getResource("/images/exit0.png")));
		exit.setBounds(1236, 13, 59, 32);
		contentPane.add(exit);
		
		JLabel back = new JLabel("");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setToolTipText("BACK");
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setIcon(new ImageIcon(NaturalPersonRegistrtation.class.getResource("/images/back-arrow.png")));
		back.setBounds(12, 13, 52, 32);
		contentPane.add(back);
		
		JLabel naturalClient = new JLabel("");
		naturalClient.setIcon(new ImageIcon(NaturalPersonRegistrtation.class.getResource("/images/person-4.png")));
		naturalClient.setBounds(50, 42, 457, 531);
		contentPane.add(naturalClient);
		
		txtNumeleClientului = new JTextField();
		txtNumeleClientului.setBounds(732, 144, 365, 22);
		contentPane.add(txtNumeleClientului);
		txtNumeleClientului.setColumns(10);
		
		JLabel lblNumeleClientului = new JLabel("Numele clientului");
		lblNumeleClientului.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeleClientului.setBounds(732, 115, 139, 16);
		contentPane.add(lblNumeleClientului);
		
		JLabel lblNumarulDeTelefon = new JLabel("Numarul de telefon");
		lblNumarulDeTelefon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumarulDeTelefon.setBounds(732, 189, 151, 16);
		contentPane.add(lblNumarulDeTelefon);
		
		txtNumarulDeTelefon = new JTextField();
		txtNumarulDeTelefon.setColumns(10);
		txtNumarulDeTelefon.setBounds(732, 218, 365, 22);
		contentPane.add(txtNumarulDeTelefon);
		
		JButton btnNewButton = new JButton("Salveaza");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Getting the textbox values
				String clientName = txtNumeleClientului.getText();
				String clientPhone = txtNumarulDeTelefon.getText();
				
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
			    HibernateUtil.shutDown();
			}
		});
		btnNewButton.setIcon(new ImageIcon(NaturalPersonRegistrtation.class.getResource("/images/save-button.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(810, 253, 197, 41);
		contentPane.add(btnNewButton);
	}
}
