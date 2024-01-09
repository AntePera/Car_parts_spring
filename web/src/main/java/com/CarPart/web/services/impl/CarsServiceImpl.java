package com.CarPart.web.services.impl;

import com.CarPart.web.models.Cars;
import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.models.Parts;
import com.CarPart.web.models.Solutions;
import com.CarPart.web.repository.CarsRepository;
import com.CarPart.web.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CarsServiceImpl implements CarsService {

    private CarsRepository carsRepository;

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Cars> findAllCars() {
        List<Cars> cars=carsRepository.findAll();
        return cars;
    }

    @Override
    public Cars saveCar(Cars car) {
        return carsRepository.save(car);
    }

    @Override
    public List<Cars> searchCars(String query) {
        List<Cars> cars=carsRepository.searchCars(query);
        return cars;
    }

    @Override
    public Cars findById(long id) {
        Cars cars= carsRepository.findById(id).get();
        return cars;
    }

    @Override
    public void delete(long id) {
        carsRepository.deleteById(id);
    }


}
