package com.cornielz.librarysystem.review.application.mapper;

import com.cornielz.librarysystem.review.application.dto.ReviewCreationRequestDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewReplaceRequestDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewResponseDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewUpdateRequestDTO;
import com.cornielz.librarysystem.review.domain.model.Review;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ReviewDTOMapper {
    Review toDomain(ReviewCreationRequestDTO dto, UUID id);

    Review toDomain(ReviewReplaceRequestDTO dto);

    Review toDomain(ReviewUpdateRequestDTO dto);

    ReviewResponseDTO toResponseDTO(Review domain);

    void replaceReviewFromDto(ReviewReplaceRequestDTO dto, @MappingTarget Review entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReviewFromDto(ReviewUpdateRequestDTO dto, @MappingTarget Review entity);
}