package com.cornielz.librarysystem.domain.book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
    Optional<Book> findById(UUID id);
    List<Book> findAll();

    void save(Book book);
    void deleteById(UUID id);
}