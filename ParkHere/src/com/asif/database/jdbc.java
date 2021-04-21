package com.asif.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




abstract class jdbc {
	
	private Connection con;
	private String str;
	
	 jdbc() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
		
		PreparedStatement ps=con.prepareStatement("create database IF NOT EXISTS ParkHere");
		ps.execute();
		ps=con.prepareStatement("use ParkHere");
		ps.execute();
		
		str="create table IF NOT EXISTS CarDetails(Vno varchar(20) primary key, Wheel varchar(4),type varchar(10),phno varchar(20),pin varchar(4),location varchar(10), Timestamp varchar(20))";
		PreparedStatement smt= con.prepareStatement(str);
		smt.execute();
		
		
		}
		
	
	
boolean Insert( String Vno ,String Wheel,String type,String phno,String pin,String loc,String Entrytime) throws ClassNotFoundException, SQLException
	{	
		str="insert into CarDetails values(?,?,?,?,?,?,?)";
		PreparedStatement smt= con.prepareStatement(str);
		smt.setString(1,Vno);
		smt.setString(2,Wheel);
		smt.setString(3,type);
		smt.setString(4,phno);
		smt.setString(5,pin);
		smt.setString(6,loc);
		smt.setString(7,Entrytime);
		smt.execute();
		
		con.close();
		 return true;
		
		 
		 
	}
boolean check(String Vno) throws SQLException
	{	
		boolean flagcheck=true;
		PreparedStatement smt= con.prepareStatement("select*from CarDetails where Vno=?");
		smt.setString(1, Vno);
		ResultSet rst= smt.executeQuery();
		if(rst.next())
		{
			flagcheck=false;
		}
		con.close();
		return flagcheck;
	}
boolean check(String Vno,String Pin) throws SQLException   //use overloading 
	{
		
		boolean flagcheck1=true;
		PreparedStatement smt= con.prepareStatement("select * from CarDetails where Vno=? and Pin=?");
		smt.setString(1, Vno);
		smt.setString(2, Pin);
		ResultSet rst= smt.executeQuery();
		while(rst.next())
		{	
			flagcheck1=false;
			
		}
		con.close();
		return flagcheck1;
		
	}
	
String[] getValue(String Vno) throws SQLException
	{	String [] values = new String[6];
		
	 PreparedStatement smt=con.prepareStatement("select*from Cardetails where Vno=?");
	 smt.setString(1,Vno);
	 ResultSet rst= smt.executeQuery();
		if(rst.next())
		{	int a=1;
			for(int i=1;i<=7;i++)
			{	
			if(i!=5) {
				values[i-a]=rst.getString(i);
			}
			else a=2;
			}
		}
		con.close();
		return values;
	}

/*ResultSet getobject(String query) throws SQLException
{	
	 PreparedStatement smt=con.prepareStatement(query);
	 ResultSet result= smt.executeQuery();
	 
	return result;
	
}*/
boolean checkLocation(String loc) throws SQLException {
	
	String query="select location from cardetails where location ="+"'"+loc+"'";
	
	PreparedStatement smt=con.prepareStatement(query);
	 ResultSet result= smt.executeQuery();
	if(result.next()) {
		con.close();
		return true;
	}
	else {
		con.close();
		return false;
	}
	
}

void closeConnection() throws SQLException {
	con.close();
}

void deleteData(String Vno) throws SQLException {
	String stmt="delete from cardetails where Vno="+"'"+Vno+"'";
	PreparedStatement smt=con.prepareStatement(stmt);
	smt.execute();
	con.close();
	
}

	
}
