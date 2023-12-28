package com.example.pet_care.entity;

import com.example.pet_care.dto.PetRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String breed;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String image;
    private String description;
    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "speciesId")
    private Species species;

    public static Pet of(PetRequest petRequest){
        Pet pet = new Pet();
        pet.setName(petRequest.getName());
        pet.setAge(petRequest.getAge());
        pet.setSize(petRequest.getSize());
        pet.setImage(petRequest.getImage());
        pet.setDescription(petRequest.getDescription());
        pet.setStatus(petRequest.getStatus());
        pet.setGender(petRequest.getGender());
        pet.setBreed(petRequest.getBreed());
        return pet;

    }


}
