package com.cornielz.librarysystem.review.application.dto;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record ReviewCreationRequestDTO(
        @NotNull UUID userId,
        @NotNull UUID bookId,
        @NotBlank @Size(max = 120) String title,
        String comment,
        @Min(1) @Max(10) int score
) {
}