package com.cornielz.librarysystem.author.infrastructure.repository;

import com.cornielz.librarysystem.author.application.dto.AuthorSearchFilters;
import com.cornielz.librarysystem.author.domain.model.Author;
import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import com.cornielz.librarysystem.author.domain.repository.AuthorRepository;
import com.cornielz.librarysystem.author.infrastructure.mapper.AuthorEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorJpaRepository jpaRepository;
    private final AuthorEntityMapper mapper;

    @Override
    public Optional<Author> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Author> findAllFiltered(AuthorSearchFilters searchFilters) {
        return jpaRepository.findAllFiltered(
                searchFilters.name(),
                searchFilters.nationality(),
                searchFilters.status(),
                searchFilters.birthDateFrom(),
                searchFilters.birthDateTo()
            )
            .orElse(new ArrayList<>())
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void save(Author author) {
        jpaRepository.save(mapper.toEntity(author));
    }

    @Override
    public void markAsDeleted(UUID id) {
        jpaRepository.findById(id).ifPresent(entity -> {
            entity.updateStatus(AuthorStatus.DELETED);
            jpaRepository.save(entity);
        });
    }
}