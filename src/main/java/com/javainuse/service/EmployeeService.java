package com.javainuse.service;

import java.util.List;

import com.javainuse.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String id);
	void update(Employee emp);
	void delete(Employee emp);
}