package com.restapi.hrmsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectID;

    private String projectTitle;

    private double budget;

}
