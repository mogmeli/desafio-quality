package com.example.desafioquality.service;

import com.example.desafioquality.exception.NoRoomFoundException;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.repositories.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.OptionalDouble;

@Service
public class BiggestRoomService {

    final PropertyRepository repository;

    public BiggestRoomService(PropertyRepository repository) {
        this.repository = repository;
    }

    public double findBiggestRoom (Property property){

        OptionalDouble biggestRoom = property.getRooms().stream().mapToDouble(e -> e.getWidth() * e.getLength()).max();

        if(biggestRoom.isEmpty()){
            throw new NoRoomFoundException("Erro ao calcular o maior quarto, nenhum quarto foi encontrado!");
        }

        return biggestRoom.getAsDouble();
    }
}
