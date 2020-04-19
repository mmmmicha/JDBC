/*================================
 	MemberMain.java
=================================*/

/*
�� ���� ���� ���α׷��� �����Ѵ�.
   - �����ͺ��̽� ���� ���α׷��� �����Ѵ�.
   - MemberDTO, MemberDAO �� Ȱ���Ѵ�.
   - �޴� ���� �� ��� �����Ѵ�. �� Process Ȱ��
   
���� ��)
==============[ ���� ���� ]==============
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

  
  
==============[ ���� ���� ]==============
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
>> �޴� ����(1~5, -1 ����) : 2

1. ��� ����
2. �̸� ����
3. �μ� ����
4. ���� ����
5. �޿� �������� ����
>> ����(1~5, -1 ����) : 1

��ü �ο� : 60��
���  �̸�  �ֹι�ȣ  �Ի���  ����  ��ȭ��ȣ  �μ�  ����  �⺻��  ����  �޿�
									:
									
									

==============[ ���� ���� ]==============
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
>> �޴� ����(1~5, -1 ����) : 
  
   
*/

package com.test.jdbc05;

import java.util.Scanner;

public class MemberMain
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Process pr = new Process();
		
		
		
		do
		{
			System.out.println("==============[ ���� ���� ]==============");
			System.out.println("1. ���� ���� �Է�");
			System.out.println("2. ���� ��ü ���");
			System.out.println("	- ��� ����");
			System.out.println("	- �̸� ����");
			System.out.println("	- �μ� ����");
			System.out.println("	- ���� ����");
			System.out.println("	- �޿� �������� ����");
			System.out.println("3. ���� �˻� ���");
			System.out.println("	- ��� �˻�");
			System.out.println("	- �̸� �˻�");
			System.out.println("	- �μ� �˻�");
			System.out.println("	- ���� �˻�");
			System.out.println("4. ���� ���� ����");
			System.out.println("5. ���� ���� ����");
			System.out.println("==========================================");
			System.out.print(">> �޴� ����(1~5, -1 ����) : ");
			
			int select = sc.nextInt();
			
			if(select == -1)
			{
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
			
			switch (select)
			{
			case 1: pr.informInput();
					break;
			case 2: do
					{
						System.out.println("1. ��� ����");
						System.out.println("2. �̸� ����");
						System.out.println("3. �μ� ����");
						System.out.println("4. ���� ����");
						System.out.println("5. �޿� �������� ����");
						System.out.println(">> ����(1~5, -1 ����) : ");
						
						select = sc.nextInt();
						
						if(select == -1)
						{
							System.out.println("�����޴��� �̵��մϴ�.");
							break;
						}
						
						switch (select)
						{
						case 1: pr.informOutput("EMP_ID");
								break;
						case 2: pr.informOutput("EMP_NAME");
								break;
						case 3: pr.informOutput("BUSEO_NAME");
								break;
						case 4: pr.informOutput("JIKWI_NAME");
								break;
						case 5: pr.informOutputD();
								break;
						}
					} while (true);
					break;
			case 3: do
					{
						System.out.println("1. ��� ����");
						System.out.println("2. �̸� ����");
						System.out.println("3. �μ� ����");
						System.out.println("4. ���� ����");
						System.out.println(">> ����(1~4, -1 ����) : ");
						
						select = sc.nextInt();
						
						if(select == -1)
						{
							System.out.println("�����޴��� �̵��մϴ�.");
							break;
						}
						
						switch (select)
						{
						case 1: pr.serchOutputS();
							break;
						case 2: pr.serchOutputN();
						break;
						case 3: pr.serchOutputB();
						break;
						case 4: pr.serchOutputJ();
						break;
						}
					} while (true);
					break;
			case 4: pr.informUpdate();
					break;
			case 5: pr.informDelete();
					break;
			}
			
		} while (true);
		
		
	}

}
