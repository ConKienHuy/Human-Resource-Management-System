package com.restapi.hrmsystem.restcontroller;

import com.restapi.hrmsystem.entity.Assignment;
import com.restapi.hrmsystem.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AssignmentRestController {

    private AssignmentService assignmentService;

    @Autowired
    public AssignmentRestController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments() {
        return assignmentService.findAll();
    }

    @GetMapping("/assignments/{id}")
    public Assignment getEmployeeById(@PathVariable int id) {
        return assignmentService.findById(id);
    }

    @PostMapping("/assignments")
    public Assignment addEmployee(@RequestBody Assignment assignment) {
        return assignmentService.save(assignment);
    }

    @PutMapping("/assignments/{id}")
    public Assignment updateEmployee(@PathVariable int id, @RequestBody Assignment assignment){
        return assignmentService.update(assignment, id);
    }

    @DeleteMapping("/assignments/{id}")
    public void deleteEmployee(@PathVariable int id) {
        assignmentService.delete(id);
    }

}
