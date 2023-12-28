package com.example.pet_care.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adoptionID;
    private Date date;
    private String comment;
}
