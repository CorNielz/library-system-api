package com.cornielz.librarysystem.book.application.dto;

import com.cornielz.librarysystem.book.domain.model.BookCondition;
import com.cornielz.librarysystem.book.domain.model.BookStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookSearchFilters(
    String title,
    String language,
    LocalDateTime publicationDateFrom,
    LocalDateTime publicationDateTo,
    BigDecimal priceMinimal,
    BigDecimal priceMaximum,
    BookCondition condition,
    BookStatus status
) {}