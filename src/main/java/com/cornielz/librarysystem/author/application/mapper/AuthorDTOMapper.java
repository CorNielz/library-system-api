package com.cornielz.librarysystem.author.application.mapper;

import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;
import com.cornielz.librarysystem.author.domain.model.Author;
import com.cornielz.librarysystem.author.application.dto.AuthorReplaceRequestDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AuthorDTOMapper {
    Author toDomain(AuthorCreationRequestDTO dto, UUID id);

    Author toDomain(AuthorReplaceRequestDTO dto);

    Author toDomain(AuthorUpdateRequestDTO dto);

    AuthorResponseDTO toResponseDTO(Author domain);

    void replaceAuthorFromDto(AuthorReplaceRequestDTO dto, @MappingTarget Author entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAuthorFromDto(AuthorUpdateRequestDTO dto, @MappingTarget Author entity);
}