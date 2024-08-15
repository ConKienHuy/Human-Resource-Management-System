package com.restapi.hrmsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_id")
    private String departmentID;

    @Column(name = "department_name")
    private String departmentName;
}
