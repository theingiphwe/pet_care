package com.example.pet_care.service.impl;

import com.example.pet_care.entity.Pet_Type;
import com.example.pet_care.repo.Pet_TypeRepo;
import com.example.pet_care.service.Pet_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Pet_TypeServiceImpl implements Pet_TypeService {
    @Autowired
    private Pet_TypeRepo petTypeRepo;
    @Override
    public Pet_Type create(Pet_Type petType) {
        return petTypeRepo.save(petType);
    }

    @Override
    public void deleteById(int id) {
        if(petTypeRepo.existsById(id)){
            petTypeRepo.deleteById(id);
        }
    }
}
