package com.example.pet_care.dto;

import com.example.pet_care.entity.FilePath;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.enumTypes.Gender;
import com.example.pet_care.enumTypes.Size;
import lombok.Data;

@Data
public class PetDto {
    private int petId;
    private String name;
    private int age;
    private String breed;
    private Gender gender;
    private String description;
    private String color;
    private Size size;
    private int speciesId;
    private int ageTypeId;
    private String image;

    public  static PetDto of(Pet pet){
        PetDto petDto = new PetDto();
        petDto.setPetId(pet.getId());
        petDto.setName(pet.getName());
        petDto.setSize(pet.getSize());
        petDto.setGender(pet.getGender());
        petDto.setColor(pet.getColor());
        petDto.setAge(pet.getAge());
        petDto.setBreed(pet.getBreed());
        petDto.setDescription(pet.getDescription());
        petDto.setImage("http://localhost:8080/pet/images/"+pet.getId());
        return petDto;
    }

}
