package com.restapi.hrmsystem.service;

import com.restapi.hrmsystem.entity.ScheduleProject;

import java.util.List;

public interface ScheduleProjectService {

    ScheduleProject findById(int id);

    List<ScheduleProject> findAll();

    ScheduleProject save(ScheduleProject sp);

    ScheduleProject update(ScheduleProject sp);

    void delete(int id);

    List<ScheduleProject> findByProjectName(String projectName);
}
