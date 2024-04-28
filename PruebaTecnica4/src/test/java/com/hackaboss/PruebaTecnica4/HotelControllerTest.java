package com.hackaboss.PruebaTecnica4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getHotels() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/agency/hotels")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


    @Test
    public void getHotelsById() throws Exception {
        String hotelId = "WINTERFELL002";
        mockMvc.perform(MockMvcRequestBuilders.get("/agency/hotels/{hotelId}" , hotelId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));


    }
}
