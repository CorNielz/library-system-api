package com.cornielz.librarysystem.review.application.services;

import com.cornielz.librarysystem.review.application.dto.ReviewCreationRequestDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewResponseDTO;
import com.cornielz.librarysystem.review.application.dto.ReviewUpdateRequestDTO;
import com.cornielz.librarysystem.review.domain.model.Review;
import com.cornielz.librarysystem.review.domain.repository.ReviewRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReviewResponseDTO create(ReviewCreationRequestDTO dto) {
        Review review = new Review(UUID.randomUUID(), dto.userId(), dto.bookId(), dto.title(), dto.comment(), dto.score());
        repository.save(review);
        return toDTO(review);
    }

    @Override
    public ReviewResponseDTO update(ReviewUpdateRequestDTO dto) {
        Review review = repository.findById(dto.id()).orElseThrow();
        review.update(dto.userId(), dto.bookId(), dto.title(), dto.comment(), dto.score());
        repository.save(review);
        return toDTO(review);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }

    @Override
    public ReviewResponseDTO getById(UUID id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<ReviewResponseDTO> listAll() {
        return List.of();
    }

    @Override
    public List<ReviewResponseDTO> listByBookId(UUID bookId) {
        return List.of();
    }

    @Override
    public List<ReviewResponseDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ReviewResponseDTO toDTO(Review review) {
        return new ReviewResponseDTO(review.id(), review.userId(), review.bookId(), review.title(), review.comment(), review.score());
    }
}