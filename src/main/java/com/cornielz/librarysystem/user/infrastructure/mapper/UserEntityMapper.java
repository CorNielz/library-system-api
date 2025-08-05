package com.cornielz.librarysystem.user.infrastructure.mapper;

import com.cornielz.librarysystem.user.domain.model.User;
import com.cornielz.librarysystem.user.infrastructure.persistence.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity entity);
}