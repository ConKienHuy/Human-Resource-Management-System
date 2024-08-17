package com.restapi.hrmsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employee_id")
    private String employeeID;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
                    CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "roles")
    private String roles;

    @Column(name = "salary")
    private double salary;

}
