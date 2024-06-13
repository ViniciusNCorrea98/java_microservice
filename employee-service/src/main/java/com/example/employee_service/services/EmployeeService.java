package com.example.employee_service.services;

import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.repo.EmployeeRepo;
import com.example.employee_service.response.EmployeeResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeResponse getEmployeeById(int id) {
        Employee employee = employeeRepo.findById(id).orElse(null);

        if (employee == null) {
            return null;
        }

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setBloodGroup(employee.getBloodGroup());

        return employeeResponse;
    }
    
    public EmployeeResponse createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setBloodGroup(employeeDTO.getBloodGroup());

        Employee savedEmployee = employeeRepo.save(employee);

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(savedEmployee.getId());
        employeeResponse.setName(savedEmployee.getName());
        employeeResponse.setEmail(savedEmployee.getEmail());
        employeeResponse.setBloodGroup(savedEmployee.getBloodGroup());

        return employeeResponse;
    }
}
