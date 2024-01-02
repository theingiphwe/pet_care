package com.example.pet_care.service;

import com.example.pet_care.dto.AdoptionRequest;
import com.example.pet_care.entity.Adoption;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdoptionService {
    void register(AdoptionRequest adoptionRequest);

    List<Adoption> findAllAdoption();

    void updateById(int id, AdoptionRequest adoptionRequest);

    void deleteById(int id);

    Adoption findById(int id);
}
