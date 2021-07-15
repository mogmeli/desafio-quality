package com.example.desafioquality.service;

import com.example.desafioquality.models.Property;
import com.example.desafioquality.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllService {

    @Autowired
    PropertyRepository propertyRepository;

    public List<Property> getAll(){
        return propertyRepository.findAll();
    }
}