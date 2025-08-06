package com.cornielz.librarysystem.review.application.mapper;

import com.cornielz.librarysystem.review.application.dto.ReviewCreationRequestDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewResponseDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewUpdateRequestDTO;
import com.cornielz.librarysystem.review.domain.model.Review;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T08:58:39-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class ReviewDTOMapperImpl implements ReviewDTOMapper {

    @Override
    public Review toDomain(ReviewCreationRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UUID userId = null;
        UUID bookId = null;
        String title = null;
        String comment = null;
        int score = 0;

        userId = dto.userId();
        bookId = dto.bookId();
        title = dto.title();
        comment = dto.comment();
        score = dto.score();

        UUID id = null;

        Review review = new Review( id, userId, bookId, title, comment, score );

        return review;
    }

    @Override
    public Review toDomain(ReviewUpdateRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UUID id = null;
        UUID userId = null;
        UUID bookId = null;
        String title = null;
        String comment = null;
        int score = 0;

        id = dto.id();
        userId = dto.userId();
        bookId = dto.bookId();
        title = dto.title();
        comment = dto.comment();
        score = dto.score();

        Review review = new Review( id, userId, bookId, title, comment, score );

        return review;
    }

    @Override
    public ReviewResponseDTO toResponseDTO(Review domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        UUID userId = null;
        UUID bookId = null;
        String title = null;
        String comment = null;
        int score = 0;

        id = domain.getId();
        userId = domain.getUserId();
        bookId = domain.getBookId();
        title = domain.getTitle();
        comment = domain.getComment();
        score = domain.getScore();

        ReviewResponseDTO reviewResponseDTO = new ReviewResponseDTO( id, userId, bookId, title, comment, score );

        return reviewResponseDTO;
    }
}
