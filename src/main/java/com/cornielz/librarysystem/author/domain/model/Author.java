package com.cornielz.librarysystem.author.domain.model;

import com.cornielz.librarysystem.book.domain.model.BookStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Author {
    private static final String NAME_REGEX = "^[\\p{L}]+([ '-][\\p{L}]+)*$";
    private static final String BIOGRAPHY_REGEX = "^(.|\\s)*[a-zA-Z]+(.|\\s)*$";

    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_NATIONALITY_LENGTH = 32;

    private final UUID id;

    private String name;
    private String biography;

    private LocalDateTime birthDate;
    private String nationality;

    private AuthorStatus status;

    public Author(UUID id, String name, String biography, LocalDateTime birthDate, String nationality, AuthorStatus status) {
        validateName(name);
        validateBiography(biography);
        validateBirthDate(birthDate);
        validateNationality(nationality);
        validateStatus(status);

        this.id = id;

        this.name = name;
        this.biography = biography;

        this.birthDate = birthDate;
        this.nationality = nationality;

        this.status = status;
    }

    // Validations

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name cannot exceed 100 characters");
        }

        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("Name cannot contain illegal characters");
        }
    }

    private void validateBiography(String biography) {
        if (biography == null || biography.isBlank()) {
            return;
        }

        if (!biography.matches(BIOGRAPHY_REGEX)) {
            throw new IllegalArgumentException("Biography cannot contain illegal characters");
        }
    }

    private void validateBirthDate(LocalDateTime birthDate) {
        if (birthDate == null) {
            return;
        }

        LocalDateTime currentMoment = LocalDateTime.now();

        if (birthDate.isAfter(currentMoment)) {
            throw new IllegalArgumentException("Birth date cannot be in the future");
        }
    }

    private void validateNationality(String nationality) {
        if (nationality == null || nationality.isBlank()) {
            throw new IllegalArgumentException("Nationality cannot be null or blank");
        }

        if (nationality.length() > MAX_NATIONALITY_LENGTH) {
            throw new IllegalArgumentException("Nationality cannot exceed 32 characters");
        }
    }

    private void validateStatus(AuthorStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
    }

    // Setters

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setBiography(String biography) {
        validateBiography(biography);
        this.biography = biography;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        validateBirthDate(birthDate);
        this.birthDate = birthDate;
    }

    public void setNationality(String nationality) {
        validateNationality(nationality);
        this.nationality = nationality;
    }

    public void setStatus(AuthorStatus status) {
        validateStatus(status);
        this.status = status;
    }

    // Getters

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public AuthorStatus getStatus() {
        return status;
    }
}