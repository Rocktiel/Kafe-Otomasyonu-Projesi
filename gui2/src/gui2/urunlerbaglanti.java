package gui2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class urunlerbaglanti {
	static final String DB_URL="jdbc:mysql://localhost:3306/urunler";
	static final String USER="root";
	static final String PASS="root";
	static final String QUERY="SELECT * FROM urunlerr";
	static Connection conn;
	static Statement s;

	static ResultSet yemekbaglanti() throws SQLException 
	{
	ResultSet myrs=null;
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/urunler","root","root");
	s=conn.createStatement();
	myrs=s.executeQuery("SELECT * FROM yemek");
	return myrs;
	}
	public static void yemekguncelle(String a,int b) throws SQLException 
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql="UPDATE yemek SET fiyat="+b+ " WHERE idurunlerr = "+ a;
		st.executeUpdate(sql);
	}
	public static void yemeksil(int a) throws SQLException 
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sorgu=String.format("DELETE from yemek where idurunlerr=%d",a);
        int silme = st.executeUpdate(sorgu);
	}
	public static void yemekverigir(int a,String b,int c) throws SQLException 
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sorgu=String.format("INSERT into yemek values('%d','%s','%d')", a,b,c);
        st.executeUpdate(sorgu);
	}

	static ResultSet icecekbaglanti() throws SQLException 
	{
	ResultSet myrs=null;
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/urunler","root","root");
	s=conn.createStatement();
	myrs=s.executeQuery("SELECT * FROM içecek");
	return myrs;
	}
	public static void icecekguncelle(String a,int b) throws SQLException 
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql="UPDATE içecek SET fiyat="+b+ " WHERE idurunlerr = "+ a;
		st.executeUpdate(sql);
	}
	public static void iceceksil(int a) throws SQLException 
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sorgu=String.format("DELETE from içecek where idurunlerr=%d",a);
        int silme = st.executeUpdate(sorgu);
	}
	public static void icecekverigir(int a,String b,int c) throws SQLException 
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sorgu=String.format("INSERT into içecek values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}

	static ResultSet tatlibaglanti() throws SQLException 
	{
	ResultSet myrs=null;
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/urunler","root","root");
	s=conn.createStatement();
	myrs=s.executeQuery("SELECT * FROM tatlı");
	return myrs;
	}
	public static void tatliguncelle(String a,int b) throws SQLException 
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sql="UPDATE tatlı SET fiyat="+b+ " WHERE idurunlerr = "+ a;
		st.executeUpdate(sql);
	}
	public static void tatlisil(int a) throws SQLException 
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sorgu=String.format("DELETE from tatlı where idurunlerr=%d",a);
        int silme = st.executeUpdate(sorgu);
	}
	public static void tatliverigir(int a,String b,int c) throws SQLException 
	{
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement st=conn.createStatement();
		String sorgu=String.format("INSERT into tatlı values('%d','%s','%d')", a,b,c);
        int ekleme = st.executeUpdate(sorgu);
	}

	







}