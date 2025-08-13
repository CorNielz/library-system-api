package com.cornielz.librarysystem.user.application.mapper;

import com.cornielz.librarysystem.user.application.dto.UserCreationRequestDTO;
import com.cornielz.librarysystem.user.application.dto.UserReplaceRequestDTO;
import com.cornielz.librarysystem.user.application.dto.UserResponseDTO;
import com.cornielz.librarysystem.user.application.dto.UserUpdateRequestDTO;
import com.cornielz.librarysystem.user.domain.model.User;
import com.cornielz.librarysystem.user.domain.model.UserStatus;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Optional;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
    User toDomain(UserCreationRequestDTO dto, UUID id);

    User toDomain(UserReplaceRequestDTO dto);

    User toDomain(UserUpdateRequestDTO dto);

    UserResponseDTO toResponseDTO(User domain);

    void replaceUserFromDto(UserReplaceRequestDTO dto, @MappingTarget User entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserUpdateRequestDTO dto, @MappingTarget User entity);
}