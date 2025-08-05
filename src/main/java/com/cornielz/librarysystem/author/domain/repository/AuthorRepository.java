package com.cornielz.librarysystem.author.domain.repository;

import com.cornielz.librarysystem.author.domain.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository {
    Optional<Author> findById(UUID id);

    Optional<Author> findByName(String name);

    List<Author> findAll();

    void save(Author author);

    void markAsDeleted(UUID id);
}