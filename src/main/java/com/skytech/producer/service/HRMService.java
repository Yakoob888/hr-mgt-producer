package com.skytech.producer.service;

import java.util.List;

import com.skytech.producer.entities.Employee;

public interface HRMService {
	public Employee saveEmployee(Employee employee);
	public Employee getEmployee(Integer id);
	public Employee updateEmployee(Employee employee, Integer id);
	public String deleteEmployee(Integer id);
	public List<Employee> getAllEmployees();
}
