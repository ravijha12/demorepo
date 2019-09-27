package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {
	//comment added using git
	private EntityManager theEntityManager;
	@Autowired
	public EmployeeDAOHibernateImp(EntityManager theEntityManager){
		this.theEntityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		//get current session
		Session currentSession = theEntityManager.unwrap(Session.class);
		
		//create Query
		Query<Employee> theQuery = currentSession.createQuery("FROM Employee",Employee.class);
		
		//create list and store employees
		List<Employee> employees = theQuery.getResultList();
		
		//return the list of employees
		System.out.println(employees);
		return employees;
	}

	@Override
	public Employee getEmployeeById(int theId) {
		
		//Get the current transaction
		Session currentSession = theEntityManager.unwrap(Session.class);
		
		//create the query using current transaction
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return the Employee
		System.out.println(theEmployee);
		return theEmployee;
	}

	@Override
	public int deleteEmployeeById(int theId) {
		
		//Get the current session
		Session currentSession = theEntityManager.unwrap(Session.class);
		
		//create query
		Query theQuery = currentSession.createQuery("DELETE FROM Employee WHERE empId=:theId");
		theQuery.setParameter("theId", theId);
		return theId;
	}

	@Override
	public Employee saveEmployee(Employee theEmployee) {

		//get the current transaction
		Session currentSession = theEntityManager.unwrap(Session.class);
		
		//create query
		currentSession.saveOrUpdate(theEmployee);
		return theEmployee;
	}

}
