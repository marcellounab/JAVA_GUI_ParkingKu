package ParkingKUFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.PreparedStatement;

public class Connect{

    public Statement stat;
    public ResultSet rs;
    public ResultSetMetaData rsm;
    public Connection con;
    public PreparedStatement pStat;

    

    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/ParkingDB","root", "" );
            stat = con.createStatement();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ResultSet execQuery(String query){
        try {
            rs = stat.executeQuery(query);
            rsm = rs.getMetaData();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

   public void insertIntohistoryparking(String txtNomorKendaraan,String username, String nametxt, 
		   String jenisKendaraan, String floor ) {
	   try {
		   pStat = (PreparedStatement) con.prepareStatement("INSERT INTO historyparking VALUES(?, ?, ?, ?, ?)");
		   pStat.setString(1, txtNomorKendaraan);
		   pStat.setString(2, username);
		   pStat.setString(3, nametxt);
		   pStat.setString(4, floor);
		   pStat.setString(5, jenisKendaraan);
		   pStat.execute();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	
   }
    
}