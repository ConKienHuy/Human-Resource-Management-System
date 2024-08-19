package com.restapi.hrmsystem.repository;

import com.restapi.hrmsystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
