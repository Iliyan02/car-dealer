package com.softuni.cardealer.domain.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name =  "parts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Part extends BaseEntity{
    private String name;
    private BigDecimal price;
    private int quantity;
    @ManyToOne()
    private Supplier supplier;
    @ManyToMany(mappedBy = "parts")
    private Set<Car> cars;
}
