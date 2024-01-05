package com.example.pet_care.enumTypes;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum DeleteStatus {

    ALLOW,
    DENY
}
