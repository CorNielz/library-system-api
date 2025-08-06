package com.cornielz.librarysystem.author.infrastructure.mapper;

import com.cornielz.librarysystem.author.domain.model.Author;
import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import com.cornielz.librarysystem.author.infrastructure.persistence.AuthorEntity;
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
public class AuthorEntityMapperImpl implements AuthorEntityMapper {

    @Override
    public AuthorEntity toEntity(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorEntity authorEntity = new AuthorEntity();

        return authorEntity;
    }

    @Override
    public Author toDomain(AuthorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        LocalDateTime birthDate = null;
        String nationality = null;

        id = entity.getId();
        name = entity.getName();
        birthDate = entity.getBirthDate();
        nationality = entity.getNationality();

        String biography = null;
        AuthorStatus status = null;

        Author author = new Author( id, name, biography, birthDate, nationality, status );

        return author;
    }
}
