package com.cornielz.librarysystem.author.infrastructure.repository;

import com.cornielz.librarysystem.author.infrastructure.persistence.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataAuthorRepository extends JpaRepository<AuthorEntity, UUID> {

}