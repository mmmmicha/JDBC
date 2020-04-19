/*========================
 	Test001.java
 	- Database 연결 테스트
==========================*/

// com 이 제일 상위
// 그 안에 util, test

package com.test.jdbc01;

import java.sql.Connection;

import com.util.jdbc01.DBConn;

public class Test001
{

	public static void main(String[] args)
	{
		Connection conn = DBConn.getConnection();
		// ※ DB 연결 과정이 부하가 크기 때문에
		//    한 번 연결된 객체를 계속 사용할 수 있도록 Singleton 패턴 적용
		
		if (conn != null)
		{
			System.out.println("데이터베이스 연결 성공~!!!");
		}
		
		DBConn.close();


	}

}
