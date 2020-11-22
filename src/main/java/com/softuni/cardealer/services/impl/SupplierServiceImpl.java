package com.softuni.cardealer.services.impl;

import com.google.gson.Gson;
import com.softuni.cardealer.constants.GlobalConstants;
import com.softuni.cardealer.domain.dtos.importXmls.SupplierImportDtoXml;
import com.softuni.cardealer.domain.dtos.importXmls.SupplierImportRootDtoXml;
import com.softuni.cardealer.domain.entites.Supplier;
import com.softuni.cardealer.domain.repositories.SupplierRepo;
import com.softuni.cardealer.services.SupplierService;
import com.softuni.cardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepo supplierRepo;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final XmlParser xmlParser;


    @Autowired
    public SupplierServiceImpl(SupplierRepo supplierRepo, ModelMapper modelMapper, Gson gson, XmlParser xmlParser) {
        this.supplierRepo = supplierRepo;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSupplier() throws IOException, JAXBException {
        SupplierImportRootDtoXml supplierImportRootDtoXml = this.xmlParser.parseXml(SupplierImportRootDtoXml.class, GlobalConstants.SUPPLIER_PATH_XML);
        for (SupplierImportDtoXml supplierImportDtoXml: supplierImportRootDtoXml.getSuppliers()) {
            this.supplierRepo.saveAndFlush(this.modelMapper.map(supplierImportDtoXml, Supplier.class));
        }
    }


//    @Override
//    public void seedSupplier() throws IOException {
//        String content = String.join("", Files.readAllLines(Path.of(SUPPLIER_PATH)));
//        SupplierSeedDto[] supplierSeedDtos = this.gson.fromJson(content, SupplierSeedDto[].class);
//        for (SupplierSeedDto supplierSeedDto : supplierSeedDtos) {
//            this.supplierRepo.saveAndFlush(this.modelMapper.map(supplierSeedDto, Supplier.class));
//        }
//
//
//    }
//
//    @Override
//    public String suppliersNotFromAbroad() {
//        Set<Supplier> suppliers = this.supplierRepo.findAllByImpo();
//        List<SupplierExportDto> supplierExportDtos = new ArrayList<>();
//        for (Supplier supplier : suppliers) {
//            SupplierExportDto supplierExportDto = this.modelMapper.map(supplier, SupplierExportDto.class);
//            supplierExportDtos.add(supplierExportDto);
//        }
//        return this.gson.toJson(supplierExportDtos);
//    }
}
