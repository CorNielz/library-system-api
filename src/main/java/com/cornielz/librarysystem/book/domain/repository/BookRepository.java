package com.cornielz.librarysystem.book.domain.repository;

import com.cornielz.librarysystem.book.domain.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
    Optional<Book> findById(UUID id);

    Optional<Book> findByTitle(String title);

    List<Book> findAll();

    void save(Book book);

    void markAsDeleted(UUID id);
}