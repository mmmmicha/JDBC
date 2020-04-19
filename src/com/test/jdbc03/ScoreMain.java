/*==============================
 	ScoreMain.java
 	
===============================*/

// �� �ǽ� ����
//	  ���� ó�� ���α׷��� �����Ѵ�. �� �����ͺ��̽� ���� �� ScoreDAO, ScoreDTO Ȱ��

//	  ���� ���� �̸�, ���� ����, ��������, ���������� �Է¹޾�
//	  ����, ����� �����Ͽ� ����ϴ� ���α׷��� �����Ѵ�.
//	  ��� �� ��ȣ(�̸�, ���� ��) �������� �����Ͽ� ����Ѵ�.

// ���� ��)
/*
1�� �л� ���� �Է�(�̸� ���� ���� ����) : ������ 80 75 60
2�� �л� ���� �Է�(�̸� ���� ���� ����) : ������ 100 90 80
3�� �л� ���� �Է�(�̸� ���� ���� ����) : ������ 80 85 80
4�� �л� ���� �Է�(�̸� ���� ���� ����) : .

----------------------------------------------------------
��ȣ	�̸�	����	����	����	����	���
----------------------------------------------------------
1		������ 	80 		75 		60 		xxx		xx.x
2		������  100 	90 		80		xxx		xx.x
3		������ 	80 		85 		80 		xxx		xx.x
----------------------------------------------------------

*/

package com.test.jdbc03;

import java.sql.SQLException;
import java.util.Scanner;

import com.util.jdbc03.DBConn;

public class ScoreMain
{

	public static void main(String[] args) throws SQLException
	{

		try
		{
			Scanner sc = new Scanner(System.in);
			ScoreDAO dao = new ScoreDAO();
			ScoreDTO dto = new ScoreDTO();
			
			int count = dao.count();
			
			while (true)
			{
				System.out.print(++count + "�� �л� ���� �Է�(�̸� ���� ���� ����) : ");
				String name = sc.next();

				if (name.equals("."))
				{
					break;
				}
				
				String kor = sc.next();
				String eng = sc.next();
				String mat = sc.next();
				
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
				
				dao.add(dto);
				
			}
			
			System.out.println("----------------------------------------------------------");
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
			System.out.println("----------------------------------------------------------");
			for (ScoreDTO dt : dao.lists())
			{
				System.out.println(dt.getSid() +"\t" + dt.getName() + "\t"+ dt.getKor() + "\t"+ dt.getEng() 
				+ "\t"+ dt.getMat() + "\t"+ dt.getSum() + "\t"+ dt.getAvg());
			}
			System.out.println("----------------------------------------------------------");

		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				DBConn.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2.toString());
			}
		}

	}

}
