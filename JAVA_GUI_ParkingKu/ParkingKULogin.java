package ParkingKUFinal;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ParkingKULogin extends JFrame {
	
	private JPanel contentPane;
	public static JTextField nametext;
	private JPasswordField passwordField;
	private Connect con;
	public static String username;
	
	ParkingKURegister rg = new ParkingKURegister();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingKULogin frame = new ParkingKULogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void login() {
		try {
			String usernameTemp = nametext.getText();
			String passwordTemp = new String(passwordField.getText());
			
			if (usernameTemp.isEmpty() || passwordTemp.isEmpty()) {
				JOptionPane.showMessageDialog(this, "username and Password cannot be Empty", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			boolean usernameIsFound = false;
			boolean passwordIsFound = false;
			String queryusername = "SELECT username FROM account";
			con.rs = con.stat.executeQuery(queryusername);
			while (con.rs.next()) {
				String username = con.rs.getString("username");
				
				if (usernameTemp.equals(username)) {
					usernameIsFound = true;
					break;
				}
			}
			if (usernameIsFound) {
				String queryPassword = "SELECT password FROM account WHERE username='%s'";
				queryPassword = String.format(queryPassword, usernameTemp);
				con.rs = con.stat.executeQuery(queryPassword);
				con.rs.next();
				String password = con.rs.getString("password");
				if (passwordTemp.equals(password)) {
					passwordIsFound = true;
				}
			}
			if (usernameIsFound && passwordIsFound) {
				
				username = usernameTemp;
				
				JOptionPane.showMessageDialog(this, "Welcome to ParkingKU", "Message", JOptionPane.INFORMATION_MESSAGE);
				Viewhome();
			}else {
				JOptionPane.showMessageDialog(this, "Incorrect username or Password", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Viewhome() {
		ParkingKUHome home = new ParkingKUHome();
		setVisible(false);
		home.setVisible(true);
		home.pack();
		home.setSize(700, 525);
		home.setLocationRelativeTo(null);
		home.setDefaultCloseOperation(home.EXIT_ON_CLOSE);
	}
	public ParkingKULogin() {
		con = new Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 439);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelJudul = new JLabel("PARKING-KU");
		labelJudul.setBounds(5, 11, 482, 32);
		labelJudul.setFont(new Font("Verdana", Font.BOLD, 25));
		labelJudul.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelJudul);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(120, 96, 251, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nametext = new JTextField();
		nametext.setBounds(10, 39, 231, 28);
		panel.add(nametext);
		nametext.setColumns(10);
	
		JLabel namelabel = new JLabel("Username");
		namelabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		namelabel.setBounds(10, 14, 84, 14);
		panel.add(namelabel);
		
		JLabel passlabel = new JLabel("Password");
		passlabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		passlabel.setBounds(10, 78, 84, 14);
		panel.add(passlabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 103, 231, 28);
		panel.add(passwordField);
		
		JLabel notifgagal = new JLabel();
		notifgagal.setHorizontalAlignment(SwingConstants.CENTER);
		notifgagal.setForeground(new Color(255, 0, 0));
		notifgagal.setBounds(142, 299, 218, 36);
		contentPane.add(notifgagal);
		
		JButton loginbutton = new JButton("LOG IN");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginbutton) {
				
				login();
				
				
			} else {
				notifgagal.setText("Password & Username input is wrong");
				}
			}
		});
		
		loginbutton.setBackground(SystemColor.text);
		loginbutton.setBounds(86, 159, 89, 23);
		panel.add(loginbutton);
		
		JButton btRegister = new JButton("REGISTER");
		btRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ParkingKURegister pr = new ParkingKURegister(); 
                setVisible(false);
                pr.setVisible(true);
                pr.pack();
                pr.setSize(700,525);
                pr.setLocationRelativeTo(null);
                pr.setDefaultCloseOperation(ParkingKURegister.EXIT_ON_CLOSE);
			}
		});
		btRegister.setBounds(196, 337, 99, 23);
		contentPane.add(btRegister);
		
	}
}