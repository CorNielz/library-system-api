package com.cornielz.librarysystem.book.application.dto;

import com.cornielz.librarysystem.book.domain.model.BookCondition;
import com.cornielz.librarysystem.book.domain.model.BookStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record BookUpdateRequestDTO(
        UUID id,
        @Size(max = 120) String title,
        String description,
        @Size(max = 10) String language,
        LocalDateTime publicationDate,
        @DecimalMin(value = "0.0", inclusive = false) BigDecimal price,
        BookCondition condition,
        BookStatus status
) {
}