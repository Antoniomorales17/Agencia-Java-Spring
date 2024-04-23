package com.hackaboss.PruebaTecnica4.controller;

import com.hackaboss.PruebaTecnica4.dto.RoomUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Room;
import com.hackaboss.PruebaTecnica4.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/hotel/rooms")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @PostMapping("/new")
    public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
        Room savedRoom = roomService.saveRoom(room);
        if (savedRoom != null) {
            return new ResponseEntity<>(savedRoom, HttpStatus.CREATED); // Habitación creada exitosamente
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // Error al crear la habitación
        }
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.findAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{roomCode}")
    public ResponseEntity<Room> getRoomByCode(@PathVariable String roomCode) {
        Room room = roomService.findRoomById(roomCode);
        if (room != null) {
            return new ResponseEntity<>(room, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Habitación no encontrada
        }
    }

    @PutMapping("/{roomCode}")
    public ResponseEntity<Room> updateRoom(@PathVariable String roomCode, @RequestBody RoomUpdateDto roomUpdateDto) {
        Room updatedRoom = roomService.updateRoom(roomCode, roomUpdateDto);
        if (updatedRoom != null) {
            return new ResponseEntity<>(updatedRoom, HttpStatus.OK); // Habitación actualizada exitosamente
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Habitación no encontrada para actualizar
        }
    }

    @DeleteMapping("/{roomCode}")
    public ResponseEntity<Void> deleteRoom(@PathVariable String roomCode) {
        Room deletedRoom = roomService.deleteRoom(roomCode);
        if (deletedRoom != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Habitación eliminada exitosamente
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Habitación no encontrada para eliminar
        }
    }
}
