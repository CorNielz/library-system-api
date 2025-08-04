package com.cornielz.librarysystem.user.application.dto;

import java.util.UUID;
import com.cornielz.librarysystem.user.domain.model.UserStatus;

public record UserResponseDTO(
    UUID id,
    String name,
    String nickname,
    String email,
    UserStatus status
) {}