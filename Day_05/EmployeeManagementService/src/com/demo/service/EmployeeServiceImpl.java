package com.demo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDaoI;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeServiceI 
{
	private EmployeeDaoI empdao;
	

	public EmployeeServiceImpl() 
	{
		empdao = new EmployeeDaoImpl();
	}


	@Override
	public boolean addNewEmployee() 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID: ");
		int empid = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter Employee Name: ");
		String empname = sc.nextLine();
		
		System.out.println("Enter Employee Role: ");
		String emprole = sc.nextLine();
		
		Employee emp = new Employee(empid, empname, emprole);
		
		return empdao.addNewEmployee(emp);
		
	}


	@Override
	public boolean deleteEmployee(int empid) 
	{
		
		return empdao.deleteEmployee(empid);
	}


	@Override
	public List<Employee> displayAll() 
	{
		return empdao.displayAll();
	}


	@Override
	public List<Employee> searchByName(String empname) {
		// TODO Auto-generated method stub
		return empdao.searchByName(empname);
	}


	@Override
	public List<Employee> sortById() 
	{
		return empdao.sortById();
	}


	@Override
	public void saveAllToFile(String fname) throws FileNotFoundException, IOException 
	{
		
		empdao.saveAllToFile(fname);
	}

}
