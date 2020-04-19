/*===============================
 	Test002.java
 	- ������ ���� �ǽ� 2
==================================*/

package com.test.jdbc06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.util.jdbc06.DBConn;

public class Test002
{
	public static void main(String[] args)
	{
		try
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
					
					System.out.print("�̸� �Է� : ");
					String name = sc.next();
					System.out.print("��ȭ��ȣ �Է� : ");
					String tel = sc.next();
					
					if (conn != null)
					{
						System.out.println("�����ͺ��̽� ���� ����~!!!");
						
						try
						{
							String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
									+ " VALUES(?, ?, ?)";
							
							PreparedStatement pstmt = conn.prepareStatement(sql);
							
							pstmt.setInt(1, Integer.parseInt(sid));
							pstmt.setString(2, name);
							pstmt.setString(3, tel);
							
							int result = pstmt.executeUpdate();
							if(result > 0)
								System.out.println("ȸ�� ���� �Է� �Ϸ�~!!!!");
						}
						catch (Exception e)
						{
							System.out.println(e.toString());
						}
					}
				
				} while (true);
				
				DBConn.close();
				System.out.println("�����ͺ��̽� ���� ����~!!!");
				System.out.println("���α׷� �����~!!!");
				
			}
			
			
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}

}
