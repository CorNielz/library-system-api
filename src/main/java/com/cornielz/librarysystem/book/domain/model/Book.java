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

    public void rename(String newTitle){
        this.title = newTitle;
    }

    public void rewriteDescription(String newDescription){
        this.description = newDescription;
    }

    public void updateLanguage(String newLanguage){
        this.language = newLanguage;
    }

    public void updatePublicationDate(LocalDateTime newPublicationDate){
        this.publicationDate = newPublicationDate;
    }

    public void updatePrice(BigDecimal newPrice){
        this.price = newPrice;
    }

    public void updateBookCondition(BookCondition newBookCondition){
        this.condition = newBookCondition;
    }

    public void updateBookStatus(BookStatus newBookStatus){
        this.status = newBookStatus;
    }

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

    public BookCondition getCondition() {
        return condition;
    }

    public BookStatus getStatus() {
        return status;
    }
}