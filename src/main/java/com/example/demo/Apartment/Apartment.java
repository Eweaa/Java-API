package com.example.demo.Apartment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Apartment
(
    Integer Id,
    @NotEmpty @Positive Integer Price,
    String Location
){}
