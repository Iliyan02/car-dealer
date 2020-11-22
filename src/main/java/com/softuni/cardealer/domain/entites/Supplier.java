package com.softuni.cardealer.domain.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier extends BaseEntity{
    private String name;
    @Column(name = "is_importer")
    private boolean isImporter;
    @OneToMany(mappedBy = "supplier")
    private Set<Part> parts;
}
