package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	private EmployeeDAO theEmployeeDAO;
	//@Autowired
	public EmployeeServiceImp(EmployeeDAO theEmployeeDAO){
		this.theEmployeeDAO = theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {

		//call the GetAllEmployees() from EmployeeDAOImp class
		return theEmployeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int theId) {
		
		// call the getEmployeeById(int theId) from EmployeeDAOImp class
		return theEmployeeDAO.getEmployeeById(theId);
	}

	@Override
	@Transactional
	public int deleteEmployeeById(int theId) {

		// call the deleteEmployeeById(int theId) from EmployeeDAOImp class
		 theEmployeeDAO.deleteEmployeeById(theId);
		 return theId;
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee theEmployee) {
		// call the saveEmployee(Employee theEmployee) from EmployeeDAOImp class
		 return theEmployeeDAO.saveEmployee(theEmployee);
	}

}
