package com.cornielz.librarysystem.author.application.dto;

import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AuthorCreationRequestDTO(
        @NotBlank @Size(max = 100) String name,
        String bio,
        @NotNull LocalDateTime birthDate,
        @NotBlank @Size(max = 32) String nationality,
        @NotNull AuthorStatus status
) {
}