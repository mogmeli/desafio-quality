package com.example.desafioquality.controllers.form;

import com.example.desafioquality.models.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Builder
@Getter
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

    public static List<Room> convert(List<RoomForm> list){
            return list.stream().map(e ->
                new Room(e.getName(), e.getWidth(), e.getLength())
            ).collect(Collectors.toList());
    }
}