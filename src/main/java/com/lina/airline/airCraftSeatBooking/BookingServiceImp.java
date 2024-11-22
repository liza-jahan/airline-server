package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.dto.request.BookingRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class BookingServiceImp implements BookingService{
    private final SeatsRepository seatsRepository;
    private final  BookingRepository bookingRepository;
    @Override
    public int bookedSeat( boolean isAvailable,int seatId, BookingRequest bookingRequest) {
        SeatsEntity seatsEntity=seatsRepository.findByIdAndIsAvailable(seatId,isAvailable).orElseThrow(() -> new RuntimeException("not found"));
        if(!seatsEntity.isAvailable()) {
            throw new IllegalStateException("Seat is already booked");
        }
        BookingEntity bookingEntity= new BookingEntity();
        bookingEntity.setPassengerName(bookingRequest.getPassengerName());
        bookingEntity.setPassengerEmail(bookingRequest.getPassengerEmail());
        bookingEntity.setSeat(seatsEntity);
        bookingEntity.setFlightEntity(seatsEntity.getFlightEntity());
        bookingEntity.setConfirmed(bookingRequest.isConfirmed());
        bookingEntity.setBookingDate(LocalDateTime.now());
        bookingRepository.save(bookingEntity);
        return bookingEntity.getId();
    }
}
