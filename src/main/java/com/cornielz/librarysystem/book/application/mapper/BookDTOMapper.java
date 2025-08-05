package com.cornielz.librarysystem.book.application.mapper;

import com.cornielz.librarysystem.book.application.dto.BookCreationRequestDTO;
import com.cornielz.librarysystem.book.application.dto.BookResponseDTO;
import com.cornielz.librarysystem.book.application.dto.BookUpdateRequestDTO;
import com.cornielz.librarysystem.book.domain.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookDTOMapper {
    Book toDomain(BookCreationRequestDTO dto);
    Book toDomain(BookUpdateRequestDTO dto);
    BookResponseDTO toResponseDTO(Book domain);
}