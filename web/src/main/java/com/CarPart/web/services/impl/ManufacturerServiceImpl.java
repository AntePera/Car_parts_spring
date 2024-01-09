package com.CarPart.web.services.impl;

import com.CarPart.web.models.Cars;
import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.repository.ManufacturerRepository;
import com.CarPart.web.services.ManufacturerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }
    @Override
    public List<Manufacturer> findAllManufacturers() {
        List<Manufacturer> manufacturers=manufacturerRepository.findAll();
        return manufacturers;
    }

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer findManById(long id) {
        Manufacturer man=manufacturerRepository.findById(id).get();
        return man;
    }

    @Override
    public List<Manufacturer> searchManufacturers(String query) {
       List<Manufacturer> manufacturers=manufacturerRepository.searchManufacturers(query);
       return manufacturers;
    }

    @Override
    public void delete(long id) {
        manufacturerRepository.deleteById(id);
    }


}
