package com.cornielz.librarysystem.review.infrastructure.repository;

import com.cornielz.librarysystem.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

public interface SpringDataReviewRepository extends JpaRepository<ReviewEntity, UUID> {

}