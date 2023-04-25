package com.AngularJS_SpringBoot.MainClass.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AngularJS_SpringBoot.MainClass.repository.EmployeeRepository;
import com.AngularJS_SpringBoot.MainClass.model.*;
import com.AngularJS_SpringBoot.MainClass.exception.ResourceNotFoundException;

@RestController
@RequestMapping(value = "API/Value/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRespository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRespository.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return employeeRespository.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {		
		Employee employee = employeeRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not Exist with Id "+id));
		
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> UpdateEmployee(@PathVariable Long id ,@RequestBody Employee employeeDetails){
		
		Employee employee = employeeRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not Exist with Id "+id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Employee UpdatedEmployee = employeeRespository.save(employee);
		
		return ResponseEntity.ok(UpdatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String ,Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not Exist with Id "+id));
		
		employeeRespository.delete(employee);
		
		Map<String,Boolean> response = new HashMap<>();
		
		response.put("deleted",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
}
