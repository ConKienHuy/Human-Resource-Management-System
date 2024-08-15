package com.restapi.hrmsystem.service.department;

import com.restapi.hrmsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentService{

    Department findDepartment(int id);

    List<Department> findAllDepartment();

    Department saveDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(int id);

    List<Department> findDepartmentByDepartmentName(String departmentName);
}
