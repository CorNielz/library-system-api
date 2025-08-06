package com.cornielz.librarysystem.review.infrastructure.mapper;

import com.cornielz.librarysystem.review.domain.model.Review;
import com.cornielz.librarysystem.review.infrastructure.persistence.ReviewEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T08:58:39-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class ReviewEntityMapperImpl implements ReviewEntityMapper {

    @Override
    public ReviewEntity toEntity(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewEntity reviewEntity = new ReviewEntity();

        return reviewEntity;
    }

    @Override
    public Review toDomain(ReviewEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String title = null;
        String comment = null;
        int score = 0;

        id = entity.getId();
        title = entity.getTitle();
        comment = entity.getComment();
        score = entity.getScore();

        UUID userId = null;
        UUID bookId = null;

        Review review = new Review( id, userId, bookId, title, comment, score );

        return review;
    }
}
