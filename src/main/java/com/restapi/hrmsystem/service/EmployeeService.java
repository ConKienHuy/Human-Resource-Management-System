package com.restapi.hrmsystem.service;

import com.restapi.hrmsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findByID(int id);

    List<Employee> findAll();

    Employee save(Employee employee);

    Employee update(Employee employee, int id);

    void delete(int id);

    Employee findByEmployeeID(String employeeID);
}
