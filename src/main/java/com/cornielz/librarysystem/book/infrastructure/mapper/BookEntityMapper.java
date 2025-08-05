package com.cornielz.librarysystem.book.infrastructure.mapper;

import com.cornielz.librarysystem.book.domain.model.Book;
import com.cornielz.librarysystem.book.infrastructure.persistence.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookEntityMapper {
    BookEntity toEntity(Book book);
    Book toDomain(BookEntity entity);
}