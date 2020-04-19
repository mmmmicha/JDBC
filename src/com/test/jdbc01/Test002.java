/*==========================
	Test002.java
	- 데이터 입력 실습 진행
	
============================*/

package com.test.jdbc01;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement; // interface에 대한 import

import com.util.jdbc01.DBConn;

public class Test002
{
	public static void main(String[] args)
	{
		Connection conn = DBConn.getConnection();
		
		if (conn == null)
		{
			System.out.println("데이터베이스 연결 실패~!!!");
			System.exit(0);
		}
		
		//System.out.println("데이터베이스 연결 성공~!!!");
		
		
		try
		{
			// 작업 객체 준비
			Statement stmt = conn.createStatement();
			// Statement interface형 반환
			
			// 데이터 입력 쿼리 실행 과정
			// 한 번 실행하면 다시 실행하지 못한다.
			// 기본키 제약조건이 설정되어 있으므로
			// 동일한 키 값이 중복될 수 있기 때문이다.
			
			// 쿼리문 준비
			String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(2, '박종호', '010-2222-2222')";
			//-- 주의. 쿼리문 끝에 『;』 붙이지 않는다.
			//   주의. 자바에서 실행한 DML 구문은 내부적으로 자동 COMMIT 된다.
			//	 주의. 오라클에서 트랜잭션 처리가 끝나지 않으면
			//	       데이터 액션 처리가 이루어지지 않는다.
			//		   (즉, 오라클에서 직접 쿼리문을 테스트 할 경우
			//		    COMMIT 또는 ROLLBACK 을 반드시 수행할 수 있도록 한다.)
			
			int result = stmt.executeUpdate(sql); // 성공적으로 dml이 수행된만큼 숫자로 반환
			
			if (result > 0)
			{
				System.out.println("데이터 입력 성공~!!!");
				
			}
			else 
			{
				System.out.println("입력 실패~!!!");
			}
			
			
			
			
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		DBConn.close();
		
		
		
	}

}

/*
 실행 결과
  
데이터 입력 성공~!!!
*/
