package org.example;


import java.sql.*;


public class Sql {

	private static Connection connect;
	
	public static void delete_statement(String id ){
		
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
	
	public static void update_statement(){
		
String sqlupdate = "UPDATE student SET name=?  WHERE id =? ";
		
		try {
			PreparedStatement pst = connect.prepareStatement(sqlupdate);
			
			pst.setString(1, "effi");
			pst.setString(2, "3344");
		//	pst.setString(3, "66127762");
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insert_statement( String id , String name , String phone){
		
		String sqlInsert = "insert into students (idstudents,name, phone) values (?,?,?)";
		
		try {
			PreparedStatement pst = connect.prepareStatement(sqlInsert);
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, phone);
		
			pst.execute();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static double select_query()
	{
		String str="";
		try {
			PreparedStatement statement = connect.prepareStatement("select average(studentsalary) from student ");
			
			ResultSet result = statement.executeQuery();
			
			while(result.next())
			{
				
				str += result.getString(1) + result.getString(2);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Double.parseDouble(str);
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
