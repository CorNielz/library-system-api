package com.cornielz.librarysystem.review.application.services;

import com.cornielz.librarysystem.review.application.dto.ReviewCreationRequestDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewResponseDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    ReviewResponseDTO create(ReviewCreationRequestDTO requestDto);

    ReviewResponseDTO update(ReviewUpdateRequestDTO requestDto);

    void delete(UUID id);

    ReviewResponseDTO getById(UUID id);

    List<ReviewResponseDTO> listAll();
}