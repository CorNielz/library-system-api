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
            "(:userId IS NULL OR review.user.id = :userId) AND " +
            "(:bookId IS NULL OR review.book.id = :bookId) AND " +
            "(:title IS NULL OR LOWER(review.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:scoreMinimum IS NULL OR review.score >= :scoreMinimum) AND " +
            "(:scoreMaximum IS NULL OR review.score <= :scoreMaximum)")
    Optional<List<ReviewEntity>> findAllFiltered(
            @Param("userId") UUID userId,
            @Param("bookId") UUID bookId,
            @Param("title") String title,
            @Param("scoreMinimum") int scoreMinimum,
            @Param("scoreMaximum") int scoreMaximum
    );
}