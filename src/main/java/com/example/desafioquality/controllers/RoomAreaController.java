package com.example.desafioquality.controllers;

import com.example.desafioquality.dto.PropertyAreaDto;
import com.example.desafioquality.dto.RoomAreaDto;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;
import com.example.desafioquality.service.PropertyService;
import com.example.desafioquality.service.RoomAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoomAreaController {

    @Autowired
    RoomAreaService roomAreaService;

    @Autowired
    PropertyService propertyService;

    @GetMapping("/roomArea/{id}")
    public ResponseEntity<PropertyAreaDto> getRoomArea(@PathVariable Long id){
        Property property = propertyService.getById(id);
        List<Room> rooms = property.getRooms();
        List<RoomAreaDto> areaDtos = rooms
                .stream()
                .map(e -> new RoomAreaDto(e.getName(), (roomAreaService.calculaArea(e))))
                .collect(Collectors.toList());
        PropertyAreaDto propertyAreaDto = new PropertyAreaDto(property.getName(), areaDtos);
        return ResponseEntity.ok(propertyAreaDto);
    }
}
