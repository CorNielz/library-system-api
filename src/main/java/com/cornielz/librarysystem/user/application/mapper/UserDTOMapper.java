package com.cornielz.librarysystem.user.application.mapper;

import com.cornielz.librarysystem.user.application.dto.UserCreationRequestDTO;
import com.cornielz.librarysystem.user.application.dto.UserResponseDTO;
import com.cornielz.librarysystem.user.application.dto.UserUpdateRequestDTO;
import com.cornielz.librarysystem.user.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
    User toDomain(UserCreationRequestDTO dto);
    User toDomain(UserUpdateRequestDTO dto);
    UserResponseDTO toResponseDTO(User domain);
}