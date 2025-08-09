package com.cornielz.librarysystem.book.infrastructure.repository;

import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import com.cornielz.librarysystem.book.domain.model.BookCondition;
import com.cornielz.librarysystem.book.domain.model.BookStatus;
import com.cornielz.librarysystem.book.infrastructure.persistence.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookJpaRepository extends JpaRepository<BookEntity, UUID> {
    @Query("SELECT book FROM BookEntity book WHERE " +
            "(:title IS NULL OR LOWER(book.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:language IS NULL OR book.language = :language) AND " +
            "(:publicationDateFrom IS NULL OR book.publicationDate >= :publicationDateFrom) AND " +
            "(:publicationDateTo IS NULL OR book.publicationDate <= :publicationDateTo) AND " +
            "(:priceMinimum IS NULL OR book.price >= :priceMinimum) AND " +
            "(:priceMaximum IS NULL OR book.price <= :priceMaximum) AND " +
            "(:condition IS NULL OR book.condition = :condition) AND " +
            "(:status IS NULL OR book.status = :status)")
    Optional<List<BookEntity>> findAllFiltered(
            @Param("title") String title,
            @Param("language") String language,
            @Param("publicationDateFrom") LocalDateTime publicationDateFrom,
            @Param("publicationDateTo") LocalDateTime publicationDateTo,
            @Param("priceMinimum") BigDecimal priceMinimum,
            @Param("priceMaximum") BigDecimal priceMaximum,
            @Param("condition") BookCondition condition,
            @Param("status") BookStatus status
    );
}