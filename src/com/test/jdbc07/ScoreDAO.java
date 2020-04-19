package com.test.jdbc07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.jdbc07.DBConn;



public class ScoreDAO
{
	private static Connection conn;
	
	public ScoreDAO()
	{
		conn = DBConn.getConnection();
	}
	
	public int input(String name, int kor, int eng, int mat)
	{
		int result = 0;
		
		try
		{
			String sql = String.format("INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) VALUES(SCORESEQ.NEXTVAL, %s, %d, %d, %d)"
									, name, kor, eng, mat);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int count()
	{
		int result = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	public ArrayList<ScoreDTO> lists()
	{
		ArrayList<ScoreDTO> arrayList = new ArrayList<ScoreDTO>();
		ScoreDTO dto = new ScoreDTO();
		
		try
		{
			String sql = "SELECT SID, NAME, KOR, ENG, MAT,"
					+ " (KOR+ENG+MAT) AS TOT,"
					+ " (KOR+ENG+MAT)/3 AS AVG,"
					+ " RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK"
					+ " FROM TBL_SCORE";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				dto.setSid(rs.getInt("SID"));
				dto.setName(rs.getString("NAME"));
				dto.setKor(rs.getInt("KOR"));
				dto.setEng(rs.getInt("ENG"));
				dto.setMat(rs.getInt("MAT"));
				dto.setTot(rs.getInt("TOT"));
				dto.setAvg(rs.getDouble("AVG"));
				dto.setRank(rs.getInt("RANK"));
				
				arrayList.add(dto);
				

			}
			
			rs.close();
			pstmt.close();
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return arrayList;
		
	}
	
	// 이름 검색 출력
	public ArrayList<ScoreDTO> lists(String name)
	{
		ArrayList<ScoreDTO> arrayList = new ArrayList<ScoreDTO>();
		ScoreDTO dto = new ScoreDTO();
		
		try
		{
			String sql = String.format("SELECT SID, NAME, KOR, ENG, MAT"
					+ ", (KOR+ENG+MAT) AS TOT"
					+ ", (KOR+ENG+MAT)/3 AS AVG"
					+ ", RANK() OVER(ORDER BY (KOR+ENG+MAT) DESC) AS RANK"
					+ " FROM TBL_SCORE"
					+ " WHERE NAME = '%s'", name);

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				dto.setSid(rs.getInt("SID"));
				dto.setName(rs.getString("NAME"));
				dto.setKor(rs.getInt("KOR"));
				dto.setEng(rs.getInt("ENG"));
				dto.setMat(rs.getInt("MAT"));
				dto.setTot(rs.getInt("TOT"));
				dto.setAvg(rs.getDouble("AVG"));
				dto.setRank(rs.getInt("RANK"));
				
				arrayList.add(dto);
				

			}
			
			rs.close();
			pstmt.close();
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return arrayList;
		
	}
	
	public int update(ScoreDTO dto)
	{
		int result = 0;
		
		try
		{
			String sql = String.format("UPDATE TBL_SCORE SET NAME = '%s', KOR = %d, ENG = %d, MAT = %d WHERE SID = %d"
									, dto.getName(), dto.getKor(), dto.getEng(), dto.getMat(), dto.getSid());
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	public int delete(int sid)
	{
		int result = 0;
		
		try
		{
			String sql = "DELETE\r\n" + 
					" FROM TBL_SCORE\r\n" + 
					" WHERE SID = 3";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return result;
	}
	
	public void close()
	{
		try
		{
			conn.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	
	
}
