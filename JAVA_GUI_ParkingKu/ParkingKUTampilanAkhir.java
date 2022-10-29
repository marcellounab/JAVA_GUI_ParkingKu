package ParkingKUFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParkingKUTampilanAkhir extends JFrame {

	private JPanel contentPane;
    public ResultSet rs;
    public ResultSetMetaData rsm;
    public Statement stat;
	private Connect con;
	ParkingKUTampilanAkhir PKTA;
	String query;
	
	static String finalpemilikkendaraan, finaljeniskendaraan, finalnokendaraan, finalfloor, finalusername;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingKUTampilanAkhir frame = new ParkingKUTampilanAkhir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void getData() {
		con = new Connect();
		  try {
              String query = "INSERT INTO historyparking(NoKendaraan, Username, Nama, Floor, JenisKendaraan) VALUES('%s','%s','%s','%s', '%s')";
              query = String.format(query, finalnokendaraan,
            		  finalusername,
                      finalpemilikkendaraan,
                      finalfloor,
                      finaljeniskendaraan);
              con.stat.execute(query);
          } catch (SQLException e1) {
              e1.printStackTrace();
          }
        }
	
	public ParkingKUTampilanAkhir() {
		
		finalusername = ParkingKULogin.username;
		finalpemilikkendaraan = ParkingKUHome.pemilikKendaraan;
		finaljeniskendaraan = (String) ParkingKUHome.comboBox.getSelectedItem();
		finalnokendaraan = ParkingKUHome.nomorKendaraan;
		finalfloor = ParkingKUSelectParkir.floor;
		
		//testing masuk ap kgk
		System.out.println("username : " + finalusername);
		System.out.println("nama pemilik : " + finalpemilikkendaraan);
		System.out.println("jenis : " + finaljeniskendaraan);
		System.out.println("nomor : " + finalnokendaraan);
		System.out.println("floor : " + finalfloor);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Terima kasih sudah menggunakan layanan kami");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(156, 353, 373, 55);
		contentPane.add(lblNewLabel);
		
		JButton selesai = new JButton("DONE");
		selesai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				
				getData();
				
				ParkingKUHome PH = new ParkingKUHome();
				setVisible(false);
				PH.setVisible(true);
				PH.setSize(700, 525);
				PH.setLocationRelativeTo(null);
				PH.setDefaultCloseOperation(ParkingKUTampilanAkhir.EXIT_ON_CLOSE);
			}
		});
		selesai.setBounds(285, 414, 117, 29);
		contentPane.add(selesai);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 684, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ParkingKU");
		lblNewLabel_1.setBounds(173, 0, 338, 70);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 68, 684, 274);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel showFloor = new JLabel("floor");
		showFloor.setBounds(101, 43, 475, 72);
		showFloor.setText(ParkingKUSelectParkir.floor);
		showFloor.setFont(new Font("Tahoma", Font.BOLD, 80));
		showFloor.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(showFloor);
		
		JLabel showNamaKendaraan = new JLabel("nama pemilik");
		showNamaKendaraan.setBounds(134, 134, 416, 49);
		showNamaKendaraan.setText(ParkingKUHome.pemilikKendaraan);
		showNamaKendaraan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		showNamaKendaraan.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(showNamaKendaraan);
		
		JLabel showJenisKendaraan = new JLabel("jenis kendaraan");
		showJenisKendaraan.setBounds(0, 115, 684, 49);
		showJenisKendaraan.setText(ParkingKUHome.jenisKendaraanpilihan);
		showJenisKendaraan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		showJenisKendaraan.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(showJenisKendaraan);
		
		JLabel showNomorKendaraan = new JLabel("nmomor kendaraan");
		showNomorKendaraan.setBounds(0, 165, 684, 49);
		showNomorKendaraan.setText(ParkingKUHome.nomorKendaraan);
		showNomorKendaraan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		showNomorKendaraan.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(showNomorKendaraan);
	}
}
