package com.softuni.cardealer.services.impl;

import com.google.gson.Gson;
import com.softuni.cardealer.domain.dtos.export.CustomerExportDto;
import com.softuni.cardealer.domain.dtos.export.CustomerWithCarExportDto;
import com.softuni.cardealer.domain.dtos.importDtos.CustomerSeedDto;
import com.softuni.cardealer.domain.entites.Customer;
import com.softuni.cardealer.domain.repositories.CustomerRepo;
import com.softuni.cardealer.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final String CUSTOMERS_PATH = "src/main/resources/jsons/customers.json";
    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper modelMapper, Gson gson) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

//    @Override
//    public void seedCustomers() throws IOException {
//        String content = String.join("", Files.readAllLines(Path.of(CUSTOMERS_PATH)));
//        CustomerSeedDto[] customerSeedDto = this.gson.fromJson(content, CustomerSeedDto[].class);
//        for (CustomerSeedDto seedDto : customerSeedDto) {
//            Customer customer = this.modelMapper.map(seedDto, Customer.class);
//            this.customerRepo.saveAndFlush(customer);
//        }









//    @Override
//    public String orderedCustomers() {
//        Set<Customer> allByOrderByYoungDriverAscBirthDateAsc = this.customerRepo.getAllByOrderByYoungDriverAscBirthDateAsc();
//
//        List<CustomerExportDto> toExport = new ArrayList<>();
//        for (Customer customer : allByOrderByYoungDriverAscBirthDateAsc) {
//            CustomerExportDto customerExportDto= this.modelMapper.map(customer, CustomerExportDto.class);
//            toExport.add(customerExportDto);
//        }
//        return this.gson.toJson(toExport);
//    }
//
//    @Override
//    public String getCustomersWithCar() {
//        Set<Customer> customers = this.customerRepo.getCustomersBySalesContaining();
//        List<CustomerWithCarExportDto> customerWithCarExportDtos = new ArrayList<>();
//        for (Customer customer : customers) {
//            CustomerWithCarExportDto customerWithCarExportDto = this.modelMapper.map(customer, CustomerWithCarExportDto.class);
//            customerWithCarExportDto.setCount(customer.getSales().size());
//            customerWithCarExportDtos.add(customerWithCarExportDto);
//        }
//        return gson.toJson(customerWithCarExportDtos);
//    }
}
