package com.example.desafioquality.repositories;

import com.example.desafioquality.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
