package com.hackaboss.PruebaTecnica4.controller;

import com.hackaboss.PruebaTecnica4.dto.HotelUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Hotel;
import com.hackaboss.PruebaTecnica4.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/hotels")
public class HotelController {
    @Autowired
    private IHotelService hotelService;

    @PostMapping("/new")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.saveHotel(hotel);

        if (savedHotel != null) {
            return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllHotels(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String dateFrom,
            @RequestParam(required = false) String dateTo) {

        List<Hotel> hotels;

        if (city != null && dateFrom != null && dateTo != null) {
            LocalDate parsedDateFrom = LocalDate.parse(dateFrom);
            LocalDate parsedDateTo = LocalDate.parse(dateTo);
            hotels = hotelService.findAvalaibleHotelsInCityForDates(city, parsedDateFrom, parsedDateTo);
        } else {
            hotels = hotelService.findAllHotel();
        }

        if (hotels.isEmpty()) {
            return new ResponseEntity<>("Don't have any hotels", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        Hotel hotel = hotelService.findHotelById(hotelId);

        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/edit/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId, @RequestBody HotelUpdateDto updatedHotel) {
        Hotel savedHotel = hotelService.updateHotel(hotelId, updatedHotel);

        if (savedHotel != null) {
            return new ResponseEntity<>(savedHotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable String hotelId) {
        Hotel deletedHotel = hotelService.deleteHotel(hotelId);

        if (deletedHotel != null) {
            return new ResponseEntity<>("Hotel deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unable to delete hotel. Either hotel not found or there are reservations in its rooms.", HttpStatus.CONFLICT);
        }
    }


}
