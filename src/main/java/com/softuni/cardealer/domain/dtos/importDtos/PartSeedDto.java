package com.softuni.cardealer.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartSeedDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private int quantity;
}
