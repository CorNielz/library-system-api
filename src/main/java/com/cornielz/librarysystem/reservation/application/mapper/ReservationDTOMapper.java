package com.cornielz.librarysystem.reservation.application.mapper;

import com.cornielz.librarysystem.reservation.application.dto.ReservationCreationRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationReplaceRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationResponseDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationUpdateRequestDTO;
import com.cornielz.librarysystem.reservation.domain.model.Reservation;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ReservationDTOMapper {
    Reservation toDomain(ReservationCreationRequestDTO dto, UUID id);

    Reservation toDomain(ReservationReplaceRequestDTO dto);

    Reservation toDomain(ReservationUpdateRequestDTO dto);

    ReservationResponseDTO toResponseDTO(Reservation domain);

    void replaceReservationFromDto(ReservationReplaceRequestDTO dto, @MappingTarget Reservation entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReservationFromDto(ReservationUpdateRequestDTO dto, @MappingTarget Reservation entity);
}