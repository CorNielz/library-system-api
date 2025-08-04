package com.cornielz.librarysystem.infrastructure.author;

import com.cornielz.librarysystem.domain.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

public interface SpringDataAuthorRepository extends JpaRepository<AuthorEntity, UUID> {

}