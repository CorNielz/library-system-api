package com.cornielz.librarysystem.book.infrastructure.repository;

import com.cornielz.librarysystem.author.application.dto.AuthorSearchFilters;
import com.cornielz.librarysystem.author.domain.model.Author;
import com.cornielz.librarysystem.book.application.dto.BookSearchFilters;
import com.cornielz.librarysystem.book.domain.model.Book;
import com.cornielz.librarysystem.book.domain.model.BookStatus;
import com.cornielz.librarysystem.book.domain.repository.BookRepository;
import com.cornielz.librarysystem.book.infrastructure.mapper.BookEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository jpaRepository;
    private final BookEntityMapper mapper;

    @Override
    public Optional<Book> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Book> findAllFiltered(BookSearchFilters searchFilters) {
        return jpaRepository.findAllFiltered(
                        searchFilters.title(),
                        searchFilters.language(),
                        searchFilters.publicationDateFrom(),
                        searchFilters.publicationDateTo(),
                        searchFilters.priceMinimum(),
                        searchFilters.priceMaximum(),
                        searchFilters.condition(),
                        searchFilters.status()
                )
                .orElse(new ArrayList<>())
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Book book) {
        jpaRepository.save(mapper.toEntity(book));
    }

    @Override
    public void markAsDeleted(UUID id) {
        jpaRepository.findById(id).ifPresent(entity -> {
            entity.updateBookStatus(BookStatus.DELETED);
            jpaRepository.save(entity);
        });
    }
}