package com.example.desafioquality.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomAreaDto {

    private String name;
    private double area;

    public RoomAreaDto(String name, double area) {
        this.name = name;
        this.area = area;
    }
}
