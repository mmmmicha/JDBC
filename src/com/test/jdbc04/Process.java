/*=====================
	Process.java
======================*/

package com.test.jdbc04;

import java.util.Scanner;

public class Process
{
	// �ֿ� �Ӽ� ���� �� �����ͺ��̽� �׼� ó�� ���� ��ü �� ScoreDAO
	private ScoreDAO dao;
	private Scanner sc;
	
	// ������ ���� �� ����� ���� ������
	public Process()
	{
		dao = new ScoreDAO();
		
	}
	
	
	// ���� �Է�
	public void sungjunInsert()
	{
		try
		{
			// �����ͺ��̽� ����
			dao.connection();
			
			int count = dao.count();
			sc = new Scanner(System.in);
			
			do
			{
				System.out.println();
				System.out.printf("%d�� �л� ���� �Է�(�̸� ���� ���� ����) : ", (++count));
				String name = sc.next();
				if(name.equals("."))
					break;
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				
				ScoreDTO dto = new ScoreDTO();
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
				
				
				dao.add(dto);
				
				
			} while (true);
			
			
			
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	// ���� ��ü ���
	
	// �̸� �˻� ���
	
	// ���� ����
	
	// ��������
			
	
}
