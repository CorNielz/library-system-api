package com.cornielz.librarysystem.domain.book;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Book {
    private static final String TITLE_REGEX = "^[\\p{L}0-9 .,'!?:;-]+$";
    private static final String DESCRIPTION_REGEX = "^(.|\\s)*[a-zA-Z]+(.|\\s)*$";

    private static final int MAX_TITLE_LENGTH = 120;
    private static final int MAX_LANGUAGE_LENGTH = 10;
    private static final int MAX_PRICE_PRECISION = 8;
    private static final int MAX_PRICE_SCALE = 2;


    private final UUID id;

    private String title;
    private String description;
    private String language;

    private LocalDateTime publicationDate;

    private BigDecimal price;
    private BookCondition condition;

    private BookStatus status;

    public Book(UUID id, String title, String description, String language, LocalDateTime publicationDate, BigDecimal price, BookCondition condition, BookStatus status) {
        validateId(id);
        validateTitle(title);
        validateDescription(description);
        validateLanguage(language);
        validatePublicationDate(publicationDate);
        validatePrice(price);
        validateCondition(condition);
        validateStatus(status);

        this.id = id;

        this.title = title;
        this.description = description;
        this.language = language;

        this.publicationDate = publicationDate;

        this.price = price;
        this.condition = condition;

        this.status = status;
    }

    private void validateId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }

        if (title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException(String.format("Title cannot exceed %s characters", MAX_TITLE_LENGTH));
        }

        if (!title.matches(TITLE_REGEX)){
            throw new IllegalArgumentException("Title cannot contain illegal characters");
        }
    }

    private void validateDescription(String description) {
        if (description == null || description.isBlank()) {
            return;
        }

        if (!description.matches(DESCRIPTION_REGEX)){
            throw new IllegalArgumentException("Description cannot contain illegal characters");
        }
    }

    private void validateLanguage(String language) {
        if (language == null || language.isBlank()) {
            throw new IllegalArgumentException("Language cannot be null or blank");
        }

        if (language.length() > MAX_LANGUAGE_LENGTH) {
            throw new IllegalArgumentException(String.format("Language cannot exceed %s characters", MAX_LANGUAGE_LENGTH));
        }
    }

    private void validatePublicationDate(LocalDateTime publicationDate) {
        if (publicationDate == null) {
            return;
        }

        LocalDateTime currentMoment = LocalDateTime.now();

        if (publicationDate.isAfter(currentMoment)) {
            throw new IllegalArgumentException("Publication date cannot be in the future");
        }
    }

    private void validatePrice(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        if (price.scale() > MAX_PRICE_SCALE) {
            throw new IllegalArgumentException(String.format("Price cannot have more than %s decimal places", MAX_PRICE_SCALE));
        }

        if (price.precision() > MAX_PRICE_PRECISION) {
            throw new IllegalArgumentException(String.format("Price cannot exceed %s total digits", MAX_PRICE_PRECISION));
        }
    }

    private void validateCondition(BookCondition condition){
        if (condition == null) {
            throw new IllegalArgumentException("Condition cannot be null");
        }
    }

    private void validateStatus(BookStatus status){
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
    }

    // Setters

    public void rename(String newTitle){
        validateTitle(newTitle);
        this.title = newTitle;
    }

    public void rewriteDescription(String newDescription){
        validateDescription(newDescription);
        this.description = newDescription;
    }

    public void updateLanguage(String newLanguage){
        validateLanguage(newLanguage);
        this.language = newLanguage;
    }

    public void updatePublicationDate(LocalDateTime newPublicationDate){
        validatePublicationDate(newPublicationDate);
        this.publicationDate = newPublicationDate;
    }

    public void updatePrice(BigDecimal newPrice){
        validatePrice(newPrice);
        this.price = newPrice;
    }

    public void updateBookCondition(BookCondition newBookCondition){
        validateCondition(newBookCondition);
        this.condition = newBookCondition;
    }

    public void updateBookStatus(BookStatus newBookStatus){
        validateStatus(newBookStatus);
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