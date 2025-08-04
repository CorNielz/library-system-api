package com.cornielz.librarysystem.user.application.dto;

import com.cornielz.librarysystem.user.domain.model.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreationRequestDTO(
        @NotBlank @Size(max = 100) String name,
        @NotBlank @Size(max = 32) String nickname,
        @NotBlank @Email @Size(max = 254) String email,
        @NotNull byte[] hashedPassword,
        @NotNull UserStatus status
) {
}