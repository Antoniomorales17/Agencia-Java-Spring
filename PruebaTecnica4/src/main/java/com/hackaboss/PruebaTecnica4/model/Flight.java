package com.hackaboss.PruebaTecnica4.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id

    private String flightCode; // Código único del vuelo.
    private String origin;
    private String destination;
    private LocalDate flightDate;
    private int maxPassengers;
    private Double seatPrice;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightBooking> flightBookings = new ArrayList<>(); // Reservas asociadas con este vuelo.
}
