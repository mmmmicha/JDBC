package com.util.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;

public class testDbc
{
	private static Connection dbConn;
	
	public static Connection getConnection()
	{
		if(dbConn == null)
		{
			try
			{
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String name = "scott";
				String pw = "tiger";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				dbConn = DriverManager.getConnection(url, name, pw);
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
	
		return dbConn;
	}
	
	public static Connection getConnection(String url, String name, String pw)
	{
		if(dbConn == null)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				dbConn = DriverManager.getConnection(url, name, pw);
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		return dbConn;
		
	}
	
	public void close()
	{
		if(dbConn != null)
		{
			try
			{
				if(!dbConn.isClosed())
					dbConn.close();
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		dbConn = null;
		
	}
}
