package com.softuni.cardealer.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierSeedDto {
    @Expose
    private String name;
    @Expose
    private boolean isImporter;
}
