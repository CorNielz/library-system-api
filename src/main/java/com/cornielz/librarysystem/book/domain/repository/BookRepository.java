package com.cornielz.librarysystem.book.domain.repository;

import com.cornielz.librarysystem.author.application.dto.AuthorSearchFilters;
import com.cornielz.librarysystem.author.domain.model.Author;
import com.cornielz.librarysystem.book.application.dto.BookSearchFilters;
import com.cornielz.librarysystem.book.domain.model.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
    Optional<Book> findById(UUID id);

    List<Book> findAllFiltered(BookSearchFilters searchFilters);

    void save(Book book);

    void markAsDeleted(UUID id);
}