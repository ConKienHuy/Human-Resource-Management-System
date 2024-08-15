package com.restapi.hrmsystem.service.employee;

import com.restapi.hrmsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(int id);

    List<Employee> getAllEmployee();

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(int id);

}
