package com.cornielz.librarysystem.application.review;

import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ReviewCreationRequestDTO(
        @NotNull UUID userId,
        @NotNull UUID bookId,
        @NotBlank @Size(max = 120) String title,
        String comment,
        @Min(1) @Max(10) int score
) {}