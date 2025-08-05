package com.cornielz.librarysystem.book.infrastructure.persistence;

import com.cornielz.librarysystem.book.domain.model.Book;
import com.cornielz.librarysystem.book.domain.model.BookStatus;
import com.cornielz.librarysystem.book.domain.repository.BookRepository;
import com.cornielz.librarysystem.book.infrastructure.mapper.BookEntityMapper;
import com.cornielz.librarysystem.book.infrastructure.repository.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
    public Optional<Book> findByTitle(String title) {
        return jpaRepository.findByTitle(title)
                .map(mapper::toDomain);
    }

    @Override
    public List<Book> findAll() {
        return jpaRepository.findAll()
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