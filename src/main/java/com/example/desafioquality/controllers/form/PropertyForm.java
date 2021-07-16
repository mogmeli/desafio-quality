package com.example.desafioquality.controllers.form;

import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;
import com.example.desafioquality.repositories.DistrictRepository;
import com.example.desafioquality.service.DistrictService;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

@Setter
@Getter
public class PropertyForm {

    @Size(max = 30)
    @NotNull
    @Pattern(regexp = "^[A-Z].*", message = "Must start with capital letter")
    @NotEmpty
    String prop_name;
    @NotNull
    @NotEmpty
    String dist_name;
    @Valid
    List<RoomForm> roomsList;

    public PropertyForm() {
    }

    public PropertyForm(String prop_name, String dist_name, List<RoomForm> roomsList) {
        this.prop_name = prop_name;
        this.dist_name = dist_name;
        this.roomsList = roomsList;
    }

    public Property convert(DistrictService districtService){
        return new Property(prop_name, RoomForm.convert(roomsList), districtService.getDistrict(dist_name));
    }
}