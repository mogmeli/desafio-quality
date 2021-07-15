package com.example.desafioquality.service;

import com.example.desafioquality.controllers.form.PropertyForm;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.repositories.DistrictRepository;
import com.example.desafioquality.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewPropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    DistrictService districtService;

    public Property save(PropertyForm propertyForm){
        Property property = propertyForm.convert(districtService);
        propertyRepository.save(property);
        return property;
    }
}