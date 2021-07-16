package com.example.desafioquality.service;

import com.example.desafioquality.exception.NoRoomFoundException;
import com.example.desafioquality.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BiggestRoomService {

    @Autowired
    RoomAreaService roomAreaService;

    @Autowired
    PropertyService propertyService;

    public Room findBiggestRoom(List<Room> rooms){

        Optional<Room> optBiggestRoom = rooms.stream().max(Comparator.comparing(e -> roomAreaService.calculaArea(e)));

        if(optBiggestRoom.isEmpty()){
            throw new NoRoomFoundException("Erro ao calcular o maior quarto, nenhum quarto foi encontrado!");
        }
        Room biggestRoom = optBiggestRoom.get();
        return biggestRoom;
    }

}
