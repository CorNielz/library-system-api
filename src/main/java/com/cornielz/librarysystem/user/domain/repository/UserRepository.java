package com.cornielz.librarysystem.user.domain.repository;

import com.cornielz.librarysystem.user.application.dto.UserReplaceRequestDTO;
import com.cornielz.librarysystem.user.application.dto.UserSearchFilters;
import com.cornielz.librarysystem.user.application.dto.UserUpdateRequestDTO;
import com.cornielz.librarysystem.user.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> getById(UUID id);

    List<User> findAllFiltered(UserSearchFilters searchFilters);

    void save(User user);

    void markAsDeleted(UUID id);
}