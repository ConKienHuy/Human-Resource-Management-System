package com.restapi.hrmsystem.repository;

import com.restapi.hrmsystem.entity.Department;
import com.restapi.hrmsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByDepartmentName(String deapartmentName);
    

}
