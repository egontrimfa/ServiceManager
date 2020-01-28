package com.license.Szerviz.Pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	static Dashboard dashboard = new Dashboard();
	ClientList clientListD = new ClientList();
	ClientRegistration clientRegistration = new ClientRegistration();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Dashboard dashboard = new Dashboard();
					dashboard.setUndecorated(true);
					dashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setBackground(Color.WHITE);
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
	            Dashboard.this.setLocation(x - xx, y - xy);  
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
		
		JLabel newClient = new JLabel("");
		newClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dashboard.setVisible(false);
				clientListD.setVisible(true);
				clientListD.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		newClient.setToolTipText("Adaugă client nou");
		newClient.setIcon(new ImageIcon(Dashboard.class.getResource("/images/new_client0.png")));
		newClient.setBounds(12, 109, 154, 154);
		contentPane.add(newClient);
		
		JLabel listClients = new JLabel("");
		listClients.setToolTipText("Clienţii");
		listClients.setIcon(new ImageIcon(Dashboard.class.getResource("/images/list_clients.png")));
		listClients.setBounds(178, 109, 154, 154);
		contentPane.add(listClients);
		
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
	}
}
