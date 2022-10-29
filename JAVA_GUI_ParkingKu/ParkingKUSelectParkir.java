package ParkingKUFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class ParkingKUSelectParkir extends JFrame {
	
	private JPanel contentPane;
	
	//variable penampung
	public static String floor;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingKUSelectParkir frame = new ParkingKUSelectParkir();
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
	public ParkingKUSelectParkir() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 523);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 684, 60);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("ParkingKu");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblTitle);
		
		JLabel lblAvailable = new JLabel("Parking Available");
		lblAvailable.setForeground(UIManager.getColor("Button.darkShadow"));
		lblAvailable.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAvailable, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(31, 106, 619, 275);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 20, 20));
		
		JButton btn1A = new JButton("1 - A");
		btn1A.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btn1A);
		btn1A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floor = "1A";
				
				// go to TampilanAkhir
				ParkingKUTampilanAkhir ta = new ParkingKUTampilanAkhir();
				setVisible(false);
				ta.setVisible(true);
				ta.setLocationRelativeTo(null);
				ta.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
		});
		
		
		JButton btn1B = new JButton("1 - B");
		btn1B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btn1B);
		btn1B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floor = "1B";
				
				// go to TampilanAkhir
				ParkingKUTampilanAkhir ta = new ParkingKUTampilanAkhir();
				setVisible(false);
				ta.setVisible(true);
				ta.setLocationRelativeTo(null);
				ta.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
		});
		
		
		JButton btn1C = new JButton("1 - C");
		btn1C.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btn1C);
		btn1C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floor = "1C";
				
				// go to TampilanAkhir
				ParkingKUTampilanAkhir ta = new ParkingKUTampilanAkhir();
				setVisible(false);
				ta.setVisible(true);
				ta.setLocationRelativeTo(null);
				ta.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
		});
		
		
		JButton btn2A = new JButton("2 - A");
		btn2A.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btn2A);
		btn2A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floor = "2A";
				
				// go to TampilanAkhir
				ParkingKUTampilanAkhir ta = new ParkingKUTampilanAkhir();
				setVisible(false);
				ta.setVisible(true);
				ta.setLocationRelativeTo(null);
				ta.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
		});
		

		JButton btn2B = new JButton("2 - B");
		btn2B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btn2B);
		btn2B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floor = "2B";
				
				// go to TampilanAkhir
				ParkingKUTampilanAkhir ta = new ParkingKUTampilanAkhir();
				setVisible(false);
				ta.setVisible(true);
				ta.setLocationRelativeTo(null);
				ta.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
		});
		
		JButton btn2C = new JButton("2 - C");
		btn2C.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btn2C);
		btn2C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floor = "2C";
				
				// go to TampilanAkhir
				ParkingKUTampilanAkhir ta = new ParkingKUTampilanAkhir();
				setVisible(false);
				ta.setVisible(true);
				ta.setLocationRelativeTo(null);
				ta.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
		});
		
		JButton btn3A = new JButton("3 - A");
		btn3A.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btn3A);
		btn3A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floor = "3A";
				
				// go to TampilanAkhir
				ParkingKUTampilanAkhir ta = new ParkingKUTampilanAkhir();
				setVisible(false);
				ta.setVisible(true);
				ta.setLocationRelativeTo(null);
				ta.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
		});
		
		JButton btn3B = new JButton("3 - B");
		btn3B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btn3B);
		btn3B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floor = "3B";
				
				// go to TampilanAkhir
				ParkingKUTampilanAkhir ta = new ParkingKUTampilanAkhir();
				setVisible(false);
				ta.setVisible(true);
				ta.setLocationRelativeTo(null);
				ta.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
		});
		
		JButton btn3C = new JButton("3 - C");
		btn3C.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btn3C);
		btn3C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floor = "3C";
				
				// go to TampilanAkhir
				ParkingKUTampilanAkhir ta = new ParkingKUTampilanAkhir();
				setVisible(false);
				ta.setVisible(true);
				ta.setSize(700, 525);
				ta.setLocationRelativeTo(null);
				ta.setDefaultCloseOperation(ParkingKUHome.EXIT_ON_CLOSE);
			}
		});
	}
}
