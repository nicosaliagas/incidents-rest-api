package com.my.app.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.app.backend.models.Exercise;

@Repository
public interface ExerciseRepository
    extends JpaRepository<Exercise, UUID> {
}
