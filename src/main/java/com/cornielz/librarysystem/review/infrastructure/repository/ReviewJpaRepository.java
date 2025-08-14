package com.cornielz.librarysystem.review.infrastructure.repository;

import com.cornielz.librarysystem.review.infrastructure.persistence.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, UUID> {
    @Query("SELECT review FROM ReviewEntity review WHERE " +
            "(review.userId = :userId OR :userId IS NULL) AND " +
            "(review.bookId = :bookId OR :bookId IS NULL) AND " +
            "(LOWER(review.title) LIKE LOWER(CONCAT('%', :title, '%')) OR :title IS NULL) AND " +
            "(review.score >= :scoreMinimum OR :scoreMinimum IS NULL) AND " +
            "(review.score <= :scoreMaximum OR :scoreMaximum IS NULL)")
    Optional<List<ReviewEntity>> findAllFiltered(
            @Param("userId") UUID userId,
            @Param("bookId") UUID bookId,
            @Param("title") String title,
            @Param("scoreMinimum") Integer scoreMinimum,
            @Param("scoreMaximum") Integer scoreMaximum
    );
}