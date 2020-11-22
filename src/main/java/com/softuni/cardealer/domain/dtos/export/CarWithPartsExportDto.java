package com.softuni.cardealer.domain.dtos.export;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarWithPartsExportDto {
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private long travelledDistance;
    @Expose
    private PartsExportDto partsExportDtos;
}
