package com.cornielz.librarysystem.author.infrastructure.persistence;

import com.cornielz.librarysystem.author.domain.model.AuthorStatus;
import com.cornielz.librarysystem.book.domain.model.BookStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
    private UUID id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
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

    public void rename(String newName) {
        this.name = newName;
    }

    public void rewriteBios(String newBios) {
        this.bios = newBios;
    }

    public void changeBirthDate(LocalDateTime newBirthDate) {
        this.birthDate = newBirthDate;
    }

    public void changeNationality(String newNationality) {
        this.nationality = newNationality;
    }

    public void updateStatus(AuthorStatus newAuthorStatus) {
        this.status = newAuthorStatus;
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