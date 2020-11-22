package com.softuni.cardealer.domain.dtos.export;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerExportDto {
    @Expose
    private long id;
    @Expose
    private String name;
    @Expose
    private LocalDateTime birthDate;
    @Expose
    private boolean isYoungDriver;
    @Expose
    private Set<SaleExportDto> sales;
}
