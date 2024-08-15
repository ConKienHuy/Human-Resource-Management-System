package com.restapi.hrmsystem.restcontroller;

import com.restapi.hrmsystem.entity.Employee;
import com.restapi.hrmsystem.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){

        // find a employee to update
        Employee dummy = employeeService.getEmployee(id);
        dummy.setEmployeeID(employee.getEmployeeID());
        dummy.setName(employee.getName());
        dummy.setEmail(employee.getEmail());
        dummy.setAddress(employee.getAddress());
        dummy.setDepartment(employee.getDepartment());
        dummy.setRoles(employee.getRoles());
        dummy.setSalary(employee.getSalary());

        return employeeService.saveEmployee(dummy);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

}
