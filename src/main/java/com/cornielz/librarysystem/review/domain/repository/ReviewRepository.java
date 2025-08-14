package com.cornielz.librarysystem.review.domain.repository;

import com.cornielz.librarysystem.review.application.dto.ReviewSearchFilters;
import com.cornielz.librarysystem.review.domain.model.Review;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository {
    Optional<Review> findById(UUID id);

    List<Review> findAllFiltered(ReviewSearchFilters searchFilters);

    void save(Review review);

    void delete(UUID id);
}