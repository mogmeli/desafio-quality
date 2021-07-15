package com.example.desafioquality.service;

import com.example.desafioquality.dto.PropertyAreaDto;
import com.example.desafioquality.dto.RoomAreaDto;
import com.example.desafioquality.exception.NoRoomFoundException;
import com.example.desafioquality.models.Property;
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

    public List<RoomAreaDto> returnBiggestRoomDto(List<Room> rooms) {
        Room biggestRoom = findBiggestRoom(rooms);
        List<RoomAreaDto> biggestRoomListDto = new ArrayList<>();
        biggestRoomListDto.add(new RoomAreaDto(biggestRoom.getName(), roomAreaService.calculaArea(biggestRoom)));
        return biggestRoomListDto;
    }

    public PropertyAreaDto getBiggestRoom(Long id){
        Property property = propertyService.getById(id);
        List<RoomAreaDto> biggestRoomListDto = returnBiggestRoomDto(property.getRooms());
        return new PropertyAreaDto(property.getName(),biggestRoomListDto);
    }
}
