package com.CarPart.web.services;

import com.CarPart.web.models.Cars;
import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.models.Parts;
import com.CarPart.web.models.Solutions;

import java.util.List;


public interface CarsService {
    List<Cars> findAllCars();
    Cars saveCar(Cars car);
    List<Cars>searchCars(String query);

    Cars findById(long id);

    void delete(long id);
}
