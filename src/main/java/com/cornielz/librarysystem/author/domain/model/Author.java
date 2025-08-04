package com.cornielz.librarysystem.author.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Author {
    private static final String NAME_REGEX = "^[\\p{L}]+([ '-][\\p{L}]+)*$";
    private static final String BIOS_REGEX = "^(.|\\s)*[a-zA-Z]+(.|\\s)*$";

    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_NATIONALITY_LENGTH = 32;

    private final UUID id;

    private String name;
    private String bios;

    private LocalDateTime birthDate;
    private String nationality;

    public Author(UUID id, String name, String bios, LocalDateTime birthDate, String nationality) {
        this.id = id;

        validateName(name);
        this.name = name;
        validateBios(bios);
        this.bios = bios;

        validateBirthDate(birthDate);
        this.birthDate = birthDate;
        validateNationality(nationality);
        this.nationality = nationality;
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

    private void validateBios(String bios) {
        if (bios == null || bios.isBlank()) {
            return;
        }

        if (!bios.matches(BIOS_REGEX)) {
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

    // Setters

    public void rename(String newName) {
        validateName(newName);
        this.name = newName;
    }

    public void rewriteBios(String newBios) {
        validateBios(newBios);
        this.bios = newBios;
    }

    public void changeBirthDate(LocalDateTime newBirthDate) {
        validateBirthDate(newBirthDate);
        this.birthDate = newBirthDate;
    }

    public void changeNationality(String newNationality) {
        validateNationality(newNationality);
        this.nationality = newNationality;
    }

    // Getters

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBios() {
        return this.bios;
    }

    public LocalDateTime getBirthDate() {
        return this.birthDate;
    }

    public String getNationality() {
        return this.nationality;
    }
}