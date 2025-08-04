package com.cornielz.librarysystem.user.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cornielz.librarysystem.user.infrastructure.persistence.UserEntity;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, UUID> {

}