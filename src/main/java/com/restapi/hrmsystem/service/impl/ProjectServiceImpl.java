package com.restapi.hrmsystem.service.impl;

import com.restapi.hrmsystem.entity.Project;
import com.restapi.hrmsystem.exception.EntityNotFoundException;
import com.restapi.hrmsystem.repository.ProjectRepository;
import com.restapi.hrmsystem.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Override
    public Project findById(int id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project with id " +id+ " not found"));
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project project, int id) {
        Project updateProject = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project with id " +id+ " not fond "));
        updateProject.setProjectName(project.getProjectName());
        updateProject.setBudget(project.getBudget());
        updateProject.setStartDate(project.getStartDate());
        updateProject.setEndDate(project.getEndDate());

        return projectRepository.save(updateProject);
    }

    @Override
    public void delete(int id) {
        Project project = projectRepository.findById(id).orElse(null);
        if(project == null )
            throw new EntityNotFoundException("Project with id " +id+ " not found");
        projectRepository.delete(project);
    }
}
