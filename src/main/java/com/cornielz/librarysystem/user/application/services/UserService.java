package com.cornielz.librarysystem.user.application.services;

import com.cornielz.librarysystem.user.application.dto.*;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO create(UserCreationRequestDTO requestDto);

    UserResponseDTO replace(UUID id, UserReplaceRequestDTO requestDto);

    UserResponseDTO update(UUID id, UserUpdateRequestDTO requestDto);

    void delete(UUID id);

    UserResponseDTO getById(UUID id);

    List<UserResponseDTO> searchWithFilters(UserSearchFilters searchFilters);
}