package com.hackaboss.PruebaTecnica4.controller;

import com.hackaboss.PruebaTecnica4.model.Flight;
import com.hackaboss.PruebaTecnica4.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/flights")
public class FlightController {

    @Autowired
    private IFlightService flightService;

    @PostMapping("/new")
    public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.saveFlight(flight);

        if (savedFlight != null) {
            return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @GetMapping
    public ResponseEntity<?> getAllFlights(@RequestParam(required = false) String origin, @RequestParam(required = false) String destination,
                                           @RequestParam(required = false) String dateFrom, @RequestParam(required = false) String dateTo) {

        List<Flight> flights;

        if (origin != null && destination != null && dateFrom != null && dateTo != null) {
            LocalDate parsedDateFrom = LocalDate.parse(dateFrom);
            LocalDate parsedDateTo = LocalDate.parse(dateTo);
            flights = flightService.findAvailableFlightWithOriginAndDestinationForDates(origin, destination, parsedDateFrom, parsedDateTo);
        } else {
            flights = flightService.findAllFlight();
        }

        if (flights.isEmpty()) {
            return new ResponseEntity<>("Don't have any flights", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(flights, HttpStatus.OK);
        }
    }

    @GetMapping("/{codFlight}")
    public ResponseEntity<Flight> getFlightById(@PathVariable String codFlight) {
        Flight flight = flightService.findFlightById(codFlight);

        if (flight != null) {
            return new ResponseEntity<>(flight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{codFlight}")
    public ResponseEntity<Flight> updateFlight(@PathVariable String codFlight, @RequestBody Flight updatedFlight) {
        Flight savedFlight = flightService.updateFlight(codFlight, updatedFlight);

        if (savedFlight != null) {
            return new ResponseEntity<>(savedFlight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codFlight}")
    public ResponseEntity<String> deleteFlight(@PathVariable String codFlight) {
        Flight deletedFlight = flightService.deleteFlight(codFlight);

        if (deletedFlight != null) {
            return new ResponseEntity<>("Flight deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unable to delete flight. Either flight not found or there are reservations", HttpStatus.NOT_FOUND);
        }
    }


}
