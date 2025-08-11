package com.cornielz.librarysystem.review.infrastructure.persistence;

import com.cornielz.librarysystem.review.application.dto.ReviewSearchFilters;
import com.cornielz.librarysystem.review.domain.model.Review;
import com.cornielz.librarysystem.review.domain.repository.ReviewRepository;
import com.cornielz.librarysystem.review.infrastructure.mapper.ReviewEntityMapper;
import com.cornielz.librarysystem.review.infrastructure.repository.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

    private final ReviewJpaRepository jpaRepository;
    private final ReviewEntityMapper mapper;

    @Override
    public Optional<Review> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Review> findAllFiltered(ReviewSearchFilters searchFilters) {
        return jpaRepository.findAllFiltered(
                        searchFilters.userId(),
                        searchFilters.bookId(),
                        searchFilters.title(),
                        searchFilters.scoreMinimum(),
                        searchFilters.scoreMaximum()
                )
                .orElse(new ArrayList<>())
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Review review) {
        jpaRepository.save(mapper.toEntity(review));
    }

    @Override
    public void delete(UUID id) {
        jpaRepository.deleteById(id);
    }
}