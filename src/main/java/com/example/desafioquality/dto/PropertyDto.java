package com.example.desafioquality.dto;

import com.example.desafioquality.models.Property;
import com.example.desafioquality.models.Room;

import java.math.BigDecimal;
import java.util.List;

public class PropertyDto {

    private final String prop_name;
    private final String prop_district;
    private final List<Room> roomsDtoList;
    public PropertyDto(Property property){
        prop_name = property.getName();
        prop_district = property.getDistrict().getName();
        roomsDtoList = property.getRooms();
    }

    public String getProp_name() {
        return prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public List<Room> getRoomsDtoList() {
        return roomsDtoList;
    }
}