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
            "(LOWER(user.name) LIKE LOWER(CONCAT('%', :name, '%')) OR :name IS NULL) AND " +
            "(LOWER(user.nickname) LIKE LOWER(CONCAT('%', :nickname, '%')) OR :nickname IS NULL) AND " +
            "(LOWER(user.email) LIKE LOWER(CONCAT('%', :email, '%')) OR :email IS NULL) AND " +
            "(:status IS NULL OR CAST(user.status AS string) = CAST(:status AS string))")
    Optional<List<UserEntity>> findAllFiltered(
            @Param("name") String name,
            @Param("nickname") String nickname,
            @Param("email") String email,
            @Param("status") UserStatus status
    );
}