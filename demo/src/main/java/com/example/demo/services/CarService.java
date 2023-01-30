package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cars;
import com.example.demo.repositories.CarRepository;

@Service
public class CarService {
    
    @Autowired
    CarRepository repository;

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

}
