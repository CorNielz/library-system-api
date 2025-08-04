package com.cornielz.librarysystem.user.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import jakarta.persistence.*;
import com.cornielz.librarysystem.domain.user.UserStatus;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private UUID id;

    @Column(length = 120, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String nickname;

    @Column(length = 254, nullable = false)
    private String email;

    @Column(name = "hashed_password", nullable = false)
    private byte[] hashedPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;

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

    protected UserEntity() {

    }

    // Setters

    public void rename(String newName) {
        this.name = newName;
    }

    public void changeNickname(String newNickname) {
        this.nickname = newNickname;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

    public void updatePassword(byte[] newHashedPassword) {
        this.hashedPassword = newHashedPassword;
    }

    public void updateStatus(UserStatus newStatus) {
        this.status = newStatus;
    }

    // Getters

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getHashedPassword() {
        return hashedPassword;
    }

    public UserStatus getStatus() {
        return status;
    }
}