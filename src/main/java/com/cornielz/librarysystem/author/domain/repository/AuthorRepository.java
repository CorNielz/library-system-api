package com.cornielz.librarysystem.author.domain.repository;

import com.cornielz.librarysystem.author.application.dto.AuthorSearchFilters;
import com.cornielz.librarysystem.author.domain.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository {
    Optional<Author> findById(UUID id);

    List<Author> findAllFiltered(AuthorSearchFilters searchFilters);

    void save(Author author);

    void markAsDeleted(UUID id);
}