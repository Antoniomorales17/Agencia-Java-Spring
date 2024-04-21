package com.hackaboss.PruebaTecnica4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomUpdateDto {
    private String roomCode;
    private LocalDate availableFrom;
    private LocalDate availableUntil;
    private Boolean reserved;
    private int numBed;
    private Boolean availableRoom;
    private Double pricePerNight;
}
