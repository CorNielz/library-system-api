package com.cornielz.librarysystem.reservation.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository {
    Optional<Reservation> findById(UUID id);
    List<Reservation> findAllByUserId(UUID id);
    List<Reservation> findAllByBookId(UUID id);
    List<Reservation> findAll();

    void save(Reservation reservation);
    void delete(UUID id);
}