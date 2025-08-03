package com.cornielz.librarysystem.domain.review;

import java.util.Objects;
import java.util.UUID;

public class Review {
    private final UUID id;

    private UUID userId;
    private UUID bookId;

    private String title;
    private String comment;
    private Integer score;

    public Review(UUID id, UUID userId, UUID bookId, String title, String comment, Integer score) {
        this.id = id;

        this.userId = userId;
        this.bookId = bookId;

        this.title = title;
        this.comment = comment;
        this.score = score;
    }
}