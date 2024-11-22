package com.lina.airline.airCraftSeatBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {

    List<BookingEntity> findByPassengerEmail(String email);

}
