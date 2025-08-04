package com.cornielz.librarysystem.domain.user;

import java.util.Objects;
import java.util.UUID;

public class User {
    private static final String NAME_REGEX = "^[\\p{L}]+([ '-][\\p{L}]+)*$";
    private static final String NICKNAME_REGEX = "^(.|\\s)*[a-zA-Z]+(.|\\s)*$";

    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_NICKNAME_LENGTH = 32;
    private static final int MAX_EMAIL_LENGTH = 254;

    private final UUID id;

    private String name;
    private String nickname;

    private String email;
    private byte[] hashedPassword;

    private UserStatus status;

    private UUID roleId;

    public User(UUID id, String name, String nickname, String email, byte[] hashedPassword, UserStatus status, UUID roleId) {
        validateId(id);
        validateId(roleId);
        validateName(name);
        validateNickname(nickname);
        validateEmail(email);
        validateHashedPassword(hashedPassword);
        validateStatus(status);

        this.id = id;

        this.name = name;
        this.nickname = nickname;

        this.email = email;
        this.hashedPassword = hashedPassword;

        this.status = status;

        this.roleId = roleId;
    }

    // Validations

    private void validateId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("Name cannot exceed %s characters", MAX_NAME_LENGTH));
        }

        if (!name.matches(NAME_REGEX)){
            throw new IllegalArgumentException("Name cannot contain illegal characters");
        }
    }

    private void validateNickname(String nickname) {
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("Nickname cannot be null or blank");
        }

        if (nickname.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("Nickname cannot exceed %s characters", MAX_NICKNAME_LENGTH));
        }

        if (!nickname.matches(NAME_REGEX)){
            throw new IllegalArgumentException("Nickname cannot contain illegal characters");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
    }

    private void validateHashedPassword(byte[] hashedPassword) {

    }

    private void validateStatus(UserStatus status){
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
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