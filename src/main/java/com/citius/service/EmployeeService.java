package com.citius.service;

import org.springframework.http.ResponseEntity;

import com.citius.dto.ResponseDto;
import com.citius.model.Employee;

public interface EmployeeService {

	ResponseDto getById(int empId);

	ResponseDto update(Employee employee);

	ResponseDto add(Employee employee);

	ResponseDto delete(int empId);

}
