package ParkingKUFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class ParkingKUHome extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTextField txtPemilikKendaraan;
	private JTextField txtNomorKendaraan;
	private JButton btnNext;

	//variable penampung
	public static String pemilikKendaraan;
	public static String jenisKendaraanpilihan;
	public static String jenisKendaraan;
	public static String nomorKendaraan;
	public Connection con;
	public static JComboBox comboBox;
	public JMenu History, SignOut;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingKUHome frame = new ParkingKUHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ParkingKUHome() {
		setLocationRelativeTo(null);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 523);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		SignOut = new JMenu("Sign Out");
		menu.add(SignOut);
		SignOut.addMouseListener(this);
		
		History = new JMenu("History");
		menu.add(History);
		History.addMouseListener(this);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 684, 106);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("ParkingKU");
		lblTitle.setBackground(Color.LIGHT_GRAY);
		panel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(SystemColor.inactiveCaptionBorder);
		panel2.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel2.setBounds(0, 106, 684, 251);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel lblPemilikKendaraan = new JLabel("Nama Pemilik Kendaraan");
		lblPemilikKendaraan.setBounds(20, 6, 319, 73);
		panel2.add(lblPemilikKendaraan);
		lblPemilikKendaraan.setHorizontalAlignment(SwingConstants.LEFT);
		lblPemilikKendaraan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtPemilikKendaraan = new JTextField();
		txtPemilikKendaraan.setBounds(344, 19, 319, 55);
		panel2.add(txtPemilikKendaraan);
		txtPemilikKendaraan.setColumns(10);
		
		JLabel lblJenisKendaraan = new JLabel("Jenis Kendaraan");
		lblJenisKendaraan.setBounds(20, 98, 319, 55);
		panel2.add(lblJenisKendaraan);
		lblJenisKendaraan.setHorizontalAlignment(SwingConstants.LEFT);
		lblJenisKendaraan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNomorKendaraan = new JLabel("Nomor Kendaraan");
		lblNomorKendaraan.setBounds(20, 172, 319, 73);
		panel2.add(lblNomorKendaraan);
		lblNomorKendaraan.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomorKendaraan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtNomorKendaraan = new JTextField();
		txtNomorKendaraan.setBounds(344, 185, 319, 55);
		panel2.add(txtNomorKendaraan);
		txtNomorKendaraan.setColumns(10);
		
		JLabel lbljenismobil = new JLabel("Must Select One");
		lbljenismobil.setForeground(Color.RED);
		lbljenismobil.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		lbljenismobil.setHorizontalAlignment(SwingConstants.LEFT);
		lbljenismobil.setBounds(20, 141, 278, 14);
		panel2.add(lbljenismobil);
		
		String[] jenisKendaraan = {"SUV","Sedan","Supercar","Van"};
		comboBox = new JComboBox(jenisKendaraan);
		comboBox.setBounds(344, 101, 319, 55);
		this.setVisible(true);
		panel2.add(comboBox);
		
		btnNext = new JButton("NEXT");
		btnNext.setBounds(287, 389, 105, 33);
		contentPane.add(btnNext);
		btnNext.addMouseListener(this);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getSource() == History) {
		HistoryPage hp = new HistoryPage();
		setVisible(false);
		hp.setVisible(true);
		hp.setSize(650, 550);
		hp.setLocationRelativeTo(null);
		hp.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);

			
	}else if(arg0.getSource() == SignOut) {
		ParkingKULogin login = new ParkingKULogin();
		setVisible(false);
		login.setVisible(true);
		login.pack();
		login.setSize(500, 525);
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
		
	}else if(arg0.getSource()== btnNext) {
		pemilikKendaraan = txtPemilikKendaraan.getText();
		jenisKendaraanpilihan = (String) comboBox.getSelectedItem();
		nomorKendaraan = txtNomorKendaraan.getText();
		
		if(txtPemilikKendaraan.getText().isEmpty()) {
					
			JOptionPane.showMessageDialog(null, "vehicle owner must be filled", "Message",
					JOptionPane.INFORMATION_MESSAGE);
		
		}else if(txtNomorKendaraan.getText().isEmpty()) {
					
			JOptionPane.showMessageDialog(null, "vehicle number must be filled", "Message",
					JOptionPane.INFORMATION_MESSAGE);
			
				
		}else {
				ParkingKUSelectParkir sp = new ParkingKUSelectParkir();
				setVisible(false);
				sp.setVisible(true);
				sp.setSize(700, 525);
				sp.setLocationRelativeTo(null);
				sp.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
	}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
