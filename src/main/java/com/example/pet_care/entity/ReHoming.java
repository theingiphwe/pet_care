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
public class ReHoming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reHomingId;
    private Date date;
    private String description;
}
