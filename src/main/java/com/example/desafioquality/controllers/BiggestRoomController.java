package com.example.desafioquality.controllers;

import com.example.desafioquality.dto.BiggestRoomDto;
import com.example.desafioquality.dto.PropertyAreaDto;
import com.example.desafioquality.dto.RoomAreaDto;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;
import com.example.desafioquality.service.BiggestRoomService;
import com.example.desafioquality.service.PropertyService;
import com.example.desafioquality.service.RoomAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiggestRoomController {

    @Autowired
    RoomAreaService roomAreaService;

    @Autowired
    BiggestRoomService biggestRoomService;

    @Autowired
    PropertyService propertyService;

    @GetMapping("/{id}/biggestroom")
    public ResponseEntity<BiggestRoomDto> getBiggestRoom(@PathVariable Long id){
        Property property = propertyService.getById(id);
        Room biggestRoom = biggestRoomService.findBiggestRoom(property.getRooms());
        RoomAreaDto roomAreaDto = new RoomAreaDto(biggestRoom.getName(), roomAreaService.calculaArea(biggestRoom));
        BiggestRoomDto biggestRoomDto = new BiggestRoomDto(property.getName(),roomAreaDto);
        return ResponseEntity.ok(biggestRoomDto);
    }

}
