package com.demo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeServiceI {

	boolean addNewEmployee();

	boolean deleteEmployee(int empid);

	List<Employee> displayAll();

	List<Employee> searchByName(String empname);

	List<Employee> sortById();

	void saveAllToFile(String fname) throws FileNotFoundException, IOException;

}
