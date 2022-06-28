package com.skytech.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skytech.producer.entities.Employee;
import com.skytech.producer.models.EmployeeResponse;
import com.skytech.producer.service.HRMService;

@RestController
public class HRMController {
	@Autowired
	HRMService service;

	@Value("${eureka.instance.instance-id}")
	public String instanceId;
	
	@PostMapping("/hrm-employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		System.out.println("Employee details are " + employee.toString());
		return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/hrm-employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		System.out.println("Producer InstanceId is :: "+instanceId);
		return new ResponseEntity<Employee>(service.getEmployee(id), HttpStatus.OK);
	}

	@PutMapping("/hrm-employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id){
		return new ResponseEntity<Employee>(service.updateEmployee(employee, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/hrm-employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		return new ResponseEntity<String>(service.deleteEmployee(id), HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hrm-employees")
	public ResponseEntity<EmployeeResponse> getAllEmployees(){
		EmployeeResponse response = new EmployeeResponse();
		response.setEmpList(service.getAllEmployees());
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	}
	@GetMapping("/hi")
	public String hi() {
		return "Hello World!!";
	}
}
