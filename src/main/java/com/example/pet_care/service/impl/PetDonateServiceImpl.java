package com.example.pet_care.service.impl;

import com.example.pet_care.dto.PetDonateRequest;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.entity.PetDonate;
import com.example.pet_care.entity.User;
import com.example.pet_care.repo.PetDonateRepo;
import com.example.pet_care.repo.PetRepo;
import com.example.pet_care.repo.UserRepo;
import com.example.pet_care.service.PetDonateService;
import com.example.pet_care.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetDonateServiceImpl implements PetDonateService {

    private UserRepo userRepo;
    private PetRepo petRepo;
    private PetDonateRepo petDonateRepo;
    @Override
    public void create(PetDonateRequest petDonateRequest) {
        User user = userRepo.findById(petDonateRequest.getUserId())
                .orElseThrow(()->new IllegalArgumentException());
        Pet pet = petRepo.findById(petDonateRequest.getPetId())
                .orElseThrow(()->new IllegalArgumentException());
        PetDonate petDonate = PetDonate.of(petDonateRequest);
        petDonate.setPet(pet);
        petDonate.setUser(user);
        petDonateRepo.save(petDonate);

    }

    @Override
    public List<PetDonate> findAllUser() {
        return petDonateRepo.findAll();
    }

    @Override
    public void updateById(int id, PetDonateRequest petDonateRequest) {
        Optional<PetDonate> existingPetDonate = petDonateRepo.findById(id);
        User user = userRepo.findById(petDonateRequest.getUserId())
                        .orElseThrow(()->new IllegalArgumentException());
        Pet pet = petRepo.findById(petDonateRequest.getPetId())
                        .orElseThrow(()->new IllegalArgumentException());
        existingPetDonate.get().setUser(user);
        existingPetDonate.get().setPet(pet);
        existingPetDonate.get().setAmount(petDonateRequest.getAmount());
        existingPetDonate.get().setDescription(petDonateRequest.getDescription());
        petDonateRepo.save(existingPetDonate.get());
    }

    @Override
    public void deleteById(int id) {
        if(petDonateRepo.existsById(id)){
            petDonateRepo.deleteById(id);
        }
    }
}
