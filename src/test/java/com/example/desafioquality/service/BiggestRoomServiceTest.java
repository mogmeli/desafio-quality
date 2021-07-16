package com.example.desafioquality.service;

import com.example.desafioquality.exception.NoRoomFoundException;
import com.example.desafioquality.models.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
class BiggestRoomServiceTest {

    @Mock
    private RoomAreaService roomAreaService;

    @Mock
    private PropertyService propertyService;

    @InjectMocks
    private BiggestRoomService biggestRoomService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    public void shouldReturnTheBiggestRoom_whenValidListOfRoomsIsPassed(){
        //given
        List<Room> rooms = new ArrayList<>();
        Room room1 = new Room("sala", 2, 3);
        Room expected = new Room("quarto", 10, 12);
        rooms.add(room1);
        rooms.add(expected);

        //when
        when(roomAreaService.calculaArea(room1)).thenReturn(6.0);
        when(roomAreaService.calculaArea(expected)).thenReturn(120.0);
        Room result = biggestRoomService.findBiggestRoom(rooms);

        //then
        assertEquals(result, expected);

    }

    @Test
    public void shouldThrowAnException_whenEmptyListOfRoomsIsPassed(){
        //given
        List<Room> rooms = new ArrayList<>();

        //when

        // then
        assertThrows(NoRoomFoundException.class, () -> biggestRoomService.findBiggestRoom(rooms));
    }

}