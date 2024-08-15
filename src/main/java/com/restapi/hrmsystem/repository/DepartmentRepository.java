package com.restapi.hrmsystem.repository;

import com.restapi.hrmsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
