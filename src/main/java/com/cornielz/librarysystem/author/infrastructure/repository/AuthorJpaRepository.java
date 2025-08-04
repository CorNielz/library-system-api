package com.cornielz.librarysystem.author.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cornielz.librarysystem.author.infrastructure.persistence.AuthorEntity;

public interface SpringDataAuthorRepository extends JpaRepository<AuthorEntity, UUID> {

}