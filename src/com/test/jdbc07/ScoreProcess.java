package com.test.jdbc07;

import java.util.Scanner;

// refactor → rename 으로 하면 클래스의 이름을 변경할 수 있음.

public class ScoreProcess
{
	public void sungjukInput()
	{
		ScoreDAO dao = new ScoreDAO();
		
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.printf("%d번째 학생의 정보를 입력하세요(이름 국어 영어 수학)", dao.count() + 1);
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
		System.out.printf("총 %d 명", dao.count());
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
		for (ScoreDTO dto : dao.lists())
		{
			System.out.println(dto.getSid()+"\t"+dto.getName()+"\t"
							+dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMat()+"\t"
							+dto.getTot()+"\t"+dto.getAvg()+"\t"+dto.getRank());
		}
		System.out.println("------------------------------------");
	}
}
