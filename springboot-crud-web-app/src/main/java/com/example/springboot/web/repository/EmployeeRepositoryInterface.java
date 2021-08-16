package com.example.springboot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.web.model.Employee;

@Repository
public interface EmployeeRepositoryInterface extends JpaRepository<Employee, Integer> {	

}
