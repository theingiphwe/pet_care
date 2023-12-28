package com.example.pet_care.dto;

import com.example.pet_care.entity.Gender;
import com.example.pet_care.entity.Size;
import com.example.pet_care.entity.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetRequest {
    private int petId;
    private String name;
    private int age;
    private String breed;
    private Gender gender;
    private String image;
    private String description;
    private Size size;
    private Status status;
    private int speciesId;
}