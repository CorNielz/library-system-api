package com.cornielz.librarysystem.book.application.dto;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.cornielz.librarysystem.domain.book.BookCondition;
import com.cornielz.librarysystem.domain.book.BookStatus;

public record BookCreationRequestDTO(
        @NotBlank @Size(max = 120) String title,
        String description,
        @NotBlank @Size(max = 10) String language,
        @NotNull LocalDateTime publicationDate,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal price,
        @NotNull BookCondition condition,
        @NotNull BookStatus status
) {}