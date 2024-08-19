package com.restapi.hrmsystem.service.impl;

import com.restapi.hrmsystem.entity.Department;
import com.restapi.hrmsystem.entity.Employee;
import com.restapi.hrmsystem.exception.EntityNotFoundException;
import com.restapi.hrmsystem.repository.EmployeeRepository;
import com.restapi.hrmsystem.service.DepartmentService;
import com.restapi.hrmsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    // Bussinesses logic layer
    private EmployeeRepository employeeRepository;
    private DepartmentService departmentService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
    }

    public Employee findByID(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id " +id+ " not found"));
        return employee;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        // Check if department exsit
        Department d = departmentService.findByID(employee.getDepartment().getId());
        employee.setDepartment(d);
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee, int id) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id " +id+ " not found"));

        // Update department the database or else throw a Not Found Exception
        Department d = departmentService.findByID(employee.getDepartment().getId());
        updateEmployee.setDepartment(d);
        updateEmployee.setName(employee.getName());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setAddress(employee.getAddress());
        updateEmployee.setSalary(employee.getSalary());
        updateEmployee.setSkills(employee.getSkills());

        return employeeRepository.save(updateEmployee);
    }

    public void delete(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee == null)
            throw new EntityNotFoundException("Employee with id" + id + " not found");
        employeeRepository.deleteById(id);
    }

}
