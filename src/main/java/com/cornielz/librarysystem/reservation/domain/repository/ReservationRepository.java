package com.cornielz.librarysystem.reservation.domain.repository;

import com.cornielz.librarysystem.reservation.application.dto.ReservationSearchFilters;
import com.cornielz.librarysystem.reservation.domain.model.Reservation;
import com.cornielz.librarysystem.reservation.domain.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository {
    Optional<Reservation> findById(UUID id);

    List<Reservation> findAllFiltered(ReservationSearchFilters searchFilters);

    void save(Reservation reservation);

    void delete(UUID id);
}