package com.softuni.cardealer.domain.repositories;

import com.softuni.cardealer.domain.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
//    @Query("SELECT c FROM Customer AS c \n" +
//            "ORDER BY birth_date ASC, is_young_driver ASC")
//    Set<Customer> getAllByOrderByYoungDriverAscBirthDateAsc();
//    @Query("select c from Customer c WHERE c. > 0")
//    Set<Customer> getCustomersBySalesContaining();

    @Query("select c FROM Customer c order by c.birthDate, c.isYoungDriver desc ")
    Set<Customer> findAllAndSort();
}
