package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.model.Flight;

import java.time.LocalDate;
import java.util.List;

public interface IFlightService {

    Flight saveFlight(Flight flight);

    List<Flight> findAllFlight();

    Flight findFlightById(String codFlight);

    Flight updateFlight(String codFlight, Flight flight);

    Flight deleteFlight(String codFlight);

    List<Flight> findAvailableFlightWithOriginAndDestinationForDates(String origin, String destination, LocalDate parsedDateFrom, LocalDate parsedDateTo);
}

