package com.example.desafioquality.controller;

import com.example.desafioquality.dto.RoomAreaDto;
import com.example.desafioquality.service.RoomAreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomAreaController {

    RoomAreaService roomAreaService;

    public RoomAreaController(RoomAreaService roomAreaService) {
        this.roomAreaService = roomAreaService;
    }

    @GetMapping("/roomArea/{id}")
    public ResponseEntity<List<RoomAreaDto>> getRoomArea(@PathVariable Long id){

        return ResponseEntity.ok(roomAreaService.getProperty(id));
    }
}
