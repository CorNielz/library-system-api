package com.cornielz.librarysystem.book.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cornielz.librarysystem.book.infrastructure.persistence.BookEntity;

public interface SpringDataBookRepository extends JpaRepository<BookEntity, UUID> {

}