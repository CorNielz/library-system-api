package com.cornielz.librarysystem.application.review;

import com.cornielz.librarysystem.domain.review.Review;
import com.cornielz.librarysystem.domain.review.ReviewRepository;

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
        repository.deleteById(id);
    }

    @Override
    public ReviewResponseDTO getById(UUID id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<ReviewResponseDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ReviewResponseDTO toDTO(Review review) {
        return new ReviewResponseDTO(review.id(), review.userId(), review.bookId(), review.title(), review.comment(), review.score());
    }
}