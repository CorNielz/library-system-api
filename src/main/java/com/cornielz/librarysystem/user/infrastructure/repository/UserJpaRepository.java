package com.cornielz.librarysystem.user.infrastructure.repository;

import com.cornielz.librarysystem.user.infrastructure.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, UUID> {

}