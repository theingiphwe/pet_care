package com.example.pet_care.entity;

import com.example.pet_care.dto.PetDto;
import com.example.pet_care.dto.PetRequest;
import com.example.pet_care.enumTypes.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String breed;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String description;

    private String color;

    @Enumerated(EnumType.STRING)
    private Size size;
    @Enumerated(EnumType.STRING)
    private Adoptable isAdoptable;
    @Enumerated(EnumType.STRING)
    private AdoptionStatus adoptionStatus;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    @OneToMany(mappedBy = "pet",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PetDonate> petDonates;

    @ManyToOne
    @JoinColumn(name = "speciesId")
    private Species species;

    @ManyToOne
    @JoinColumn(name = "ageTypeId")
    private AgeType ageType;

    @OneToOne
    @JoinColumn(name = "filePath_PetImage")
    private FilePath filePath;


    public static Pet of(PetRequest petRequest){
        Pet pet = new Pet();
        pet.setName(petRequest.getName());
        pet.setAge(petRequest.getAge());
        pet.setSize(petRequest.getSize());
        pet.setDescription(petRequest.getDescription());
        pet.setGender(petRequest.getGender());
        pet.setBreed(petRequest.getBreed());
        pet.setColor(petRequest.getColor());
        return pet;

    }



}
