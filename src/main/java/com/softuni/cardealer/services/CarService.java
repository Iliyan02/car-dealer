package com.softuni.cardealer.services;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CarService {

    @Transactional
    void seedCars() throws Exception;
    void exportByToyota() throws JAXBException;
    void carsAndTheirPartXml() throws JAXBException;
//    String findByToyota();
//    String findAllCarsWithParts() throws NoSuchFieldException;
}
