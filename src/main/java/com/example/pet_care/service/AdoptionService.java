package com.example.pet_care.service;

import com.example.pet_care.entity.Adoption;
import com.example.pet_care.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdoptionService {
    void create(Adoption adoption);

    List<Adoption> findAllAdoption();

    void updateById(int id, Adoption adoption);

    void deleteById(int id);

    Adoption findById(int id);
}