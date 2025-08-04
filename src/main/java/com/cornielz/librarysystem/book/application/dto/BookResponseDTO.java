package com.cornielz.librarysystem.book.application.dto;

import com.cornielz.librarysystem.book.domain.model.BookCondition;
import com.cornielz.librarysystem.book.domain.model.BookStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record BookResponseDTO(
        UUID id,
        String title,
        String description,
        String language,
        LocalDateTime publicationDate,
        BigDecimal price,
        BookCondition condition,
        BookStatus status
) {
}