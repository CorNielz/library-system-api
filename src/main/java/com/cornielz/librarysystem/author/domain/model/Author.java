package com.cornielz.librarysystem.domain.author;

import java.util.Objects;
import java.time.LocalDateTime

public class Author {
    private final UUID id;

    private String name;
    private String bios;

    private LocalDateTime birthDdate;
    private String nationality;

    public Author(UUID id, String name, String bios, LocalDateTime birthDdate, String nationality) {
        this.id = id;

        this.name = name;
        this.bios = bios;

        this.birthDdate = birthDdate;
        this.nationality = nationality;
    }

    // Setters


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

    public LocalDateTime getBirthDdate() {
        return this.birthDdate;
    }

    public String getNationality() {
        return this.nationality;
    }
}