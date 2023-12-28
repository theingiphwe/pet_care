package com.example.pet_care.service.impl;

import com.example.pet_care.entity.Species;
import com.example.pet_care.entity.User;
import com.example.pet_care.repo.SpeciesRepo;
import com.example.pet_care.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesServiceImpl implements SpeciesService {
    @Autowired
    private SpeciesRepo speciesRepo;
    @Override
    public Species create(Species petType) {
        return speciesRepo.save(petType);
    }

    @Override
    public void deleteById(int id) {
        if(speciesRepo.existsById(id)){
            speciesRepo.deleteById(id);
        }
    }

    @Override
    public void updateById(int id, Species species) {
        Optional<Species> existingSpecies = speciesRepo.findById(id);
        existingSpecies.get().setName(species.getName());
        speciesRepo.save(existingSpecies.get());
    }

    @Override
    public List<Species> findAllSpecies() {
        return speciesRepo.findAll();
    }

    @Override
    public Species findById(int id) {
        return speciesRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }
}
