package com.cornielz.librarysystem.author.infrastructure.repository;

import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import com.cornielz.librarysystem.author.infrastructure.persistence.AuthorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, UUID> {
    @Query("SELECT a FROM AuthorEntity a WHERE " +
            "(:name IS NULL OR LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:nationality IS NULL OR a.nationality = :nationality) AND " +
            "(:status IS NULL OR a.status = :status) AND " +
            "(:birthDateFrom IS NULL OR a.birthDate >= :birthDateFrom) AND " +
            "(:birthDateTo IS NULL OR a.birthDate <= :birthDateTo)")
    Optional<List<AuthorEntity>> findAllFiltered(
            @Param("name") String name,
            @Param("nationality") String nationality,
            @Param("status") AuthorStatus status,
            @Param("birthDateFrom") LocalDateTime birthDateFrom,
            @Param("birthDateTo") LocalDateTime birthDateTo
    );
}