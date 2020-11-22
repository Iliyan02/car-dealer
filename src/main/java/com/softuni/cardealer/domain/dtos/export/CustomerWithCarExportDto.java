package com.softuni.cardealer.domain.dtos.export;


import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerWithCarExportDto {
    @Expose
    private String name;
    @Expose
    private int count;
    @Expose
    protected double spentMoney;

}
