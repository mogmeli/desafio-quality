package com.example.desafioquality.service;

import com.example.desafioquality.dto.RoomAreaDto;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.repositories.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomAreaService {

    PropertyRepository propertyRepository;

    PropertyService propertyService;

    public RoomAreaService(PropertyRepository propertyRepository, PropertyService propertyService) {
        this.propertyRepository = propertyRepository;
        this.propertyService = propertyService;
    }

    public List<RoomAreaDto> getProperty(Long id){
        Property property = propertyService.getById(id);
        List<RoomAreaDto> rooms = property.getRooms()
                .stream()
                .map(e -> new RoomAreaDto(e.getName(), (e.getLength()*e.getWidth())))
                .collect(Collectors.toList());
        return rooms;
    }


}
