package com.hackaboss.PruebaTecnica4;


import com.hackaboss.PruebaTecnica4.model.Flight;
import com.hackaboss.PruebaTecnica4.repository.FlightRepository;
import com.hackaboss.PruebaTecnica4.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class FlightTest {
    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    private List<Flight> mockList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockList = new ArrayList<>();
    }


    // Prueba para verificar si se pueden obtener vuelos correctamente.
    @Test
    public void getFlights() {
        mockList.add(new Flight("AA1", "Estocolmo", "Austria", LocalDate.parse("2024-02-15"), 200, 100.00, null));
        when(flightRepository.findAll()).thenReturn(mockList);

        List<Flight> flightList = flightService.findAllFlight();
        assertTrue(flightList != null && !flightList.isEmpty());
    }


    // Prueba para verificar si la lista de vuelos está vacía.
    @Test
    public void getFlightsEmpty() {
        when(flightRepository.findAll()).thenReturn(mockList);

        List<Flight> flightList = flightService.findAllFlight();
        assertTrue(flightList == null || flightList.isEmpty());

    }


    // Prueba para verificar si se pueden obtener vuelos entre ciertas fechas y en una ciudad específica.
    @Test
    public void getFlightsBetweenDatesAndCity() {
        Flight flight = new Flight("AA1", "Estocolmo", "Austria", LocalDate.parse("2024-02-15"), 200, 100.00, null);

        mockList.add(flight);

        when(flightRepository.findByOriginAndDestination("Estocolmo", "Austria")).thenReturn(mockList);

        List<Flight> flightList = flightService.findAvailableFlightWithOriginAndDestinationForDates("Estocolmo", "Austria", LocalDate.parse("2024-02-15"), LocalDate.parse("2025-02-15"));

        assertTrue(flightList != null && !flightList.isEmpty());

    }


}