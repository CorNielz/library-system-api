package com.cornielz.librarysystem.review.application.services;

import java.util.List;
import java.util.UUID;
import com.cornielz.librarysystem.review.application.dto.ReviewCreationRequestDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewResponseDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewUpdateRequestDTO;

public interface ReviewService {
    ReviewResponseDTO create(ReviewCreationRequestDTO request);
    ReviewResponseDTO update(ReviewUpdateRequestDTO request);
    void delete(UUID id);
    ReviewResponseDTO getById(UUID id);
    List<ReviewResponseDTO> listAll();
    List<ReviewResponseDTO> listByBookId(UUID bookId);
}