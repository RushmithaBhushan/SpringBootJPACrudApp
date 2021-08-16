package com.example.springboot.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.web.model.Employee;
import com.example.springboot.web.repository.EmployeeRepositoryInterface;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	EmployeeRepositoryInterface employeeRepositoryInterface;

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.findAll();
	}
	
	public void saveEmployee(Employee employee) {
		this.employeeRepositoryInterface.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeDb = this.employeeRepositoryInterface.findById(employee.getId());
		if(employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setFirstName(employee.getFirstName());
			employeeUpdate.setLastName(employee.getLastName());
			employeeUpdate.setEmail(employee.getEmail());
			employeeRepositoryInterface.save(employeeUpdate);
			return employeeUpdate;
		}
		else {
			System.out.println("Record Not found");
		}
		return employee;
		
	}
	
	public void deleteEmployee(int id) {
		this.employeeRepositoryInterface.deleteById(id);
	}

}
