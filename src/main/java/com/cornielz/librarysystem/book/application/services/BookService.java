package com.cornielz.librarysystem.book.application.services;

import com.cornielz.librarysystem.book.application.dto.BookCreationRequestDTO;
import com.cornielz.librarysystem.book.application.dto.BookResponseDTO;
import com.cornielz.librarysystem.book.application.dto.BookSearchFilters;
import com.cornielz.librarysystem.book.application.dto.BookUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface BookService {
    BookResponseDTO create(BookCreationRequestDTO requestDto);

    BookResponseDTO update(BookUpdateRequestDTO requestDto);

    void delete(UUID id);

    BookResponseDTO getById(UUID id);

    List<BookResponseDTO> searchWithFilters(BookSearchFilters searchFilters);
}
