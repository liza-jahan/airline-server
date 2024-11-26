package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.dto.APIResponse;
import com.lina.airline.dto.request.BookingRequest;
import com.lina.airline.dto.response.CreationResponseInt;
import com.lina.airline.wrapperclass.BookingRequestWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@AllArgsConstructor
@Slf4j
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/add-booking")
    public ResponseEntity<APIResponse<CreationResponseInt>> creatSeatBooking(@RequestBody BookingRequestWrapper bookingRequestWrapper) {

        int bookSeat = bookingService.bookSeat(bookingRequestWrapper.isAvailable(),
                bookingRequestWrapper.getSeatId(), bookingRequestWrapper.getBookingRequest());
        log.info("Received request: isAvailable={}, seatId={}, bookingRequest={}",  bookingRequestWrapper.getBookingRequest(), bookingRequestWrapper.getBookingRequest());

        APIResponse<CreationResponseInt> responseDTO = APIResponse
                .<CreationResponseInt>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponseInt(bookSeat))
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
