package com.softuni.cardealer.domain.dtos.export;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
public class PartsExportDto {
    private String name;
    private BigDecimal price;
}
