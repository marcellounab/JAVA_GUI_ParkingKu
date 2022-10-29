package ParkingKUFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ParkingKURegister extends JFrame {
	
	public static String name;
	public static String username;
	public static String password;
	
	private JPanel contentPane;
	private JTextField InputUsername;
	private JPasswordField InputPassword;
	private JPasswordField InputConfirmPassword;
	private JTextField InputName;
	private Connect con;
	public JLabel Notif;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingKURegister frame = new ParkingKURegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ParkingKURegister() {
		con = new Connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 523);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Judul_1 = new JLabel("ParkingKU");
		Judul_1.setHorizontalAlignment(SwingConstants.CENTER);
		Judul_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		Judul_1.setBounds(117, 0, 454, 98);
		contentPane.add(Judul_1);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserName.setBounds(116, 153, 101, 42);
		contentPane.add(lblUserName);
		
		InputUsername = new JTextField();
		InputUsername.setColumns(10);
		InputUsername.setBounds(329, 164, 198, 34);
		contentPane.add(InputUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(116, 227, 93, 42);
		contentPane.add(lblPassword);
		
		JLabel Notif = new JLabel();
		Notif.setForeground(Color.RED);
		Notif.setHorizontalAlignment(SwingConstants.RIGHT);
		Notif.setBounds(225, 358, 302, 25);
		contentPane.add(Notif);
		
		JButton btnRegister = new JButton("REGISTER");
			
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(InputPassword.getText().isEmpty() ||(InputConfirmPassword.getText().isEmpty() || 
				InputName.getText().isEmpty() || InputUsername.getText().isEmpty())) {
					
					JOptionPane.showMessageDialog(null, "Data Cannot be Empty", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}else if(InputPassword.getText().equals(InputConfirmPassword.getText())) {
					name = InputName.getText();
                    username = InputUsername.getText();
                    password = InputPassword.getText();
					
					try {
						String query = "INSERT INTO account(username, name, password) VALUES('%s','%s','%s')";
						query = String.format(query, username, name, password);
						con.stat.execute(query);
					} catch (SQLException b) {
						// TODO Auto-generated catch block
						b.printStackTrace();
					}
					
					ParkingKULogin login = new ParkingKULogin();
					setVisible(false);
					login.setVisible(true);
					login.pack();
					login.setSize(500, 525);
					login.setLocationRelativeTo(null);
					login.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
				}else if(!(InputPassword.getText().equals(InputConfirmPassword.getText()))) {
					 JOptionPane.showMessageDialog(null, "Password Did not Match", "Message",
								JOptionPane.INFORMATION_MESSAGE);
				
			}}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBounds(251, 407, 145, 42);
		contentPane.add(btnRegister);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(116, 312, 166, 42);
		contentPane.add(lblConfirmPassword);
		
		InputPassword = new JPasswordField();
		InputPassword.setBounds(329, 238, 198, 34);
		contentPane.add(InputPassword);
		
		InputConfirmPassword = new JPasswordField();
		InputConfirmPassword.setBounds(329, 314, 198, 34);
		contentPane.add(InputConfirmPassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(116, 84, 101, 42);
		contentPane.add(lblName);
		
		InputName = new JTextField();
		InputName.setColumns(10);
		InputName.setBounds(329, 95, 198, 34);
		contentPane.add(InputName);
		
		JLabel lblExit = new JLabel("Back");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ParkingKULogin login = new ParkingKULogin();
				setVisible(false);
				login.setVisible(true);
				login.pack();
				login.setSize(500, 525);
				login.setLocationRelativeTo(null);
				login.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
			}
		});
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExit.setBounds(608, 0, 75, 40);
		contentPane.add(lblExit);
	
		
	}
}