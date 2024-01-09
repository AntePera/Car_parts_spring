package com.CarPart.web.services;

import com.CarPart.web.models.Cars;
import com.CarPart.web.models.Manufacturer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> findAllManufacturers();
    Manufacturer saveManufacturer(Manufacturer manufacturer);

    Manufacturer findManById(long id);

    List<Manufacturer>searchManufacturers(String query);

    void delete(long id);
}
