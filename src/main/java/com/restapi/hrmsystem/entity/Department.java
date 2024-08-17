package com.restapi.hrmsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
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

    @OneToMany(fetch = FetchType.LAZY, // Default FetchType in one to many
            mappedBy = "department",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
                        CascadeType.DETACH, CascadeType.MERGE})
    private List<Employee> employees;
}
