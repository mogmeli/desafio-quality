package com.example.desafioquality.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private District district;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Room> rooms;

    public Property() {
    }

    public Property(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }
}