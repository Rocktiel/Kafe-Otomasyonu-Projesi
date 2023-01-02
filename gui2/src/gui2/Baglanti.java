package gui2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Baglanti {
		static Connection conn;
		static Statement s;
		
		static void KayitOl(String username,String sifre) throws SQLException {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","root");
			Statement s=conn.createStatement(); 
            String sorgu=String.format("insert into new_table values('%s','%s')",username,sifre);
            int ekleme = s.executeUpdate(sorgu);
		}
		
		static ResultSet bul() throws SQLException {
			ResultSet myrs=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","root");
			s=conn.createStatement();
			myrs=s.executeQuery("SELECT * FROM new_table");
			
			return myrs;
		}
		
		

	}


