package org.example;


import java.sql.*;


public class Sql {

	private static Connection connect;
	
	public static void deleteStatement(String id ){

		System.out.println("הגעתי");
		System.out.println(id);
		
		String sqldelete = "delete from person where id = ?";
		
		try {
			PreparedStatement pst = connect.prepareStatement(sqldelete);
			
			pst.setString(1, id);
			pst.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public static void updateStatement(String id,String fullName , String phonNum , String password){
		
String sqlupdate = "UPDATE person SET fullName=? ,phonNum = ?,password = ? WHERE id =? ";


		try {
			PreparedStatement pst = connect.prepareStatement(sqlupdate);
			
			pst.setString(1, fullName );
			pst.setString(2, phonNum);
			pst.setString(3, password);
			pst.setString(4, id);

			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insertStatement( String id , String name , String phone ,String password){
		
		String sqlInsert = "insert into person (id ,fullName, phonNum , password) values (?,?,?,?)";
		
		try {
			PreparedStatement pst = connect.prepareStatement(sqlInsert);
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, phone);
			pst.setString(4, password);
		
			pst.execute();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public static String selectQuery(String id)
	{
		String str="";
		try {
			PreparedStatement statement = connect.prepareStatement("select * from person where id ="+id);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next())
			{
				
				str += result.getString(1) + "*" +result.getString(2) + "*" +result.getString(3)+ "*" +result.getString(4);
				
			}
			System.out.println(str);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public static void connection()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Works");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ConectingToSQL ()
	{
		connection();
		String host = "jdbc:mysql://localhost:3306/my_database";
		String username = "root";
		String password = "HILA123@malka#!";
			
		try {
			 connect = (Connection) DriverManager.getConnection(host, username, password);
		System.out.println("work");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
