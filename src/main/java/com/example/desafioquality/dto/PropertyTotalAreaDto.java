package com.example.desafioquality.dto;


import lombok.Getter;


@Getter
public class PropertyTotalAreaDto {

    private final String propName;
    private final long roomsCount;
    private final double size;

    public PropertyTotalAreaDto(String propName, long roomsCount, double size) {
        this.propName = propName;
        this.roomsCount = roomsCount;
        this.size = size;
    }
}
