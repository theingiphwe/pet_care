package com.example.pet_care.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Status {
    ON_SALE,
    OFF_SALE
}