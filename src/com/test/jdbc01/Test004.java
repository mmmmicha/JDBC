/*===================================
	Test004.java
	- select ������ ���� �� ��� ����
=====================================*/

package com.test.jdbc01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.util.jdbc01.DBConn;

public class Test004
{
	public static void main(String[] args)
	{
		// �����ͺ��̽� ���� ��ü ����
		Connection conn = DBConn.getConnection();
		
		if (conn != null)
		{
			System.out.println("�����ͺ��̽� ���� ����~!!!");
			
			try
			{
				// �۾� ��ü ����
				Statement stmt = conn.createStatement();
				
				// ������ �غ�
				String sql = "SELECT SID,NAME,TEL FROM TBL_MEMBER ORDER BY 1";
				
				// executeQuery() �޼ҵ带 ����ϸ�
				// ���� ����� ResultSet ��ü�� ������ �� �ִ�.
				// ������, ResultSet ��ü�� ���ǿ� ���� ����� ��θ�
				// �Ѳ����� �����ִ� ������ �ƴϴ�.
				// ����, �����ͺ��̽��κ��� ȹ���� ���� ������� ����
				// ������ ������ ���°� �Ǵ� ���̴�.
				// �� ������... ResultSet �� �����ߴٰ� �ؼ�
				// �����ͺ��̽��� ������ ���� �Ǹ�,
				// ResultSet ��ü�� ���̻� ���� ����� ������ �� ���� �ȴ�.
				
				ResultSet rs = stmt.executeQuery(sql);
				
				//DBConn.close(); ���� �ȵ�!!!
				
				while (rs.next())	// ResultSet �� ���� ���� ���� ���� ��ȯ
				{
					// ���ڵ忡�� ������� �������� ���� getter() �޼ҵ�
					// �� getXxx()
					String sid = rs.getString("SID");
					String name = rs.getString("NAME");
					String tel = rs.getString("TEL");
					
					String str = String.format("%3s %8s %12s",sid, name, tel);
					
					System.out.println(str);
					
				}

				rs.close();	// ������� ���ҽ� �ݳ�
				
				stmt.close();	// �۾���ü ���ҽ� �ݳ�
				
				
				
				
			} 
			catch (Exception e)
			{
				System.out.println(e.toString());
				
				
			}
			
			
		}//end if
		
		DBConn.close();	// ���� ��ü ���ҽ� �ݳ�
		
		System.out.println("�����ͺ��̽� ���� ����");
		System.out.println("���α׷� �����~!!!");
	}
	
	
}

/* ���� ���
  
  
�����ͺ��̽� ���� ����~!!!
  1      ������ 010-1111-1111
  2      ����ȣ 010-2222-2222
  3      ��ҿ� 010-3333-3333
  4      ������ 010-4444-4444
�����ͺ��̽� ���� ����
���α׷� �����~!!!
*/
