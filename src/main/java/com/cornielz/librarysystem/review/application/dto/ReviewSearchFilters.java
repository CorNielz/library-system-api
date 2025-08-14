package com.cornielz.librarysystem.review.application.dto;

import java.util.UUID;

public record ReviewSearchFilters(
        UUID userId,
        UUID bookId,
        String title,
        Integer scoreMinimum,
        Integer scoreMaximum
) {}