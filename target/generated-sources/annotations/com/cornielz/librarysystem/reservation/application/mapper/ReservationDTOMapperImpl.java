package com.cornielz.librarysystem.reservation.application.mapper;

import com.cornielz.librarysystem.reservation.application.dto.ReservationCreationRequestDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationResponseDTO;
import com.cornielz.librarysystem.reservation.application.dto.ReservationUpdateRequestDTO;
import com.cornielz.librarysystem.reservation.domain.model.Reservation;
import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T08:58:39-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class ReservationDTOMapperImpl implements ReservationDTOMapper {

    @Override
    public Reservation toDomain(ReservationCreationRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UUID userId = null;
        UUID bookId = null;
        LocalDateTime borrowingDate = null;
        LocalDateTime expectedReturnDate = null;
        LocalDateTime returnDate = null;
        BigDecimal appliedPrice = null;
        ReservationStatus status = null;

        userId = dto.userId();
        bookId = dto.bookId();
        borrowingDate = dto.borrowingDate();
        expectedReturnDate = dto.expectedReturnDate();
        returnDate = dto.returnDate();
        appliedPrice = dto.appliedPrice();
        status = dto.status();

        UUID id = null;

        Reservation reservation = new Reservation( id, userId, bookId, borrowingDate, expectedReturnDate, returnDate, appliedPrice, status );

        return reservation;
    }

    @Override
    public Reservation toDomain(ReservationUpdateRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UUID id = null;
        UUID userId = null;
        UUID bookId = null;
        LocalDateTime borrowingDate = null;
        LocalDateTime expectedReturnDate = null;
        LocalDateTime returnDate = null;
        BigDecimal appliedPrice = null;
        ReservationStatus status = null;

        id = dto.id();
        userId = dto.userId();
        bookId = dto.bookId();
        borrowingDate = dto.borrowingDate();
        expectedReturnDate = dto.expectedReturnDate();
        returnDate = dto.returnDate();
        appliedPrice = dto.appliedPrice();
        status = dto.status();

        Reservation reservation = new Reservation( id, userId, bookId, borrowingDate, expectedReturnDate, returnDate, appliedPrice, status );

        return reservation;
    }

    @Override
    public ReservationResponseDTO toResponseDTO(Reservation domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        UUID userId = null;
        UUID bookId = null;
        LocalDateTime borrowingDate = null;
        LocalDateTime expectedReturnDate = null;
        LocalDateTime returnDate = null;
        BigDecimal appliedPrice = null;
        ReservationStatus status = null;

        id = domain.getId();
        userId = domain.getUserId();
        bookId = domain.getBookId();
        borrowingDate = domain.getBorrowingDate();
        expectedReturnDate = domain.getExpectedReturnDate();
        returnDate = domain.getReturnDate();
        appliedPrice = domain.getAppliedPrice();
        status = domain.getStatus();

        ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO( id, userId, bookId, borrowingDate, expectedReturnDate, returnDate, appliedPrice, status );

        return reservationResponseDTO;
    }
}
