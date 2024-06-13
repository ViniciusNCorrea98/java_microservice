package com.example.employee_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_service.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
}
