package com.example.pet_care.service.impl;

import com.example.pet_care.entity.AgeType;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.repo.AgeTypeRepo;
import com.example.pet_care.service.AgeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgeTypeServiceImpl implements AgeTypeService {

    @Autowired
    private AgeTypeRepo ageTypeRepo;
    @Override
    public void create(AgeType ageType) {
        ageTypeRepo.save(ageType);
    }

    @Override
    public void deleteById(int id) {
        if(ageTypeRepo.existsById(id)){
            ageTypeRepo.deleteById(id);
        }
    }

    @Override
    public void updateById(int id, AgeType ageType) {
        AgeType existingAgeType = ageTypeRepo.findById(id)
                .orElseThrow(()->new IllegalArgumentException());
        existingAgeType.setAgeBetween(ageType.getAgeBetween());
        existingAgeType.setCategory(ageType.getCategory());
        ageTypeRepo.save(existingAgeType);

    }

    @Override
    public List<AgeType> findAllAgeType() {
        return ageTypeRepo.findAll();
    }
}
