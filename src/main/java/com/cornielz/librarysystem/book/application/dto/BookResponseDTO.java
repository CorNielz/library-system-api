package com.cornielz.librarysystem.application.book;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import com.cornielz.librarysystem.domain.book.BookCondition;
import com.cornielz.librarysystem.domain.book.BookStatus;

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