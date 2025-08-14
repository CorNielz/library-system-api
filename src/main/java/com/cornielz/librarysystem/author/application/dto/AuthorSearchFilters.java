package com.cornielz.librarysystem.author.application.dto;

import com.cornielz.librarysystem.author.domain.model.AuthorStatus;

import java.time.LocalDateTime;

public record AuthorSearchFilters(
    String name,
    LocalDateTime birthDateFrom,
    LocalDateTime birthDateTo,
    String nationality,
    AuthorStatus status
) {}