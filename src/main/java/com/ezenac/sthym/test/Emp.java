package com.ezenac.sthym.test;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Emp {

	private int empno;
	private String ename;
	private java.util.Date hiredate;
	
	public Emp() {}
	
	
	public Emp(int empno) {
		super();
		this.empno = empno;
	}


	public Emp(int empno, String ename, Date hiredate) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public java.util.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(java.util.Date hiredate) {
		this.hiredate = hiredate;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		Emp e=(Emp)obj;
		return this.empno==e.getEmpno();
	}
	
	
	
}
