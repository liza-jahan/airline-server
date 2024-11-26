package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.dto.request.BookingRequest;
import com.lina.airline.exception.IllegalException;
import com.lina.airline.exception.SeatNotAvailableException;
import com.lina.airline.service.impl.EmailServiceImp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
@Slf4j
public class BookingServiceImp implements BookingService{
    private final SeatsRepository seatsRepository;
    private final  BookingRepository bookingRepository;
    private  final EmailServiceImp emailServiceImp;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public int bookSeat(boolean isAvailable, int seatId, BookingRequest bookingRequest) {


        if(bookingRequest ==null || bookingRequest.getPassengerName()==null || bookingRequest.getPassengerEmail()==null){
            throw  new IllegalException("Invalid booking request","2020-23");
       }
        entityManager.clear();
        SeatsEntity seatsEntity=seatsRepository.findByIdAndIsAvailable(seatId,isAvailable).orElseThrow(() -> new SeatNotAvailableException("Seat not found or already booked"));


        if(!seatsEntity.isAvailable()) {
            throw new IllegalStateException("Seat is already booked");
        }
         seatsEntity.setAvailable(false);
         seatsRepository.save(seatsEntity);

        BookingEntity bookingEntity= new BookingEntity();
        bookingEntity.setPassengerName(bookingRequest.getPassengerName());
        bookingEntity.setPassengerEmail(bookingRequest.getPassengerEmail());
        bookingEntity.setSeat(seatsEntity);
        bookingEntity.setFlightEntity(seatsEntity.getFlightEntity());
        bookingEntity.setConfirmed(bookingRequest.isConfirmed());
        bookingEntity.setBookingDate(LocalDateTime.now());
        bookingRepository.save(bookingEntity);

        emailServiceImp.sendMail(
                "Seat Booking Confirmation",
                "Dear " + bookingRequest.getPassengerName() + ",\n\n" +
                        "Your booking for seat ID " + seatId + " has been successfully confirmed.\n\n" +
                        "Thank you for choosing us!",
                bookingRequest.getPassengerEmail()
        );

        return bookingEntity.getId();
    }
}