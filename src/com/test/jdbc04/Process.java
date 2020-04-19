/*=====================
	Process.java
======================*/

package com.test.jdbc04;

import java.util.Scanner;

public class Process
{
	// 주요 속성 구성 → 데이터베이스 액션 처리 전담 객체 → ScoreDAO
	private ScoreDAO dao;
	private Scanner sc;
	
	// 생성자 정의 → 사용자 정의 생성자
	public Process()
	{
		dao = new ScoreDAO();
		
	}
	
	
	// 성적 입력
	public void sungjunInsert()
	{
		try
		{
			// 데이터베이스 연결
			dao.connection();
			
			int count = dao.count();
			sc = new Scanner(System.in);
			
			do
			{
				System.out.println();
				System.out.printf("%d번 학생 성적 입력(이름 국어 영어 수학) : ", (++count));
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
	
	// 성적 전체 출력
	
	// 이름 검색 출력
	
	// 성적 수정
	
	// 성적삭제
			
	
}
