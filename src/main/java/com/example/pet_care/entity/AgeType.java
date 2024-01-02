package com.example.pet_care.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class AgeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  ageTypeId;
    private String category;
    private String ageBetween;
    @OneToMany(mappedBy = "ageType",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pet> pets;
}
