package com.softuni.cardealer.services.impl;

import com.google.gson.Gson;
import com.softuni.cardealer.constants.GlobalConstants;
import com.softuni.cardealer.domain.dtos.exportXmls.CustomerExportOrderDtoXml;
import com.softuni.cardealer.domain.dtos.exportXmls.CustomerOrderedRootExportDtoXml;
import com.softuni.cardealer.domain.dtos.importXmls.CustomerImportDtoXml;
import com.softuni.cardealer.domain.dtos.importXmls.CustomerImportRootDtoXml;
import com.softuni.cardealer.domain.entites.Customer;
import com.softuni.cardealer.domain.repositories.CustomerRepo;
import com.softuni.cardealer.services.CustomerService;
import com.softuni.cardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final static String CUSTOMERS_ORDERED = "src/main/resources/xmls/exported/ordered-customers.xml";
    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final XmlParser xmlParser;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper modelMapper, Gson gson, XmlParser xmlParser) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCustomers() throws IOException, JAXBException {
        CustomerImportRootDtoXml customerImportRootDtoXml = this.xmlParser.parseXml(CustomerImportRootDtoXml.class, GlobalConstants.CUSTOMERS_PATH_XML);
        for (CustomerImportDtoXml customerDto : customerImportRootDtoXml.getCustomers()) {
            Customer customer = this.modelMapper.map(customerDto, Customer.class);
            this.customerRepo.saveAndFlush(customer);
        }
    }

    @Override
    public void exportOrdered() throws JAXBException {
        Set<CustomerExportOrderDtoXml> dtos = this.customerRepo.findAllAndSort()
                .stream()
                .map(c -> this.modelMapper.map(c, CustomerExportOrderDtoXml.class))
                .collect(Collectors.toSet());

        CustomerOrderedRootExportDtoXml rootDto = new CustomerOrderedRootExportDtoXml();
        rootDto.setCustomers(dtos);
        this.xmlParser.exportXml(rootDto, CustomerOrderedRootExportDtoXml.class, CUSTOMERS_ORDERED);
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
