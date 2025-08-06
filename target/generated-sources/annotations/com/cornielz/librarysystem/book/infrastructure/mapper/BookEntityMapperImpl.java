package com.cornielz.librarysystem.book.infrastructure.mapper;

import com.cornielz.librarysystem.book.domain.model.Book;
import com.cornielz.librarysystem.book.domain.model.BookCondition;
import com.cornielz.librarysystem.book.domain.model.BookStatus;
import com.cornielz.librarysystem.book.infrastructure.persistence.BookEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T08:58:39-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class BookEntityMapperImpl implements BookEntityMapper {

    @Override
    public BookEntity toEntity(Book book) {
        if ( book == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        return bookEntity;
    }

    @Override
    public Book toDomain(BookEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String title = null;
        String description = null;
        String language = null;
        LocalDateTime publicationDate = null;
        BigDecimal price = null;
        BookCondition condition = null;
        BookStatus status = null;

        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        language = entity.getLanguage();
        publicationDate = entity.getPublicationDate();
        price = entity.getPrice();
        condition = entity.getCondition();
        status = entity.getStatus();

        Book book = new Book( id, title, description, language, publicationDate, price, condition, status );

        return book;
    }
}
