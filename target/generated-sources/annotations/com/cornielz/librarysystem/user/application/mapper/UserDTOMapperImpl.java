package com.cornielz.librarysystem.user.application.mapper;

import com.cornielz.librarysystem.user.application.dto.UserCreationRequestDTO;
import com.cornielz.librarysystem.user.application.dto.UserResponseDTO;
import com.cornielz.librarysystem.user.application.dto.UserUpdateRequestDTO;
import com.cornielz.librarysystem.user.domain.model.User;
import com.cornielz.librarysystem.user.domain.model.UserStatus;
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
public class UserDTOMapperImpl implements UserDTOMapper {

    @Override
    public User toDomain(UserCreationRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        String name = null;
        String nickname = null;
        String email = null;
        byte[] hashedPassword = null;
        UserStatus status = null;

        name = dto.name();
        nickname = dto.nickname();
        email = dto.email();
        byte[] hashedPassword1 = dto.hashedPassword();
        if ( hashedPassword1 != null ) {
            hashedPassword = Arrays.copyOf( hashedPassword1, hashedPassword1.length );
        }
        status = dto.status();

        UUID id = null;

        User user = new User( id, name, nickname, email, hashedPassword, status );

        return user;
    }

    @Override
    public User toDomain(UserUpdateRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String nickname = null;
        String email = null;
        byte[] hashedPassword = null;
        UserStatus status = null;

        id = dto.id();
        name = dto.name();
        nickname = dto.nickname();
        email = dto.email();
        byte[] hashedPassword1 = dto.hashedPassword();
        if ( hashedPassword1 != null ) {
            hashedPassword = Arrays.copyOf( hashedPassword1, hashedPassword1.length );
        }
        status = dto.status();

        User user = new User( id, name, nickname, email, hashedPassword, status );

        return user;
    }

    @Override
    public UserResponseDTO toResponseDTO(User domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String nickname = null;
        String email = null;
        byte[] hashedPassword = null;
        UserStatus status = null;

        id = domain.getId();
        name = domain.getName();
        nickname = domain.getNickname();
        email = domain.getEmail();
        byte[] hashedPassword1 = domain.getHashedPassword();
        if ( hashedPassword1 != null ) {
            hashedPassword = Arrays.copyOf( hashedPassword1, hashedPassword1.length );
        }
        status = domain.getStatus();

        UserResponseDTO userResponseDTO = new UserResponseDTO( id, name, nickname, email, hashedPassword, status );

        return userResponseDTO;
    }
}
