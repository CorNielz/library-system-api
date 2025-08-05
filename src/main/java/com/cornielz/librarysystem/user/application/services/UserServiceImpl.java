package com.cornielz.librarysystem.user.application.services;

import com.cornielz.librarysystem.user.application.dto.UserCreationRequestDTO;
import com.cornielz.librarysystem.user.application.dto.UserResponseDTO;
import com.cornielz.librarysystem.user.application.dto.UserUpdateRequestDTO;
import com.cornielz.librarysystem.user.domain.model.User;
import com.cornielz.librarysystem.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponseDTO create(UserCreationRequestDTO dto) {
        User user = new User(UUID.randomUUID(), dto.name(), dto.nickname(), dto.email(), dto.hashedPassword(), dto.status());
        repository.save(user);
        return toDTO(user);
    }

    @Override
    public UserResponseDTO update(UserUpdateRequestDTO dto) {
        User user = new User(dto.id(), dto.name(), dto.nickname(), dto.email(), dto.hashedPassword(), dto.status());
        repository.save(user);
        return toDTO(user);
    }

    @Override
    public void delete(UUID id) {
        repository.markAsDeleted(id);
    }

    @Override
    public UserResponseDTO getById(UUID id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<UserResponseDTO> listAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getNickname(), user.getEmail(), user.getHashedPassword(), user.getStatus());
    }
}