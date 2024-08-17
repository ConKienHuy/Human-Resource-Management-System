package com.restapi.hrmsystem.restcontroller;

import com.restapi.hrmsystem.entity.Department;
import com.restapi.hrmsystem.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentRestController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        return departmentService.findAll();
    }

    @GetMapping("/departments/{id}")
    public Department getByID(@PathVariable int id){
        return departmentService.findByID(id);
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.save(department);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable int id, @RequestBody Department department){
        return departmentService.update(department,id);
    }
}
