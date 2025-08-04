package com.cornielz.librarysystem.book.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import com.cornielz.librarysystem.book.domain.model.BookCondition;
import com.cornielz.librarysystem.book.domain.model.BookStatus;

public record BookResponseDTO(
        UUID id,
        String title,
        String description,
        String language,
        LocalDateTime publicationDate,
        BigDecimal price,
        BookCondition condition,
        BookStatus status
) {}