package com.asif.database;

import java.sql.SQLException;

public class interactionJDBC extends jdbc {
	
	
	
	public interactionJDBC() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean insert( String Vno ,String Wheel,String type,String phno,String pin,String loc,String Entrytime) throws ClassNotFoundException, SQLException
	{
		return Insert(Vno , Wheel, type, phno, pin, loc,Entrytime);
	}
	
	public boolean verifyLogin(String Vno) throws ClassNotFoundException, SQLException
	{
		return check(Vno);
	}
	public String[] getsvalue(String Vno) throws SQLException
	{
		String[] str=getValue(Vno);
		return str;
	}
	public boolean FindLoc(String loc) throws SQLException
	{
		return checkLocation(loc);
		
	}
	/*public ResultSet SendQuery(String query) throws SQLException
	{	
		return getobject(query);	
	}*/
	public void close() throws SQLException {
		closeConnection();
	}
	public boolean checkPin(String Vno,String Pin) throws SQLException {
		
		return check(Vno,Pin);
	}
	public void Delete(String Vno) throws ClassNotFoundException, SQLException
	{	
		deleteData(Vno);
	}
	

}
