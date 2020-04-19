package com.test.jdbc05;

public class MemberDTO
{

	//사번  이름  주민번호  입사일  지역  전화번호  부서  직위  기본급  수당  급여
	private int empid;
	private String empname, ssn, ibsadate, city, tel, buseo, jikwi;
	private int minbasicpay, basicpay, sudang, pay;
	
	public int getMinbasicpay()
	{
		return minbasicpay;
	}
	public void setMinbasicpay(int minbasicpay)
	{
		this.minbasicpay = minbasicpay;
	}
	public int getEmpid()
	{
		return empid;
	}
	public void setEmpid(int empid)
	{
		this.empid = empid;
	}
	public String getEmpname()
	{
		return empname;
	}
	public void setEmpname(String empname)
	{
		this.empname = empname;
	}
	public String getSsn()
	{
		return ssn;
	}
	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}
	public String getIbsadate()
	{
		return ibsadate;
	}
	public void setIbsadate(String ibsadate)
	{
		this.ibsadate = ibsadate;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getBuseo()
	{
		return buseo;
	}
	public void setBuseo(String buseo)
	{
		this.buseo = buseo;
	}
	public String getJikwi()
	{
		return jikwi;
	}
	public void setJikwi(String jikwi)
	{
		this.jikwi = jikwi;
	}
	public int getBasicpay()
	{
		return basicpay;
	}
	public void setBasicpay(int basicpay)
	{
		this.basicpay = basicpay;
	}
	public int getSudang()
	{
		return sudang;
	}
	public void setSudang(int sudang)
	{
		this.sudang = sudang;
	}
	public int getPay()
	{
		return pay;
	}
	public void setPay(int pay)
	{
		this.pay = pay;
	}
	
	
}
