package com.example.pet_care.service.impl;

import com.example.pet_care.entity.Adoption;
import com.example.pet_care.repo.AdoptionRepo;
import com.example.pet_care.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdoptionServiceImpl implements AdoptionService {

    @Autowired
    private AdoptionRepo adoptionRepo;
    @Override
    public void create(Adoption adoption) {
        adoptionRepo.save(adoption);
    }

    @Override
    public List<Adoption> findAllAdoption() {
        return adoptionRepo.findAll();
    }

    @Override
    public void updateById(int id, Adoption adoption) {
        Optional<Adoption> existingAdoption = adoptionRepo.findById(id);
        existingAdoption.get().setDate(adoption.getDate());
        existingAdoption.get().setComment(adoption.getComment());
        adoptionRepo.save(existingAdoption.get());
    }

    @Override
    public void deleteById(int id) {
        if(adoptionRepo.existsById(id)){
            adoptionRepo.deleteById(id);
        }
    }

    @Override
    public Adoption findById(int id) {
        return adoptionRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }
}
