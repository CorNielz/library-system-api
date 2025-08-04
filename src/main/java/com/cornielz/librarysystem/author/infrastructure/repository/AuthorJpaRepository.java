package com.cornielz.librarysystem.infrastructure.author.AuthorEntity;

import com.cornielz.librarysystem.domain.author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SpringDataAuthorRepository extends JpaRepository<AuthorEntity, UUID> {

}