package com.example.desafioquality.controllers.form;

import com.example.desafioquality.models.Room;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

@Setter
public class RoomForm {

    @Size(max = 30)
    @NotNull
    @Pattern(regexp = "^[A-Z].*", message = "Must start with capital letter")
    @NotEmpty
    private final String name;
    @Max(value = 25)
    @NotNull
    @Min( value = 1)
    private final double width;
    @Max(value = 33)
    @NotNull
    @Min( value = 1)
    private final double length;

    public RoomForm(Room room) {
        this.name = room.getName();
        this.width = room.getWidth();
        this.length = room.getLength();
    }

    public static List<Room> convert(List<RoomForm> list){
            return list.stream().map(e ->
                new Room(e.name, e.width, e.length)
            ).collect(Collectors.toList());
    }
}