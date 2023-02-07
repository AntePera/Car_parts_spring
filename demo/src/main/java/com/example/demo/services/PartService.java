package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Parts;
import com.example.demo.repositories.PartRepository;

@Service
public class PartService {
    
    @Autowired
    PartRepository repository;


    public List<Parts> getAll()
    {
        return repository.findAll();
    }

    public Parts getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO PART PRESENT WITH ID = " + id));
    }

    public Parts add(Parts part)
    {
        return repository.save(part);
    }
}
