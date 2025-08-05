package com.cornielz.librarysystem.reservation.infrastructure.repository;

import com.cornielz.librarysystem.reservation.infrastructure.persistence.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, UUID> {

}