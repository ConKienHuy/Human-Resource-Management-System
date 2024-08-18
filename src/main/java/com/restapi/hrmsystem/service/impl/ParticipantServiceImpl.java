package com.restapi.hrmsystem.service.impl;

import com.restapi.hrmsystem.entity.Employee;
import com.restapi.hrmsystem.entity.Participant;
import com.restapi.hrmsystem.entity.ScheduleProject;
import com.restapi.hrmsystem.exception.EntityNotFoundException;
import com.restapi.hrmsystem.repository.ParticipantRepository;
import com.restapi.hrmsystem.service.EmployeeService;
import com.restapi.hrmsystem.service.ParticipantService;
import com.restapi.hrmsystem.service.ScheduleProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantRepository participantRepository;
    private ScheduleProjectService scheduleProjectService;
    private EmployeeService employeeService;

    @Autowired
    public ParticipantServiceImpl(ParticipantRepository ptRepo, ScheduleProjectService spService,EmployeeService empService){
        this.participantRepository = ptRepo;
        this.scheduleProjectService = spService;
        this.employeeService = empService;
    }

    @Override
    public Participant findByID(int id) {
        Participant p =  participantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participant with id " +id +" not found"));
        return p;
    }

    @Override
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    @Override
    public Participant save(Participant participant) {
        // Add new participant
        return participantRepository.save(participant);
    }

    @Override
    public Participant update(Participant participant) {
        // Business logic handling
        Participant updateParticipant = participantRepository.findById(participant.getId())
                .orElseThrow(() -> new EntityNotFoundException("Participant with id " +participant.getId() +" not found"));
        updateParticipant.setRole(participant.getRole());
        updateParticipant.setStartDate(participant.getStartDate());
        updateParticipant.setEndDate(participant.getEndDate());

        // Check if employee is existed in database
        Employee emp = employeeService.findByID(participant.getEmployee().getId());
        updateParticipant.setEmployee(emp);

        // Check schedule project
        ScheduleProject sp = scheduleProjectService.findById(participant.getScheduleProject().getId());
        updateParticipant.setScheduleProject(sp);

        return updateParticipant;
    }

    @Override
    public void delete(int id) {
        Participant deleteParticipant = participantRepository.findById(id)
                .orElse(null);
        if(deleteParticipant != null){
            participantRepository.delete(deleteParticipant);
        }
        else throw new EntityNotFoundException("Participant with id " +id+ " not found");

    }

    @Override
    public Participant findByRole(String role) {
        return null;
    }

    @Override
    public Participant findbyEmployee(String employeeName) {
        return null;
    }
}
