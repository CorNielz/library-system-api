package com.cornielz.librarysystem.reservation.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cornielz.librarysystem.reservation.infrastructure.persistence.ReservationEntity;

public interface SpringDataReservationRepository extends JpaRepository<ReservationEntity, UUID> {

}