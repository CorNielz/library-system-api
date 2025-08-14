package com.cornielz.librarysystem.author.infrastructure.mapper;

import com.cornielz.librarysystem.author.domain.model.Author;
import com.cornielz.librarysystem.author.infrastructure.persistence.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorEntityMapper {
    AuthorEntity toEntity(Author author);
    Author toDomain(AuthorEntity entity);
}