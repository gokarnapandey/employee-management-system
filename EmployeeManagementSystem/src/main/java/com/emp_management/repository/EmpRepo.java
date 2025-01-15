package com.emp_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp_management.entity.Employee;


@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
