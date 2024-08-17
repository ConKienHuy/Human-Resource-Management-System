package com.restapi.hrmsystem.service.department;

import com.restapi.hrmsystem.entity.Department;
import com.restapi.hrmsystem.exception.EntityNotFoundException;
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
    public Department findByID(int id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Department with id " + id + " not found"));

        return department;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department saveDepartment, int id) {
        Department existDepartment = departmentRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Department with id " + id + " not found"));
        existDepartment.setDepartmentID(saveDepartment.getDepartmentID());
        existDepartment.setDepartmentName(saveDepartment.getDepartmentName());

        return departmentRepository.save(existDepartment);
    }

    @Override
    public void delete(int id) {
        Department saveDepartment = departmentRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Department with id " + id + " not found"));

        departmentRepository.deleteById(saveDepartment.getId());
    }

    @Override
    public Department findByDepartmentName(String departmentName) {
         Department findDepartment = departmentRepository.findByDepartmentName(departmentName);
         if(findDepartment == null){
             throw new EntityNotFoundException("Department with name " + departmentName + " not found");
         }

         return findDepartment;
    }

}
