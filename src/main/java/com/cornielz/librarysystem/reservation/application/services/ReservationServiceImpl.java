package com.cornielz.librarysystem.reservation.application.services;

import com.cornielz.librarysystem.reservation.application.dto.ReservationCreationRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationReplaceRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationResponseDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationUpdateRequestDTO;
import com.cornielz.librarysystem.reservation.domain.model.Reservation;
import com.cornielz.librarysystem.reservation.application.dto.ReservationSearchFilters;
import com.cornielz.librarysystem.reservation.application.mapper.ReservationDTOMapper;
import com.cornielz.librarysystem.reservation.domain.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final ReservationDTOMapper dtoMapper;

    public ReservationServiceImpl(ReservationRepository repository, ReservationDTOMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public ReservationResponseDTO create(ReservationCreationRequestDTO dto) {
        UUID reservationId = UUID.randomUUID();
        Reservation reservation = dtoMapper.toDomain(dto, reservationId);

        repository.save(reservation);

        return dtoMapper.toResponseDTO(reservation);
    }

    @Override
    public ReservationResponseDTO replace(UUID id, ReservationReplaceRequestDTO dto) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        dtoMapper.replaceReservationFromDto(dto, reservation);
        repository.save(reservation);

        return dtoMapper.toResponseDTO(reservation);
    }

    @Override
    public ReservationResponseDTO update(UUID id, ReservationUpdateRequestDTO dto) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        dtoMapper.updateReservationFromDto(dto, reservation);
        repository.save(reservation);

        return dtoMapper.toResponseDTO(reservation);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }

    @Override
    public ReservationResponseDTO getById(UUID id) {
        return repository.findById(id)
                .map(dtoMapper::toResponseDTO)
                .orElse(null);
    }

    @Override
    public List<ReservationResponseDTO> searchWithFilters(ReservationSearchFilters searchFilters) {
        return repository.findAllFiltered(searchFilters)
                .stream()
                .map(dtoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}