package com.hackaboss.PruebaTecnica4.service;

import com.hackaboss.PruebaTecnica4.dto.HotelUpdateDto;
import com.hackaboss.PruebaTecnica4.model.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> findAllHotel();

    Hotel findHotelById(String codHotel);

    Hotel updateHotel(String codHotel, HotelUpdateDto hotelUpdateDto);

    Hotel deleteHotel(String codHotel);

    List<Hotel> findAvalaibleHotelsInCityForDates(String city, LocalDate parsedDateFrom, LocalDate parsedDateTo);
}
