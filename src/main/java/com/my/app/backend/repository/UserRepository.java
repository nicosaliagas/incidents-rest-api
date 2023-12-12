package com.my.app.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.my.app.backend.models.User;

@Repository
public interface UserRepository
    extends JpaRepository<User, Long> {

  Optional<User> findByEmailAddress(String emailAddress);

  @Query("SELECT u FROM User u WHERE u.emailAddress = :emailAddress AND u.password = :password")
  Optional<User> findByEmailAddressAndPassword(@Param("emailAddress") String emailAddress, @Param("password") String password);
}
