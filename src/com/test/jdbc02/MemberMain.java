/*============================================
 * 		MemeberMain.java
 * 		- main() 메소드를 포함하고 있는 클래스
 * 
 ==============================================*/

// ○ TBL_MEMBER 테이블을 활용하여
//	  이름과 전화번호를 여러 건 입력받고,
//    전체 출력하는 기능을 가진 프로그램을 구현한다.
//	  단, 데이터베이스 연동이 이루어져야 하고,
//	  MemberDAO, MemberDTO 클래스를 활용해야 한다.

// 실행 예)

// 이름 전화번호 입력(1) : 강초롱 010-1111-1111
// >> 회원정보 입력 완료~!!! 
// 이름 전화번호 입력(2) : 안준헌 010-2222-2222
// >> 회원정보 입력 완료~!!! 
// 이름 전화번호 입력(3) : 김동현 010-3333-3333
// >> 회원정보 입력 완료~!!! 
// 이름 전화번호 입력(4) : .

//-----------------------------------------------
// 전체 회원 수 : 3명
//-----------------------------------------------
/*
번호		이름			전화번호
1		   강초롱		010-1111-1111
2		   안준헌		010-2222-2222
3		   김동현		010-3333-3333
-------------------------------------------------
Ctrl Shift /
*/

// TBL_MEMBER 테이블에 대한 기존 데이터 삭제 및 시퀀스 객체 생성

/*package com.test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class MemberMain
{

	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		int count = 0;
		String name;
		String tel;
		
		
		while (true)
		{
			
			MemberDTO dto = new MemberDTO();
			
			System.out.print("이름 전화번호 입력(" + (dao.count() + 1) + ") : ");
			name = sc.next();
			
			if (name.equals("."))
				break;
			
			dto.setName(name);
			dto.setTel(sc.next());
			
			count += dao.add(dto);
			
			System.out.println(">> 회원 정보 입력 완료~!!!");
		}
		
		System.out.println("---------------------------------");
		System.out.println("전체 회원 수 : " + dao.count() + "명");
		System.out.println("---------------------------------");
		System.out.println("번호\t이름\t전화번호");
		dao.list();
		
		Iterator<MemberDTO> it = dao.list().iterator();
		
		while (it.hasNext())
		{
			MemberDTO md = it.next();
			System.out.println(md.getSid() + "\t" + md.getName() + "\t" + md.getTel() );
			
		}
		System.out.println("---------------------------------");
		
	
	}

}*/

package com.test.jdbc02;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import com.util.jdbc02.DBConn;

public class MemberMain
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			MemberDAO dao = new MemberDAO();
			int count = dao.count();
			String name;

			while (true)
			{

				System.out.print("이름 전화번호 입력(" + (++count) + ") : ");
				name = sc.next();

				if (name.equals("."))
					break;

				// MemberDTO 클래스의 멤버 구성
				MemberDTO dto = new MemberDTO();

				dto.setName(name);
				dto.setTel(sc.next());

				int result = dao.add(dto);
				if (result > 0)
					System.out.println(">> 회원 정보 입력 완료~!!!");
			}

			// -----------------------------------------------
			// 전체 회원 수 : 3명
			// -----------------------------------------------
			/*
			 * 번호 이름 전화번호 1 강초롱 010-1111-1111 2 안준헌 010-2222-2222 3 김동현 010-3333-3333
			 * ------------------------------------------------- Ctrl Shift /
			 */

			System.out.println("---------------------------------");
			System.out.println("전체 회원 수 : " + dao.count() + "명");
			System.out.println("---------------------------------");
			System.out.println("번호\t이름\t전화번호");
			dao.list();

			Iterator<MemberDTO> it = dao.list().iterator();

			while (it.hasNext())
			{
				MemberDTO md = it.next();
				System.out.println(md.getSid() + "\t" + md.getName() + "\t" + md.getTel());

			}
			System.out.println("---------------------------------");
			// ctrl alt 화살표 → 단축키
			// alt shift a → 단축키

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
				System.out.println("데이터베이스 연결 닫힘~!!!");
			}
			catch (Exception e2)
			{
				System.out.println(e2.toString());
			}
		}

	}// end main()

}// end MemberMain