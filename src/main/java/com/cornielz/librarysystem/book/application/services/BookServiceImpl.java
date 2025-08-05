package com.cornielz.librarysystem.book.application.services;

import com.cornielz.librarysystem.book.application.dto.BookCreationRequestDTO;
import com.cornielz.librarysystem.book.application.dto.BookResponseDTO;
import com.cornielz.librarysystem.book.application.dto.BookUpdateRequestDTO;
import com.cornielz.librarysystem.book.application.mapper.BookDTOMapper;
import com.cornielz.librarysystem.book.domain.model.Book;
import com.cornielz.librarysystem.book.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookDTOMapper dtoMapper;

    public BookServiceImpl(BookRepository repository, BookDTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public BookResponseDTO create(BookCreationRequestDTO dto) {
        Book book = dtoMapper.toDomain(dto);
        repository.save(book);
        return dtoMapper.toResponseDTO(book);
    }

    @Override
    public BookResponseDTO update(BookUpdateRequestDTO dto) {
        Book book = dtoMapper.toDomain(dto);
        repository.save(book);
        return dtoMapper.toResponseDTO(book);
    }

    @Override
    public void delete(UUID id) {
        repository.markAsDeleted(id);
    }

    @Override
    public BookResponseDTO getById(UUID id) {
        return repository.findById(id)
                .map(dtoMapper::toResponseDTO)
                .orElse(null);
    }

    @Override
    public List<BookResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(dtoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

}