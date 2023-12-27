package com.example.pet_care.service;

import com.example.pet_care.entity.Pet_Type;

public interface Pet_TypeService {

    Pet_Type create(Pet_Type petType);

    void deleteById(int id);
}
