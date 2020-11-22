package com.softuni.cardealer.services.impl;

import com.google.gson.Gson;
import com.softuni.cardealer.constants.GlobalConstants;
import com.softuni.cardealer.domain.dtos.importXmls.PartImportDtoXml;
import com.softuni.cardealer.domain.dtos.importXmls.PartImportRootDtoXml;
import com.softuni.cardealer.domain.entites.Part;
import com.softuni.cardealer.domain.entites.Supplier;
import com.softuni.cardealer.domain.repositories.CarRepo;
import com.softuni.cardealer.domain.repositories.PartRepo;
import com.softuni.cardealer.domain.repositories.SupplierRepo;
import com.softuni.cardealer.services.CarService;
import com.softuni.cardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.Optional;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {
    private final static String CAR_PATH = "src/main/resources/jsons/cars.json";
    private final CarRepo carRepo;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final PartRepo partRepo;
    private final XmlParser xmlParser;
    private final SupplierRepo supplierRepo;

    public CarServiceImpl(CarRepo carRepo, ModelMapper modelMapper, Gson gson, PartRepo partRepo, XmlParser xmlParser, SupplierRepo supplierRepo) {
        this.carRepo = carRepo;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.partRepo = partRepo;
        this.xmlParser = xmlParser;
        this.supplierRepo = supplierRepo;
    }

    @Override
    public void seedCars() throws Exception {

    }


//    @Override
//    @Transactional
//    public void seedCars() throws Exception {
//        String content = String.join("", Files.readAllLines(Path.of(CAR_PATH)));
//        CarSeedDto[] carSeedDto = this.gson.fromJson(content, CarSeedDto[].class);
//        for (CarSeedDto seedDto : carSeedDto) {
//            Car car = this.modelMapper.map(seedDto, Car.class);
//            car.setParts(getRandomParts());
//            this.carRepo.saveAndFlush(car);
//        }
//    }

//    @Override
//    public String findByToyota() {
//        Set<Car> toyota = this.carRepo.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota");
//        List<CarExportDto> carExportDtos = new ArrayList<>();
//        for (Car car : toyota) {
//            CarExportDto carExportDto = this.modelMapper.map(car, CarExportDto.class);
//            carExportDtos.add(carExportDto);
//        }
//        return this.gson.toJson(carExportDtos);
//    }
//
//    @Override
//    public String findAllCarsWithParts() throws NoSuchFieldException {
//        Set<Car> cars = this.carRepo.findAllBy();
//        List<CarWithPartsExportDto> carWithPartsExportDtos = new ArrayList<>();
//        for (Car car : cars) {
//            CarWithPartsExportDto carWithPartsExportDto = this
//                    .modelMapper.map(car, CarWithPartsExportDto.class);
//            carWithPartsExportDtos.add(carWithPartsExportDto);
//        }
//        return this.gson.toJson(carWithPartsExportDtos);
//    }
//
//    private Set<Part> getRandomParts() throws Exception {
//        Set<Part> parts = new HashSet<>();
//        for (int i = 0; i < 3; i++) {
//            Part part = this.getRandomPart();
//            parts.add(part);
//        }
//        return parts;
//    }
//
//    private Part getRandomPart() throws Exception {
//        Random random = new Random();
//        long index = (long) random.nextInt((int)this.partRepo.count()) + 1;
//        Optional<Part> part = this.partRepo.findById(index);
//
//        if (part.isPresent()){
//            return part.get();
//        } else {
//            throw new Exception("Invalid part id");
//        }
//    }
}
