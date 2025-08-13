package com.cornielz.librarysystem.user.application.dto;

import com.cornielz.librarysystem.user.domain.model.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record UserUpdateRequestDTO(
        @Size(max = 100) String name,
        @Size(max = 32) String nickname,
        @Email @Size(max = 254) String email,
        String password,
        UserStatus status
) {
}