package com.example.desafioquality.service;

import com.example.desafioquality.controller.dto.PropertyTotalAreaDto;
import com.example.desafioquality.controller.dto.PropertyValueDto;
import com.example.desafioquality.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FindValuePropertyService {

    @Autowired
    private PropertyService propertyService;
    @Autowired
    private RoomAreaService roomAreaService;

    public FindValuePropertyService(PropertyService propertyService, RoomAreaService roomAreaService) {
        this.propertyService = propertyService;
        this.roomAreaService = roomAreaService;

    }

    private double totalArea(Property property) {
        return property
                .getRooms()
                .stream()
                .mapToDouble(e -> roomAreaService.calculaArea(e))
                .sum();

    }
}
