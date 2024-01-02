package com.example.pet_care.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class DonateRequest {

    private double amount;
    private String description;
    private Date date;
    private int userId;
}
