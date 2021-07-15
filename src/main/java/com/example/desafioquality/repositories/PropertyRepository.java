package com.example.desafioquality.repositories;

import com.example.desafioquality.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
