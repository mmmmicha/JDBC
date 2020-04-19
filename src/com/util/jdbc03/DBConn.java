package com.util.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;


/*=====================
 	DBConn.java
======================*/

// ※ 싱글톤(Singleton) 디자인 패턴을 이용한 Database 연결 객체 생성 전용 클래스
//     (열쇠깎아서 문통과하고 그다음엔 그 깎아놓은것들로 사용해서 문여는 예시)
//    → DB 연결 과정이 가장 부하가 크기 때문에
//		 연결이 필요할 때 마다 객체를 생성하는 것이 아니라
//		 한 번 연결된 객체를 계속 사용하도록 처리.

// DBConn 클래스는 완벽하게 외우기!!!!!! 손코딩 시험 볼 것.

// 핵심 1. static 2. if문

// 한 줄 통째로 지우기 : ctrl + D
// 괄호 적당하게 위치시키기 : ctrl shift f

public class DBConn // 오로지 연결만을 위한 클래스!! 반드시 그래야 함.
{
	// 변수 선언
	private static Connection dbConn; // 이놈이 열쇠 역할
	//-- 자동으로 null 초기화

	// 메소드 정의 → 연결
	public static Connection getConnection()
	{
		// 한 번 연결된 객체를 계속 사용...
		// 즉, 연결되지 않은 경우에만 연결을 시도하겠다는 의미
		// → Singleton(디자인 패턴)
		if (dbConn == null)
		{
			try
			{
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				//								---------IP자리(루프백 address도 가능)
				// localhost 는 오라클 서버의 IP 주소를 기재하는 부분
				// 1521 은 오라클 Port Number
				// xe 는 오라클 SID(Express Edition 은 xe)

				String user = "scott"; //-- 오라클 사용자 계정 이름
				String pwd = "tiger";  //-- 오라클 사용자 계정 암호


				Class.forName("oracle.jdbc.driver.OracleDriver");
				//-- OracleDriver 클래스에 대한 객체 생성
				//	 드라이버 로딩 → JVM 에 전달
				
				dbConn = DriverManager.getConnection(url, user, pwd); // 얘 static 임. 그리고 명칭은 같지만 DriverManager 클래스 내에 있는 메소드
				//-- 오라클 서버 실제 연결
				//	 위 (line 30 ~ 50)는... 연결을 위한 환경을 설정하는 과정
				//   갖고있는 인자값(매개변수)은 오라클 주소, 계정명, 패스워드
				
			} catch (Exception e) // (ClassNotFoundException, SQLException)
			{
				System.out.println(e.toString());
				//-- 오라클 서버 연결 실패 시... 오류 메세지 출력하는 부분
			}

		}
		return dbConn;
		//-- 구성된 연결 객체 반환
		
		
	}//end getConnection()

	
	// getConnection() 메소드의 오버로딩 → 연결
	public static Connection getConnection(String url, String user, String pwd)
	{
		if (dbConn == null)
		{
			try
			{
				Class.forName("Oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url, user, pwd);
				
			} 
			catch (Exception e)
			{
				System.out.println(e.toString());

			}
		}
		return dbConn;
		//-- 구성된 연결 객체 반환
		
	}//end getConnection(String url, String user, String pwd)

	
	// 메소드 정의 → 연결 종료 메소드
	public static void close()
	{
		// dbConn 변수(멤버 변수)는
		// Database 가 연결된 상태일 경우 Connection 을 갖는다.
		// 연결되지 않은 상태라면 null 인 상태가 된다.
		if (dbConn != null)
		{
			try
			{
				// 연결 객체의 isClosed() 메소드를 통해 연결상태 확인
				//-- 연결이 닫혀있는 경우 true 반환
				//   연결이 닫혀있지 않은 경우 false 반환
				if (!dbConn.isClosed())
				{
					dbConn.close();
					//-- 연결 객체의 close() 메소드를 통해 연결 종료
				}
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}

		dbConn = null;
		//-- 연결 객체 초기화
		//   이 처리를 안해놓으면 앞서 만들어놓은 메소드에 적용을 못시킴.(조건문에 걸리도록...)
		
	}//end close()

}// end class DBConn

