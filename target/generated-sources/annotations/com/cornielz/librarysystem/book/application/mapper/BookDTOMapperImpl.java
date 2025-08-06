package com.cornielz.librarysystem.book.application.mapper;

import com.cornielz.librarysystem.book.application.dto.BookCreationRequestDTO;
import com.cornielz.librarysystem.book.application.dto.BookResponseDTO;
import com.cornielz.librarysystem.book.application.dto.BookUpdateRequestDTO;
import com.cornielz.librarysystem.book.domain.model.Book;
import com.cornielz.librarysystem.book.domain.model.BookCondition;
import com.cornielz.librarysystem.book.domain.model.BookStatus;
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
public class BookDTOMapperImpl implements BookDTOMapper {

    @Override
    public Book toDomain(BookCreationRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        String title = null;
        String description = null;
        String language = null;
        LocalDateTime publicationDate = null;
        BigDecimal price = null;
        BookCondition condition = null;
        BookStatus status = null;

        title = dto.title();
        description = dto.description();
        language = dto.language();
        publicationDate = dto.publicationDate();
        price = dto.price();
        condition = dto.condition();
        status = dto.status();

        UUID id = null;

        Book book = new Book( id, title, description, language, publicationDate, price, condition, status );

        return book;
    }

    @Override
    public Book toDomain(BookUpdateRequestDTO dto) {
        if ( dto == null ) {
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

        id = dto.id();
        title = dto.title();
        description = dto.description();
        language = dto.language();
        publicationDate = dto.publicationDate();
        price = dto.price();
        condition = dto.condition();
        status = dto.status();

        Book book = new Book( id, title, description, language, publicationDate, price, condition, status );

        return book;
    }

    @Override
    public BookResponseDTO toResponseDTO(Book domain) {
        if ( domain == null ) {
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

        id = domain.getId();
        title = domain.getTitle();
        description = domain.getDescription();
        language = domain.getLanguage();
        publicationDate = domain.getPublicationDate();
        price = domain.getPrice();
        condition = domain.getCondition();
        status = domain.getStatus();

        BookResponseDTO bookResponseDTO = new BookResponseDTO( id, title, description, language, publicationDate, price, condition, status );

        return bookResponseDTO;
    }
}
