package com.softuni.cardealer.domain.repositories;

import com.softuni.cardealer.domain.entites.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Long> {
    @Query("SELECT s FROM Supplier s WHERE s.isImporter = FALSE")
    Set<Supplier> findAllByImpo();
}
