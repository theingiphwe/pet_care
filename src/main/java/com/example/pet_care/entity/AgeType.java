package com.example.pet_care.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ageTypeId")
public class AgeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  ageTypeId;
    private String category;
    private String ageBetween;
    @OneToMany(mappedBy = "ageType")
    @JsonIgnore
    @JsonManagedReference
    private List<Pet> pets;
}
