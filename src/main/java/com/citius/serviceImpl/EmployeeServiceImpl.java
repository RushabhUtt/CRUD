package com.citius.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.citius.dto.ResponseDto;
import com.citius.model.Employee;
import com.citius.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	ResponseDto response = new ResponseDto();

	Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();

	@Override
	public ResponseDto getById(int empId) {

		List<Employee> list = empMap.entrySet().stream().filter(m -> m.getKey() == empId).map(Map.Entry::getValue)
				.collect(Collectors.toList());

		response.setResponseData(list.get(0));
		response.setResponseMessage("Employee found for " + empId);
		response.setResult("Sucess");
		return response;
	}

	@Override
	public ResponseDto add(Employee employee) {

		empMap.put(employee.getEmpId(), employee);
		response.setResponseData(empMap.get(employee.getEmpId()));
		response.setResponseMessage("Employee details added");
		response.setResult("Sucess");
		return response;
	}

	@Override
	public ResponseDto update(Employee employee) {
		if(!empMap.containsKey(employee.getEmpId())) {
			response.setResponseMessage("Employee details not found for empId "+employee.getEmpId());
			response.setResult("Fail");
		}
		else {
			empMap.put(employee.getEmpId(), employee);
			response.setResponseData(empMap.get(employee.getEmpId()));
			response.setResponseMessage("Employee details updated for empId"+employee.getEmpId());
			response.setResult("Sucess");
			
		}
		return response;
		
	}

	@Override
	public ResponseDto delete(int empId) {

		empMap.remove(empId);
		response.setResponseMessage("Employee deleted successfully");
		response.setResult("Sucess");
		return response;
	}

}
