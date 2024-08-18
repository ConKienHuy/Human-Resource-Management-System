package com.restapi.hrmsystem.service;

import com.restapi.hrmsystem.entity.Participant;

import java.util.List;

public interface ParticipantService {

    Participant findByID(int id);

    List<Participant> findAll();

    Participant save(Participant participant);

    Participant update(Participant participant);

    void delete(int id);

    Participant findByRole(String role);

    Participant findbyEmployee(String employeeName);
}
