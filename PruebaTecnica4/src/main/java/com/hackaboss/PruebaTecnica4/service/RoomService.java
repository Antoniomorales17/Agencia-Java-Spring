package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.RoomUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Room;
import com.hackaboss.PruebaTecnica4.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room findRoomById(String roomCode) {
        return roomRepository.findById(roomCode).orElse(null);
    }

    @Override
    public Room updateRoom(String roomCode, RoomUpdateDto roomUpdateDto) {
        Room room = findRoomById(roomCode);
        if (room != null) {
            // Actualizar los campos de la habitación con los datos del DTO
            room.setAvailableFrom(roomUpdateDto.getAvailableFrom());
            room.setAvailableUntil(roomUpdateDto.getAvailableUntil());
            room.setNumBed(roomUpdateDto.getNumBed());
            room.setAvalaibleRoom(roomUpdateDto.getAvailableRoom());
            room.setPricePerNight(roomUpdateDto.getPricePerNight());

            return roomRepository.save(room);
        }
        return null;
    }

    @Override
    public Room deleteRoom(String roomCode) {
        Room room = findRoomById(roomCode);
        if (room != null) {
            roomRepository.delete(room);
        }
        return room;
    }
}
