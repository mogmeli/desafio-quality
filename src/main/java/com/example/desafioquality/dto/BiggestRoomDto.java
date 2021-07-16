package com.example.desafioquality.dto;

import lombok.Getter;

@Getter
public class BiggestRoomDto {

    private String name;
    private RoomAreaDto biggestRoom;

    public BiggestRoomDto(String name, RoomAreaDto biggestRoom) {
        this.name = name;
        this.biggestRoom = biggestRoom;
    }
}
