package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.EmployeeDao;
import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		employeeDao.insertEmployees(employees);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(String empId) {
		Employee employee = employeeDao.getEmployeeById(empId);
		return employee;
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		employeeDao.update(emp);
		
	}
	@Override
	public void delete(Employee emp) {
		// TODO Auto-generated method stub
		employeeDao.delete(emp);
		
	}



}