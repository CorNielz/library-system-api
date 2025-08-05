package com.cornielz.librarysystem.user.infrastructure.repository;

import com.cornielz.librarysystem.review.infrastructure.persistence.ReviewEntity;
import com.cornielz.librarysystem.user.infrastructure.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}