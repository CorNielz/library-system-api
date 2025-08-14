package com.cornielz.librarysystem.review.infrastructure.mapper;

import com.cornielz.librarysystem.review.domain.model.Review;
import com.cornielz.librarysystem.review.infrastructure.persistence.ReviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewEntityMapper {
    ReviewEntity toEntity(Review review);
    Review toDomain(ReviewEntity entity);
}