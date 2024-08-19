package com.restapi.hrmsystem.service;

import com.restapi.hrmsystem.entity.Project;

import java.util.List;

public interface ProjectService {

    Project findById(int id);

    List<Project> findAll();

    Project save(Project project);

    Project update(Project project, int id);

    void delete(int id);
}
