package com.cornielz.librarysystem.review.application.dto;

import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public record ReviewUpdateRequestDTO(
        @NotNull UUID id,
        @NotNull UUID userId,
        @NotNull UUID bookId,
        @NotBlank @Size(max = 120) String title,
        String comment,
        @Min(1) @Max(10) int score
) {}