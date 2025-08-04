package com.cornielz.librarysystem.infrastructure.persistence.author;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import jakarta.persistence.*;
import com.cornielz.librarysystem.domain.author.AuthorStatus;

@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
    private UUID id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "text")
    private String bios;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(length = 32, nullable = false)
    private String nationality;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthorStatus status;

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