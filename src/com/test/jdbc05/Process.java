package com.test.jdbc05;

import java.util.ArrayList;
import java.util.Scanner;

/*==============[ 직원 관리 ]==============
1. 직원 정보 입력
2. 직원 전체 출력
	- 사번 정렬
	- 이름 정렬
	- 부서 정렬
	- 직위 정렬
	- 급여 내림차순 정렬
3. 직원 검색 출력
	- 사번 검색
	- 이름 검색
	- 부서 검색
	- 직위 검색
4. 직원 정보 수정
5. 직원 정보 삭제
==========================================
>> 메뉴 선택(1~5, -1 종료) : 1

직원 정보 입력 -------------------------------------------
이름 : 이은채
주민등록번호(yymmdd-nnnnnnn) : 900123-2234567
입사일(yyyy-mm-dd) : 2015-05-06
지역(강원,경기,경남,경북,부산,서울,인천,전남,전북,제주,충남) : 서울
전화번호 : 010-1234-1234
부서(개발부,기획부,영업부,인사부,자재부,총무부,홍보부) : 개발부
직위(사장,전무,상무,이사,부장,차장,과장,대리,사원) : 대리
기본급(최소 1250000 이상) : 1300000
수당 : 1000000
>> 직원 정보 입력 완료~!!!
----------------------------------------------------------   


1. 사번 정렬
2. 이름 정렬
3. 부서 정렬
4. 직위 정렬
5. 급여 내림차순 정렬
>> 선택(1~5, -1 종료) : 1

전체 인원 : 60명
사번  이름  주민번호  입사일  지역  전화번호  부서  직위  기본급  수당  급여
									:


*/

public class Process
{
	
	public void informInput()
	{
		Scanner sc = new Scanner(System.in);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		
		System.out.println();
		System.out.println("직원 정보 입력 -------------------------------------------");
		System.out.print("이름 : ");
		String name = sc.next();
		dto.setEmpname(name);
		
		System.out.print("주민등록번호(yymmdd-nnnnnnn) : ");
		String ssn = sc.next();
		dto.setSsn(ssn);
		
		System.out.print("입사일(yyyy-mm-dd) : ");
		String date = sc.next();
		dto.setIbsadate(date);
		
		System.out.print("지역(강원,경기,경남,경북,부산,서울,인천,전남,전북,제주,충남) : ");
		String city = sc.next();
		dto.setCity(city);
		
		System.out.print("전화번호 : ");
		String tel = sc.next();
		dto.setTel(tel);
		
		System.out.print("부서(개발부,기획부,영업부,인사부,자재부,총무부,홍보부) : ");
		String buseo = sc.next();
		dto.setBuseo(buseo);
		
		System.out.print("직위(사장,전무,상무,이사,부장,차장,과장,대리,사원) : ");
		String jikwi = sc.next();
		dto.setJikwi(jikwi);
		
		System.out.printf("기본급(최소 %d 이상) : ", dao.outMinpay(dao.jikwiID(dto)));
		int basicpay = sc.nextInt();
		dto.setBasicpay(basicpay);
		
		System.out.print("수당 : ");
		int sudang = sc.nextInt();
		dto.setSudang(sudang);
		
		int result = dao.add(dto);
		
		if (result > 0)
			System.out.println(">> 직원 정보 입력 완료~!!!");
		else
			System.out.println("정보입력이 되지 않았습니다.");
		
		System.out.println("----------------------------------------------------------");
		
		dao.close();
		
		
		
	}
	
	public void informOutput(String a)
	{
		
		MemberDAO dao = new MemberDAO();
		
		System.out.println();
		System.out.printf("전체 인원 : %d명\n", dao.count());
		System.out.println("사번  이름  주민번호  입사일  지역  전화번호  부서  직위  기본급  수당  급여");
		
		for (MemberDTO dto : dao.lists(a))
		{
			System.out.printf("%3d %3s %14s %10s %3s %12s %3s %2s %8d %8d %9d\n",dto.getEmpid(), dto.getEmpname(), dto.getSsn(), dto.getIbsadate()
												, dto.getCity(), dto.getTel(), dto.getBuseo(), dto.getJikwi(), dto.getBasicpay()
												, dto.getSudang(), dto.getPay());
		}
		
		dao.close();
		
	}
	
	public void informOutputD()
	{
		MemberDAO dao = new MemberDAO();
		
		System.out.println();
		System.out.printf("전체 인원 : %d명\n", dao.count());
		System.out.println("사번  이름  주민번호  입사일  지역  전화번호  부서  직위  기본급  수당  급여");
		
		for (MemberDTO dto : dao.Desclists())
		{
			System.out.printf("%3d %3s %14s %10s %3s %12s %3s %2s %8d %8d %9d\n",dto.getEmpid(), dto.getEmpname(), dto.getSsn(), dto.getIbsadate()
												, dto.getCity(), dto.getTel(), dto.getBuseo(), dto.getJikwi(), dto.getBasicpay()
												, dto.getSudang(), dto.getPay());
		}
		
		dao.close();
	}
	
