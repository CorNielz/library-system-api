package com.cornielz.librarysystem.author.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository {
    Optional<Author> findById(UUID id);
    List<Author> findAll();

    void save(Author author);
    void markAsDeleted(UUID id);
}