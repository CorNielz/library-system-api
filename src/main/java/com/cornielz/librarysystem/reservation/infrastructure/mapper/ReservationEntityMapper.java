package com.cornielz.librarysystem.reservation.infrastructure.mapper;

import com.cornielz.librarysystem.reservation.domain.model.Reservation;
import com.cornielz.librarysystem.reservation.infrastructure.persistence.ReservationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationEntityMapper {
    ReservationEntity toEntity(Reservation reservation);
    Reservation toDomain(ReservationEntity entity);
}