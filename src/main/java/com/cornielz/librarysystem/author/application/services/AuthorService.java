package com.cornielz.librarysystem.author.application.services;

import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    AuthorResponseDTO create(AuthorCreationRequestDTO requestDto);

    AuthorResponseDTO update(AuthorUpdateRequestDTO requestDto);

    void delete(UUID id);

    AuthorResponseDTO getById(UUID id);

    List<AuthorResponseDTO> listAll();
}