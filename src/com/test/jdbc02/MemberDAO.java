/*===========================================
 	MemberDAO.java
 	- �����ͺ��̽� �׼� ó�� ���� ��ü ����
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
	// �ֿ� ���� ���� �� DB ���� ��ü
	private Connection conn;
	
	// ������ ���� �� ����� ���� ������
	public MemberDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	
	// ��� Ŭ���̾�Ʈ�� �ȸ���!
	// main �̶� db �� �����
	//��� �� �޼ҵ� ���� �� �����͸� �Է��ϴ� ��� �� insert ������ ����
	public int add(MemberDTO dto) throws SQLException
	{
		// �۾���ü ����
		Statement stmt = conn.createStatement();
		
		// ������ �غ�
		String sql = String.format("INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXT(), %s, %s)", dto.getName(), dto.getTel());
		
		
		stmt.close();
		
		return stmt.executeUpdate(sql);
		
			
	}

	// ��� �� �޼ҵ� ���� �� �ο� ���� �ľ��ϴ� ��� �� select ������ ����
	public int count() throws SQLException
	{
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT COUNT(*) FROM TBL_MEMBER";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		int count = rs.getInt("COUNT(*)"); // �̰� Ʋ��!! ALIAS �� ������
		
		stmt.close();
		
		return count;
		
		
	}
	
	// ��� �� �޼ҵ� ���� �� ������ ��ü ��ȸ�ϴ� ��� �� select ������ ����
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
	// �ֿ� ���� ���� �� DB ���� ��ü
	private Connection conn;
	
	// ������ ���� �� ����� ���� ������
	public MemberDAO() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	
	// ��� Ŭ���̾�Ʈ�� �ȸ���!
	// main �̶� db �� �����
	// ��� �� �޼ҵ� ���� �� �����͸� �Է��ϴ� ��� �� insert ������ ����
	public int add(MemberDTO dto) throws SQLException
	{
		// ��ȯ�� ������� ���� ���� (����� ���� ����)
		int result = 0;
		
		// �۾� ��ü ����
		Statement stmt = conn.createStatement();
		
		/*
		�� Statement �� ����
		   - Statement
		     �ϳ��� ������ ����ϰ� ���� �� �̻� ����� �� ����.
		   - PreparedStatement
		     �ϳ��� PreparedStatement �� ������ ���� �� ó���� �� �ִ�.
		   - CallableStatement
		     �����ͺ��̽� ���� ������ ���ν����� �Լ� ���� ȣ���� �� �ִ�.
		     
		�� Statement �� �ǹ�
		   �ڹٿ��� ���Ǵ� 3���� ������ �۾� ��ü����
		   �����ͺ��̽��� ������ ��Ƽ� ������ �׸� ������ ��������.
		   ��, �۾� ��ü�� ������ �Ǿ� �����ͺ��̽��� ����������
		   �� ������ �����ͺ��̽� ������ ó���Ǵ� ���̴�.
		   �� ��, �� �� ����ϰ� ������ �׸��� Statement �̸�,
		   �� ����� ������ �׸��� PreparedStatement �̴�.     
		*/
		
		// Ŀ���� �غ�
		String sql = String.format
				("INSERT INTO TBL_MEMBER(SID, NAME, TEL) "
						+ "VALUES(MEMBERSEQ.NEXTVAL, '%s', '%s')"
						, dto.getName(), dto.getTel()) ;
		
		// �׽�Ʈ
		System.out.println(sql);
		
		
		// ������ ����
		result = stmt.executeUpdate(sql);
		
		stmt.close();
			
		
		// ����� ��ȯ
		return result;
		
			
	}

	
	
	// ��� �� �޼ҵ� ���� �� �ο� ���� �ľ��ϴ� ��� �� select ������ ����
	public int count() throws SQLException
	{
		// ��������� ��ȯ�ϰ� �� ���� ���� �� �ʱ�ȭ
		
		int result = 0;
		
		// �۾� ��ü �غ�
		Statement stmt = conn.createStatement();
		
		// ������ �غ�
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
		// �� Ư������ �� �ִ°͵��� 'ALIAS' �� ���ؼ� �� ��.
		
		// �׽�Ʈ
		System.out.println(sql);
		
		
		// ������ ���� �� select ������ �� ResultSet ��ȯ
		ResultSet rs = stmt.executeQuery(sql);
		
		
		// ResultSet ó�� �� �ݺ��� ����
		// ��� ���忡�� �߰����ִ� ������ ���� �����آZ����! �� ����� ��.
		while (rs.next()) // ��� �� �� ���� (�׷��� ��ǻ� if �� �ᵵ �������) // if (rs.next())
		{
			result = rs.getInt("COUNT");
		}
		
		rs.close();
		stmt.close();
		
		
		// ���� ����� ��ȯ
		return result;
		
		
	}
	
	// ��� �� �޼ҵ� ���� �� ������ ��ü ��ȸ�ϴ� ��� �� select ������ ����
	public ArrayList<MemberDTO> list() throws SQLException
	{
		
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			// MemberDTO �ν��Ͻ� ���� (�ݺ��ؼ�...)
			MemberDTO dto = new MemberDTO();	//						   �� �� ����Ŭ �ε��� �����̹Ƿ� 1����!!
			dto.setSid(rs.getString("SID"));	// dto.setSid(rs.getString(1));
			dto.setName(rs.getString("NAME"));  // dto.setSid(rs.getString(2));
			dto.setTel(rs.getString("TEL"));    // dto.setSid(rs.getString(3));
			
			result.add(dto);
		}
		rs.close();
		
		stmt.close();
		
		
			
        
        
		return result;
			
	}
	
	
	// �����ͺ��̽� ���� ����
	public void close() throws SQLException
	{
		DBConn.close();
	}
	
	
	
}
