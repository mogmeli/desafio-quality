package com.example.desafioquality.repositories;

import com.example.desafioquality.models.District;
import com.example.desafioquality.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Long> {
}
