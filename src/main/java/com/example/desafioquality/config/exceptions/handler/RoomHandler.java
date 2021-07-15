package com.example.desafioquality.config.exceptions.handler;

import com.example.desafioquality.config.exceptions.NoRoomFoundException;
import com.example.desafioquality.dtos2.RoomExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RoomHandler {

    @ExceptionHandler(NoRoomFoundException.class)
    public ResponseEntity<RoomExceptionDto> notFoundHandler(NoRoomFoundException noRoomFoundException){
        return ResponseEntity.badRequest().body(new RoomExceptionDto(noRoomFoundException.getMessage()));
    }
}
