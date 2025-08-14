package com.cornielz.librarysystem.user.application.dto;

import com.cornielz.librarysystem.user.domain.model.UserStatus;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String nickname,
        String email,
        UserStatus status
) {
}