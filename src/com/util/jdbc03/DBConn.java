package com.util.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;


/*=====================
 	DBConn.java
======================*/

// �� �̱���(Singleton) ������ ������ �̿��� Database ���� ��ü ���� ���� Ŭ����
//     (�����Ƽ� ������ϰ� �״����� �� ��Ƴ����͵�� ����ؼ� ������ ����)
//    �� DB ���� ������ ���� ���ϰ� ũ�� ������
//		 ������ �ʿ��� �� ���� ��ü�� �����ϴ� ���� �ƴ϶�
//		 �� �� ����� ��ü�� ��� ����ϵ��� ó��.

// DBConn Ŭ������ �Ϻ��ϰ� �ܿ��!!!!!! ���ڵ� ���� �� ��.

// �ٽ� 1. static 2. if��

// �� �� ��°�� ����� : ctrl + D
// ��ȣ �����ϰ� ��ġ��Ű�� : ctrl shift f

public class DBConn // ������ ���Ḹ�� ���� Ŭ����!! �ݵ�� �׷��� ��.
{
	// ���� ����
	private static Connection dbConn; // �̳��� ���� ����
	//-- �ڵ����� null �ʱ�ȭ

	// �޼ҵ� ���� �� ����
	public static Connection getConnection()
	{
		// �� �� ����� ��ü�� ��� ���...
		// ��, ������� ���� ��쿡�� ������ �õ��ϰڴٴ� �ǹ�
		// �� Singleton(������ ����)
		if (dbConn == null)
		{
			try
			{
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				//								---------IP�ڸ�(������ address�� ����)
				// localhost �� ����Ŭ ������ IP �ּҸ� �����ϴ� �κ�
				// 1521 �� ����Ŭ Port Number
				// xe �� ����Ŭ SID(Express Edition �� xe)

				String user = "scott"; //-- ����Ŭ ����� ���� �̸�
				String pwd = "tiger";  //-- ����Ŭ ����� ���� ��ȣ


				Class.forName("oracle.jdbc.driver.OracleDriver");
				//-- OracleDriver Ŭ������ ���� ��ü ����
				//	 ����̹� �ε� �� JVM �� ����
				
				dbConn = DriverManager.getConnection(url, user, pwd); // �� static ��. �׸��� ��Ī�� ������ DriverManager Ŭ���� ���� �ִ� �޼ҵ�
				//-- ����Ŭ ���� ���� ����
				//	 �� (line 30 ~ 50)��... ������ ���� ȯ���� �����ϴ� ����
				//   �����ִ� ���ڰ�(�Ű�����)�� ����Ŭ �ּ�, ������, �н�����
				
			} catch (Exception e) // (ClassNotFoundException, SQLException)
			{
				System.out.println(e.toString());
				//-- ����Ŭ ���� ���� ���� ��... ���� �޼��� ����ϴ� �κ�
			}

		}
		return dbConn;
		//-- ������ ���� ��ü ��ȯ
		
		
	}//end getConnection()

	
	// getConnection() �޼ҵ��� �����ε� �� ����
	public static Connection getConnection(String url, String user, String pwd)
	{
		if (dbConn == null)
		{
			try
			{
				Class.forName("Oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url, user, pwd);
				
			} 
			catch (Exception e)
			{
				System.out.println(e.toString());

			}
		}
		return dbConn;
		//-- ������ ���� ��ü ��ȯ
		
	}//end getConnection(String url, String user, String pwd)

	
	// �޼ҵ� ���� �� ���� ���� �޼ҵ�
	public static void close()
	{
		// dbConn ����(��� ����)��
		// Database �� ����� ������ ��� Connection �� ���´�.
		// ������� ���� ���¶�� null �� ���°� �ȴ�.
		if (dbConn != null)
		{
			try
			{
				// ���� ��ü�� isClosed() �޼ҵ带 ���� ������� Ȯ��
				//-- ������ �����ִ� ��� true ��ȯ
				//   ������ �������� ���� ��� false ��ȯ
				if (!dbConn.isClosed())
				{
					dbConn.close();
					//-- ���� ��ü�� close() �޼ҵ带 ���� ���� ����
				}
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}

		dbConn = null;
		//-- ���� ��ü �ʱ�ȭ
		//   �� ó���� ���س����� �ռ� �������� �޼ҵ忡 ������ ����Ŵ.(���ǹ��� �ɸ�����...)
		
	}//end close()

}// end class DBConn

