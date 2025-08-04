package com.cornielz.librarysystem.author.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import com.cornielz.librarysystem.author.domain.model.AuthorStatus;

public record AuthorResponseDTO(
        UUID id,
        String name,
        String bio,
        LocalDateTime birthDate,
        String nationality,
        AuthorStatus status
) {}