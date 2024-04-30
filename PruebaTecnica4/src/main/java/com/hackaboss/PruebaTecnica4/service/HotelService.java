package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.HotelUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Hotel;
import com.hackaboss.PruebaTecnica4.model.Room;
import com.hackaboss.PruebaTecnica4.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        if (existingHotel(hotel.getHotelCode())) {
            return null;
        }
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> findAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findHotelById(String codHotel) {
        return hotelRepository.findById(codHotel).orElse(null);
    }

    @Override
    public Hotel updateHotel(String codHotel, HotelUpdateDto hotelUpdateDto) {

        if (existingHotel(codHotel)) {
            Hotel existingHotel = hotelRepository.findById(codHotel).orElse(null);
            if (existingHotel != null) {
                existingHotel.setHotelName(hotelUpdateDto.getHotelName());
                existingHotel.setCity(hotelUpdateDto.getCity());
                return hotelRepository.save(existingHotel);
            }
        }
        return null;
    }

    @Override
    public Hotel deleteHotel(String codHotel) {
        if (existingHotel(codHotel)) {
            Hotel hotel = hotelRepository.findById(codHotel).orElse(null);
            if (hotel != null && areRoomsEmpty(hotel)) {
                hotelRepository.delete(hotel);
                return hotel;

            }
        }
        return null;
    }

    @Override
    public List<Hotel> findAvalaibleHotelsInCityForDates(String city, LocalDate dateFrom, LocalDate dateTo) {
        return hotelRepository.findByCityIgnoreCase(city).stream()
                .filter(hotel -> hotel.getRooms().stream()
                        .anyMatch(room -> isRoomAvalaibleForDates(room, dateFrom, dateTo))).collect(Collectors.toList());
    }


    /**
     * Verifica si una habitación está disponible para un rango de fechas específico.
     *
     * @param room     La habitación que se está verificando.
     * @param dateFrom La fecha de inicio del rango de fechas.
     * @param dateTo   La fecha de fin del rango de fechas.
     * @return true si la habitación está disponible para el rango de fechas especificado, de lo contrario false.
     */

    private boolean isRoomAvalaibleForDates(Room room, LocalDate dateFrom, LocalDate dateTo) {
        return room.getAvailableFrom().isBefore(dateTo) && room.getAvailableUntil().isAfter(dateFrom);
    }


    /**
     * Verifica si existe un hotel con el código especificado.
     *
     * @param codHotel El código del hotel a verificar.
     * @return true si existe un hotel con el código especificado, de lo contrario false.
     */

    private boolean existingHotel(String codHotel) {
        return hotelRepository.existsById(codHotel);
    }


    /**
     * Verifica si todas las habitaciones de un hotel están vacías, es decir, no tienen reservas.
     *
     * @param hotel El hotel para el cual se está realizando la verificación.
     * @return true si todas las habitaciones están vacías, de lo contrario false.
     */
    private boolean areRoomsEmpty(Hotel hotel) {
        return hotel.getRooms().stream()
                .allMatch(room -> room.getRoomBookings().isEmpty());
    }
}
