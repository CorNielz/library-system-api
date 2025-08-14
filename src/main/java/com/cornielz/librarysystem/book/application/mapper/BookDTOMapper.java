package com.cornielz.librarysystem.book.application.mapper;

import com.cornielz.librarysystem.book.application.dto.BookCreationRequestDTO;
import com.cornielz.librarysystem.book.application.dto.BookReplaceRequestDTO;
import com.cornielz.librarysystem.book.application.dto.BookResponseDTO;
import com.cornielz.librarysystem.book.application.dto.BookUpdateRequestDTO;
import com.cornielz.librarysystem.book.domain.model.Book;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface BookDTOMapper {
    Book toDomain(BookCreationRequestDTO dto, UUID id);

    Book toDomain(BookReplaceRequestDTO dto);

    Book toDomain(BookUpdateRequestDTO dto);

    BookResponseDTO toResponseDTO(Book domain);

    void replaceBookFromDto(BookReplaceRequestDTO dto, @MappingTarget Book entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromDto(BookUpdateRequestDTO dto, @MappingTarget Book entity);
}