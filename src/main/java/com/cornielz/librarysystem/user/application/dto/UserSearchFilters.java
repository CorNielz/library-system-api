package com.cornielz.librarysystem.user.application.dto;

import com.cornielz.librarysystem.user.domain.model.UserStatus;

public record UserSearchFilters(
        String name,
        String nickname,
        String email,
        UserStatus status
) {}