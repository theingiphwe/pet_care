package com.example.pet_care.entity;

import com.example.pet_care.dto.PetDonateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class PetDonate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petDonateId;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private double amount;
    private String description;

    public static PetDonate of(PetDonateRequest petDonateRequest){
        PetDonate petDonate = new PetDonate();
        petDonate.setAmount(petDonateRequest.getAmount());
        petDonate.setDescription(petDonateRequest.getDescription());
        return petDonate;
    }
}
