package com.example.desafioquality.controller;

import com.example.desafioquality.controllers.NewPropertyController;
import com.example.desafioquality.controllers.form.PropertyForm;
import com.example.desafioquality.controllers.form.RoomForm;
import com.example.desafioquality.models.District;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;
import com.example.desafioquality.repositories.PropertyRepository;
import com.example.desafioquality.repositories.RoomRepository;
import com.example.desafioquality.service.NewPropertyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class NewPropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private RoomRepository roomRepository;


    @Autowired
    ObjectMapper objectMapper;

    @AfterEach
    void tearDown() {
        propertyRepository.deleteAll();
        roomRepository.deleteAll();

    }

    @Test
    void givenNewProperty_shouldReturn200() throws Exception {

        //given
        List<RoomForm> rooms = new ArrayList<>();
        rooms.add(0, new RoomForm("Cozinha", 20, 2));
        PropertyForm property = new PropertyForm("Casa1", "Mooca", rooms);

        //when


        //then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/property")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(property)))
                .andExpect(status().isOk());
    }

    @Test
    void givenNewPropertyWithWrongAttributes_shouldReturn404() throws Exception {

        //given
        List<RoomForm> rooms = new ArrayList<>();
        rooms.add(0, new RoomForm("cozinha", 333333, 0));
        PropertyForm property = new PropertyForm("Casa1", "moocaa", rooms);

        //when


        //then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(property)))
                .andExpect(status().is4xxClientError());
    }
}