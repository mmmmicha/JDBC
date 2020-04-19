/*===============================
 	Test003.java
 	- ������ ���� �ǽ� 3
==================================*/

package com.test.jdbc06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.jdbc06.DBConn;

public class Test003
{
	public static void main(String[] args)
	{
		try
		{
			Connection conn = DBConn.getConnection();
			
			if (conn != null)
			{
				System.out.println("�����ͺ��̽� ���� ����~!!!");
				
				try
				{
					String sql = "SELECT SID, NAME, TEL"
							+ " FROM TBL_MEMBER"
							+ " ORDER BY SID";
					
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					ResultSet rs = pstmt.executeQuery();
					
					while (rs.next())
					{
						int sid = rs.getInt("SID");
						String name = rs.getString("NAME");
						String tel = rs.getString("TEL");
						
						String str = String.format("%3d %7s %10s", sid, name, tel);
						
						System.out.println(str);
					}
					
					rs.close();
					pstmt.close();
					
					
				}
				catch (Exception e)
				{
					System.out.println(e.toString());
				}
			}
			
			DBConn.close();
			System.out.println("�����ͺ��̽� ���� ����~!!!");
			System.out.println("���α׷� �����~!!!");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
/* ��� ���

�����ͺ��̽� ���� ����~!!!
  1     ������ 010-1212-1212
  2     ������ 010-3434-3434
  3     ������ 010-3434-3434
  4     ������ 010-4545-4545
  5     ����ȣ 010-5555-5555
  6     ������ 010-6666-6666
�����ͺ��̽� ���� ����~!!!
���α׷� �����~!!!
*/
