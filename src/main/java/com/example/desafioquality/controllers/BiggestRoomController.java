package com.example.desafioquality.controllers;

import com.example.desafioquality.dto.PropertyAreaDto;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;
import com.example.desafioquality.service.BiggestRoomService;
import com.example.desafioquality.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiggestRoomController {


    @Autowired
    BiggestRoomService biggestRoomService;

    @Autowired
    PropertyService propertyService;

    @GetMapping("/{id}/biggestroom")
    public ResponseEntity<PropertyAreaDto> getBiggestRoom(@PathVariable Long id){
        Property property = propertyService.getById(id);
        return ResponseEntity.ok(biggestRoomService.getBiggestRoom(id));
    }

}
