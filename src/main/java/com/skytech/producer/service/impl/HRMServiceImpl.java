package com.skytech.producer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skytech.producer.entities.Employee;
import com.skytech.producer.repository.HRMRepository;
import com.skytech.producer.service.HRMService;

@Service
public class HRMServiceImpl implements HRMService {
	@Autowired
	HRMRepository repository;

	@Override
	public Employee getEmployee(Integer id) {
		Optional<Employee> employee = repository.findById(id);
			return employee.get();
		
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		Employee emp = repository.findById(id).get();
		if(null != employee.getFirstName() && !employee.getFirstName().equals(""))
			emp.setFirstName(employee.getFirstName());
		if(null != employee.getLastName() && !employee.getLastName().equals(""))
			emp.setLastName(employee.getLastName());
		if(null != employee.getEmail() && !employee.getEmail().equals(""))
			emp.setEmail(employee.getEmail());
		if(null != employee.getRole() && !employee.getRole().equals(""))
			emp.setRole(employee.getRole());
		if(null != employee.getTechnology() && !employee.getTechnology().equals(""))
			emp.setTechnology(employee.getTechnology());
		return repository.save(emp);
	}

	@Override
	public String deleteEmployee(Integer id) {
		repository.deleteById(id);
		return "Employee deleted "+id;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

}
