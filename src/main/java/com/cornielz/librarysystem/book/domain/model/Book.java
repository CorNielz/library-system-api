package com.cornielz.librarysystem.domain.book;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Book {
    private final UUID id;

    private String title;
    private String description;
    private String language;

    private LocalDateTime publicationDate;

    private BigDecimal price;
    private BookCondition condition;

    private BookStatus status;

    public Book(UUID id, String title, String description, String language, LocalDateTime publicationDate, BigDecimal price, BookCondition condition, BookStatus status) {
        this.id = id;

        this.title = title;
        this.description = description;
        this.language = language;

        this.publicationDate = publicationDate;

        this.price = price;
        this.condition = condition;

        this.status = status;
    }

    // Setters

    // Getters

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BookCondition condition{
        return condition
    }

    public BookStatus getStatus() {
        return status;
    }
}