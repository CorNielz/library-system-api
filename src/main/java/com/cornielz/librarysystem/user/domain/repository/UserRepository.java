package com.cornielz.librarysystem.user.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.cornielz.librarysystem.user.domain.model.User;

public interface UserRepository {
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);

    List<User> findAllByName(String name);
    List<User> findAll();

    void save(User user);
    void markAsDeleted(UUID id);
}