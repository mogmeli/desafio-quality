package com.example.desafioquality.controllers;

import com.example.desafioquality.controllers.Dto.PropertyDto;
import com.example.desafioquality.controllers.form.PropertyForm;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.service.NewPropertyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/new")
public class NewPropertyController {
    @Autowired
    NewPropertyService newPropertyService;

    @PostMapping
    public ResponseEntity<PropertyDto> newProperty(@RequestBody PropertyForm propertyForm, UriComponentsBuilder uriBuilder){
        Property property = newPropertyService.convert(propertyForm);
        newPropertyService.save(property);
        URI uri = uriBuilder.path("/property/{id}").buildAndExpand(property.getId()).toUri();

        return ResponseEntity.ok().body(new PropertyDto(property));

    }

}