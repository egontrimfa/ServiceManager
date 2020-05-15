package com.license.Szerviz.Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;

import com.license.HibernateUtil.HibernateUtil;
import com.license.Szerviz.Entities.Receptions_auto_pieces;
import com.license.Szerviz.Entities.User;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	static LoginFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	static Session session;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginFrame();
					frame.setVisible(true);
					
					//Open new hibernate session
					session = HibernateUtil.getSessionFactory().openSession();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel JP_south_LF = new JPanel();
		contentPane.add(JP_south_LF, BorderLayout.SOUTH);
		JP_south_LF.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Logare");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user = validateUser(textField.getText(), encryptPassword(String.valueOf(passwordField.getPassword())));
				if(user!=null) {
					frame.dispose();
					new ServiceFrame("admin");
				}else {
					JOptionPane.showMessageDialog(null, "Utilizatorul cu parola data nu exista!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		JP_south_LF.add(btnNewButton);
		
		JPanel JP_center_LF = new JPanel();
		contentPane.add(JP_center_LF, BorderLayout.CENTER);
		JP_center_LF.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel JL_userName_LF = new JLabel("Numele unilizatorului:");
		JL_userName_LF.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_center_LF.add(JL_userName_LF, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		JP_center_LF.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel JL_userPassword_LF = new JLabel("Parola:");
		JL_userPassword_LF.setFont(new Font("Tahoma", Font.BOLD, 16));
		JP_center_LF.add(JL_userPassword_LF, "cell 0 1,alignx trailing");
		
		passwordField = new JPasswordField();
		JP_center_LF.add(passwordField, "cell 1 1,growx");
	}
	
	//Generate MD5 encrypted password
	private String encryptPassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
            return generatedPassword;
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
            return null;
        }
	}
	//Validate user credintials
	private User validateUser(String userName, String userPassword) {
		User user = null;
		try {
			//Begin transaction
			session.beginTransaction();
			
			user= (User) session.createQuery("from User where username=:uname and userpassword=:upwd")
					.setParameter("uname", userName)
					.setParameter("upwd", userPassword)
					.uniqueResult();
			
		    //Committing the transaction
		    session.getTransaction().commit();
		    
			if(user!=null) {
				return user;
			}else {
				return null;
			}
		    
		    //Shotting down the session factory
		    //HibernateUtil.shutDown();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
}
