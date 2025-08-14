package com.cornielz.librarysystem.author.application.dto;

import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record AuthorUpdateRequestDTO(
        UUID id,
        @Size(max = 100) String name,
        String biography,
        LocalDateTime birthDate,
        @Size(max = 32) String nationality,
        AuthorStatus status
) {
}