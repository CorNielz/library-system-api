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
            "(LOWER(book.title) LIKE LOWER(CONCAT('%', :title, '%')) OR :title IS NULL) AND " +
            "(book.language = :language OR :language IS NULL) AND " +
            "(book.publicationDate >= :publicationDateFrom OR CAST(:publicationDateFrom AS date) IS NULL) AND " +
            "(book.publicationDate <= :publicationDateTo OR CAST(:publicationDateTo AS date) IS NULL) AND " +
            "(book.price >= :priceMinimum OR :priceMinimum IS NULL) AND " +
            "(book.price <= :priceMaximum OR :priceMaximum IS NULL) AND " +
            "(CAST(book.condition AS string) = CAST(:condition AS string) OR :condition IS NULL) AND " +
            "(CAST(book.status AS string) = CAST(:status AS string) OR :status IS NULL)")
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