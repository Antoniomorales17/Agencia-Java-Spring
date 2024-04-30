package com.hackaboss.PruebaTecnica4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
public class Room {

    @Id
    private String roomCode; // Código único de la habitación.
    private LocalDate availableFrom;
    private LocalDate availableUntil;
    private int numBed;
    private Boolean avalaibleRoom;
    private Double pricePerNight;


    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel; // Hotel al que pertenece la habitación.

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomBooking> roomBookings = new ArrayList<>(); // Reservas asociadas con esta habitación.

}
