/*===========================================
 	MemberDAO.java
 	- 데이터베이스 액션 처리 전용 객체 구성
===========================================*/

/*package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class MemberDAO
{
	// 주요 변수 선언 → DB 연결 객체
	private Connection conn;
	
	// 생성자 정의 → 사용자 정의 생성자
	public MemberDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	
	// 얘는 클라이언트랑 안만나!
	// main 이랑 db 의 연결고리
	//기능 → 메소드 정의 → 데이터를 입력하는 기능 → insert 쿼리문 수행
	public int add(MemberDTO dto) throws SQLException
	{
		// 작업객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = String.format("INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXT(), %s, %s)", dto.getName(), dto.getTel());
		
		
		stmt.close();
		
		return stmt.executeUpdate(sql);
		
			
	}

	// 기능 → 메소드 정의 → 인원 수를 파악하는 기능 → select 쿼리문 수행
	public int count() throws SQLException
	{
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT COUNT(*) FROM TBL_MEMBER";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		int count = rs.getInt("COUNT(*)"); // 이거 틀림!! ALIAS 꼭 정해줘
		
		stmt.close();
		
		return count;
		
		
	}
	
	// 기능 → 메소드 정의 → 데이터 전체 조회하는 기능 → select 쿼리문 수행
	public ArrayList<MemberDTO> list() throws SQLException
	{
		MemberDTO dto = new MemberDTO();
		
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER";
		
		ResultSet rs = stmt.executeQuery(sql);
		
        while (rs.next())
		{
        	
        	String sid = rs.getString("SID");
			String name = rs.getString("NAME");
			String tel = rs.getString("TEL");
			
			dto.setSid(sid);
        	dto.setName(name);
        	dto.setTel(tel);
				
			arr.add(dto);
				
		}
        
        rs.close();
        
        stmt.close();
        
        
		return arr;
			
	}
	
}*/


package com.test.jdbc02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.jdbc02.DBConn;

public class MemberDAO
{
	// 주요 변수 선언 → DB 연결 객체
	private Connection conn;
	
	// 생성자 정의 → 사용자 정의 생성자
	public MemberDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	
	// 얘는 클라이언트랑 안만나!
	// main 이랑 db 의 연결고리
	// 기능 → 메소드 정의 → 데이터를 입력하는 기능 → insert 쿼리문 수행
	public int add(MemberDTO dto) throws SQLException
	{
		// 반환할 결과값을 담을 변수 (적용된 행의 갯수)
		int result = 0;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		/*
		※ Statement 의 종류
		   - Statement
		     하나의 쿼리를 사용하고 나면 더 이상 사용할 수 없다.
		   - PreparedStatement
		     하나의 PreparedStatement 로 쿼리를 여러 번 처리할 수 있다.
		   - CallableStatement
		     데이터베이스 내의 스토어드 프로시저나 함수 등을 호출할 수 있다.
		     
		※ Statement 의 의미
		   자바에서 사용되는 3가지 종류의 작업 객체들은
		   데이터베이스로 쿼리를 담아서 보내는 그릇 정도로 생각하자.
		   즉, 작업 객체에 쿼리를 실어 데이터베이스로 보내버리면
		   그 내용이 데이터베이스 내에서 처리되는 것이다.
		   이 때, 한 번 사용하고 버리는 그릇은 Statement 이며,
		   재 사용이 가능한 그릇은 PreparedStatement 이다.     
		*/
		
		// 커리문 준비
		String sql = String.format
				("INSERT INTO TBL_MEMBER(SID, NAME, TEL) "
						+ "VALUES(MEMBERSEQ.NEXTVAL, '%s', '%s')"
						, dto.getName(), dto.getTel()) ;
		
		// 테스트
		System.out.println(sql);
		
		
		// 쿼리문 실행
		result = stmt.executeUpdate(sql);
		
		stmt.close();
			
		
		// 결과값 반환
		return result;
		
			
	}

	
	
	// 기능 → 메소드 정의 → 인원 수를 파악하는 기능 → select 쿼리문 수행
	public int count() throws SQLException
	{
		// 결과값으로 반환하게 될 변수 선언 및 초기화
		
		int result = 0;
		
		// 작업 객체 준비
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
		// 꼭 특수문자 들어가 있는것들을 'ALIAS' 꼭 정해서 할 것.
		
		// 테스트
		System.out.println(sql);
		
		
		// 쿼리문 실행 → select 쿼리문 → ResultSet 반환
		ResultSet rs = stmt.executeQuery(sql);
		
		
		// ResultSet 처리 → 반복문 구성
		// 얘는 현장에서 중계해주는 격으로 어제 설명해줫었어! 잘 기억할 것.
		while (rs.next()) // 얘는 한 번 돌아 (그래서 사실상 if 를 써도 상관없어) // if (rs.next())
		{
			result = rs.getInt("COUNT");
		}
		
		rs.close();
		stmt.close();
		
		
		// 최종 결과값 반환
		return result;
		
		
	}
	
	// 기능 → 메소드 정의 → 데이터 전체 조회하는 기능 → select 쿼리문 수행
	public ArrayList<MemberDTO> list() throws SQLException
	{
		
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			// MemberDTO 인스턴스 생성 (반복해서...)
			MemberDTO dto = new MemberDTO();	//						   ↓ ※ 오라클 인덱스 기준이므로 1부터!!
			dto.setSid(rs.getString("SID"));	// dto.setSid(rs.getString(1));
			dto.setName(rs.getString("NAME"));  // dto.setSid(rs.getString(2));
			dto.setTel(rs.getString("TEL"));    // dto.setSid(rs.getString(3));
			
			result.add(dto);
		}
		rs.close();
		
		stmt.close();
		
		
			
        
        
		return result;
			
	}
	
	
	// 데이터베이스 연결 종료
	public void close() throws SQLException
	{
		DBConn.close();
	}
	
	
	
}
