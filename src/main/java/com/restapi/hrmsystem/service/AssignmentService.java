package com.restapi.hrmsystem.service;

import com.restapi.hrmsystem.entity.Assignment;

import java.util.List;

public interface AssignmentService {

    Assignment findById(int id);

    List<Assignment> findAll();

    Assignment save(Assignment assignment);

    Assignment update(Assignment assignment, int id);

    void delete(int id);
}
