package com.example.desafioquality.service;

import com.example.desafioquality.exception.PropertyNotFoundException;
import com.example.desafioquality.models.District;
import com.example.desafioquality.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    public District getDistrict(String dist_name) {
        Optional<District> district = Optional.ofNullable(districtRepository.getByName(dist_name));

        if(district.isEmpty()){
            throw new PropertyNotFoundException("The provided district name does not exist.");
        }else{
            return district.get();
        }
    }
}