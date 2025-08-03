package com.cornielz.librarysystem.domain.user;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final UUID id;

    private String name;
    private String nickname;

    private String email;
    private byte[] hashedPassword;

    private UserStatus status;

    private UUID roleId;

    public User(UUID id, String name, String nickname, String email, byte[] hashedPassword, UserStatus status, UUID roleId) {
        this.id = id;

        this.name = name;
        this.nickname = nickname;

        this.email = email;
        this.hashedPassword = hashedPassword;

        this.status = status;

        this.roleId = roleId;
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

    public void assignNewRole(UUID newRoleId) {
        this.roleId = newRoleId;
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

    public UserStatus  getStatus() {
        return status;
    }

    public UUID getRoleId() {
        return roleId;
    }
}