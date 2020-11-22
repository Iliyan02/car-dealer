package com.softuni.cardealer.services;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface   CustomerService {
   void seedCustomers() throws IOException, JAXBException;
//    String orderedCustomers();
//    String getCustomersWithCar();
   void exportOrdered() throws JAXBException;
}
