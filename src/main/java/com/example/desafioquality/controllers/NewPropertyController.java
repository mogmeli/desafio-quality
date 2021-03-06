package com.example.desafioquality.controllers;

import com.example.desafioquality.dto.PropertyDto;
import com.example.desafioquality.controllers.form.PropertyForm;
import com.example.desafioquality.models.Property;
import com.example.desafioquality.service.NewPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController()
@RequestMapping("/property")
public class NewPropertyController {
    @Autowired
    NewPropertyService newPropertyService;

    @PostMapping
    public ResponseEntity<PropertyDto> newProperty(@RequestBody @Valid PropertyForm propertyForm, UriComponentsBuilder uriBuilder){

        Property property = newPropertyService.save(propertyForm);
        URI uri = uriBuilder.path("/property/{id}").buildAndExpand(property.getId()).toUri();

        return ResponseEntity.created(uri).body(new PropertyDto(property));
    }

}