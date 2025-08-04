package com.cornielz.librarysystem.application.book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    BookResponseDTO create(BookCreationRequestDTO request);
    BookResponseDTO update(BookUpdateRequestDTO request);
    void delete(UUID id);
    BookResponseDTO getById(UUID id);
    List<BookResponseDTO> listAll();
}
