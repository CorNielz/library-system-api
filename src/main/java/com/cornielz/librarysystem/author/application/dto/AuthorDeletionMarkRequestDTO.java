package com.cornielz.librarysystem.author.application.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AuthorDeletionMarkRequestDTO(
        @NotNull UUID id
) {
}