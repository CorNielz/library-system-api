package com.cornielz.librarysystem.author.application.services;

import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;
import com.cornielz.librarysystem.author.application.mapper.AuthorDTOMapper;
import com.cornielz.librarysystem.author.domain.model.Author;
import com.cornielz.librarysystem.author.domain.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorDTOMapper dtoMapper;

    public AuthorServiceImpl(AuthorRepository repository, AuthorDTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public AuthorResponseDTO create(AuthorCreationRequestDTO dto) {
        Author author = dtoMapper.toDomain(dto);
        repository.save(author);
        return dtoMapper.toResponseDTO(author);
    }

    @Override
    public AuthorResponseDTO update(AuthorUpdateRequestDTO dto) {
        Author author = dtoMapper.toDomain(dto);
        repository.save(author);
        return dtoMapper.toResponseDTO(author);
    }

    @Override
    public void delete(UUID id) {
        repository.markAsDeleted(id);
    }

    @Override
    public AuthorResponseDTO getById(UUID id) {
        return repository.findById(id)
                .map(dtoMapper::toResponseDTO)
                .orElse(null);
    }

    @Override
    public List<AuthorResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(dtoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}