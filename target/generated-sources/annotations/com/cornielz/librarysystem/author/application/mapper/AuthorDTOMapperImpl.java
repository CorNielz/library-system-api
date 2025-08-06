package com.cornielz.librarysystem.author.application.mapper;

import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;
import com.cornielz.librarysystem.author.domain.model.Author;
import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T08:58:39-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class AuthorDTOMapperImpl implements AuthorDTOMapper {

    @Override
    public Author toDomain(AuthorCreationRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        String name = null;
        String biography = null;
        LocalDateTime birthDate = null;
        String nationality = null;
        AuthorStatus status = null;

        name = dto.name();
        biography = dto.biography();
        birthDate = dto.birthDate();
        nationality = dto.nationality();
        status = dto.status();

        UUID id = null;

        Author author = new Author( id, name, biography, birthDate, nationality, status );

        return author;
    }

    @Override
    public Author toDomain(AuthorUpdateRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String biography = null;
        LocalDateTime birthDate = null;
        String nationality = null;
        AuthorStatus status = null;

        id = dto.id();
        name = dto.name();
        biography = dto.biography();
        birthDate = dto.birthDate();
        nationality = dto.nationality();
        status = dto.status();

        Author author = new Author( id, name, biography, birthDate, nationality, status );

        return author;
    }

    @Override
    public AuthorResponseDTO toResponseDTO(Author domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String biography = null;
        LocalDateTime birthDate = null;
        String nationality = null;
        AuthorStatus status = null;

        id = domain.getId();
        name = domain.getName();
        biography = domain.getBiography();
        birthDate = domain.getBirthDate();
        nationality = domain.getNationality();
        status = domain.getStatus();

        AuthorResponseDTO authorResponseDTO = new AuthorResponseDTO( id, name, biography, birthDate, nationality, status );

        return authorResponseDTO;
    }
}
