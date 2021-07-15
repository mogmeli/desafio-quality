package com.example.desafioquality.exception.handler;

import com.example.desafioquality.exception.NoRoomFoundException;
import com.example.desafioquality.dto.RoomExceptionDto;
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
