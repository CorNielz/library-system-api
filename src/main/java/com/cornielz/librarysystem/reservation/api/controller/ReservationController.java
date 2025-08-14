package com.cornielz.librarysystem.reservation.api.controller;

import com.cornielz.librarysystem.reservation.application.dto.ReservationCreationRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationReplaceRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationResponseDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationUpdateRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationSearchFilters;
import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;
import com.cornielz.librarysystem.reservation.application.services.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@Valid @RequestBody ReservationCreationRequestDTO dto) {
        return ResponseEntity.ok(reservationService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> replaceReservation(@PathVariable UUID id, @Valid @RequestBody ReservationReplaceRequestDTO dto) {
        return ResponseEntity.ok(reservationService.replace(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> updateReservation(@PathVariable UUID id, @Valid @RequestBody ReservationUpdateRequestDTO dto) {
        return ResponseEntity.ok(reservationService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getReservation(@PathVariable UUID id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ReservationResponseDTO>> searchReservations(
            @RequestParam(required = false) UUID userId,
            @RequestParam(required = false) UUID reservationId,
            @RequestParam(required = false) LocalDateTime borrowingDateFrom,
            @RequestParam(required = false) LocalDateTime borrowingDateTo,
            @RequestParam(required = false) LocalDateTime expectedReturnDateFrom,
            @RequestParam(required = false) LocalDateTime expectedReturnDateTo,
            @RequestParam(required = false) LocalDateTime returnDateFrom,
            @RequestParam(required = false) LocalDateTime returnDateTo,
            @RequestParam(required = false) BigDecimal appliedPriceMinimum,
            @RequestParam(required = false) BigDecimal appliedPriceMaximum,
            @RequestParam(required = false) ReservationStatus status
    ) {
        ReservationSearchFilters searchFilters = new ReservationSearchFilters(userId, reservationId, borrowingDateFrom, borrowingDateTo, expectedReturnDateFrom, expectedReturnDateTo, returnDateFrom, returnDateTo, appliedPriceMinimum, appliedPriceMaximum, status);
        return ResponseEntity.ok(reservationService.searchWithFilters(searchFilters));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable UUID id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}