package com.cornielz.librarysystem.application.author;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;

public record AuthorDeletionMarkRequestDTO(
        @NotNull UUID id
) {}