package com.example.pet_care.dto;

import com.example.pet_care.enumTypes.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetRequest {
    private String name;
    private int age;
    private String breed;
    private Gender gender;
    private String image;
    private String description;
    private String color;
    private Size size;
    private Adoptable isAdoptable;
    private AdoptionStatus adoptionStatus;
    private DeleteStatus deleteStatus;
    private int speciesId;

    private int ageTypeId;

}
