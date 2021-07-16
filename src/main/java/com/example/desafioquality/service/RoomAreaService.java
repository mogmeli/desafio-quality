package com.example.desafioquality.service;
import com.example.desafioquality.models.Room;
import com.example.desafioquality.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class RoomAreaService {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropertyService propertyService;

    public double calculaArea(Room room){
        return room.getWidth()*room.getLength();
    }

    public BigDecimal calculaValor(Room room, BigDecimal valor){
        return valor.multiply(BigDecimal.valueOf(calculaArea(room)));
    }
}
