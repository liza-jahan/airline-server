package com.lina.airline.airflight;

import com.lina.airline.airCraftSeatBooking.BookingService;
import com.lina.airline.dto.APIResponse;
import com.lina.airline.dto.request.FlightRequest;
import com.lina.airline.dto.response.CreationResponse;
import com.lina.airline.dto.response.CreationResponseInt;
import com.lina.airline.dto.response.CreationResponseString;
import com.lina.airline.wrapperclass.BookingRequestWrapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class FlightController {


    private final  FlightService flightService;
    @PostMapping("/add-flight/{aircraftId}")
    public ResponseEntity<APIResponse<CreationResponseInt>> addFlight(@Valid @RequestBody FlightRequest flightRequest, @PathVariable UUID aircraftId) {
            int addFlight= flightService.saveFlight(flightRequest,aircraftId);

        APIResponse<CreationResponseInt> responseDTO = APIResponse
                .<CreationResponseInt>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponseInt(addFlight))
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //String origin, String destination
    @GetMapping("/search-flight/{origin}/{destination}")
    public ResponseEntity<APIResponse<CreationResponseString>> searchFlight(@RequestBody @PathVariable String destination, @RequestBody @PathVariable String origin) {
        List<FlightEntity> flight =flightService.searchFlights(origin, destination);

        APIResponse<CreationResponseString> responseDTO = APIResponse
                .<CreationResponseString>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponseString(flight.toString()))
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