	public void serchOutputN()
	{
		MemberDAO dao = new MemberDAO();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		
		System.out.println();
		System.out.println("사번  이름  주민번호  입사일  지역  전화번호  부서  직위  기본급  수당  급여");
		
		for (MemberDTO dto : dao.SearchlistsN(name))
		{
			System.out.printf("%3d %3s %14s %10s %3s %12s %3s %2s %8d %8d %9d\n",dto.getEmpid(), dto.getEmpname(), dto.getSsn(), dto.getIbsadate()
												, dto.getCity(), dto.getTel(), dto.getBuseo(), dto.getJikwi(), dto.getBasicpay()
												, dto.getSudang(), dto.getPay());
		}
		
		dao.close();
	}
	
	public void serchOutputJ()
	{
		MemberDAO dao = new MemberDAO();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직위를 입력하세요(사장,전무,상무,이사,부장,차장,과장,대리,사원) : ");
		String jikwi = sc.next();
		
		System.out.println();
		System.out.println("사번  이름  주민번호  입사일  지역  전화번호  부서  직위  기본급  수당  급여");
		
		for (MemberDTO dto : dao.SearchlistsJ(jikwi))
		{
			System.out.printf("%3d %3s %14s %10s %3s %12s %3s %2s %8d %8d %9d\n",dto.getEmpid(), dto.getEmpname(), dto.getSsn(), dto.getIbsadate()
												, dto.getCity(), dto.getTel(), dto.getBuseo(), dto.getJikwi(), dto.getBasicpay()
												, dto.getSudang(), dto.getPay());
		}
		
		dao.close();
	}
	
	public void serchOutputB()
	{
		MemberDAO dao = new MemberDAO();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("부서를 입력하세요(개발부,기획부,영업부,인사부,자재부,총무부,홍보부) : ");
		String buseo = sc.next();
		
		System.out.println();
		System.out.println("사번  이름  주민번호  입사일  지역  전화번호  부서  직위  기본급  수당  급여");
		
		for (MemberDTO dto : dao.SearchlistsB(buseo))
		{
			System.out.printf("%3d %3s %14s %10s %3s %12s %3s %2s %8d %8d %9d\n",dto.getEmpid(), dto.getEmpname(), dto.getSsn(), dto.getIbsadate()
												, dto.getCity(), dto.getTel(), dto.getBuseo(), dto.getJikwi(), dto.getBasicpay()
												, dto.getSudang(), dto.getPay());
		}
		
		dao.close();
	}
	
	public void serchOutputS()
	{
		MemberDAO dao = new MemberDAO();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사원번호를 입력하세요 : ");
		String empid = sc.next();
		
		
		System.out.println();
		System.out.println("사번  이름  주민번호  입사일  지역  전화번호  부서  직위  기본급  수당  급여");
		
		for (MemberDTO dto : dao.SearchlistsS(empid))
		{
			System.out.printf("%3d %3s %14s %10s %3s %12s %3s %2s %8d %8d %9d\n",dto.getEmpid(), dto.getEmpname(), dto.getSsn(), dto.getIbsadate()
												, dto.getCity(), dto.getTel(), dto.getBuseo(), dto.getJikwi(), dto.getBasicpay()
												, dto.getSudang(), dto.getPay());
		}
		
		dao.close();
	}
	
	public void informUpdate()
	{
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println();
		System.out.println("수정할 정보 입력 -------------------------------------------");
		System.out.print("수정할 사원의 부서번호를 입력하세요 : ");
		int empid = sc.nextInt();
		dto.setEmpid(empid);
		
		System.out.print("이름 : ");
		String name = sc.next();
		dto.setEmpname(name);
		
		System.out.print("주민등록번호(yymmdd-nnnnnnn) : ");
		String ssn = sc.next();
		dto.setSsn(ssn);
		
		System.out.print("입사일(yyyy-mm-dd) : ");
		String date = sc.next();
		dto.setIbsadate(date);
		
		System.out.print("지역(강원,경기,경남,경북,부산,서울,인천,전남,전북,제주,충남) : ");
		String city = sc.next();
		dto.setCity(city);
		
		System.out.print("전화번호 : ");
		String tel = sc.next();
		dto.setTel(tel);
		
		System.out.print("부서(개발부,기획부,영업부,인사부,자재부,총무부,홍보부) : ");
		String buseo = sc.next();
		dto.setBuseo(buseo);
		
		System.out.print("직위(사장,전무,상무,이사,부장,차장,과장,대리,사원) : ");
		String jikwi = sc.next();
		dto.setJikwi(jikwi);
		
		System.out.printf("기본급(최소 %d 이상) : ", dao.outMinpay(dao.jikwiID(dto)));
		int basicpay = sc.nextInt();
		dto.setBasicpay(basicpay);
		
		System.out.print("수당 : ");
		int sudang = sc.nextInt();
		dto.setSudang(sudang);
		
		int result = dao.empUpdate(dto);
		
		if (result > 0)
			System.out.println(">> 직원 정보 수정 완료~!!!");
		else
			System.out.println("정보수정이 되지 않았습니다.");
		
		System.out.println("----------------------------------------------------------");
		
		dao.close();
	}
	
	
	public void informDelete()
	{
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		
		
		System.out.print("삭제할 사원의 번호를 입력하세요 : ");
		int empid = sc.nextInt();
		
		int result = dao.delete(empid);
		
		if(result > 0)
			System.out.println("해당 정보가 삭제되었습니다.");
		else
			System.out.println("삭제되지 않았습니다.");
		
		dao.close();
		
	}
	
	
	
}
