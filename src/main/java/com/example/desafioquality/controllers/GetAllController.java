package com.example.desafioquality.controllers;

import com.example.desafioquality.models.Property;
import com.example.desafioquality.service.GetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class GetAllController {

    @Autowired
    GetAllService getAllService;

    @GetMapping()
    public ResponseEntity<List<Property>> getAllProperty(){
        return ResponseEntity.ok(getAllService.getAll());
    }
}