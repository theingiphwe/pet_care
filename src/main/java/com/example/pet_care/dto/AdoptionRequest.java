package com.example.pet_care.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AdoptionRequest {

    private Date date;
    private String comment;
    private int userId;
    private int petId;//*
}
