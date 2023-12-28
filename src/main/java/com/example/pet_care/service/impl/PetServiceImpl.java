package com.example.pet_care.service.impl;

import com.example.pet_care.dto.PetRequest;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.entity.Species;
import com.example.pet_care.repo.PetRepo;
import com.example.pet_care.repo.SpeciesRepo;
import com.example.pet_care.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private SpeciesRepo speciesRepo;
    @Override
    public void register(PetRequest petRequest) {
        Species species = speciesRepo.findById(petRequest.getSpeciesId())
                .orElseThrow(()->new IllegalArgumentException());
        Pet pet = Pet.of(petRequest);
        pet.setSpecies(species);
        petRepo.save(pet);
    }

    @Override
    public List<Pet> findAllUser() {
        return petRepo.findAll();
    }

    @Override
    public void updateById(int id, Pet pet) {
        Optional<Pet> existingPet = petRepo.findById(id);
        existingPet.get().setName(pet.getName());
        existingPet.get().setAge(pet.getAge());
        existingPet.get().setBreed(pet.getBreed());
        existingPet.get().setGender(pet.getGender());
        existingPet.get().setImage(pet.getImage());
        existingPet.get().setDescription(pet.getDescription());
        existingPet.get().setSize(pet.getSize());
        existingPet.get().setStatus(pet.getStatus());
        petRepo.save(existingPet.get());
    }

    @Override
    public void deleteById(int id) {
        if(petRepo.existsById(id)){
            petRepo.deleteById(id);
        }
    }

    @Override
    public Pet findById(int id) {
        return petRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }
}
