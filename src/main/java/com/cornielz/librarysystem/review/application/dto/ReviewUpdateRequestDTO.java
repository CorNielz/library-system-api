package com.cornielz.librarysystem.review.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ReviewUpdateRequestDTO(
        UUID id,
        UUID userId,
        UUID bookId,
        @Size(max = 120) String title,
        String comment,
        @Min(1) @Max(10) int score
) {}