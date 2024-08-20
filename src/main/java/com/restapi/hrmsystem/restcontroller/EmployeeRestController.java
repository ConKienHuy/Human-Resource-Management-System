package com.restapi.hrmsystem.restcontroller;

import com.restapi.hrmsystem.entity.Employee;
import com.restapi.hrmsystem.service.DepartmentService;
import com.restapi.hrmsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.findByID(id);
    }

    // @RequestBody tells Spring Boot to convert Json in request body to Employee object
    @PostMapping("/employees")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        // Return STATUS CODE = 200 (ok)
        // Body contains the newly created Employee object
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
        // Return STATUS CODE = 200 (ok)
        return ResponseEntity.ok().build();
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        return employeeService.update(employee, id);
    }

}
