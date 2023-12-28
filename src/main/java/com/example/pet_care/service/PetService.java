package com.example.pet_care.service;

import com.example.pet_care.dto.PetRequest;
import com.example.pet_care.entity.Pet;

import java.util.List;

public interface PetService {
    void register(PetRequest petRequest);

    List<Pet> findAllUser();

    void updateById(int id, Pet pet);

    void deleteById(int id);

    Pet findById(int id);
}
