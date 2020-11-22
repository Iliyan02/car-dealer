package com.softuni.cardealer;

import com.softuni.cardealer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Engine implements CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public Engine(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
       // seedData();
        //System.out.println(this.customerService.orderedCustomers());
        //System.out.println(this.carService.findByToyota());
        //System.out.println(this.supplierService.suppliersNotFromAbroad());
        //System.out.println(this.carService.findAllCarsWithParts());
       // System.out.println(this.customerService.getCustomersWithCar());


        //seedDataXmlFiles();
        // Имах проблеми със сийдването при мапинг таблицата,
        // но това не се отразява на изпълнението на методите,
        // ако разберете как да ги оправя, пишете в description-a

        //this.customerService.exportOrdered();
        //this.carService.exportByToyota();
        //this.supplierService.suppliersNotFromAbroad();
//        this.carService.carsAndTheirPartXml();
        this.saleService.saleDiscount();

    }

    private void seedDataXmlFiles() throws Exception {
        this.supplierService.seedSupplier();
        this.partService.seedPart();
        this.customerService.seedCustomers();
        this.saleService.seedSales();
        this.carService.seedCars();
    }

//    private void seedData() throws Exception {
//        this.supplierService.seedSupplier();
//        this.partService.seedPart();
//        this.carService.seedCars();
//        this.customerService.seedCustomers();
//        this.saleService.seedSales();
//    }
}
