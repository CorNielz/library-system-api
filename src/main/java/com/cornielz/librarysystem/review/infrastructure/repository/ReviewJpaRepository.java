package com.cornielz.librarysystem.review.infrastructure.repository;

import com.cornielz.librarysystem.review.infrastructure.persistence.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, UUID> {

}