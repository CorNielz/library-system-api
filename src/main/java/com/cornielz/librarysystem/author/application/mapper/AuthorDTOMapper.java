package com.cornielz.librarysystem.author.application.mapper;

import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;
import com.cornielz.librarysystem.author.domain.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorDTOMapper {
    Author toDomain(AuthorCreationRequestDTO dto);
    Author toDomain(AuthorUpdateRequestDTO dto);
    AuthorResponseDTO toResponseDTO(Author domain);
}