package com.example.desafioquality.service;

import com.example.desafioquality.dto.PropertyTotalAreaDto;
import com.example.desafioquality.dto.PropertyValueDto;
import com.example.desafioquality.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FindValuePropertyService {

    @Autowired
    private RoomAreaService roomAreaService;

    public double totalArea(Property property) {
        return property
                .getRooms()
                .stream()
                .mapToDouble(e -> roomAreaService.calculaArea(e))
                .sum();

    }

    public BigDecimal valueProperty(Property property) {
        return BigDecimal.valueOf(totalArea(property)).multiply(property.getDistrict().getValue_m2());
    }

}
