package com.example.desafioquality.service;

import com.example.desafioquality.dto.PropertyAreaDto;
import com.example.desafioquality.dto.RoomAreaDto;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;
import com.example.desafioquality.repositories.PropertyRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public List<RoomAreaDto> calculaRoomAreas(List<Room> rooms){
        return rooms
                .stream()
                .map(e -> new RoomAreaDto(e.getName(), (calculaArea(e))))
                .collect(Collectors.toList());
    }

    public PropertyAreaDto getRoomAreas(Long id){
        Property property = propertyService.getById(id);
        List<RoomAreaDto> areadto = calculaRoomAreas(property.getRooms());
        return new PropertyAreaDto(property.getName(),areadto);
    }

    public double calculaArea(Room room){
        return room.getWidth()*room.getLength();
    }

    public BigDecimal calculaValor(Room room, BigDecimal valor){
        return valor.multiply(BigDecimal.valueOf(calculaArea(room)));
    }
}
