package com.example.pet_care.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDonate {
    private double Amount;
    private String Description;
}
