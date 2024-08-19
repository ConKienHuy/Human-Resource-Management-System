package com.restapi.hrmsystem.restcontroller;

import com.restapi.hrmsystem.entity.Project;
import com.restapi.hrmsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectRestController {

    private ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/projects/{id}")
    public Project getEmployeeById(@PathVariable int id) {
        return projectService.findById(id);
    }

    @PostMapping("/projects")
    public Project addEmployee(@RequestBody Project project) {
        return projectService.save(project);
    }

    @PutMapping("/projects/{id}")
    public Project updateEmployee(@PathVariable int id, @RequestBody Project project){
        return projectService.update(project, id);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteEmployee(@PathVariable int id) {
        projectService.delete(id);
    }

}
