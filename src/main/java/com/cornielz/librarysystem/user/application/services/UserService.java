package com.cornielz.librarysystem.application.user;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO create(UserCreationRequestDTO request);
    UserResponseDTO update(UserUpdateRequestDTO request);
    void delete(UUID id);
    UserResponseDTO getById(UUID id);
    List<UserResponseDTO> listAll();
}