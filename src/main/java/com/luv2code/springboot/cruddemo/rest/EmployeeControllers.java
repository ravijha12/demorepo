package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
public class EmployeeControllers {
	
	private EmployeeService theEmployeeService;
	
	@Autowired
	public EmployeeControllers(EmployeeService theEmployeeService){
		this.theEmployeeService = theEmployeeService;
	}
	
	@RequestMapping("/checkHealth")
	public String checkHealth(){
		
		return "Spring boot Application is up and running";
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		
		return theEmployeeService.getAllEmployees();
	}
	
	
	@GetMapping("/employee/{theId}")
	public Employee getEmployeeById(@PathVariable int theId){
		
		return theEmployeeService.getEmployeeById(theId);
	}
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee theEmployee){
		theEmployee.setEmpId(0);
		 return theEmployeeService.saveEmployee(theEmployee);	 
	}
	
	@DeleteMapping("/employee/{theId}")
	public String deleteEmplpyee(@PathVariable int theId){
		Employee targetEmployee = theEmployeeService.getEmployeeById(theId);
		if(targetEmployee==null)
			throw new RuntimeException("Employee Not found by id: "+theId);
		 int i =  theEmployeeService.deleteEmployeeById(theId); 
		  return "Deleted Employee with id: "+i;
	} 
}
