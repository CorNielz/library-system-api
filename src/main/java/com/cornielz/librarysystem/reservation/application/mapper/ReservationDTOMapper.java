package com.cornielz.librarysystem.reservation.application.mapper;

import com.cornielz.librarysystem.reservation.application.dto.ReservationCreationRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationResponseDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationUpdateRequestDTO;
import com.cornielz.librarysystem.reservation.domain.model.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationDTOMapper {
    Reservation toDomain(ReservationCreationRequestDTO dto);
    Reservation toDomain(ReservationUpdateRequestDTO dto);
    ReservationResponseDTO toResponseDTO(Reservation domain);
}