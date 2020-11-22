package com.softuni.cardealer.domain.repositories;

import com.softuni.cardealer.domain.entites.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
//    @Query("select c FROM Car c WHERE c.make = :make order by c.model, c.travelledDistance desc")
    Set<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
    Set<Car> findAllBy();
}
