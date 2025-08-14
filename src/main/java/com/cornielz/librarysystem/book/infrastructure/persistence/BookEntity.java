package com.cornielz.librarysystem.book.infrastructure.persistence;

import com.cornielz.librarysystem.book.domain.model.BookCondition;
import com.cornielz.librarysystem.book.domain.model.BookStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    private UUID id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 10, nullable = false)
    private String language;

    @Column(name = "publication_date")
    private LocalDateTime publicationDate;

    @Column(precision = 8, scale = 2, nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookCondition condition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_update_at", nullable = false)
    private LocalDateTime lastUpdateAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.lastUpdateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdateAt = LocalDateTime.now();
    }

    public BookEntity() {

    }

    // Setters

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCondition(BookCondition condition) {
        this.condition = condition;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
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