package com.cornielz.librarysystem.user.infrastructure.persistence;

import com.cornielz.librarysystem.user.domain.model.User;
import com.cornielz.librarysystem.user.domain.model.UserStatus;
import com.cornielz.librarysystem.user.domain.repository.UserRepository;
import com.cornielz.librarysystem.user.infrastructure.mapper.UserEntityMapper;
import com.cornielz.librarysystem.user.infrastructure.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final UserEntityMapper mapper;

    @Override
    public void save(User user) {
        jpaRepository.save(mapper.toEntity(user));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void markAsDeleted(UUID id) {
        jpaRepository.findById(id).ifPresent(entity -> {
            entity.updateStatus(UserStatus.DELETED);
            jpaRepository.save(entity);
        });
    }
}