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

    private BigDecimal valueProperty(Property property) {

        return BigDecimal.valueOf(totalArea(property)).multiply(property.getDistrict().getValue_m2());
    }

    public PropertyTotalAreaDto getDtoTotalArea(Long propertyId) {

        Property property = propertyService.getById(propertyId);

        return new PropertyTotalAreaDto(property.getName(), property.getRooms().size(), totalArea(property));
    }

    public PropertyValueDto getDtoValue(Long propertyId){
        Property property = propertyService.getById(propertyId);

        return new PropertyValueDto(property.getName(), property.getRooms().size(), valueProperty(property));
    }

}
