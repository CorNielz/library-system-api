package com.cornielz.librarysystem.author.application.services;

import com.cornielz.librarysystem.author.application.dto.AuthorCreationRequestDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorResponseDTO;
import com.cornielz.librarysystem.author.application.dto.AuthorUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    AuthorResponseDTO create(AuthorCreationRequestDTO request);

    AuthorResponseDTO update(AuthorUpdateRequestDTO request);

    void delete(UUID id);

    AuthorResponseDTO getById(UUID id);

    List<AuthorResponseDTO> listAll();
}