package com.citius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citius.dto.ResponseDto;
import com.citius.model.Employee;
import com.citius.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/getById")
	public ResponseEntity<ResponseDto> getById(@RequestParam int empId) {
		ResponseDto response = service.getById(empId);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseDto> add(@RequestBody Employee employee) {
		ResponseDto response = service.add(employee);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDto> update(@RequestBody Employee employee) {
		ResponseDto response = service.update(employee);

		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> delete(@RequestParam int empId) {
		ResponseDto response = service.delete(empId);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);

	}
}
