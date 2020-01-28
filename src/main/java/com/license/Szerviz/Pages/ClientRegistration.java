package com.license.Szerviz.Pages;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.Cursor;

public class ClientRegistration extends JFrame {

	private JPanel contentPane;
	static ClientRegistration clientRegistration = new ClientRegistration();
	//Dashboard dashboard = new Dashboard();
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientRegistration.setUndecorated(true);
					clientRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	

	/**
	 * Create the frame.
	 */
	
	public ClientRegistration() {
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
	            ClientRegistration.this.setLocation(x - xx, y - xy);  
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
		
		JLabel natural = new JLabel("");
		natural.setAlignmentX(Component.CENTER_ALIGNMENT);
		natural.setIcon(new ImageIcon(ClientRegistration.class.getResource("/images/persfizik0.png")));
		natural.setVerticalAlignment(SwingConstants.TOP);
		natural.setBounds(55, 163, 581, 378);
		contentPane.add(natural);
		
		JLabel legal = new JLabel("");
		legal.setIcon(new ImageIcon(ClientRegistration.class.getResource("/images/PERSJUR0.png")));
		legal.setVerticalAlignment(SwingConstants.TOP);
		legal.setAlignmentX(0.5f);
		legal.setBounds(675, 163, 581, 378);
		contentPane.add(legal);
		
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
				/*clientRegistration.setVisible(false);
				dashboard.setVisible(true);
				dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
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
