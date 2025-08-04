package com.cornielz.librarysystem.reservation.infrastructure.repository;

import com.cornielz.librarysystem.reservation.infrastructure.persistence.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataReservationRepository extends JpaRepository<ReservationEntity, UUID> {

}