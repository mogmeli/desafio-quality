package com.example.desafioquality.controllers;

import com.example.desafioquality.dto.PropertyAreaDto;
import com.example.desafioquality.service.RoomAreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomAreaController {

    RoomAreaService roomAreaService;

    public RoomAreaController(RoomAreaService roomAreaService) {
        this.roomAreaService = roomAreaService;
    }

    @GetMapping("/roomArea/{id}")
    public ResponseEntity<PropertyAreaDto> getRoomArea(@PathVariable Long id){
        return ResponseEntity.ok(roomAreaService.getRoomAreas(id));
    }
}
