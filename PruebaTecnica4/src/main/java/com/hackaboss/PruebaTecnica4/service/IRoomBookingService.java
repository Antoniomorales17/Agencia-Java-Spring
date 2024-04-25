package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.RoomBookingUpdateDto;
import com.hackaboss.PruebaTecnica4.model.RoomBooking;

import java.util.List;

public interface IRoomBookingService {

    RoomBooking saveRoomBooking(RoomBooking roomBooking);
    List<RoomBooking> findAllRoomBooking();
    RoomBooking findRoomBookingById(Long codRoomBooking);
    RoomBooking updateRoomBooking(Long codRoomBooking, RoomBookingUpdateDto roomBookingUpdateDto);
    RoomBooking deleteRoomBooking(Long codRoomBooking);
}
