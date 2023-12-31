package com.example.pet_care.entity;

import com.example.pet_care.dto.DonateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Getter
@Setter
public class Donate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private String description;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public static Donate of(DonateRequest donateRequest){
        Donate donate  = new Donate();
        donate.setAmount(donateRequest.getAmount());
        donate.setDate(donateRequest.getDate());
        donate.setDescription(donateRequest.getDescription());
        return donate;
    }
}
