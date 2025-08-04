package com.cornielz.librarysystem.domain.review;

import java.util.Objects;
import java.util.UUID;

public class Review {
    private static final String TITLE_REGEX = "^[\\p{L}0-9 .,'!?:;-]+$";
    private static final String COMMENT_REGEX = "^[\\p{L}0-9 .,'!?:;\\-\\s]*$";

    private static final int MAX_TITLE_LENGTH = 120;
    private static final int MAX_SCORE_RATING = 10;

    private final UUID id;

    private final UUID userId;
    private final UUID bookId;

    private String title;
    private String comment;
    private int score;

    public Review(UUID id, UUID userId, UUID bookId, String title, String comment, int score) {
        validateId(id);
        validateId(userId);
        validateId(bookId);

        validateTitle(title);
        validateComment(comment);
        validateScore(score);

        this.id = id;

        this.userId = userId;
        this.bookId = bookId;

        this.title = title;
        this.comment = comment;
        this.score = score;
    }

    // Validations

    private void validateId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
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

    private void validateComment(String comment) {
        if (comment == null || comment.isBlank()) {
            return;
        }

        if (!comment.matches(COMMENT_REGEX)){
            throw new IllegalArgumentException("Comment cannot contain illegal characters");
        }
    }

    private void validateScore(int score) {
        if (score < 0){
            throw new IllegalArgumentException("Score cannot be lower than 0");
        }

        if (score > MAX_SCORE_RATING){
            throw new IllegalArgumentException(String.format("Score cannot be higher than %s", MAX_SCORE_RATING));
        }
    }

    // Setters

    public void updateTitle(String newTitle) {
        validateTitle(newTitle);
        this.title = newTitle;
    }

    public void updateComment(String newComment) {
        validateComment(newComment);
        this.comment = newComment;
    }

    public void updateScore(int newScore) {
        validateScore(newScore);
        this.score = newScore;
    }

    // Getters


    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getBookId() {
        return bookId;
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