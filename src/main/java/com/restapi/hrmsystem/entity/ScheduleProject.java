package com.restapi.hrmsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScheduleProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_start_date")
    private LocalDate projectStartDate;

    @Column(name = "project_end_date")
    private LocalDate projectEndDate;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany
    private List<Participant> participants;

    @Column(name = "progress")
    private int progress;
}
