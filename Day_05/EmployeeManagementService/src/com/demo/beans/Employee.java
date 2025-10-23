package com.demo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable
{
	private int empid;
	private String empname;
	private String emprole;
	
	public Employee() 
	{
		super();
	}
	
	

	public Employee(int empid) {
		super();
		this.empid = empid;
	}



	public Employee(int empid, String empname, String emprole) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.emprole = emprole;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empid == other.empid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmprole() {
		return emprole;
	}

	public void setEmprole(String emprole) {
		this.emprole = emprole;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", emprole=" + emprole + "]";
	}
	
	
	
	
}
