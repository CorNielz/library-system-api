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
}