package com.restapi.hrmsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private ScheduleProject scheduleProject;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "participant_role")
    private String role;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
