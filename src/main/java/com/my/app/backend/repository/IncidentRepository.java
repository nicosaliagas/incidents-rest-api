package com.my.app.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.app.backend.models.IncidentEntity;

@Repository
public interface IncidentRepository 
  extends JpaRepository<IncidentEntity, Long> {
}
