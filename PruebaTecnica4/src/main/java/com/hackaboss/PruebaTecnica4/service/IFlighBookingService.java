package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.FlightBookingUpdateDto;
import com.hackaboss.PruebaTecnica4.model.FlightBooking;

import java.util.List;

public interface IFlighBookingService {

    FlightBooking saveFlightBooking(FlightBooking flightBooking);

    List<FlightBooking> findAllFlightBooking();

    FlightBooking findFlightBookingById(Long codFlightBooking);

    FlightBooking updateFlightBooking(Long codFlightBooking, FlightBookingUpdateDto flightBookingDto);

    FlightBooking deleteFlightBooking(Long codFlightBooking);

}
