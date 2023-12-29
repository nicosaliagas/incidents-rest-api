package com.my.app.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.my.app.backend.exceptions.ContrainteUniqueException;
import com.my.app.backend.models.Exercise;
import com.my.app.backend.repository.ExerciseRepository;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Exercise> list() {
        return exerciseRepository.findAll();
    }
    
    public Exercise findExerciseById(UUID id) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);
        
        if (exerciseOptional.isPresent()) {
            return exerciseOptional.get();
        } else {
            return null;
        }
    }

    public Exercise saveExercise(Exercise newExercise) {
        try {
            return exerciseRepository.save(newExercise);
        } catch (DataIntegrityViolationException ex) {
            throw new ContrainteUniqueException("L'exercice existe déjà.");
        }
    }
}
