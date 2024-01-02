package com.example.pet_care.service.impl;

import com.example.pet_care.entity.AgeType;
import com.example.pet_care.repo.AgeTypeRepo;
import com.example.pet_care.service.AgeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
