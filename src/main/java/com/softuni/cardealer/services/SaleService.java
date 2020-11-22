package com.softuni.cardealer.services;

import javax.xml.bind.JAXBException;

public interface SaleService {
        void seedSales();
        void saleDiscount() throws JAXBException;
}
