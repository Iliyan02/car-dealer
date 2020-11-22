package com.softuni.cardealer.domain.repositories;

import com.softuni.cardealer.domain.entites.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepo extends JpaRepository<Part, Long> {
}
