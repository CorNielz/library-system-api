package com.cornielz.librarysystem.application.review;

import java.util.UUID;

public record ReviewResponseDTO(
        UUID id,
        UUID userId,
        UUID bookId,
        String title,
        String comment,
        int score
) {}