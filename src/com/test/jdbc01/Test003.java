/*=================================
	  Test003.java
	  - ������ �Է� �ǽ�
===================================*/

/*
�� JDBC ���α׷��� �ۼ�

   1. ����̹� �ν��Ͻ� ����
   	  ����� ���ϵ�(�����ͺ��̽����� ���� �������� ���� ���ϵ�)��
   	  ���������� �����ϴ��� Ȯ���ϴ�.
   	  *** �� ���������� ���� �ν��Ͻ��� �������� �ʰ�,
   	  *** ����̹��� �ִ����� Ȯ���ϴ��� ���α׷��� �����ϴ� ������ ������ ����.
   	  
   	  �� ����̹� Ŭ������ ã�� ���
   	  	 ��Class�� ��� Ŭ������ ��forName()�� �޼ҵ带 ���.
   	  	 �� �޼ҵ�� �Ű������� �Ѱܹ��� �̸��� Ŭ������ ã���ִ� ������ �����ϸ�
   	  	 �ش� Ŭ������ ã�� ���� ��� ��ClassNotFoundException�� ���ܸ�
   	  	 �߻���Ű�� �ȴ�.
   	  	 
   	2. ���� ��ü ����
   	   (Class.forName() �޼ҵ带 Ȱ���Ͽ�...) ã�� ����̹� Ŭ������ ������
   	   ��ġ�� �����ͺ��̽� ������ �����ϴ� Connection ��ü�� �����Ѵ�.
   	   
   	   �� Connection ��ü�� DriverManager Ŭ������
   	   	  ��getConnection()�� �̶�� static �޼ҵ�� �����Ѵ�.
   	   	  ���ܴ� �����ͺ��̽� ������ ������ �����ϴ� �������� ������ ���� ���
   	   	  �߻��ϰ� �Ǹ�, SQLException ���ܸ� �߻���Ű�� �ȴ�.
   	   	  
   	 3. �۾� ��ü ����
   	    ����� ��Ʈ�� ���� ���ǹ��� ���� �� �ֵ��� �����ִ� ��ü�� �����Ѵ�.
   	    �ڹٿ����� ũ�� �� ���� ������� ���Ǹ� ó���Ѵ�.
   	    
   	    1) Statement ��ü ����
   	       ���� ���Ǹ� ó���� �� �ַ� ���
   	       
   	    2) PreparedStatement ��ü ����
   	       ���� ���Ǹ� ó���� �� �ַ� ���
   	       
   	    3) callableStatement ��ü ����
   	       ���ν����� �Լ��� ȣ���� �� �ֵ��� ���
 */

package com.test.jdbc01;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.util.jdbc01.DBConn;

public class Test003
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConn.getConnection();
		
		do
		{
			System.out.print("��ȣ�� �Է��ϼ���(-1 ����) : ");
			String sid = sc.next();
			
			// �ݺ����� ������ ���ʶ߸��� �ڵ� ����
			if (sid.equals("-1"))
				break;
			
			System.out.print("�̸��� �Է��ϼ��� : ");
			String name = sc.next();
			
			System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
			String tel = sc.next();
			
			if (conn != null)
			{
				System.out.println("�����ͺ��̽� ���� ����~!!!");
				
				try
				{
					Statement stmt = conn.createStatement();
					String sql = String.format(
							"INSERT INTO TBL_MEMBER(SID, NAME, TEL) "
							+ "VALUES(%s, '%s', '%s')"// ** �ߺ��� sid ���� ���� ''�� ����. �̴� ����Ŭ�� �޾��� �� number�� �ν��� ��.
									, sid, name, tel);
					
					// �����ͺ��̽��κ��� ���� ����� �����;� �ϴ� ���
					// �� ��executeQuery()�� �޼ҵ� ���
					// Ư�� ������ �����ͺ��̽��� �����ؾ� �ϴ� ���
					// �� ��executeUpdate()�� �޼ҵ� ���
					int result = stmt.executeUpdate(sql);
					
					if(result > 0)
						System.out.println("ȸ�������� �ԷµǾ����ϴ�.");
					
					
				} 
				catch (Exception e)
				{
					System.out.println(e.toString());
				}
			}
				
		} while (true);
		
		sc.close(); // ���¿� �� �� �ִ� ����. ���ҽ��� ������ ���α׷�����Ǹ� �ڵ����� �ݳ���.
		DBConn.close();
		
		System.out.println("�����ͺ��̽� ���� ����~~!!!");
		System.out.println("���α׷� �����~!!!");
		
		
		
		
		
	}//end main()
	
}//end Test003


/* ���� ���
  
 
ȸ�������� �ԷµǾ����ϴ�.
��ȣ�� �Է��ϼ���(-1 ����) : 4
�̸��� �Է��ϼ��� : ������
��ȭ��ȣ�� �Է��ϼ��� : 010-4444-4444
�����ͺ��̽� ���� ����~!!!
ȸ�������� �ԷµǾ����ϴ�.
��ȣ�� �Է��ϼ���(-1 ����) : -1
�����ͺ��̽� ���� ����~~!!!
���α׷� �����~!!!
*/


