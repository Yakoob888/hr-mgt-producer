package com.skytech.producer.models;

import java.util.List;

import com.skytech.producer.entities.Employee;

import lombok.Data;
@Data
public class EmployeeResponse {
	private List<Employee> empList;
}
