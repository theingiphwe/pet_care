package com.example.pet_care.service;

import com.example.pet_care.entity.Species;
import com.example.pet_care.entity.User;

import java.util.List;

public interface SpeciesService {

    Species create(Species petType);

    void deleteById(int id);

    void updateById(int id, Species species);

    List<Species> findAllSpecies();

    Species findById(int id);
}
