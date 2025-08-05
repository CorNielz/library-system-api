package com.cornielz.librarysystem.book.infrastructure.repository;

import com.cornielz.librarysystem.book.infrastructure.persistence.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookJpaRepository extends JpaRepository<BookEntity, UUID> {
    Optional<BookEntity> findByTitle(String title);
    List<BookEntity> findAllByAuthorNameIgnoreCase(String author);
}