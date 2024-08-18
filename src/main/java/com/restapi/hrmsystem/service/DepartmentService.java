package com.restapi.hrmsystem.service;

import com.restapi.hrmsystem.entity.Department;

import java.util.List;

public interface DepartmentService{

    Department findByID(int id);

    List<Department> findAll();

    Department save(Department department);

    Department update(Department department, int id);

    void delete(int id);

    Department findByDepartmentName(String departmentName);
}
