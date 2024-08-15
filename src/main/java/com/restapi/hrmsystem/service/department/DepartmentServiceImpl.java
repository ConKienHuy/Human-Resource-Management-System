package com.restapi.hrmsystem.service.department;

import com.restapi.hrmsystem.entity.Department;
import com.restapi.hrmsystem.exception.BaseException;
import com.restapi.hrmsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Department findDepartment(int id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->new BaseException("Department with id " + id + " not found"));

        return department;
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        Department saveDepartment = departmentRepository.findById(department.getId())
                .orElseThrow(() ->new BaseException("Department with id " + department.getId() + " not found"));

        return departmentRepository.save(saveDepartment);
    }

    @Override
    public void deleteDepartment(int id) {
        Department saveDepartment = departmentRepository.findById(id)
                .orElseThrow(() ->new BaseException("Department with id " + id + " not found"));

        departmentRepository.deleteById(saveDepartment.getId());
    }

    @Override
    public List<Department> findDepartmentByDepartmentName(String departmentName) {
        return List.of();
    }
}
