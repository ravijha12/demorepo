package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int theId);
	public int deleteEmployeeById(int theId);
	public Employee saveEmployee(Employee theEmployee);
}
