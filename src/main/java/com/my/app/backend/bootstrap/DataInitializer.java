package com.my.app.backend.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.my.app.backend.models.Exercise;
import com.my.app.backend.models.User;
import com.my.app.backend.repository.ExerciseRepository;
import com.my.app.backend.repository.UserRepository;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository, ExerciseRepository exerciseRepository) {
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public void initializeData() {
        User user = userRepository.save(new User("Aliagas", "Nicos", "nico.sesma@gmail.com", "656706"));
        exerciseRepository.save(new Exercise("Push Up", "bla bla bla", "Triceps", "Photo 1", user));
        exerciseRepository.save(new Exercise("Front Lever", "bla bla bla", "Avant-bras et poignets", "Photo 1", user));
        exerciseRepository.save(new Exercise("Pull Up", "bla bla bla", "Biceps", "Photo 1", user));
        exerciseRepository.save(new Exercise("Tuck Planche", "bla bla bla", "Avant-bras et poignets", "Photo 1", user));
        exerciseRepository.save(new Exercise("Straddle Planche", "bla bla bla", "Avant-bras et poignets", "Photo 1", user));
        exerciseRepository.save(new Exercise("Handstand Push Up", "bla bla bla", "Triceps", "Photo 1", user));
        exerciseRepository.save(new Exercise("Handstand", "bla bla bla", "Avant-bras et poignets", "Photo 1", user));
        exerciseRepository.save(new Exercise("Full Planche", "bla bla bla", "Avant-bras et poignets", "Photo 1", user));
    }
}
