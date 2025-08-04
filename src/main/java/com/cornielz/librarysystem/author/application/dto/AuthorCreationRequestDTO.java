package com.cornielz.librarysystem.application.author;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.cornielz.librarysystem.domain.author.AuthorStatus;

public record AuthorCreationRequestDTO(
        @NotBlank @Size(max = 100) String name,
        String bio,
        @NotNull LocalDateTime birthDate,
        @NotBlank @Size(max = 32) String nationality,
        @NotNull AuthorStatus status
) {}