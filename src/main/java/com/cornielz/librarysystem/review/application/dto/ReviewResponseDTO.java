package com.cornielz.librarysystem.review.application.dto;

import java.util.UUID;

public record ReviewResponseDTO(
        UUID id,
        UUID userId,
        UUID bookId,
        String title,
        String comment,
        int score
) {
}