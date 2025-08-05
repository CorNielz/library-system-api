package com.cornielz.librarysystem.user.application.services;

import com.cornielz.librarysystem.user.application.dto.UserCreationRequestDTO;
import com.cornielz.librarysystem.user.application.dto.UserResponseDTO;
import com.cornielz.librarysystem.user.application.dto.UserUpdateRequestDTO;
import com.cornielz.librarysystem.user.application.mapper.UserDTOMapper;
import com.cornielz.librarysystem.user.domain.model.User;
import com.cornielz.librarysystem.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserDTOMapper dtoMapper;

    public UserServiceImpl(UserRepository repository, UserDTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public UserResponseDTO create(UserCreationRequestDTO dto) {
        User user = dtoMapper.toDomain(dto);
        repository.save(user);
        return dtoMapper.toResponseDTO(user);
    }

    @Override
    public UserResponseDTO update(UserUpdateRequestDTO dto) {
        User user = dtoMapper.toDomain(dto);
        repository.save(user);
        return dtoMapper.toResponseDTO(user);
    }

    @Override
    public void delete(UUID id) {
        repository.markAsDeleted(id);
    }

    @Override
    public UserResponseDTO getById(UUID id) {
        return repository.findById(id)
                .map(dtoMapper::toResponseDTO)
                .orElse(null);
    }

    @Override
    public List<UserResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(dtoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}