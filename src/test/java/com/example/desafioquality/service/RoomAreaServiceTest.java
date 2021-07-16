package com.example.desafioquality.service;

import com.example.desafioquality.models.Room;
import com.example.desafioquality.repositories.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class RoomAreaServiceTest {

    @Mock
    PropertyRepository propertyRepository;

    @Mock
    PropertyService propertyService;

    @InjectMocks
    private RoomAreaService roomAreaService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    public void shouldReturnEachRoomArea_WhenSendingValidPropertyId(){
        //given
        Room room2 = new Room("quarto", 10, 12);
        double expected = 120.0;

        //when
        double result = roomAreaService.calculaArea(room2);

        //then
        assertEquals(result, expected);

    }

    @Test
    public void shouldReturnRightRoomValue_WhenSendingARoomAndValue(){
        //given
        Room room = new Room("quarto", 10, 12);
        BigDecimal valor = new BigDecimal("15");
        BigDecimal expected = new BigDecimal("1800.0");

        //when
        BigDecimal result = roomAreaService.calculaValor(room,valor);

        //then
        assertEquals(result,expected);

    }
}