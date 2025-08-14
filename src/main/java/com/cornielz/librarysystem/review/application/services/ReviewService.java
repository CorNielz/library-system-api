package com.cornielz.librarysystem.review.application.services;

import com.cornielz.librarysystem.review.application.dto.*;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    ReviewResponseDTO create(ReviewCreationRequestDTO requestDto);

    ReviewResponseDTO replace(UUID id, ReviewReplaceRequestDTO requestDto);

    ReviewResponseDTO update(UUID id, ReviewUpdateRequestDTO requestDto);

    void delete(UUID id);

    ReviewResponseDTO getById(UUID id);

    List<ReviewResponseDTO> searchWithFilters(ReviewSearchFilters searchFilters);
}