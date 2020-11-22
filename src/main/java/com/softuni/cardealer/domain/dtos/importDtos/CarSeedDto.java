package com.softuni.cardealer.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarSeedDto {
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private long travelledDistance;
}
