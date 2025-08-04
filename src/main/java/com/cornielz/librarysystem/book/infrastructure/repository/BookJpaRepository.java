package com.cornielz.librarysystem.book.infrastructure.repository;

import com.cornielz.librarysystem.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

public interface SpringDataBookRepository extends JpaRepository<BookEntity, UUID> {

}