package com.example.desafioquality.service;

import com.example.desafioquality.models.Property;
import com.example.desafioquality.repositories.PropertyRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class FindValuePropertyService {

    private PropertyService propertyService;

    public FindValuePropertyService(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    public BigDecimal valueProperty(Long propertyId) {
        Property property = propertyService.getById(propertyId);

        double rooms = property
                .getRooms()
                .stream()
                .mapToDouble(e -> e.getLength() * e.getWidth())
                .sum();

        return BigDecimal.valueOf(rooms).multiply(property.getDistrict().getValue_m2());
    }
}
