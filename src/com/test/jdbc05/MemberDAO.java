package com.test.jdbc05;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.jdbc05.DBConn;

public class MemberDAO
{
	private Connection conn;
	
	public MemberDAO()
	{
		conn = DBConn.getConnection();
	}
	
	// 전체 인원수 세는 메소드
	public int count()
	{
		int result = 0;
		
		try
		{
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT COUNT(*) AS COUNT FROM TBL_EMP";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next())
				result = rs.getInt("COUNT");
			
			rs.close();
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	// 최소봉급
	public int outMinpay(int jikwi)
	{
		int result = 0;
		
		try
		{
			Statement stmt = conn.createStatement();
			String sql = String.format("SELECT MIN_BASICPAY FROM TBL_JIKWI WHERE JIKWI_ID = %d", jikwi);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())
				result = rs.getInt("MIN_BASICPAY");
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	// 도시 이름 → 도시 아이디
	public int cityID(MemberDTO dto)
	{
		int city = 0;
		
		try
		{
			Statement stmt = conn.createStatement();
			String sql = String.format("SELECT CITY_ID FROM TBL_CITY WHERE CITY_LOC = '%s'", dto.getCity());
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())
				city = rs.getInt("CITY_ID");
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return city;
		
	}
	
	// 부서 이름 → 부서 아이디
	public int buseoID(MemberDTO dto)
	{
		int buseo = 0;
		
		try
		{
			Statement stmt = conn.createStatement();
			String sql = String.format("SELECT BUSEO_ID FROM TBL_BUSEO WHERE BUSEO_NAME = '%s'", dto.getBuseo());
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())
				buseo = rs.getInt("BUSEO_ID");
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return buseo;
		
	}
	
	// 직위 이름 → 직위 아이디
	public int jikwiID(MemberDTO dto)
	{
		int jikwi = 0;
		
		try
		{
			Statement stmt = conn.createStatement();
			String sql = String.format("SELECT JIKWI_ID FROM TBL_JIKWI WHERE JIKWI_NAME = '%s'", dto.getJikwi());
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())
				jikwi = rs.getInt("JIKWI_ID");
			
			rs.close();
			stmt.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return jikwi;
		
	}
	
	
	public int add(MemberDTO dto)
	{
		int result = 0;
		
		int city = 0;
		int buseo = 0;
		int jikwi = 0;
		long minpay = 0;
		
		city = cityID(dto);
		buseo = buseoID(dto);
		jikwi = jikwiID(dto);
		
		try
		{
			
			
			Statement stmt1 = conn.createStatement();
			
			String sql1 = String.format("INSERT INTO TBL_EMP(EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_ID, TEL, BUSEO_ID, JIKWI_ID, BASICPAY, SUDANG) VALUES(EMPSEQ.NEXTVAL, '%s', '%s', TO_DATE('%s', 'YYYY-MM-DD'), %d, '%s', %d, %d, %d, %d)"
									, dto.getEmpname(), dto.getSsn(), dto.getIbsadate(), city, dto.getTel(), buseo, jikwi, dto.getBasicpay(), dto.getSudang());
			
			result = stmt1.executeUpdate(sql1);
			
			
			
			stmt1.close();
			
			
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	// 사번, 이름, 부서, 직위 정렬 전체 출력
	public ArrayList<MemberDTO> lists(String a)
	{
		ArrayList<MemberDTO> arrayList = null;
		
		try
		{
			Statement stmt = conn.createStatement();
			
			String sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_LOC, TEL, BUSEO_NAME, JIKWI_NAME, MIN_BASICPAY, BASICPAY, SUDANG, PAY FROM EMPVIEW ORDER BY %s", a);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while (rs.next())
			{
				int empidd = rs.getInt("EMP_ID");
				String empname = rs.getString("EMP_NAME");
				String ssn = rs.getString("SSN");
				String ibsadate = rs.getString("IBSADATE");
				String cityloc = rs.getString("CITY_LOC");
				String tel = rs.getString("TEL");
				String buseo = rs.getString("BUSEO_NAME");
				String jikwi = rs.getString("JIKWI_NAME");
				int minbasicpay = rs.getInt("MIN_BASICPAY");
				int basicpay = rs.getInt("BASICPAY");
				int sudang = rs.getInt("SUDANG");
				int pay = rs.getInt("PAY");
				
				MemberDTO dto = new MemberDTO();
				
				dto.setEmpid(empidd);
				dto.setEmpname(empname);
				dto.setSsn(ssn);
				dto.setIbsadate(ibsadate);
				dto.setCity(cityloc);
				dto.setTel(tel);
				dto.setBuseo(buseo);
				dto.setJikwi(jikwi);
				dto.setMinbasicpay(minbasicpay);
				dto.setBasicpay(basicpay);
				dto.setSudang(sudang);
				dto.setPay(pay);
				
				arrayList = new ArrayList<MemberDTO>();
				
				arrayList.add(dto);
				
			}
			
			rs.close();
			
			stmt.close();
			
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return arrayList;
		
	}
	
	// 내림차순 정렬 전체 출력
	public ArrayList<MemberDTO> Desclists()
	{
		ArrayList<MemberDTO> arrayList = null;
		
		try
		{
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_LOC, TEL, BUSEO_NAME, JIKWI_NAME, MIN_BASICPAY, BASICPAY, SUDANG, PAY FROM EMPVIEW ORDER BY BASICPAY DESC";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while (rs.next())
			{
				int empidd = rs.getInt("EMP_ID");
				String empname = rs.getString("EMP_NAME");
				String ssn = rs.getString("SSN");
				String ibsadate = rs.getString("IBSADATE");
				String cityloc = rs.getString("CITY_LOC");
				String tel = rs.getString("TEL");
				String buseo = rs.getString("BUSEO_NAME");
				String jikwi = rs.getString("JIKWI_NAME");
				int minbasicpay = rs.getInt("MIN_BASICPAY");
				int basicpay = rs.getInt("BASICPAY");
				int sudang = rs.getInt("SUDANG");
				int pay = rs.getInt("PAY");
				
				MemberDTO dto = new MemberDTO();
				
				dto.setEmpid(empidd);
				dto.setEmpname(empname);
				dto.setSsn(ssn);
				dto.setIbsadate(ibsadate);
				dto.setCity(cityloc);
				dto.setTel(tel);
				dto.setBuseo(buseo);
				dto.setJikwi(jikwi);
				dto.setMinbasicpay(minbasicpay);
				dto.setBasicpay(basicpay);
				dto.setSudang(sudang);
				dto.setPay(pay);
				
				arrayList = new ArrayList<MemberDTO>();
				
				arrayList.add(dto);
				
			}
			
			rs.close();
			
			stmt.close();
			
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return arrayList;
		
	}
	
	
	
	// 직원 이름 검색 출력
	public ArrayList<MemberDTO> SearchlistsN(String a)
	{
		ArrayList<MemberDTO> arrayList = null;
		
		try
		{
			Statement stmt = conn.createStatement();
			
			String sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_LOC, TEL, BUSEO_NAME, JIKWI_NAME, MIN_BASICPAY, BASICPAY, SUDANG, PAY FROM EMPVIEW WHERE EMP_NAME = '%s'", a);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while (rs.next())
			{
				int empidd = rs.getInt("EMP_ID");
				String empname = rs.getString("EMP_NAME");
				String ssn = rs.getString("SSN");
				String ibsadate = rs.getString("IBSADATE");
				String cityloc = rs.getString("CITY_LOC");
				String tel = rs.getString("TEL");
				String buseo = rs.getString("BUSEO_NAME");
				String jikwi = rs.getString("JIKWI_NAME");
				int minbasicpay = rs.getInt("MIN_BASICPAY");
				int basicpay = rs.getInt("BASICPAY");
				int sudang = rs.getInt("SUDANG");
				int pay = rs.getInt("PAY");
				
				MemberDTO dto = new MemberDTO();
				
				dto.setEmpid(empidd);
				dto.setEmpname(empname);
				dto.setSsn(ssn);
				dto.setIbsadate(ibsadate);
				dto.setCity(cityloc);
				dto.setTel(tel);
				dto.setBuseo(buseo);
				dto.setJikwi(jikwi);
				dto.setMinbasicpay(minbasicpay);
				dto.setBasicpay(basicpay);
				dto.setSudang(sudang);
				dto.setPay(pay);
				
				arrayList = new ArrayList<MemberDTO>();
				
				arrayList.add(dto);
				
			}
			
			rs.close();
			
			stmt.close();
			
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return arrayList;
		
	}
	
	
	// 번호 검색
	public ArrayList<MemberDTO> SearchlistsS(String a)
	{
		ArrayList<MemberDTO> arrayList = null;
		
		try
		{
			Statement stmt = conn.createStatement();
			
			String sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_LOC, TEL, BUSEO_NAME, JIKWI_NAME, MIN_BASICPAY, BASICPAY, SUDANG, PAY FROM EMPVIEW WHERE EMP_ID = %s", a);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while (rs.next())
			{
				int empidd = rs.getInt("EMP_ID");
				String empname = rs.getString("EMP_NAME");
				String ssn = rs.getString("SSN");
				String ibsadate = rs.getString("IBSADATE");
				String cityloc = rs.getString("CITY_LOC");
				String tel = rs.getString("TEL");
				String buseo = rs.getString("BUSEO_NAME");
				String jikwi = rs.getString("JIKWI_NAME");
				int minbasicpay = rs.getInt("MIN_BASICPAY");
				int basicpay = rs.getInt("BASICPAY");
				int sudang = rs.getInt("SUDANG");
				int pay = rs.getInt("PAY");
				
				MemberDTO dto = new MemberDTO();
				
				dto.setEmpid(empidd);
				dto.setEmpname(empname);
				dto.setSsn(ssn);
				dto.setIbsadate(ibsadate);
				dto.setCity(cityloc);
				dto.setTel(tel);
				dto.setBuseo(buseo);
				dto.setJikwi(jikwi);
				dto.setMinbasicpay(minbasicpay);
				dto.setBasicpay(basicpay);
				dto.setSudang(sudang);
				dto.setPay(pay);
				
				arrayList = new ArrayList<MemberDTO>();
				
				arrayList.add(dto);
				
			}
			
			rs.close();
			
			stmt.close();
			
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return arrayList;
		
	}
	
	// 부서 이름 검색
	public ArrayList<MemberDTO> SearchlistsB(String a)
	{
		ArrayList<MemberDTO> arrayList = null;
		
		try
		{
			Statement stmt = conn.createStatement();
			
			String sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_LOC, TEL, BUSEO_NAME, JIKWI_NAME, MIN_BASICPAY, BASICPAY, SUDANG, PAY FROM EMPVIEW WHERE BUSEO_NAME = '%s'", a);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while (rs.next())
			{
				int empidd = rs.getInt("EMP_ID");
				String empname = rs.getString("EMP_NAME");
				String ssn = rs.getString("SSN");
				String ibsadate = rs.getString("IBSADATE");
				String cityloc = rs.getString("CITY_LOC");
				String tel = rs.getString("TEL");
				String buseo = rs.getString("BUSEO_NAME");
				String jikwi = rs.getString("JIKWI_NAME");
				int minbasicpay = rs.getInt("MIN_BASICPAY");
				int basicpay = rs.getInt("BASICPAY");
				int sudang = rs.getInt("SUDANG");
				int pay = rs.getInt("PAY");
				
				MemberDTO dto = new MemberDTO();
				
				dto.setEmpid(empidd);
				dto.setEmpname(empname);
				dto.setSsn(ssn);
				dto.setIbsadate(ibsadate);
				dto.setCity(cityloc);
				dto.setTel(tel);
				dto.setBuseo(buseo);
				dto.setJikwi(jikwi);
				dto.setMinbasicpay(minbasicpay);
				dto.setBasicpay(basicpay);
				dto.setSudang(sudang);
				dto.setPay(pay);
				
				arrayList = new ArrayList<MemberDTO>();
				
				arrayList.add(dto);
				
			}
			
			rs.close();
			
			stmt.close();
			
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return arrayList;
		
	}
	
	// 직위 검색
	public ArrayList<MemberDTO> SearchlistsJ(String a)
	{
		ArrayList<MemberDTO> arrayList = null;
		
		try
		{
			Statement stmt = conn.createStatement();
			
			String sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_LOC, TEL, BUSEO_NAME, JIKWI_NAME, MIN_BASICPAY, BASICPAY, SUDANG, PAY FROM EMPVIEW WHERE JIKWI_NAME = '%s'", a);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			
			while (rs.next())
			{
				int empidd = rs.getInt("EMP_ID");
				String empname = rs.getString("EMP_NAME");
				String ssn = rs.getString("SSN");
				String ibsadate = rs.getString("IBSADATE");
				String cityloc = rs.getString("CITY_LOC");
				String tel = rs.getString("TEL");
				String buseo = rs.getString("BUSEO_NAME");
				String jikwi = rs.getString("JIKWI_NAME");
				int minbasicpay = rs.getInt("MIN_BASICPAY");
				int basicpay = rs.getInt("BASICPAY");
				int sudang = rs.getInt("SUDANG");
				int pay = rs.getInt("PAY");
				
				MemberDTO dto = new MemberDTO();
				
				dto.setEmpid(empidd);
				dto.setEmpname(empname);
				dto.setSsn(ssn);
				dto.setIbsadate(ibsadate);
				dto.setCity(cityloc);
				dto.setTel(tel);
				dto.setBuseo(buseo);
				dto.setJikwi(jikwi);
				dto.setMinbasicpay(minbasicpay);
				dto.setBasicpay(basicpay);
				dto.setSudang(sudang);
				dto.setPay(pay);
				
				arrayList = new ArrayList<MemberDTO>();
				
				arrayList.add(dto);
				
			}
			
			rs.close();
			
			stmt.close();
			
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return arrayList;
		
	}
	
	// 업데이트
	public int empUpdate(MemberDTO dto)
	{
		int result = 0;
		
		int city = 0;
		int buseo = 0;
		int jikwi = 0;
		
		try
		{
			
			city = cityID(dto);
			buseo = buseoID(dto);
			jikwi = jikwiID(dto);
			
			
			Statement stmt = conn.createStatement();
			
			String sql = String.format("UPDATE TBL_EMP SET EMP_NAME = '%s', SSN = '%s', IBSADATE = TO_DATE('%s', 'YYYY-MM-DD'), CITY_ID = %d, TEL = '%s', BUSEO_ID = %d, JIKWI_ID = %d, BASICPAY = %d, SUDANG = %d WHERE EMP_ID = %d"
					           , dto.getEmpname(), dto.getSsn(), dto.getIbsadate(), city, dto.getTel(), buseo, jikwi, dto.getBasicpay(), dto.getSudang(), dto.getEmpid());
			
			result = stmt.executeUpdate(sql);
			
			
			
			stmt.close();
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	// 삭제
	public int delete(int empid)
	{
		int result = 0;
		
		try
		{
			Statement stmt = conn.createStatement();
			
			String sql = String.format("DELETE FROM TBL_EMP WHERE EMP_ID = %d", empid);
			
			result = stmt.executeUpdate(sql);
			
			stmt.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	public void close()
	{
		try
		{
			DBConn.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	
}
