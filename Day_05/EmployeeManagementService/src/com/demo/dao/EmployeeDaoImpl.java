package com.demo.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDaoI 
{
	static List<Employee> emplist = new ArrayList<>();
	
	@Override
	public boolean addNewEmployee(Employee emp) 
	{
		return emplist.add(emp);
	}

	@Override
	public boolean deleteEmployee(int empid) 
	{
		Employee emp = new Employee(empid);
		int pos = emplist.indexOf(emp);
		if(pos != -1)
		{
			return emplist.remove(emp);
		}
		return false;
	}

	@Override
	public List<Employee> displayAll() 
	{
		
		return emplist;
	}

	@Override
	public List<Employee> searchByName(String empname) 
	{
		List<Employee> elist = new ArrayList<>();
		
		for(Employee emp : emplist)
		{
			if(emp.getEmpname().equals(empname))
			{
				elist.add(emp);
			}
		}
		
		return elist;
	}

	@Override
	public List<Employee> sortById() 
	{
		List<Employee> elist = new ArrayList<>();
		for(Employee e : emplist)
		{
			elist.add(e);
		}
		
		Comparator<Employee> c = (o1, o2) -> {
			return o1.getEmpid() - o2.getEmpid();
		};
		
		elist.sort(c);
		
		return elist;
	}

	@Override
	public void saveAllToFile(String fname) throws FileNotFoundException, IOException 
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname))) 
		{
			oos.writeObject(emplist);
			System.out.println("All Employees saved successfully");
		} 
		
	}

}
