package com.softuni.cardealer.domain.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity{
    private String make;
    private String model;
    @Column(name = "travelled_distance")
    private long travelledDistance;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Part> parts;
}
