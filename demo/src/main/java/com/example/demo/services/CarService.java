package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cars;
import com.example.demo.entity.Parts;
import com.example.demo.repositories.CarRepository;

@Service
public class CarService {
    
    @Autowired
    CarRepository repository;

    @Autowired
    PartService partService;

    public List<Cars> getAll()
    {
        return repository.findAll();
    }

    public Cars getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO CAR PRESENT WITH ID = " + id));
    }

    public Cars add(Cars car)
    {
        return repository.save(car);
    }

    public Cars addCarToParts(int partId, int carId)
    {
        Cars car = getById(carId);
        Parts part = partService.getById(partId);
        part.addCar(car);
        partService.add(part);
        return car;
    }

}
