package com.cornielz.librarysystem.domain.author;

import java.util.Objects;
import java.time.LocalDateTime;

public class Author {
    private final UUID id;

    private String name;
    private String bios;

    private LocalDateTime birthDate;
    private String nationality;

    public Author(UUID id, String name, String bios, LocalDateTime birthDate, String nationality) {
        this.id = id;

        this.name = name;
        this.bios = bios;

        this.birthDate = birthDate;
        this.nationality = nationality;
    }

    // Setters

    public void rename(String newName){
        this.name = newName;
    }

    public void rewriteBios(String newBios){
        this.bios = newBios;
    }

    public void changeBirthDate(LocalDateTime newBirthDate){
        this.birthDate = newBirthDate;
    }

    public void changeNationality(String newNationality){
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