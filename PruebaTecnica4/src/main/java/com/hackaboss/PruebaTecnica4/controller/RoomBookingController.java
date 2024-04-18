package com.hackaboss.PruebaTecnica4.controller;

import com.hackaboss.PruebaTecnica4.service.IRoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agency/hotel-booking")
public class RoomBookingController {

    @Autowired
    private IRoomBookingService roomBookingService;
}
