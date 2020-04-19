package com.util.jdbc07;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConn
{
	private static Connection dbConn;
	
	public static Connection getConnection()
	{
		
		try
		{
			if (dbConn == null)
			{
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String name = "scott";
				String pw = "tiger";
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로딩
				
				dbConn = DriverManager.getConnection(url, name, pw); // 연결하기
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return dbConn;
	}
	
	
	public static Connection getConnection(String url, String name, String pw)
	{
		try
		{
			if (dbConn == null)
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				dbConn = DriverManager.getConnection(url, name, pw);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return dbConn;
	}
	
	public static void Close()
	{
		if (dbConn != null)
		{
			try
			{
				if (!dbConn.isClosed())
				{
					dbConn.close();
				}
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		dbConn = null;
		
	}
	
	
}
