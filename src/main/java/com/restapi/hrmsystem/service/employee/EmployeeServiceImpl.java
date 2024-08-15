package com.restapi.hrmsystem.service.employee;

import com.restapi.hrmsystem.entity.Employee;
import com.restapi.hrmsystem.exception.employee.EmployeeNotFoundException;
import com.restapi.hrmsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElse(null);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        return employee;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        Employee saveEmployee = employeeRepository.findById(employee.getEmployeeID())
                .orElse(null);
        if (saveEmployee == null) {
            throw new EmployeeNotFoundException("Employee with id" + employee.getEmployeeID() + " not found");
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id)
                        .orElse(null);
        if(employee == null) {
            throw new EmployeeNotFoundException("Employee with id" + id + " not found");
        }
        employeeRepository.deleteById(id);
    }
}
