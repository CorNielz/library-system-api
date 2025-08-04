package com.cornielz.librarysystem.book.domain.services;

import java.util.List;
import java.util.UUID;
import com.cornielz.librarysystem.book.application.dto.BookCreationRequestDTO;
import com.cornielz.librarysystem.book.application.dto.BookResponseDTO;
import com.cornielz.librarysystem.book.application.dto.BookUpdateRequestDTO;

public interface BookService {
    BookResponseDTO create(BookCreationRequestDTO request);
    BookResponseDTO update(BookUpdateRequestDTO request);
    void delete(UUID id);
    BookResponseDTO getById(UUID id);
    List<BookResponseDTO> listAll();
}
