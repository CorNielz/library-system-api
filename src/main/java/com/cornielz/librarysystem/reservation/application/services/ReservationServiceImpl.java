package com.cornielz.librarysystem.reservation.application.services;

import com.cornielz.librarysystem.reservation.application.dto.ReservationCreationRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationResponseDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationUpdateRequestDTO;
import com.cornielz.librarysystem.reservation.domain.model.Reservation;
import com.cornielz.librarysystem.reservation.domain.repository.ReservationRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    public ReservationServiceImpl(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReservationResponseDTO create(ReservationCreationRequestDTO dto) {
        Reservation reservation = new Reservation(UUID.randomUUID(), dto.userId(), dto.bookId(), dto.borrowingDate(), dto.expectedReturnDate(), dto.returnDate(), dto.appliedPrice(), dto.status());
        repository.save(reservation);
        return toDTO(reservation);
    }

    @Override
    public ReservationResponseDTO update(ReservationUpdateRequestDTO dto) {
        Reservation reservation = repository.findById(dto.id()).orElseThrow();
        reservation.update(dto.userId(), dto.bookId(), dto.borrowingDate(), dto.expectedReturnDate(), dto.returnDate(), dto.appliedPrice(), dto.status());
        repository.save(reservation);
        return toDTO(reservation);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }

    @Override
    public ReservationResponseDTO getById(UUID id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<ReservationResponseDTO> listAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ReservationResponseDTO toDTO(Reservation reservation) {
        return new ReservationResponseDTO(reservation.id(), reservation.userId(), reservation.bookId(), reservation.borrowingDate(), reservation.expectedReturnDate(), reservation.returnDate(), reservation.appliedPrice(), reservation.status());
    }
}