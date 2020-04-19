package com.test.jdbc03;

public class ScoreDTO
{
	String sid, name, kor, eng, mat, sum, avg;

	public String getSum()
	{
		return sum;
	}

	public void setSum(String sum)
	{
		this.sum = sum;
	}

	public String getAvg()
	{
		return avg;
	}

	public void setAvg(String avg)
	{
		this.avg = avg;
	}

	public String getSid()
	{
		return sid;
	}

	public void setSid(String sid)
	{
		this.sid = sid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getKor()
	{
		return kor;
	}

	public void setKor(String kor)
	{
		this.kor = kor;
	}

	public String getEng()
	{
		return eng;
	}

	public void setEng(String eng)
	{
		this.eng = eng;
	}

	public String getMat()
	{
		return mat;
	}

	public void setMat(String mat)
	{
		this.mat = mat;
	}
}
