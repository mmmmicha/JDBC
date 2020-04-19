package com.test.jdbc05;

import java.util.ArrayList;
import java.util.Scanner;

/*==============[ ���� ���� ]==============
1. ���� ���� �Է�
2. ���� ��ü ���
	- ��� ����
	- �̸� ����
	- �μ� ����
	- ���� ����
	- �޿� �������� ����
3. ���� �˻� ���
	- ��� �˻�
	- �̸� �˻�
	- �μ� �˻�
	- ���� �˻�
4. ���� ���� ����
5. ���� ���� ����
==========================================
>> �޴� ����(1~5, -1 ����) : 1

���� ���� �Է� -------------------------------------------
�̸� : ����ä
�ֹε�Ϲ�ȣ(yymmdd-nnnnnnn) : 900123-2234567
�Ի���(yyyy-mm-dd) : 2015-05-06
����(����,���,�泲,���,�λ�,����,��õ,����,����,����,�泲) : ����
��ȭ��ȣ : 010-1234-1234
�μ�(���ߺ�,��ȹ��,������,�λ��,�����,�ѹ���,ȫ����) : ���ߺ�
����(����,����,��,�̻�,����,����,����,�븮,���) : �븮
�⺻��(�ּ� 1250000 �̻�) : 1300000
���� : 1000000
>> ���� ���� �Է� �Ϸ�~!!!
----------------------------------------------------------   


1. ��� ����
2. �̸� ����
3. �μ� ����
4. ���� ����
5. �޿� �������� ����
>> ����(1~5, -1 ����) : 1

��ü �ο� : 60��
���  �̸�  �ֹι�ȣ  �Ի���  ����  ��ȭ��ȣ  �μ�  ����  �⺻��  ����  �޿�
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
		System.out.println("���� ���� �Է� -------------------------------------------");
		System.out.print("�̸� : ");
		String name = sc.next();
		dto.setEmpname(name);
		
		System.out.print("�ֹε�Ϲ�ȣ(yymmdd-nnnnnnn) : ");
		String ssn = sc.next();
		dto.setSsn(ssn);
		
		System.out.print("�Ի���(yyyy-mm-dd) : ");
		String date = sc.next();
		dto.setIbsadate(date);
		
		System.out.print("����(����,���,�泲,���,�λ�,����,��õ,����,����,����,�泲) : ");
		String city = sc.next();
		dto.setCity(city);
		
		System.out.print("��ȭ��ȣ : ");
		String tel = sc.next();
		dto.setTel(tel);
		
		System.out.print("�μ�(���ߺ�,��ȹ��,������,�λ��,�����,�ѹ���,ȫ����) : ");
		String buseo = sc.next();
		dto.setBuseo(buseo);
		
		System.out.print("����(����,����,��,�̻�,����,����,����,�븮,���) : ");
		String jikwi = sc.next();
		dto.setJikwi(jikwi);
		
		System.out.printf("�⺻��(�ּ� %d �̻�) : ", dao.outMinpay(dao.jikwiID(dto)));
		int basicpay = sc.nextInt();
		dto.setBasicpay(basicpay);
		
		System.out.print("���� : ");
		int sudang = sc.nextInt();
		dto.setSudang(sudang);
		
		int result = dao.add(dto);
		
		if (result > 0)
			System.out.println(">> ���� ���� �Է� �Ϸ�~!!!");
		else
			System.out.println("�����Է��� ���� �ʾҽ��ϴ�.");
		
		System.out.println("----------------------------------------------------------");
		
		dao.close();
		
		
		
	}
	
	public void informOutput(String a)
	{
		
		MemberDAO dao = new MemberDAO();
		
		System.out.println();
		System.out.printf("��ü �ο� : %d��\n", dao.count());
		System.out.println("���  �̸�  �ֹι�ȣ  �Ի���  ����  ��ȭ��ȣ  �μ�  ����  �⺻��  ����  �޿�");
		
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
		System.out.printf("��ü �ο� : %d��\n", dao.count());
		System.out.println("���  �̸�  �ֹι�ȣ  �Ի���  ����  ��ȭ��ȣ  �μ�  ����  �⺻��  ����  �޿�");
		
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
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.next();
		
		System.out.println();
		System.out.println("���  �̸�  �ֹι�ȣ  �Ի���  ����  ��ȭ��ȣ  �μ�  ����  �⺻��  ����  �޿�");
		
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
		
		System.out.print("������ �Է��ϼ���(����,����,��,�̻�,����,����,����,�븮,���) : ");
		String jikwi = sc.next();
		
		System.out.println();
		System.out.println("���  �̸�  �ֹι�ȣ  �Ի���  ����  ��ȭ��ȣ  �μ�  ����  �⺻��  ����  �޿�");
		
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
		
		System.out.print("�μ��� �Է��ϼ���(���ߺ�,��ȹ��,������,�λ��,�����,�ѹ���,ȫ����) : ");
		String buseo = sc.next();
		
		System.out.println();
		System.out.println("���  �̸�  �ֹι�ȣ  �Ի���  ����  ��ȭ��ȣ  �μ�  ����  �⺻��  ����  �޿�");
		
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
		
		System.out.print("�����ȣ�� �Է��ϼ��� : ");
		String empid = sc.next();
		
		
		System.out.println();
		System.out.println("���  �̸�  �ֹι�ȣ  �Ի���  ����  ��ȭ��ȣ  �μ�  ����  �⺻��  ����  �޿�");
		
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
		System.out.println("������ ���� �Է� -------------------------------------------");
		System.out.print("������ ����� �μ���ȣ�� �Է��ϼ��� : ");
		int empid = sc.nextInt();
		dto.setEmpid(empid);
		
		System.out.print("�̸� : ");
		String name = sc.next();
		dto.setEmpname(name);
		
		System.out.print("�ֹε�Ϲ�ȣ(yymmdd-nnnnnnn) : ");
		String ssn = sc.next();
		dto.setSsn(ssn);
		
		System.out.print("�Ի���(yyyy-mm-dd) : ");
		String date = sc.next();
		dto.setIbsadate(date);
		
		System.out.print("����(����,���,�泲,���,�λ�,����,��õ,����,����,����,�泲) : ");
		String city = sc.next();
		dto.setCity(city);
		
		System.out.print("��ȭ��ȣ : ");
		String tel = sc.next();
		dto.setTel(tel);
		
		System.out.print("�μ�(���ߺ�,��ȹ��,������,�λ��,�����,�ѹ���,ȫ����) : ");
		String buseo = sc.next();
		dto.setBuseo(buseo);
		
		System.out.print("����(����,����,��,�̻�,����,����,����,�븮,���) : ");
		String jikwi = sc.next();
		dto.setJikwi(jikwi);
		
		System.out.printf("�⺻��(�ּ� %d �̻�) : ", dao.outMinpay(dao.jikwiID(dto)));
		int basicpay = sc.nextInt();
		dto.setBasicpay(basicpay);
		
		System.out.print("���� : ");
		int sudang = sc.nextInt();
		dto.setSudang(sudang);
		
		int result = dao.empUpdate(dto);
		
		if (result > 0)
			System.out.println(">> ���� ���� ���� �Ϸ�~!!!");
		else
			System.out.println("���������� ���� �ʾҽ��ϴ�.");
		
		System.out.println("----------------------------------------------------------");
		
		dao.close();
	}
	
	
	public void informDelete()
	{
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		
		
		System.out.print("������ ����� ��ȣ�� �Է��ϼ��� : ");
		int empid = sc.nextInt();
		
		int result = dao.delete(empid);
		
		if(result > 0)
			System.out.println("�ش� ������ �����Ǿ����ϴ�.");
		else
			System.out.println("�������� �ʾҽ��ϴ�.");
		
		dao.close();
		
	}
	
	
	
}
