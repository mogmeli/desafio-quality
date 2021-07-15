package com.example.desafioquality.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PropertyValueDto {

    private final String propName;
    private final long roomsCount;
    private final BigDecimal value;


    public PropertyValueDto(String propName, long roomsCount, BigDecimal value) {
        this.propName = propName;
        this.roomsCount = roomsCount;
        this.value = value;
    }
}
