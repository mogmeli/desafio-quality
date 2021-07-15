package com.example.desafioquality.controllers.form;

import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;

import javax.swing.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

public class PropertyForm {

    @Size(max = 30)
    @NotNull
    @Pattern(regexp = "^[A-Z][a-z0-9_-]{3,19}$")
    String prop_name;
    @NotNull
    Long id_District;
    List<Room> roomsList;

    public Property convert(PropertyForm propertyForm){
        return new Property(prop_name, roomsList);
    }

}