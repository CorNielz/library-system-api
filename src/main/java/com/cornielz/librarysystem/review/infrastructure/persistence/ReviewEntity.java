package com.cornielz.librarysystem.review.infrastructure.persistence;

import com.cornielz.librarysystem.book.infrastructure.persistence.BookEntity;
import com.cornielz.librarysystem.user.infrastructure.persistence.UserEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reviews")
public class ReviewEntity {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @Column(length = 120, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = false)
    private int score;

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

    public ReviewEntity() {

    }

    // Setters

    public void updateTitle(String newTitle) {
        this.title = newTitle;
    }

    public void updateComment(String newComment) {
        this.comment = newComment;
    }

    public void updateScore(int newScore) {
        this.score = newScore;
    }

    // Getters


    public UUID getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public BookEntity getBook() {
        return book;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public int getScore() {
        return score;
    }
}