package com.cornielz.librarysystem.review.application.mapper;

import com.cornielz.librarysystem.review.application.dto.ReviewCreationRequestDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewResponseDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewUpdateRequestDTO;
import com.cornielz.librarysystem.review.domain.model.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewDTOMapper {
    Review toDomain(ReviewCreationRequestDTO dto);
    Review toDomain(ReviewUpdateRequestDTO dto);
    ReviewResponseDTO toResponseDTO(Review domain);
}