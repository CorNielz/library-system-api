package com.cornielz.librarysystem.author.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;

public record AuthorDeletionMarkRequestDTO(
        @NotNull UUID id
) {}