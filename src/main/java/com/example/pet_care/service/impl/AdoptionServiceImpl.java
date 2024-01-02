package com.example.pet_care.service.impl;

import com.example.pet_care.dto.AdoptionRequest;
import com.example.pet_care.entity.Adoption;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.entity.User;
import com.example.pet_care.repo.AdoptionRepo;
import com.example.pet_care.repo.PetRepo;
import com.example.pet_care.repo.UserRepo;
import com.example.pet_care.service.AdoptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {

    private AdoptionRepo adoptionRepo;
    private UserRepo userRepo;

    private PetRepo petRepo;
    @Override
    public void register(AdoptionRequest adoptionRequest) {
        User user = userRepo.findById(adoptionRequest.getUserId())
                        .orElseThrow(()->new IllegalArgumentException());
        Pet pet = petRepo.findById(adoptionRequest.getPetId())
                .orElseThrow(()-> new IllegalArgumentException());

        Adoption adoption = Adoption.of(adoptionRequest);
        adoption.setPet(pet);
        adoption.setUser(user);
        adoptionRepo.save(adoption);
    }

    @Override
    public List<Adoption> findAllAdoption() {
        return adoptionRepo.findAll();
    }

    @Override
    public void updateById(int id, AdoptionRequest adoptionRequest) {
        Optional<Adoption> existingAdoption = adoptionRepo.findById(id);
        existingAdoption.get().setDate(adoptionRequest.getDate());
        existingAdoption.get().setComment(adoptionRequest.getComment());
        Pet pet = petRepo.findById(adoptionRequest.getPetId())
                .orElseThrow(()->new IllegalArgumentException());
        User user = userRepo.findById(adoptionRequest.getUserId())
                .orElseThrow(()->new IllegalArgumentException());
        existingAdoption.get().setPet(pet);
        existingAdoption.get().setUser(user);
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
