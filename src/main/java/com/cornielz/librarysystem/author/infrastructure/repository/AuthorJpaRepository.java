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
    @Query("SELECT author FROM AuthorEntity author WHERE " +
            "(LOWER(author.name) LIKE LOWER(CONCAT('%', :name, '%')) OR :name IS NULL) AND " +
            "(author.nationality = :nationality OR :nationality IS NULL) AND " +
            "(CAST(author.status AS string) = CAST(:status AS string) OR :status IS NULL) AND " +
            "(author.birthDate >= :birthDateFrom OR CAST(:birthDateFrom AS date) IS NULL) AND " +
            "(author.birthDate <= :birthDateTo OR CAST(:birthDateTo AS date) IS NULL)")
    Optional<List<AuthorEntity>> findAllFiltered(
            @Param("name") String name,
            @Param("nationality") String nationality,
            @Param("status") AuthorStatus status,
            @Param("birthDateFrom") LocalDateTime birthDateFrom,
            @Param("birthDateTo") LocalDateTime birthDateTo
    );
}