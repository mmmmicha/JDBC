/*============================================
 * 		MemeberMain.java
 * 		- main() �޼ҵ带 �����ϰ� �ִ� Ŭ����
 * 
 ==============================================*/

// �� TBL_MEMBER ���̺��� Ȱ���Ͽ�
//	  �̸��� ��ȭ��ȣ�� ���� �� �Է¹ް�,
//    ��ü ����ϴ� ����� ���� ���α׷��� �����Ѵ�.
//	  ��, �����ͺ��̽� ������ �̷������ �ϰ�,
//	  MemberDAO, MemberDTO Ŭ������ Ȱ���ؾ� �Ѵ�.

// ���� ��)

// �̸� ��ȭ��ȣ �Է�(1) : ���ʷ� 010-1111-1111
// >> ȸ������ �Է� �Ϸ�~!!! 
// �̸� ��ȭ��ȣ �Է�(2) : ������ 010-2222-2222
// >> ȸ������ �Է� �Ϸ�~!!! 
// �̸� ��ȭ��ȣ �Է�(3) : �赿�� 010-3333-3333
// >> ȸ������ �Է� �Ϸ�~!!! 
// �̸� ��ȭ��ȣ �Է�(4) : .

//-----------------------------------------------
// ��ü ȸ�� �� : 3��
//-----------------------------------------------
/*
��ȣ		�̸�			��ȭ��ȣ
1		   ���ʷ�		010-1111-1111
2		   ������		010-2222-2222
3		   �赿��		010-3333-3333
-------------------------------------------------
Ctrl Shift /
*/

// TBL_MEMBER ���̺� ���� ���� ������ ���� �� ������ ��ü ����

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
			
			System.out.print("�̸� ��ȭ��ȣ �Է�(" + (dao.count() + 1) + ") : ");
			name = sc.next();
			
			if (name.equals("."))
				break;
			
			dto.setName(name);
			dto.setTel(sc.next());
			
			count += dao.add(dto);
			
			System.out.println(">> ȸ�� ���� �Է� �Ϸ�~!!!");
		}
		
		System.out.println("---------------------------------");
		System.out.println("��ü ȸ�� �� : " + dao.count() + "��");
		System.out.println("---------------------------------");
		System.out.println("��ȣ\t�̸�\t��ȭ��ȣ");
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

				System.out.print("�̸� ��ȭ��ȣ �Է�(" + (++count) + ") : ");
				name = sc.next();

				if (name.equals("."))
					break;

				// MemberDTO Ŭ������ ��� ����
				MemberDTO dto = new MemberDTO();

				dto.setName(name);
				dto.setTel(sc.next());

				int result = dao.add(dto);
				if (result > 0)
					System.out.println(">> ȸ�� ���� �Է� �Ϸ�~!!!");
			}

			// -----------------------------------------------
			// ��ü ȸ�� �� : 3��
			// -----------------------------------------------
			/*
			 * ��ȣ �̸� ��ȭ��ȣ 1 ���ʷ� 010-1111-1111 2 ������ 010-2222-2222 3 �赿�� 010-3333-3333
			 * ------------------------------------------------- Ctrl Shift /
			 */

			System.out.println("---------------------------------");
			System.out.println("��ü ȸ�� �� : " + dao.count() + "��");
			System.out.println("---------------------------------");
			System.out.println("��ȣ\t�̸�\t��ȭ��ȣ");
			dao.list();

			Iterator<MemberDTO> it = dao.list().iterator();

			while (it.hasNext())
			{
				MemberDTO md = it.next();
				System.out.println(md.getSid() + "\t" + md.getName() + "\t" + md.getTel());

			}
			System.out.println("---------------------------------");
			// ctrl alt ȭ��ǥ �� ����Ű
			// alt shift a �� ����Ű

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
				System.out.println("�����ͺ��̽� ���� ����~!!!");
			}
			catch (Exception e2)
			{
				System.out.println(e2.toString());
			}
		}

	}// end main()

}// end MemberMain