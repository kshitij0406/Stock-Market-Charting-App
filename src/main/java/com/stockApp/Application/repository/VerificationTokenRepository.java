package com.stockApp.Application.repository;

import com.stockApp.Application.model.User;
import com.stockApp.Application.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
    VerificationToken findByUser(User user);
}