package com.cornielz.librarysystem.reservation.infrastructure.repository;

import com.cornielz.librarysystem.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

public interface SpringDataReservationRepository extends JpaRepository<ReservationEntity, UUID> {

}