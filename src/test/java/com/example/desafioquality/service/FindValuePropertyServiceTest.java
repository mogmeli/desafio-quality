package com.example.desafioquality.service;

import com.example.desafioquality.models.District;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class FindValuePropertyServiceTest {

    @Mock
    private RoomAreaService roomAreaService;
    @InjectMocks
    private FindValuePropertyService findValuePropertyService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void shouldReturnValue252_WhenCalculateValueProperty() {
        //Given
        List<Room> rooms = new ArrayList<>();
        Room room1 = new Room("sala", 2, 3);
        Room room2 = new Room("quarto", 10, 12);
        rooms.add(room1);
        rooms.add(room2);

        District district = new District("SP", new BigDecimal(2));
        Property property = new Property("BatCaverna", rooms, district);

        BigDecimal expected = new BigDecimal(252).setScale(1, RoundingMode.HALF_UP);

        //When
        when(roomAreaService.calculaArea(room1)).thenReturn(6.0);
        when(roomAreaService.calculaArea(room2)).thenReturn(120.0);
        BigDecimal result = findValuePropertyService.valueProperty(property);

        //Then
        assertEquals(expected, result);
    }
}