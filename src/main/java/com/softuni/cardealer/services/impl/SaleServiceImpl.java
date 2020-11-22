package com.softuni.cardealer.services.impl;

import com.softuni.cardealer.domain.dtos.lastExport.SaleExportDto;
import com.softuni.cardealer.domain.dtos.lastExport.SaleExportRootDto;
import com.softuni.cardealer.domain.entites.Car;
import com.softuni.cardealer.domain.entites.Customer;
import com.softuni.cardealer.domain.entites.Sale;
import com.softuni.cardealer.domain.repositories.CarRepo;
import com.softuni.cardealer.domain.repositories.CustomerRepo;
import com.softuni.cardealer.domain.repositories.SaleRepo;
import com.softuni.cardealer.services.SaleService;
import com.softuni.cardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private static final String SALE_WITH_DISCOUNT = "src/main/resources/xmls/exported/sales-discounts.xml";
    private final SaleRepo saleRepo;
    private final CarRepo carRepo;
    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public SaleServiceImpl(SaleRepo saleRepo, CarRepo carRepo, CustomerRepo customerRepo, ModelMapper modelMapper, XmlParser xmlParser) {
        this.saleRepo = saleRepo;
        this.carRepo = carRepo;
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }








    @Override
    public void seedSales() {
        Sale sale = new Sale();
        sale.setCar(getRandomCar());
        sale.setCustomer(getRandomCustomer());
        sale.setDiscount(5);

        Sale sale1 = new Sale();
        sale1.setCar(getRandomCar());
        sale1.setCustomer(getRandomCustomer());
        sale1.setDiscount(10);

        Sale sale2 = new Sale();
        sale2.setCar(getRandomCar());
        sale2.setCustomer(getRandomCustomer());
        sale2.setDiscount(30 );

        this.saleRepo.saveAndFlush(sale);
        this.saleRepo.saveAndFlush(sale1);
        this.saleRepo.saveAndFlush(sale2);
    }

    @Override
    public void saleDiscount() throws JAXBException {
        SaleExportRootDto saleExportRootDto = new SaleExportRootDto();
        List<SaleExportDto> saleExportDtos = new ArrayList<>();
        for (Sale sale : this.saleRepo.findAll()) {
            SaleExportDto saleExportDto = this.modelMapper.map(sale, SaleExportDto.class);
            saleExportDto.setDiscount(saleExportDto.getDiscount() / 100);

            double totalPrice = sale.getCar().getParts()
                    .stream()
                    .mapToDouble(p -> Double.parseDouble(p.getPrice().toString()))
                    .sum();
            saleExportDto.setPrice(BigDecimal.valueOf(totalPrice));
            double priceWithDiscount = totalPrice - totalPrice * sale.getDiscount() * 1.0 / 100;
            saleExportDto.setPriceWithDiscount(BigDecimal.valueOf(priceWithDiscount));
            saleExportDtos.add(saleExportDto);
        }

        saleExportRootDto.setSales(saleExportDtos);
        this.xmlParser.exportXml(saleExportRootDto, SaleExportRootDto.class, SALE_WITH_DISCOUNT);
    }

    private Customer getRandomCustomer() {
        Random random = new Random();
        long id = (long) random.nextInt((int)this.customerRepo.count()) + 1;
        return this.customerRepo.findById(id).get();
    }

    private Car getRandomCar() {
        Random random = new Random();
        long id = (long) random.nextInt((int)this.carRepo.count()) + 1;
        return this.carRepo.findById(id).get();
    }
}
