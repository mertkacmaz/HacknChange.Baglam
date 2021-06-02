package com.baglam.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baglam.api.entity.Employee;
import com.baglam.api.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping()
	public Iterable<Employee> getAll() {
		return employeeRepository.findAll();
	}
}
