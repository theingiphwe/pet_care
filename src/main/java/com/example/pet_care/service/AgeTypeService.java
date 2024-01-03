package com.example.pet_care.service;

import com.example.pet_care.entity.AgeType;

import java.util.List;

public interface AgeTypeService {
    void create(AgeType ageType);

    void deleteById(int id);

    void updateById(int id, AgeType ageType);

    List<AgeType> findAllAgeType();
}
