package gui2;

import java.awt.Container;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class masabaglanti {
	
	static final String DB_URL="jdbc:mysql://localhost:3306/masalar";
	static final String USER="root";
	static final String PASS="root";
	static Connection conn;
	static Statement s;

	static ResultSet masa1() throws SQLException {
		ResultSet myrs=null;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		s=conn.createStatement();
		myrs=s.executeQuery("SELECT * FROM masa1");
		
		return myrs;
	}
	public static void silmasa1() throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("delete from masa1" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa1(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		 String sql = "UPDATE masa1"+" SET adet='"+(b-c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		String sorgu=String.format("delete from masa1 where adet<=0" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void verigirmasa1(int a,String b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("insert into masa1 values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa1esit(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql = "UPDATE masa1"+" SET adet='"+(b+c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		
	}
	
	static ResultSet masa2() throws SQLException {
		ResultSet myrs=null;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		s=conn.createStatement();
		myrs=s.executeQuery("SELECT * FROM masa2");
		
		return myrs;
	}
	public static void silmasa2() throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("delete from masa2" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa2(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		
		 String sql = "UPDATE masa2"+" SET adet='"+(b-c)+"' WHERE adi='"+a+"' ";
		
		st.executeUpdate(sql);
		String sorgu=String.format("delete from masa2 where adet<=0" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void verigirmasa2(int a,String b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("insert into masa2 values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa2esit(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql = "UPDATE masa2"+" SET adet='"+(b+c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		
	}
	
	static ResultSet masa3() throws SQLException {
		ResultSet myrs=null;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		s=conn.createStatement();
		myrs=s.executeQuery("SELECT * FROM masa3");
		
		return myrs;
	}
	public static void silmasa3() throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("delete from masa3" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa3(String a,int b,int c) throws SQLException {
	Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
	Statement st=conn.createStatement();
	 String sql = "UPDATE masa3"+" SET adet='"+(b-c)+"' WHERE adi='"+a+"' ";
	st.executeUpdate(sql);
	String sorgu=String.format("delete from masa3 where adet<=0" );
    int silme = st.executeUpdate(sorgu);
}
	public static void verigirmasa3(int a,String b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("insert into masa3 values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa3esit(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql = "UPDATE masa3"+" SET adet='"+(b+c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		
	}
	
	static ResultSet masa4() throws SQLException {
		ResultSet myrs=null;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		s=conn.createStatement();
		myrs=s.executeQuery("SELECT * FROM masa4");
		
		return myrs;
	}
	public static void silmasa4() throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("delete from masa4" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa4(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		 String sql = "UPDATE masa4"+" SET adet='"+(b-c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		String sorgu=String.format("delete from masa4 where adet<=0" );
	    int silme = st.executeUpdate(sorgu);
	}
	public static void verigirmasa4(int a,String b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("insert into masa4 values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa4esit(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql = "UPDATE masa4"+" SET adet='"+(b+c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		
	}
	
	static ResultSet masa5() throws SQLException {
		ResultSet myrs=null;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		s=conn.createStatement();
		myrs=s.executeQuery("SELECT * FROM masa5");
		
		return myrs;
	}
	public static void silmasa5() throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("delete from masa5" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa5(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		 String sql = "UPDATE masa5"+" SET adet='"+(b-c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		String sorgu=String.format("delete from masa5 where adet<=0" );
	    int silme = st.executeUpdate(sorgu);
	}
	public static void verigirmasa5(int a,String b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("insert into masa5 values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa5esit(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql = "UPDATE masa5"+" SET adet='"+(b+c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		
	}
	
	static ResultSet masa6() throws SQLException {
		ResultSet myrs=null;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		s=conn.createStatement();
		myrs=s.executeQuery("SELECT * FROM masa6");
		
		return myrs;
	}
	public static void silmasa6() throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("delete from masa6" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa6(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		 String sql = "UPDATE masa6"+" SET adet='"+(b-c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		String sorgu=String.format("delete from masa6 where adet<=0" );
	    int silme = st.executeUpdate(sorgu);
	}
	public static void verigirmasa6(int a,String b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("insert into masa6 values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa6esit(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql = "UPDATE masa6"+" SET adet='"+(b+c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		
	}
	
	static ResultSet masa7() throws SQLException {
		ResultSet myrs=null;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		s=conn.createStatement();
		myrs=s.executeQuery("SELECT * FROM masa7");
		
		return myrs;
	}
	public static void silmasa7() throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("delete from masa7" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa7(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		 String sql = "UPDATE masa7"+" SET adet='"+(b-c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		String sorgu=String.format("delete from masa7 where adet<=0" );
	    int silme = st.executeUpdate(sorgu);
	}
	public static void verigirmasa7(int a,String b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("insert into masa7 values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa7esit(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql = "UPDATE masa7"+" SET adet='"+(b+c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		
	}

	static ResultSet masa8() throws SQLException {
		ResultSet myrs=null;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		s=conn.createStatement();
		myrs=s.executeQuery("SELECT * FROM masa8");
		
		return myrs;
	}
	public static void silmasa8() throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("delete from masa8" );
        int silme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa8(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		 String sql = "UPDATE masa8"+" SET adet='"+(b-c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		String sorgu=String.format("delete from masa8 where adet<=0" );
	    int silme = st.executeUpdate(sorgu);
	}
	public static void verigirmasa8(int a,String b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		
		String sorgu=String.format("insert into masa8 values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}
	public static void guncellemasa8esit(String a,int b,int c) throws SQLException {
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql = "UPDATE masa8"+" SET adet='"+(b+c)+"' WHERE adi='"+a+"' ";
		st.executeUpdate(sql);
		
	}
	
}
