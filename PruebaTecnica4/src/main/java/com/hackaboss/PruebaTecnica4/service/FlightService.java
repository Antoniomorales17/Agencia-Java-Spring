package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.model.Flight;
import com.hackaboss.PruebaTecnica4.model.FlightBooking;
import com.hackaboss.PruebaTecnica4.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements  IFlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight saveFlight(Flight flight) {
        if (existingFlight(flight.getFlightCode())){
            return null;
        }
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAllFlight() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findFlightById(String codFlight) {
        return flightRepository.findById(codFlight).orElse(null);
    }

    @Override
    public Flight updateFlight(String codFlight, Flight updatedFlight) {
        if (existingFlight(codFlight)){
            Flight existingFlight = flightRepository.findById(codFlight).orElse(null);

            if (existingFlight != null) {
                existingFlight.setOrigin(updatedFlight.getOrigin());
                existingFlight.setDestination(updatedFlight.getDestination());
                existingFlight.setFlightDate(updatedFlight.getFlightDate());
                existingFlight.setMaxPassengers(updatedFlight.getMaxPassengers());
                existingFlight.setSeatPrice(updatedFlight.getSeatPrice());

                return flightRepository.save(existingFlight);
            }
        }
        return null;
    }

    @Override
    public Flight deleteFlight(String codFlight) {
        if (existingFlight(codFlight)){
            Flight flight = flightRepository.findById(codFlight).orElse(null);

            if (flight != null && existingFlightBookings(flight)){
                flightRepository.delete(flight);
                return flight;
            }
        }
        return null;
    }

    @Override
    public List<Flight> findAvailableFlightWithOriginAndDestinationForDates(String origin, String destination, LocalDate flightDate, LocalDate maxDate) {
        return flightRepository.findByOriginAndDestination(origin, destination).stream()
                .filter(flight -> flight.getFlightDate().isEqual(flightDate)
                        || (flight.getFlightDate().isAfter(flightDate) && flight.getFlightDate().isBefore(maxDate)))
                .collect(Collectors.toList());
    }

    private boolean isBookingValid(String codFlight, FlightBooking newFlightBooking) {
        Flight flight = flightRepository.findById(codFlight).get();
        if (flight == null) {
            return false;
        } else {
            int totalPassagers = flight.getFlightBookings().size();
            return (totalPassagers + newFlightBooking.getNumPersons()) <= flight.getMaxPassengers();
        }
    }

    private boolean existingFlight(String codFlight){
        return flightRepository.existsById(codFlight);
    }

    private boolean existingFlightBookings(Flight flight){
        return
                flight.getFlightBookings().isEmpty();
    }
}
