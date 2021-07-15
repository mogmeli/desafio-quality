package com.example.desafioquality.service;

import com.example.desafioquality.controllers.form.PropertyForm;
import com.example.desafioquality.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewPropertyService {

    @Autowired
    NewPropertyService newPropertyService;

    public Property convert(PropertyForm propertyForm) {
        return propertyForm.convert(propertyForm);
    }

    public void save(Property property){
        //TODO: Check if district Id exists, if so, saves the property.
    }
}