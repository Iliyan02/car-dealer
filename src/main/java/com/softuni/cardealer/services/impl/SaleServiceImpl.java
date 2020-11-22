package com.softuni.cardealer.services.impl;

import com.softuni.cardealer.domain.entites.Car;
import com.softuni.cardealer.domain.entites.Customer;
import com.softuni.cardealer.domain.entites.Sale;
import com.softuni.cardealer.domain.repositories.CarRepo;
import com.softuni.cardealer.domain.repositories.CustomerRepo;
import com.softuni.cardealer.domain.repositories.SaleRepo;
import com.softuni.cardealer.services.SaleService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepo saleRepo;
    private final CarRepo carRepo;
    private final CustomerRepo customerRepo;

    public SaleServiceImpl(SaleRepo saleRepo, CarRepo carRepo, CustomerRepo customerRepo) {
        this.saleRepo = saleRepo;
        this.carRepo = carRepo;
        this.customerRepo = customerRepo;
    }








//    @Override
//    public void seedSales() {
//        Sale sale = new Sale();
//        sale.setCar(getRandomCar());
//        sale.setCustomer(getRandomCustomer());
//        sale.setDiscount(5);
//
//        Sale sale1 = new Sale();
//        sale1.setCar(getRandomCar());
//        sale1.setCustomer(getRandomCustomer());
//        sale1.setDiscount(10);
//
//        Sale sale2 = new Sale();
//        sale2.setCar(getRandomCar());
//        sale2.setCustomer(getRandomCustomer());
//        sale2.setDiscount(30 );
//
//        this.saleRepo.saveAndFlush(sale);
//        this.saleRepo.saveAndFlush(sale1);
//        this.saleRepo.saveAndFlush(sale2);
//    }
//
//    private Customer getRandomCustomer() {
//        Random random = new Random();
//        long id = (long) random.nextInt((int)this.customerRepo.count()) + 1;
//        return this.customerRepo.findById(id).get();
//    }
//
//    private Car getRandomCar() {
//        Random random = new Random();
//        long id = (long) random.nextInt((int)this.carRepo.count()) + 1;
//        return this.carRepo.findById(id).get();
//    }
}
