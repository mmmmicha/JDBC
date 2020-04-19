/*=====================================================
	Test001.java
    - CallableStatement �� Ȱ���� SQL ���� ���� �ǽ� 1
========================================================*/

package com.test.jdbc08;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.util.jdbc08.DBConn;


public class Test001
{
	public static void main(String[] args)
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			Connection conn = DBConn.getConnection();
			
			do
			{
				System.out.print("��ȣ �Է�(-1 ����) : ");
				String sid = sc.next();
				
				if (sid.equals("-1"))
					break;
				
				System.out.println("�̸� �Է� : ");
				String name = sc.next();
				System.out.println("��ȭ��ȣ �Է� : ");
				String tel = sc.next();
				
				if (conn != null)
				{
					System.out.println("�����ͺ��̽� ���� ����~!!!");
					try
					{
//						Statement stmt = conn.createStatement();
//						String sql = "INTSET ...";
						
						String sql = "{call PRC_MEMBERINSERT(?, ?, ?)}";
						CallableStatement cstmt = conn.prepareCall(sql);
						cstmt.setInt(1, Integer.parseInt(sid));
						cstmt.setString(2, name);
						cstmt.setString(3, tel);
						
						int result = cstmt.executeUpdate();
						if(result>0)
							System.out.println("ȸ�� ���� �Է� �Ϸ�~!!!");
						
						
						
					}
					catch (Exception e)
					{
						System.out.println(e.toString());
					}
					
				}
			} while (true);
			
			DBConn.Close();
			System.out.println("�����ͺ��̽� ���� ����~!!!");
			System.out.println("���α׷� �����~!!!");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
