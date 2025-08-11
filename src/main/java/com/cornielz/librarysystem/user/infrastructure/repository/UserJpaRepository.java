package com.cornielz.librarysystem.user.infrastructure.repository;

import com.cornielz.librarysystem.user.domain.model.UserStatus;
import com.cornielz.librarysystem.user.infrastructure.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    @Query("SELECT user FROM UserEntity user WHERE " +
            "(:name IS NULL OR LOWER(user.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:nickname IS NULL OR LOWER(user.nickname) LIKE LOWER(CONCAT('%', :nickname, '%'))) AND " +
            "(:email IS NULL OR LOWER(user.email) LIKE LOWER(CONCAT('%', :email, '%'))) AND " +
            "(:status IS NULL OR user.status = :status)")
    Optional<List<UserEntity>> findAllFiltered(
            @Param("name") String name,
            @Param("nickname") String nickname,
            @Param("email") String email,
            @Param("status") UserStatus status
    );
}