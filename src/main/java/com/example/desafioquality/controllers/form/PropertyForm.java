package com.example.desafioquality.controllers.form;

import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;
import com.example.desafioquality.repositories.DistrictRepository;
import com.example.desafioquality.service.DistrictService;
import lombok.Setter;

import javax.swing.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

@Setter
public class PropertyForm {

    @Size(max = 30)
    @NotNull
    @Pattern(regexp = "^[A-Z][a-z0-9_-]{3,19}$")
    String prop_name;
    @NotNull
    String dist_name; //TODO: insert this value on constructor
    List<Room> roomsList;

    public PropertyForm() {
    }

    public Property convert(DistrictService districtService){
        return new Property(prop_name, roomsList, districtService.getDistrict(dist_name));
    }
}