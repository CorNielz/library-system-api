package com.cornielz.librarysystem.reservation.infrastructure.mapper;

import com.cornielz.librarysystem.reservation.domain.model.Reservation;
import com.cornielz.librarysystem.reservation.domain.model.ReservationStatus;
import com.cornielz.librarysystem.reservation.infrastructure.persistence.ReservationEntity;
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
public class ReservationEntityMapperImpl implements ReservationEntityMapper {

    @Override
    public ReservationEntity toEntity(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationEntity reservationEntity = new ReservationEntity();

        return reservationEntity;
    }

    @Override
    public Reservation toDomain(ReservationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        LocalDateTime borrowingDate = null;
        LocalDateTime expectedReturnDate = null;
        LocalDateTime returnDate = null;
        BigDecimal appliedPrice = null;
        ReservationStatus status = null;

        id = entity.getId();
        borrowingDate = entity.getBorrowingDate();
        expectedReturnDate = entity.getExpectedReturnDate();
        returnDate = entity.getReturnDate();
        appliedPrice = entity.getAppliedPrice();
        status = entity.getStatus();

        UUID userId = null;
        UUID bookId = null;

        Reservation reservation = new Reservation( id, userId, bookId, borrowingDate, expectedReturnDate, returnDate, appliedPrice, status );

        return reservation;
    }
}
