package com.my.app.backend.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.backend.models.Incident;
import com.my.app.backend.repository.IncidentRepository;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> list() {
        return incidentRepository.findAll();
    }

    public Incident newIncident(Incident incident) {
        return incidentRepository.save(incident);
    }
}
