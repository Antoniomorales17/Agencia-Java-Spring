package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.RoomUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Room;
import com.hackaboss.PruebaTecnica4.repository.HotelRepository;
import com.hackaboss.PruebaTecnica4.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;


    /**
     * Guarda una habitación en el repositorio.
     * Antes de guardar la habitación, se verifica si el hotel asociado existe.
     *
     * @param room La habitación que se va a guardar.
     * @return La habitación guardada si se realiza con éxito, de lo contrario null.
     */

    @Override
    public Room saveRoom(Room room) {
        String codHotel = room.getHotel().getHotelCode();

        if (hotelRepository.existsById(codHotel)) {
            if (existingRoom(room.getRoomCode())) {
                return null;
            }
            return roomRepository.save(room);
        } else {
            return null;
        }


    }

    @Override
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room findRoomById(String codRoom) {
        return roomRepository.findById(codRoom).orElse(null);
    }


    /**
     * Actualiza los datos de una habitación en el repositorio.
     *
     * @param codRoom       El código de la habitación que se va a actualizar.
     * @param roomUpdateDto El DTO que contiene los nuevos datos de la habitación.
     * @return La habitación actualizada si se realiza con éxito, de lo contrario null.
     */

    @Override
    public Room updateRoom(String codRoom, RoomUpdateDto roomUpdateDto) {
        Room existingRoom = roomRepository.findById(codRoom).orElse(null);

        if (existingRoom != null) {
            existingRoom.setAvailableFrom(roomUpdateDto.getAvailableFrom());
            existingRoom.setAvailableUntil(roomUpdateDto.getAvailableUntil());
            existingRoom.setNumBed(roomUpdateDto.getNumBed());
            existingRoom.setAvalaibleRoom(roomUpdateDto.getAvailableRoom());
            existingRoom.setPricePerNight(roomUpdateDto.getPricePerNight());

            return roomRepository.save(existingRoom);
        }
        return null;
    }

    @Override
    public Room deleteRoom(String codRoom) {
        if (existingRoom(codRoom)) {
            Room room = roomRepository.findById(codRoom).orElse(null);
            if (room != null) {
                roomRepository.delete(room);
                return room;
            }
        }
        return null;
    }


    /**
     * Verifica si existe una habitación con el código especificado.
     *
     * @param codRoom El código de la habitación a verificar.
     * @return true si existe una habitación con el código especificado, de lo contrario false.
     */

    private boolean existingRoom(String codRoom) {
        return roomRepository.existsById(codRoom);
    }
}
