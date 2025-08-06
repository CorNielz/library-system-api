package com.cornielz.librarysystem.user.infrastructure.mapper;

import com.cornielz.librarysystem.user.domain.model.User;
import com.cornielz.librarysystem.user.domain.model.UserStatus;
import com.cornielz.librarysystem.user.infrastructure.persistence.UserEntity;
import java.util.Arrays;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T08:58:39-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class UserEntityMapperImpl implements UserEntityMapper {

    @Override
    public UserEntity toEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        return userEntity;
    }

    @Override
    public User toDomain(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String nickname = null;
        String email = null;
        byte[] hashedPassword = null;
        UserStatus status = null;

        id = entity.getId();
        name = entity.getName();
        nickname = entity.getNickname();
        email = entity.getEmail();
        byte[] hashedPassword1 = entity.getHashedPassword();
        if ( hashedPassword1 != null ) {
            hashedPassword = Arrays.copyOf( hashedPassword1, hashedPassword1.length );
        }
        status = entity.getStatus();

        User user = new User( id, name, nickname, email, hashedPassword, status );

        return user;
    }
}
