package com.example.desafioquality.controllers;


import com.example.desafioquality.dto.PropertyTotalAreaDto;
import com.example.desafioquality.dto.PropertyValueDto;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.service.FindValuePropertyService;
import com.example.desafioquality.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TotalAreaController {

    @Autowired
    FindValuePropertyService findValuePropertyService;

    @Autowired
    PropertyService propertyService;

    @GetMapping("/{id}/totalarea")
    public ResponseEntity<PropertyTotalAreaDto> getTotalArea(@PathVariable Long id){

        Property property = propertyService.getById(id);
        PropertyTotalAreaDto propertyTotalAreaDto = new PropertyTotalAreaDto(
                property.getName(),
                property.getRooms().size(),
                findValuePropertyService.totalArea(property));

        return ResponseEntity.ok(propertyTotalAreaDto);
    }

    @GetMapping("/{id}/precoTotalArea")
    public ResponseEntity<PropertyValueDto> getValueProperty(@PathVariable Long id) {

        Property property = propertyService.getById(id);

        PropertyValueDto propertyValueDto = new PropertyValueDto(
                property.getName(),
                property.getRooms().size(),
                findValuePropertyService.valueProperty(property));

        return ResponseEntity.ok(propertyValueDto);
    }
}
