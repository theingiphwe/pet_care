package com.example.pet_care.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDonateRequest {

    private int petId;
    private int userId;
    private double amount;
    private String description;
}
