package com.cornielz.librarysystem.application.reservation;

import com.cornielz.librarysystem.domain.reservation.Reservation;
import com.cornielz.librarysystem.domain.reservation.ReservationRepository;

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
        repository.deleteById(id);
    }

    @Override
    public ReservationResponseDTO getById(UUID id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<ReservationResponseDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ReservationResponseDTO toDTO(Reservation reservation) {
        return new ReservationResponseDTO(reservation.id(), reservation.userId(), reservation.bookId(), reservation.borrowingDate(), reservation.expectedReturnDate(), reservation.returnDate(), reservation.appliedPrice(), reservation.status());
    }
}