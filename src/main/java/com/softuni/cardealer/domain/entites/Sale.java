package com.softuni.cardealer.domain.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale extends BaseEntity{
    private int discount;
    @OneToOne
    private Car car;
    @ManyToOne
    private Customer customer;
}
