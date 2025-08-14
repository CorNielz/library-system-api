package com.cornielz.librarysystem.review.api.controller;

import com.cornielz.librarysystem.review.application.dto.*;
import com.cornielz.librarysystem.review.application.services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> createReview(@Valid @RequestBody ReviewCreationRequestDTO dto) {
        return ResponseEntity.ok(reviewService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> replaceReview(@PathVariable UUID id, @Valid @RequestBody ReviewReplaceRequestDTO dto) {
        return ResponseEntity.ok(reviewService.replace(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> updateReview(@PathVariable UUID id, @Valid @RequestBody ReviewUpdateRequestDTO dto) {
        return ResponseEntity.ok(reviewService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> getReview(@PathVariable UUID id) {
        return ResponseEntity.ok(reviewService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ReviewResponseDTO>> searchReviews(
            @RequestParam(required = false) UUID userId,
            @RequestParam(required = false) UUID bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) int scoreMinimum,
            @RequestParam(required = false) int scoreMaximum
    ) {
        ReviewSearchFilters searchFilters = new ReviewSearchFilters(userId, bookId, title, scoreMinimum, scoreMaximum);
        return ResponseEntity.ok(reviewService.searchWithFilters(searchFilters));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable UUID id) {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }
}