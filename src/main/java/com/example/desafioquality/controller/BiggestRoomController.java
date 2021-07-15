package com.example.desafioquality.controller;

import com.example.desafioquality.models.Property;
import com.example.desafioquality.service.BiggestRoomService;
import com.example.desafioquality.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiggestRoomController {


    @Autowired
    BiggestRoomService biggestRoomService;

    @Autowired
    PropertyService propertyService;

    @GetMapping("/{id}/biggestroom")
    public String orderSellerFollowers(@PathVariable Long id){
        Property property = propertyService.getById(id);
        return "Maior comodo:" + biggestRoomService.findBiggestRoom(property).getName();
    }

}
