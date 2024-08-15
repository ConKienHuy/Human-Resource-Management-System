package com.restapi.hrmsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_id")
    private int employeeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
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
