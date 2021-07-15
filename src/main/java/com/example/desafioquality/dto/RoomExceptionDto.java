package com.example.desafioquality.dto;


public class RoomExceptionDto {

    private final String message;

    public RoomExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
