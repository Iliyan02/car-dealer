package com.softuni.cardealer.services.impl;

import com.google.gson.Gson;
import com.softuni.cardealer.constants.GlobalConstants;
import com.softuni.cardealer.domain.dtos.importXmls.PartImportDtoXml;
import com.softuni.cardealer.domain.dtos.importXmls.PartImportRootDtoXml;
import com.softuni.cardealer.domain.entites.Part;
import com.softuni.cardealer.domain.entites.Supplier;
import com.softuni.cardealer.domain.repositories.PartRepo;
import com.softuni.cardealer.domain.repositories.SupplierRepo;
import com.softuni.cardealer.services.PartService;
import com.softuni.cardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private final static String PARTS_PATH = "src/main/resources/jsons/parts.json";
    private final PartRepo partRepo;
    private final ModelMapper modelMapper;
    private final SupplierRepo supplierRepo;
    private final Gson gson;
    private final XmlParser xmlParser;

    @Autowired
    public PartServiceImpl(PartRepo partRepo, ModelMapper modelMapper, SupplierRepo supplierRepo, Gson gson, XmlParser xmlParser) {
        this.partRepo = partRepo;
        this.modelMapper = modelMapper;
        this.supplierRepo = supplierRepo;
        this.gson = gson;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedPart() throws Exception {
        PartImportRootDtoXml partImportRootDtoXml = this.xmlParser.parseXml(PartImportRootDtoXml.class, GlobalConstants.PARTS_PATH_XML);
        for (PartImportDtoXml part : partImportRootDtoXml.getParts()) {
            Part part1 = this.modelMapper.map(part, Part.class);
            part1.setSupplier(this.getRandomSupplier());
            this.partRepo.saveAndFlush(part1);
        }
    }

    private Supplier getRandomSupplier() throws Exception {
        Random random = new Random();
        long index = (long)random.nextInt((int) this.supplierRepo.count())+1;
        Optional<Supplier> supplier = this.supplierRepo.findById(index);
        if (supplier.isPresent()){
            return supplier.get();
        } else {
            throw new Exception("Supplier does not exist.");
        }
    }

//    @Override
//    public void seedPart() throws Exception {
//        String content = String.join("", Files.readAllLines(Path.of(PARTS_PATH)));
//        PartSeedDto[] partSeedDtos = this.gson.fromJson(content, PartSeedDto[].class);
//        for (PartSeedDto partSeedDto : partSeedDtos) {
//            Part part = this.modelMapper.map(partSeedDto, Part.class);
//            part.setSupplier(getRandomSupplier());
//            this.partRepo.saveAndFlush(part);
//        }
//
//    }
//
//    private Supplier getRandomSupplier() throws Exception {
//        Random random = new Random();
//        long index = (long)random.nextInt((int) this.supplierRepo.count()) + 1;
//        Optional<Supplier> supplier = this.supplierRepo.findById(index);
//        if (supplier.isPresent()){
//            return supplier.get();
//        } else {
//            throw new Exception("Supplier does not exist");
//        }
//    }
}
