package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cars;
import com.example.demo.services.CarService;

@RestController
public class CarController {
    
    @Autowired
    CarService service;

    @GetMapping("/cars")
    public ResponseEntity<List<Cars>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Cars> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/cars")
    public ResponseEntity<Cars> add(@RequestBody Cars car)
    {
        return ResponseEntity.ok(service.add(car));
    }



}
