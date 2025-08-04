package com.cornielz.librarysystem.book.domain.services;

import com.cornielz.librarysystem.book.application.dto.BookCreationRequestDTO;
import com.cornielz.librarysystem.book.application.dto.BookResponseDTO;
import com.cornielz.librarysystem.book.application.dto.BookUpdateRequestDTO;
import com.cornielz.librarysystem.book.domain.model.Book;
import com.cornielz.librarysystem.book.domain.repository.BookRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookResponseDTO create(BookCreationRequestDTO dto) {
        Book book = new Book(UUID.randomUUID(), dto.title(), dto.description(), dto.language(), dto.publicationDate(), dto.price(), dto.condition(), dto.status());
        repository.save(book);
        return toDTO(book);
    }

    @Override
    public BookResponseDTO update(BookUpdateRequestDTO dto) {
        Book book = repository.findById(dto.id()).orElseThrow();
        book.update(dto.title(), dto.description(), dto.language(), dto.publicationDate(), dto.price(), dto.condition(), dto.status());
        repository.save(book);
        return toDTO(book);
    }

    @Override
    public void delete(UUID id) {
        repository.markAsDeleted(id);
    }

    @Override
    public BookResponseDTO getById(UUID id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<BookResponseDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private BookResponseDTO toDTO(Book book) {
        return new BookResponseDTO(book.id(), book.title(), book.description(), book.language(), book.publicationDate(), book.price(), book.condition(), book.status());
    }
}
