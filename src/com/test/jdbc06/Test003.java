/*===============================
 	Test003.java
 	- 쿼리문 전송 실습 3
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
				System.out.println("데이터베이스 연결 성공~!!!");
				
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
			System.out.println("데이터베이스 연결 닫힘~!!!");
			System.out.println("프로그램 종료됨~!!!");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
/* 결과 출력

데이터베이스 연결 성공~!!!
  1     한현수 010-1212-1212
  2     두현수 010-3434-3434
  3     두현수 010-3434-3434
  4     네현수 010-4545-4545
  5     박종호 010-5555-5555
  6     성열원 010-6666-6666
데이터베이스 연결 닫힘~!!!
프로그램 종료됨~!!!
*/
