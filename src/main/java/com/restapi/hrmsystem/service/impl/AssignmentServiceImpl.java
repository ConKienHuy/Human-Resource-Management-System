package com.restapi.hrmsystem.service.impl;

import com.restapi.hrmsystem.entity.Assignment;
import com.restapi.hrmsystem.entity.Employee;
import com.restapi.hrmsystem.entity.Project;
import com.restapi.hrmsystem.exception.EntityNotFoundException;
import com.restapi.hrmsystem.repository.AssignmentRepository;
import com.restapi.hrmsystem.service.AssignmentService;
import com.restapi.hrmsystem.service.EmployeeService;
import com.restapi.hrmsystem.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;
    private EmployeeService employeeService;
    private ProjectService projectService;

    @Override
    public Assignment findById(int id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Assignment with id " +id+ " not found"));
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment save(Assignment Assignment) {
        return assignmentRepository.save(Assignment);
    }

    @Override
    public Assignment update(Assignment assignment, int id) {
        Employee employee = employeeService.findByID(assignment.getEmployee().getId());
        Project project = projectService.findById(assignment.getProject().getId());
        Assignment updateAssignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Assignment with id " +id+ " not found "));
        updateAssignment.setEmployee(employee);
        updateAssignment.setProject(project);
        updateAssignment.setStartDate(assignment.getStartDate());
        updateAssignment.setEndDate(assignment.getEndDate());
        updateAssignment.setEmployeeRole(assignment.getEmployeeRole());

        return assignmentRepository.save(updateAssignment);
    }

    @Override
    public void delete(int id) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if(assignment == null )
            throw new EntityNotFoundException("Assignment with id " +id+ " not found");
        assignmentRepository.delete(assignment);
    }
}
