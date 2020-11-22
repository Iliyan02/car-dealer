package com.softuni.cardealer.services;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface SupplierService {

    void seedSupplier() throws IOException, JAXBException;
   void suppliersNotFromAbroad() throws JAXBException;
}
