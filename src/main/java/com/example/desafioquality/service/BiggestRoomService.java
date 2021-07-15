package com.example.desafioquality.service;

import com.example.desafioquality.exception.NoRoomFoundException;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;
import com.example.desafioquality.repositories.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

@Service
public class BiggestRoomService {

    final PropertyRepository repository;

    public BiggestRoomService(PropertyRepository repository) {
        this.repository = repository;
    }

    public Room findBiggestRoom (Property property){

        Optional<Room> biggestRoom = property.getRooms().stream().max(Comparator.comparing(e -> e.getWidth()*e.getLength()));

        if(biggestRoom.isEmpty()){
            throw new NoRoomFoundException("Erro ao calcular o maior quarto, nenhum quarto foi encontrado!");
        }

        return biggestRoom.get();
    }
}
