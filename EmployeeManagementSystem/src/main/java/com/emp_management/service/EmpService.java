package com.emp_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_management.entity.Employee;
import com.emp_management.repository.EmpRepo;



@Service
public class EmpService {
	
	
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
		
	}
	
	public List<Employee> getAllEmp() {
		return repo.findAll();
	}
	
	public Optional<Employee> getEmpById(int id) {
		return repo.findById(id);
	}
	
	public void deleteEmp(int id) {
		repo.deleteById(id);
	}
	
	
}
