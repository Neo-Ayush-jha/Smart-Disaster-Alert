package com.example.disasteralert.repository;

import com.example.disasteralert.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByVerificationToken(String verificationToken);

    // For login — will check both email and password match
    Optional<User> findByEmailAndPassword(String email, String password);
}
