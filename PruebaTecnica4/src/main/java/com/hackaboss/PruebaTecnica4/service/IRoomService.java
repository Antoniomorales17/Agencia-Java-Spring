package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.RoomUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Room;

import java.util.List;

public interface IRoomService {

    Room saveRoom(Room room);

    List<Room> findAllRooms();

    Room findRoomById(String codRoom);

    Room updateRoom(String codRoom, RoomUpdateDto room);

    Room deleteRoom(String codRoom);
}
