package com.test.jdbc07;

import java.util.Scanner;

// refactor �� rename ���� �ϸ� Ŭ������ �̸��� ������ �� ����.

public class ScoreProcess
{
	public void sungjukInput()
	{
		ScoreDAO dao = new ScoreDAO();
		
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.printf("%d��° �л��� ������ �Է��ϼ���(�̸� ���� ���� ����)", dao.count() + 1);
			String name = sc.next();
			
			if (name.equals("."))
				break;
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int mat = sc.nextInt();
			
			dao.input(name, kor, eng, mat);
			
		} while (true);
		
		dao.close();
		
		
	}
	
	public void print()
	{
		ScoreDAO dao = new ScoreDAO();
		
		System.out.println("------------------------------------");
		System.out.printf("�� %d ��", dao.count());
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
		for (ScoreDTO dto : dao.lists())
		{
			System.out.println(dto.getSid()+"\t"+dto.getName()+"\t"
							+dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMat()+"\t"
							+dto.getTot()+"\t"+dto.getAvg()+"\t"+dto.getRank());
		}
		System.out.println("------------------------------------");
	}
}
