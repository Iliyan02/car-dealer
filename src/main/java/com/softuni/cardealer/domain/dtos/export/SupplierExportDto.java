package com.softuni.cardealer.domain.dtos.export;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SupplierExportDto {
    @Expose
    private long id;
    @Expose
    private String name;
    @Expose
    private int count;
}
