package com.restapi.hrmsystem.service.impl;

import com.restapi.hrmsystem.entity.ScheduleProject;
import com.restapi.hrmsystem.service.ScheduleProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleProjectServiceImpl implements ScheduleProjectService {


    @Override
    public ScheduleProject findById(int id) {
        return null;
    }

    @Override
    public List<ScheduleProject> findAll() {
        return List.of();
    }

    @Override
    public ScheduleProject save(ScheduleProject sp) {
        return null;
    }

    @Override
    public ScheduleProject update(ScheduleProject sp) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ScheduleProject> findByProjectName(String projectName) {
        return List.of();
    }
}
