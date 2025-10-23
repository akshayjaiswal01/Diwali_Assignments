package com.demo.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.EmployeeServiceI;
import com.demo.service.EmployeeServiceImpl;

public class TestEmployeeManagementService 
{

	public static void main(String[] args) 
	{
		EmployeeServiceI empservice = new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		do 
		{
			System.out.println("1. Add Employee to list \r\n"
							+ "2. Remove Employee list \r\n"
							+ "3. Show all Employee \r\n"
							+ "4. Show all Employee in sorted order (sort on the basis of empID) \r\n"
							+ "5. Find a Employee with empName \r\n"
							+ "6. Save all Employees into file \r\n"
							+ "7. Quit");
			
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			switch (choice) 
			{
				case 1 ->
				{
					boolean status = empservice.addNewEmployee();
					if(status)
					{
						System.out.println("Employee added successfully");
					}
					else {
						System.out.println("Failed to add");
					}
				}
				case 2 ->
				{
					System.out.println("Enter Employee ID: ");
					int empid = sc.nextInt();
					
					boolean status = empservice.deleteEmployee(empid);
					if(status)
					{
						System.out.println("Deleted Successfully");
					}
					else {
						System.out.println("Failed to delete");
					}
				}
				case 3 ->
				{
					List<Employee> emplist = empservice.displayAll();
					if(emplist.isEmpty())
					{
						System.out.println("No Employees found");
					}
					else {
						emplist.forEach(System.out::println);
					}
					
				}
				case 4 ->
				{
					List<Employee> elist = empservice.sortById();
					if(elist.isEmpty())
					{
						System.out.println("No Employees found");
					}
					else {
						elist.forEach(System.out::println);
					}
				}
				case 5 ->
				{
					sc.nextLine();
					System.out.println("Enter Employee Name: ");
					String empname = sc.nextLine();
					
					List<Employee> emplist = empservice.searchByName(empname);
					if(emplist.isEmpty())
					{
						System.out.println("No Employees found");
					}
					else {
						emplist.forEach(System.out::println);
					}
				}
				case 6 ->
				{
					try {
						empservice.saveAllToFile("employee.dat");
						System.out.println("Employee Data Saved Successfully");
					} catch (FileNotFoundException e) {
						System.out.println("File Not Found...."+e.getMessage());
					} catch (IOException e) {
						System.out.println("Error saving Employees..."+e.getMessage());
					}
					
				}
				case 7 ->
				{
					System.exit(0);
				}
				
				default ->
				{
					System.out.println("Invalid Choice");
				}
				
			} 
		} while (choice != 7);

	}

}

