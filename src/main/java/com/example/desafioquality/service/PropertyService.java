package com.example.desafioquality.service;


import com.example.desafioquality.exception.PropertyNotFoundException;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.repositories.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyService {

    PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public Property getById(Long id) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if(optionalProperty.isEmpty())
            throw new PropertyNotFoundException("Property not found.");
        return optionalProperty.get();

    }
}
