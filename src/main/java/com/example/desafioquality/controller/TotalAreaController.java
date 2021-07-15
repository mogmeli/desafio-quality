package com.example.desafioquality.controller;


import com.example.desafioquality.controller.dto.PropertyTotalAreaDto;
import com.example.desafioquality.controller.dto.PropertyValueDto;
import com.example.desafioquality.service.FindValuePropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TotalAreaController {

    @Autowired
    FindValuePropertyService findValuePropertyService;

    @GetMapping("/{id}/totalarea")
    public ResponseEntity<PropertyTotalAreaDto> getTotalArea(@PathVariable Long id){

        return ResponseEntity.ok(findValuePropertyService.getDtoTotalArea(id));
    }

    @GetMapping("/{id}/precoTotalArea")
    public ResponseEntity<PropertyValueDto> getValueProperty(@PathVariable Long id) {

        return ResponseEntity.ok(findValuePropertyService.getDtoValue(id));
    }
}
