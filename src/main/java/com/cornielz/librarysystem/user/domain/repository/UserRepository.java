package com.cornielz.librarysystem.user.domain.repository;

import com.cornielz.librarysystem.user.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    void save(User user);

    void markAsDeleted(UUID id);
}