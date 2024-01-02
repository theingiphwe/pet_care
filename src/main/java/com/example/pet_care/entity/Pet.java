package com.example.pet_care.entity;

import com.example.pet_care.dto.PetRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    private String color;

    @Enumerated(EnumType.STRING)
    private Size size;

//    @Enumerated(EnumType.STRING)
//    private Status status;
    @Column(name = "is_adoptable")
    private boolean isAdoptable;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "pet",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PetDonate> petDonates;

    @ManyToOne
    @JoinColumn(name = "speciesId")
    private Species species;

//    @ManyToOne
//    @JoinTable(name = "pet_reHoming",joinColumns = @JoinColumn(name = "pet_id"),
//            inverseJoinColumns = @JoinColumn(name = "reHoming_id"))
//    private ReHoming reHoming;

//    @ManyToOne
//    @JoinTable(name = "pet_adoption",joinColumns = @JoinColumn(name = "pet_id"),
//            inverseJoinColumns = @JoinColumn(name = "adoption_id"))
//    private Adoption adoption;

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
        pet.setColor(petRequest.getColor());
        pet.setAdoptable(petRequest.isAdoptable());
        return pet;

    }


}
