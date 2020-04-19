package com.test.jdbc03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.jdbc03.DBConn;

public class ScoreDAO
{
	
	private Connection conn;
	
	public ScoreDAO()
	{
		conn = DBConn.getConnection(); // ¿¬°á ¿Ï·á
	}
	
	public int add(ScoreDTO dto) throws SQLException
	{
		
		String sql = String.format("INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) VALUES(SCORESEQ.NEXTVAL, '%s', '%s', '%s', '%s')"
				, dto.getName(), dto.getKor(), dto.getEng(), dto.getMat());
		
		Statement stmt = conn.createStatement();
		
		int result = stmt.executeUpdate(sql);
		
		stmt.close();
			
		return result;
		
		
	}
	
	
	
	public int count() throws SQLException
	{
		
		Connection conn = DBConn.getConnection();
		
		int result = 0;
		
		String sql = String.format("SELECT COUNT(*) AS COUNT FROM TBL_SCORE");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		if (rs.next())
		{
			result = rs.getInt("COUNT");
		}
		
		
		stmt.close();
		
		
		
		
		return result;
		
	}
	
	public ArrayList<ScoreDTO> lists() throws SQLException
	{
		Connection conn = DBConn.getConnection();
		
		ArrayList<ScoreDTO> arr = new ArrayList<ScoreDTO>();
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS ÃÑÁ¡, (KOR+ENG+MAT)/3 AS Æò±Õ FROM TBL_SCORE";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			
			dto.setSid(rs.getString("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setKor(rs.getString("KOR"));
			dto.setEng(rs.getString("Eng"));
			dto.setMat(rs.getString("Mat"));
			dto.setSum(rs.getString("ÃÑÁ¡"));
			dto.setAvg(rs.getString("Æò±Õ"));
			
			arr.add(dto);
			
		}
		
		stmt.close();
		
		
		return arr;	
		
		
	}
	
}




