package com.example.pet_care.service;

import com.example.pet_care.entity.AgeType;

public interface AgeTypeService {
    void create(AgeType ageType);

    void deleteById(int id);
}
