package com.cornielz.librarysystem.reservation.infrastructure.repository;

import com.cornielz.librarysystem.reservation.infrastructure.persistence.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, UUID> {
    List<ReservationEntity> findAllByUserId(UUID userId);
    List<ReservationEntity> findAllByBookId(UUID bookId);
}