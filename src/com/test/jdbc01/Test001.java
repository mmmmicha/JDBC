/*========================
 	Test001.java
 	- Database ���� �׽�Ʈ
==========================*/

// com �� ���� ����
// �� �ȿ� util, test

package com.test.jdbc01;

import java.sql.Connection;

import com.util.jdbc01.DBConn;

public class Test001
{

	public static void main(String[] args)
	{
		Connection conn = DBConn.getConnection();
		// �� DB ���� ������ ���ϰ� ũ�� ������
		//    �� �� ����� ��ü�� ��� ����� �� �ֵ��� Singleton ���� ����
		
		if (conn != null)
		{
			System.out.println("�����ͺ��̽� ���� ����~!!!");
		}
		
		DBConn.close();


	}

}
