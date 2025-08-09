package com.cornielz.librarysystem.review.application.dto;

import java.util.UUID;

public record ReviewSearchFilters(
        UUID userId,
        UUID bookId,
        String title,
        int scoreMinimum,
        int scoreMaximum
) {}