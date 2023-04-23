package com.AngularJS_SpringBoot.MainClass.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AngularJS_SpringBoot.MainClass.repository.EmployeeRepository;
import com.AngularJS_SpringBoot.MainClass.model.*;

@RestController
@RequestMapping(value = "API/Value/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRespository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRespository.findAll();
	}
}
