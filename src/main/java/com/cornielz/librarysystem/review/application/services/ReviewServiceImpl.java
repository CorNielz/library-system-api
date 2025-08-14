package com.cornielz.librarysystem.review.application.services;

import com.cornielz.librarysystem.review.application.dto.*;
import com.cornielz.librarysystem.review.application.mapper.ReviewDTOMapper;
import com.cornielz.librarysystem.review.domain.model.Review;
import com.cornielz.librarysystem.review.domain.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ReviewDTOMapper dtoMapper;

    public ReviewServiceImpl(ReviewRepository repository, ReviewDTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public ReviewResponseDTO create(ReviewCreationRequestDTO dto) {
        UUID reviewId = UUID.randomUUID();
        Review review = dtoMapper.toDomain(dto, reviewId);

        repository.save(review);

        return dtoMapper.toResponseDTO(review);
    }

    @Override
    public ReviewResponseDTO replace(UUID id, ReviewReplaceRequestDTO dto) {
        Review review = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        dtoMapper.replaceReviewFromDto(dto, review);
        repository.save(review);

        return dtoMapper.toResponseDTO(review);
    }

    @Override
    public ReviewResponseDTO update(UUID id, ReviewUpdateRequestDTO dto) {
        Review review = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        dtoMapper.updateReviewFromDto(dto, review);
        repository.save(review);

        return dtoMapper.toResponseDTO(review);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }

    @Override
    public ReviewResponseDTO getById(UUID id) {
        return repository.findById(id)
                .map(dtoMapper::toResponseDTO)
                .orElse(null);
    }

    @Override
    public List<ReviewResponseDTO> searchWithFilters(ReviewSearchFilters searchFilters) {
        return repository.findAllFiltered(searchFilters)
                .stream()
                .map(dtoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}