package com.cornielz.librarysystem.author.application.dto;

import com.cornielz.librarysystem.author.domain.model.AuthorStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record AuthorResponseDTO(
        UUID id,
        String name,
        String biography,
        LocalDateTime birthDate,
        String nationality,
        AuthorStatus status
) {
}