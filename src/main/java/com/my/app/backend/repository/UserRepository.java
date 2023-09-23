package com.my.app.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.app.backend.models.User;

@Repository
public interface UserRepository
    extends JpaRepository<User, Long> {

  Optional<User> findByMail(String mail);
}
