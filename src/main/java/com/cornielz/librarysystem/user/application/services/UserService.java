package com.cornielz.librarysystem.user.application.services;

import java.util.List;
import java.util.UUID;
import com.cornielz.librarysystem.user.application.dto.UserCreationRequestDTO;
import com.cornielz.librarysystem.user.application.dto.UserUpdateRequestDTO;
import com.cornielz.librarysystem.user.application.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO create(UserCreationRequestDTO request);
    UserResponseDTO update(UserUpdateRequestDTO request);
    void delete(UUID id);
    UserResponseDTO getById(UUID id);
    List<UserResponseDTO> listAll();
}