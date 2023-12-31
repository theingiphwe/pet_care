package com.example.pet_care.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReHomingRequest {

    private int reHomingId;
    private Date date;
    private String description;
    private int userId;
}
