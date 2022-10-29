package ParkingKUFinal;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class HistoryPage extends JFrame implements MouseListener{
	ParkingKUTampilanAkhir PTA = new ParkingKUTampilanAkhir();
	
	public JButton btnClearAll,btnDelete;
	private JMenuBar menu; 
	public JMenu toHome;
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTable table;
	private Vector<Object> tableContent;
	public String nokendaraan;
	private boolean dataSelected = false;
	
	public Statement stat;
	public ResultSet rs;
	public Connect con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryPage frame = new HistoryPage();
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
	
	
	public HistoryPage() {
		con = new Connect();
		String header[] = {"NoKendaraan","Username", "Nama", "Floor", "JenisKendaraan"};
		dtm = new DefaultTableModel(header,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(dtm);
		
		
		con.rs = con.execQuery("SELECT * FROM historyparking");
		try {
			while(con.rs.next()) {
				tableContent = new Vector<Object>();
				for (int i = 1; i < con.rsm.getColumnCount()+1 ; i++) {
					tableContent.add(con.rs.getObject(i) + "");
				}
				dtm.addRow(tableContent);
			}
			table.setModel(dtm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		menu = new JMenuBar();
		setJMenuBar(menu);
	
		toHome = new JMenu("Home");
		menu.add(toHome);
		toHome.addMouseListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 50, 527, 312);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				dataSelected = false;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 0).toString();
				if (!value.isEmpty()) {
					dataSelected = true;
				}
			try {			
			if(table.getSelectedRowCount () == 1) {		
				String query = "DELETE FROM historyparking WHERE NoKendaraan LIKE '%s'";
				query = String.format(query, value);
				con.stat.execute(query);
				dtm.removeRow(table.getSelectedRow());
			
				table.getSelectionModel().clearSelection();
					}
				}catch (SQLException b) {
					b.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(28, 375, 111, 33);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_2 = new JLabel("Personal History");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(28, 13, 229, 24);
		contentPane.add(lblNewLabel_2);
		btnClearAll = new JButton("Clear All");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String query = "DELETE FROM historyparking";
					try {
				con.stat.execute(query);
					} catch (SQLException b) {
						// TODO Auto-generated catch block
					b.printStackTrace();
					}
				dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
			
				}

			});
	
		btnClearAll.setBounds(151, 375, 111, 33);
		contentPane.add(btnClearAll);
		
		setTitle("History");
		setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == toHome) {
			ParkingKUHome home = new ParkingKUHome();
			setVisible(false);
			home.setVisible(true);
			home.pack();
			home.setSize(700, 525);
			home.setLocationRelativeTo(null);
			home.setDefaultCloseOperation(home.EXIT_ON_CLOSE);
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