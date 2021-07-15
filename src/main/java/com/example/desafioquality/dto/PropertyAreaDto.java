package com.example.desafioquality.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class PropertyAreaDto {

    private String name;
    private List<RoomAreaDto> roomAreaDtoList;

    public PropertyAreaDto(String name, List<RoomAreaDto> roomAreaDtoList) {
        this.name = name;
        this.roomAreaDtoList = roomAreaDtoList;
    }
}
