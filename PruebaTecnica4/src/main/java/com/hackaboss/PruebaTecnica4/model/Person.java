package com.hackaboss.PruebaTecnica4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    private String dni;
    private String name;
    private String lastName;
    private String email;

    @JsonIgnore
    @ManyToMany(mappedBy = "persons")
    private List<RoomBooking> roomBookings = new ArrayList<>(); // Reservas de habitación asociadas con esta persona

    @JsonIgnore
    @ManyToMany(mappedBy = "persons")
    private List<FlightBooking> flightBookings = new ArrayList<>(); // Reservas de vuelo asociadas con esta persona.
}
