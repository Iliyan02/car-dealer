package com.softuni.cardealer.domain.repositories;

import com.softuni.cardealer.domain.entites.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Long> {
}
