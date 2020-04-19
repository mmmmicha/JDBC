/*==============================
 	ScoreMain.java
 	
===============================*/

// ○ 실습 문제
//	  성적 처리 프로그램을 구현한다. → 데이터베이스 연동 → ScoreDAO, ScoreDTO 활용

//	  여러 명의 이름, 국어 점수, 영어점수, 수학점수를 입력받아
//	  총점, 평균을 연산하여 출력하는 프로그램을 구현한다.
//	  출력 시 번호(이름, 총점 등) 오름차순 정렬하여 출력한다.

// 실행 예)
/*
1번 학생 성적 입력(이름 국어 영어 수학) : 박혜민 80 75 60
2번 학생 성적 입력(이름 국어 영어 수학) : 오지은 100 90 80
3번 학생 성적 입력(이름 국어 영어 수학) : 김종범 80 85 80
4번 학생 성적 입력(이름 국어 영어 수학) : .

----------------------------------------------------------
번호	이름	국어	영어	수학	총점	평균
----------------------------------------------------------
1		박혜민 	80 		75 		60 		xxx		xx.x
2		오지은  100 	90 		80		xxx		xx.x
3		김종범 	80 		85 		80 		xxx		xx.x
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
				System.out.print(++count + "번 학생 성적 입력(이름 국어 영어 수학) : ");
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
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
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
